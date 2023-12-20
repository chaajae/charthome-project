package com.charthome.board.model.service;


import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    void save(BoardEntity board);

    BoardEntity getBoardItem(Long boardNo);

    Page<BoardDTO> boardList(Pageable pageable, String boardCode);
}
