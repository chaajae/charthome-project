package com.charthome.reply.model.service;

import com.charthome.reply.model.dto.ReplyDto;

import java.util.List;

public interface ReplyService {
    void replySave(ReplyDto reply);

    List<ReplyDto> replyList(Long boardNo);
}
