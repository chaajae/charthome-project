//package com.charthome.board.model.dto;
//
//import com.charthome.board.model.entity.BoardEntity;
//import com.charthome.common.TimeFormatter;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class BoardDto {
//
//    private Long boardNo;
//    private String boardCode;
//    private Long boardWriter;
//    private String boardTitle;
//    private String boardContent;
//    private String createDate;
//    private String boardStatus;
//    private Long boardCount;
//    private List<String> imgList;
//    public static BoardDto toBoardDto(BoardEntity boardEntity) {
//        BoardDto toBoardDto = new BoardDto();
//        toBoardDto.setBoardNo(boardEntity.getBoardNo());
//        toBoardDto.setBoardCode(boardEntity.getBoardCode());
//        toBoardDto.setBoardWriter(boardEntity.getBoardWriter());
//        toBoardDto.setBoardTitle(boardEntity.getBoardTitle());
//        toBoardDto.setBoardContent(boardEntity.getBoardContent());
//        toBoardDto.setCreateDate(TimeFormatter.formatTimeString(boardEntity.getCreateDate()));
//        toBoardDto.setBoardCount(boardEntity.getBoardCount());
//        return toBoardDto;
//    }
//
//}

package com.charthome.board.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
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


    public BoardDto(Long boardNo, String boardCode, Long boardWriter, String boardTitle,
                    String boardContent, String createDate, String boardStatus, Long boardCount) {
        this.boardNo = boardNo;
        this.boardCode = boardCode;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createDate = createDate;
        this.boardStatus = boardStatus;
        this.boardCount = boardCount;
    }
}