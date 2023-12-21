package com.charthome.oauth.controller;

import com.charthome.oauth.model.service.OauthService;
import com.charthome.user.model.dto.UserDto;
import com.charthome.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
@SessionAttributes("loginUser")
public class OauthController {

    private final OauthService oauthService;
    private final UserService userService;
    @GetMapping("/naver")
    public void naverLogin(HttpServletRequest request , HttpServletResponse response) throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
        String url = oauthService.getNaverAuthorizeUrl();
        try {
            response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/naver/login")
    public String callback(HttpServletRequest request , Model model) throws Exception {
        UserDto loginUser = oauthService.getNaverInfo(request.getParameter("code"));
        model.addAttribute("loginUser",loginUser);

        return "redirect:/";
    }

}
