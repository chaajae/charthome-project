package com.charthome.board.model.service;

import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    @Override
    public void save(BoardEntity board) {
        boardRepository.save(board);
    }

    @Override
    public BoardEntity getBoardItem(Long boardNo) {
        Optional<BoardEntity> boardByBoardNo = boardRepository.findByBoardNo(boardNo);

       // if (boardByBoardNo.isPresent()) {
            BoardEntity boardEntity = boardByBoardNo.get();
      //  }

        return boardEntity;
    }

    @Override
    public List<BoardDTO> boardList(String boardCode) {

        List<BoardEntity> entityList = boardRepository.findAllByBoardCode(boardCode);
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        for(BoardEntity entity : entityList){
            list.add(BoardDTO.toBoardDTO(entity));
        }

        return list;
    }
}
