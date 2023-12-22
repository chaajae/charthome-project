package com.charthome.reply.model.entity;

import com.charthome.common.entity.BaseTimeEntity;
import com.charthome.reply.model.dto.ReplyDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reply")
public class ReplyEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNo;

    @Column
    private Long boardNo;

    @Column
    private Long userNo;

    @Column
    private String replyContent;

    @Column
    private String replyStatus;

    public static ReplyEntity toEntity(ReplyDto reply){
        ReplyEntity entity = new ReplyEntity();
        entity.setBoardNo(reply.getBoardNo());
        entity.setUserNo(reply.getUserNo());
        entity.setReplyContent(reply.getReplyContent());
        return entity;
    }

    @PrePersist
    public void prePersist() {
        this.replyStatus = this.replyStatus == null ? "y" : this.replyStatus;
    }

}
