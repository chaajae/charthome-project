package com.charthome.user.controller;

import com.charthome.attachment.model.service.AttachmentService;
import com.charthome.common.Utils;
import com.charthome.user.model.dto.UserDTO;
import com.charthome.user.model.entity.UserEntity;
import com.charthome.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Optional;

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

        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        String updateProfile = attachmentService.uploadImg(file);

        loginUser.setUserProfile(updateProfile);
        UserDTO updateUser = userService.updateProfile(loginUser);
        model.addAttribute("loginUser",updateUser);
        return ResponseEntity.ok("프로필이미지업로드");
    }

    @PatchMapping("/updateNick")
    @ResponseBody
    public ResponseEntity<String> updateNick(@RequestParam("updateNick") String updateNick, HttpSession session, Model model) {
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        loginUser.setUserNick(updateNick);
        UserDTO updateUser = userService.updateProfile(loginUser);
        model.addAttribute("loginUser",updateUser);
        return ResponseEntity.ok("닉네임수정완료");
    }

}
