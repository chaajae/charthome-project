package com.charthome.reply.model.dto;

import com.charthome.common.TimeFormatter;
import com.charthome.reply.model.entity.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private Long replyNo;
    private Long boardNo;
    private Long userNo;
    private String replyContent;
    private String createDate;
    private String replyStatus;

    public static ReplyDto toDto(ReplyEntity entity) {
        ReplyDto reply = new ReplyDto();
        reply.setReplyNo(entity.getReplyNo());
        reply.setBoardNo(entity.getBoardNo());
        reply.setUserNo(entity.getUserNo());
        reply.setReplyContent(entity.getReplyContent());
        reply.setCreateDate(TimeFormatter.formatTimeString(entity.getCreateDate()));
        reply.setReplyStatus(entity.getReplyStatus());
        return reply;
    }

}
