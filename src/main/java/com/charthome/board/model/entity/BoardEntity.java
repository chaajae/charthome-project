package com.charthome.board.model.entity;

import com.charthome.board.model.dto.BoardDto;
import com.charthome.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column
    private String boardCode;

    @Column
    private Long boardWriter;

    @Column
    private String boardTitle;

    @Column
    private String boardContent;

    @Column
    private String boardStatus;

    @Column
    private Long boardCount;



    public static BoardEntity toEntity(BoardDto boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardCode(boardDTO.getBoardCode());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
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

