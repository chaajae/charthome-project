package com.charthome.reply.controller;

import com.charthome.reply.model.dto.ReplyDto;
import com.charthome.reply.model.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyContoller {

    private final ReplyService replyService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> replySave(@RequestBody final ReplyDto reply) {
        replyService.replySave(reply);
        return ResponseEntity.ok("success");
    }
}
