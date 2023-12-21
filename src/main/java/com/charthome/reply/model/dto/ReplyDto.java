package com.charthome.reply.model.dto;

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
    private String replyStatus;


}
