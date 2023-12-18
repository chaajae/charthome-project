package com.charthome.board.model.service;


import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;

public interface BoardService {
    void save(BoardEntity board);

    BoardEntity getBoardItem(Long boardNo);
}
