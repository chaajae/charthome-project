package com.charthome.board.model.dto;

import com.charthome.board.model.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long boardNo;
    private String boardCode;
    private Long boardWriter;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createDate;
    private String boardStatus;
    private Long boardCount;
    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardNo(boardEntity.getBoardNo());
        boardDTO.setBoardCode(boardEntity.getBoardCode());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContent(boardEntity.getBoardContent());
        boardDTO.setCreateDate(boardEntity.getCreateDate());
        boardDTO.setBoardCount(boardEntity.getBoardCount());
        return boardDTO;
    }

}
