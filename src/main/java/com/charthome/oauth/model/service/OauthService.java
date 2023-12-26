package com.charthome.oauth.model.service;

import com.charthome.oauth.model.dto.NaverDto;


import com.charthome.user.model.dto.UserDto;
import com.charthome.user.model.entity.UserEntity;
import com.charthome.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OauthService {

    private String clientId = "qW2vJScI5B16Mq6_mffX";
    private String redirectUrl = "http://localhost:8090/api/oauth/naver/login";
    private String clientSecret = "xaZjP9o6mn";

    private final UserService userService;
    public String getNaverAuthorizeUrl() throws URISyntaxException, MalformedURLException,UnsupportedEncodingException {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("https://nid.naver.com/oauth2.0/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", URLEncoder.encode(redirectUrl, "UTF-8"))
                .queryParam("state", URLEncoder.encode("1027", "UTF-8"))
                .build();

        return uriComponents.toString();
    }
    public UserDto getNaverInfo(String code) throws Exception {
        if (code == null) throw new Exception("Failed get authorization code");

        String accessToken = "";
        String refreshToken = "";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "application/x-www-form-urlencoded");

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type"   , "authorization_code");
            params.add("client_id"    , clientId);
            params.add("client_secret", clientSecret);
            params.add("code"         , code);
            params.add("redirect_uri" , redirectUrl);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    "https://nid.naver.com/oauth2.0/token",
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());
            log.info("제이슨 {}" ,jsonObj);
            accessToken  = (String) jsonObj.get("access_token");
            refreshToken = (String) jsonObj.get("refresh_token");
        } catch (Exception e) {
            throw new Exception("API call failed");
        }

        NaverDto naverInfo = getUserInfoWithToken(accessToken);
        Optional<UserEntity> findUserByUserId = userService.findUserByUserId(naverInfo.getId());
        if(findUserByUserId.isEmpty()){
            UserEntity user = UserEntity.toUserEntity(naverInfo);
            userService.save(user);
        }

        Optional<UserEntity> loginEntity = userService.findUserByUserId(naverInfo.getId());
//        UserDto loginUser = UserDto.toUserDTO(loginEntity.get());
        UserDto loginUser = new UserDto(loginEntity.get());
        return loginUser;
    }

    private NaverDto getUserInfoWithToken(String accessToken) throws Exception {
        //HttpHeader 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader 담기
        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = rt.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                httpEntity,
                String.class
        );
        //Response 데이터 파싱
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj    = (JSONObject) jsonParser.parse(response.getBody());
        JSONObject account = (JSONObject) jsonObj.get("response");

        String id = String.valueOf(account.get("id"));
        String email = String.valueOf(account.get("email"));
        String name = String.valueOf(account.get("name"));

        return NaverDto.builder()
                .id(id)
                .email(email)
                .name(name).build();
    }
}
