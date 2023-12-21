package com.charthome.board.model.service;


import com.charthome.board.model.dto.BoardDto;
import com.charthome.board.model.dto.BoardLikeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
    void boardWrite(BoardDto board);

    BoardDto getBoardItem(Long boardNo, HttpServletRequest req, HttpServletResponse res);

    Page<BoardDto> boardList(Pageable pageable, String boardCode);

    void boardLike(BoardLikeDto boardLikeDto);
}
