package com.charthome.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    private Date createDate;
    private String boardStatus;
    private Long boardCount;

}
