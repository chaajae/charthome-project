package com.charthome.board.model.service;

import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    @Override
    public void save(BoardEntity board) {
        boardRepository.save(board);
    }
}
