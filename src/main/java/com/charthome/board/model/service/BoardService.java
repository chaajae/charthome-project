package com.charthome.board.model.service;


import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    void save(BoardEntity board);

    BoardEntity getBoardItem(Long boardNo);

    List<BoardDTO> boardList(String boardCode);
}
