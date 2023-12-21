package com.charthome.user.controller;

import com.charthome.attachment.model.service.AttachmentService;
import com.charthome.user.model.dto.UserDto;
import com.charthome.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@SessionAttributes("loginUser")
public class UserController {

    private final UserService userService;
    private final AttachmentService attachmentService;
    @GetMapping("/signup")
    public String signupPage() {
        return "user/signup";
    }

    @GetMapping("/signin")
    public String signinPage() {
        return "user/signin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus status) {
        session.invalidate();
        status.setComplete();
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }

    @PatchMapping("/profileUpload")
    @ResponseBody
    public ResponseEntity<String> profileUpload(@RequestParam("profileImg") MultipartFile file, HttpSession session, Model model) {

        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        String updateProfile = attachmentService.uploadImg(file);

        loginUser.setUserProfile(updateProfile);
        UserDto updateUser = userService.updateProfile(loginUser);
        model.addAttribute("loginUser",updateUser);
        return ResponseEntity.ok("프로필이미지업로드");
    }
// 두개 메소드 합치는거 리팩토링
    @PatchMapping("/updateNick")
    @ResponseBody
    public ResponseEntity<String> updateNick(@RequestParam("updateNick") String updateNick, HttpSession session, Model model) {
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        loginUser.setUserNick(updateNick);
        UserDto updateUser = userService.updateProfile(loginUser);
        model.addAttribute("loginUser",updateUser);
        return ResponseEntity.ok("닉네임수정완료");
    }

}
