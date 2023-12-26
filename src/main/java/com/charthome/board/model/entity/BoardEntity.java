package com.charthome.board.model.entity;

import com.charthome.attachment.model.entity.AttachmentEntity;
import com.charthome.board.model.dto.BoardDto;
import com.charthome.common.entity.BaseTimeEntity;
import com.charthome.reply.model.entity.ReplyEntity;
import com.charthome.user.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long id;

    @Column
    private String boardCode;

//    @Column
//    private Long boardWriter;

    @Column
    private String boardTitle;

    @Column
    private String boardContent;

    @Column
    private String boardStatus;

    @Column
    private Long boardCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_writer")
    private UserEntity user;

    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL)
    private List<ReplyEntity> reply;

    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL)
    private List<BoardLikeEntity> boardLike;

    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL)
    private List<AttachmentEntity> attachment;


    public static BoardEntity toEntity(BoardDto boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        UserEntity user = new UserEntity();
        boardEntity.setBoardCode(boardDTO.getBoardCode());
//        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        user.setId(Long.valueOf(boardDTO.getBoardWriter()));
        boardEntity.setUser(user);
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContent(boardDTO.getBoardContent());
        return boardEntity;
    }

    @PrePersist
    public void prePersist() {
        this.boardStatus = this.boardStatus == null ? "y" : this.boardStatus;
        this.boardCount = this.boardCount == null ? 0 : this.boardCount;
    }
}

