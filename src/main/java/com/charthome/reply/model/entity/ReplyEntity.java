package com.charthome.reply.model.entity;

import com.charthome.board.model.entity.BoardEntity;
import com.charthome.common.entity.BaseTimeEntity;
import com.charthome.reply.model.dto.ReplyDto;
import com.charthome.user.model.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reply")
public class ReplyEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_no")
    private Long id;

//    @Column
//    private Long boardNo;

//    @Column
//    private Long userNo;

    @Column
    private String replyContent;

    @Column
    private String replyStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_no")
    private BoardEntity board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private UserEntity user;

    public static ReplyEntity toEntity(ReplyDto reply){
        ReplyEntity entity = new ReplyEntity();
        BoardEntity board = new BoardEntity();
        UserEntity user = new UserEntity();
        user.setId(reply.getUserNo());
        board.setId(reply.getBoardNo());
        entity.setBoard(board);
        entity.setUser(user);
        entity.setReplyContent(reply.getReplyContent());
        return entity;
    }

    @PrePersist
    public void prePersist() {
        this.replyStatus = this.replyStatus == null ? "y" : this.replyStatus;
    }

}
