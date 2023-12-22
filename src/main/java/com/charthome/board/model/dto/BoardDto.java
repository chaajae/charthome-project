package com.charthome.board.model.dto;

import com.charthome.board.model.entity.BoardEntity;
import com.charthome.common.TimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long boardNo;
    private String boardCode;
    private Long boardWriter;
    private String boardTitle;
    private String boardContent;
    private String createDate;
    private String boardStatus;
    private Long boardCount;
    private List<String> imgList;
    public static BoardDto toDto(BoardEntity boardEntity) {
        BoardDto toBoardDto = new BoardDto();
        toBoardDto.setBoardNo(boardEntity.getBoardNo());
        toBoardDto.setBoardCode(boardEntity.getBoardCode());
        toBoardDto.setBoardWriter(boardEntity.getBoardWriter());
        toBoardDto.setBoardTitle(boardEntity.getBoardTitle());
        toBoardDto.setBoardContent(boardEntity.getBoardContent());
        toBoardDto.setCreateDate(TimeFormatter.formatTimeString(boardEntity.getCreateDate()));
        toBoardDto.setBoardCount(boardEntity.getBoardCount());
        return toBoardDto;
    }

}

