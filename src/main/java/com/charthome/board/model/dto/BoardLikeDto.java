package com.charthome.board.model.dto;

import com.charthome.board.model.entity.BoardLikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardLikeDto {
    private Long userNo;
    private Long boardNo;

    public BoardLikeDto(BoardLikeEntity boardLike){
        userNo = boardLike.getUser().getId();
        boardNo = boardLike.getBoard().getId();
    }
}
