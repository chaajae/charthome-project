package com.charthome.attachment.controller;

import com.charthome.attachment.model.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/attach")
@Slf4j
public class AttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/imgUpload")
    @ResponseBody
    public ResponseEntity<String> uploadImg(@RequestParam final MultipartFile image) {
        String result = attachmentService.uploadImg(image);
        return ResponseEntity.ok(result);
    }
}
