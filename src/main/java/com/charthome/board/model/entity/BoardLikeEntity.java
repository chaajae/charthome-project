package com.charthome.board.model.entity;

import com.charthome.board.model.dto.BoardLikeDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "board_like")
public class BoardLikeEntity {

    @Id
    @Column
    private Long userNo;

    @Column
    private Long boardNo;

    public static BoardLikeEntity toBoardLikeEntity(BoardLikeDto boardLikeDto){
        BoardLikeEntity boardLikeEntity = new BoardLikeEntity();
        boardLikeEntity.setUserNo(boardLikeDto.getUserNo());
        boardLikeEntity.setBoardNo(boardLikeDto.getBoardNo());
        return boardLikeEntity;
    }

}
