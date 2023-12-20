package com.charthome.board.model.service;

import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        BoardEntity boardEntity = boardByBoardNo.get();
        return boardEntity;
    }

//    @Override
//    public List<BoardDTO> boardList(String boardCode) {
//
//        List<BoardEntity> entityList = boardRepository.findAllByBoardCode(boardCode);
//        List<BoardDTO> list = new ArrayList<BoardDTO>();
//        for(BoardEntity entity : entityList){
//            list.add(BoardDTO.toBoardDTO(entity));
//        }
//
//        return list;
//    }

    @Override
    public Page<BoardDTO> boardList(Pageable pageable, String boardCode) {

        int page = pageable.getPageNumber() - 1; // page 위치에 있는 값은 0부터 시작한다.
        int pageLimit = 10;
        Page<BoardEntity> entityList = boardRepository.findAllByBoardCode(boardCode,PageRequest.of(page,pageLimit,Sort.by(Sort.Direction.DESC,"boardNo")));
        Page<BoardDTO> dtoList = entityList.map(
                entity -> BoardDTO.toBoardDTO(entity)
        );

        return dtoList;
    }
}
