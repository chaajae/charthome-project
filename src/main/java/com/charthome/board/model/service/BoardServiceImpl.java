package com.charthome.board.model.service;

import com.charthome.attachment.model.entity.AttachmentEntity;
import com.charthome.attachment.repository.AttachmentRepository;
import com.charthome.board.model.dto.BoardDto;
import com.charthome.board.model.dto.BoardLikeDto;
import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.model.entity.BoardLikeEntity;
import com.charthome.board.repository.BoardLikeRepository;
import com.charthome.board.repository.BoardRepository;
import com.charthome.common.TimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final AttachmentRepository attachmentRepository;
    private final BoardLikeRepository boardLikeRepository;
    @Override
    public void boardWrite(BoardDto board) {
//        BoardEntity boardEntity = BoardEntity.toBoardEntity(board);
        BoardEntity boardEntity = BoardEntity.builder()
                                    .boardCode(board.getBoardCode())
                                    .boardWriter(board.getBoardWriter())
                                    .boardTitle(board.getBoardTitle())
                                    .boardContent(board.getBoardContent())
                                    .build();

        Long boardNo = boardRepository.save(boardEntity).getBoardNo();
        List<String> imgList = board.getImgList();
        List<AttachmentEntity> atList = new ArrayList<>();
        for (String imgUrl : imgList) {
            atList.add(AttachmentEntity.toAttachmentEntity(imgUrl,boardNo));
        }
        attachmentRepository.saveAll(atList);
    }

    @Override
    public BoardDto getBoardItem(Long boardNo, HttpServletRequest req, HttpServletResponse res) {
        Optional<BoardEntity> boardByBoardNo = boardRepository.findByBoardNo(boardNo);
        BoardEntity boardEntity = boardByBoardNo.get();

        Cookie cookie = null;
        Cookie[] cArr = req.getCookies();

        if(cArr != null && cArr.length > 0) {
            for(Cookie c : cArr) {
                if(c.getName().equals("readBoardNo")) {
                    cookie = c;
                    break;
                }
            }
        }
        boolean countUp = false;
        if(cookie == null) {
            cookie = new Cookie("readBoardNo",boardNo+"");
            boardEntity.setBoardCount(boardEntity.getBoardCount()+1);
            countUp = true;
        }else {
            String [] arr = cookie.getValue().split("/");
            List<String> list = Arrays.asList(arr);
            if(list.indexOf(boardNo+"") == -1) {
                cookie.setValue(cookie.getValue()+"/"+boardNo);
                boardEntity.setBoardCount(boardEntity.getBoardCount()+1);
                countUp = true;
            }
        }
        if(countUp){
            cookie.setPath(req.getContextPath());
            cookie.setMaxAge(60 * 60 * 1);
            res.addCookie(cookie);
        }
//        BoardDto boardItem = BoardDto.toBoardDto(boardEntity);
        BoardDto boardItem = BoardDto.builder()
                .boardNo(boardEntity.getBoardNo())
                .boardCode(boardEntity.getBoardCode())
                .boardWriter(boardEntity.getBoardWriter())
                .boardTitle(boardEntity.getBoardTitle())
                .boardContent(boardEntity.getBoardContent())
                .createDate(TimeFormatter.formatTimeString(boardEntity.getCreateDate()))
                .boardStatus(boardEntity.getBoardStatus())
                .boardCount(boardEntity.getBoardCount())
                .build();

        return boardItem;
    }



    @Override
    public Page<BoardDto> boardList(Pageable pageable, String boardCode) {

        int page = pageable.getPageNumber() - 1; // page 위치에 있는 값은 0부터 시작한다.
        int pageLimit = 10;
        Page<BoardEntity> entityList = boardRepository.findAllByBoardCode(boardCode,PageRequest.of(page,pageLimit,Sort.by(Sort.Direction.DESC,"boardNo")));
        Page<BoardDto> dtoList = entityList.map(
//                entity -> BoardDto.toBoardDto(entity)
                entity -> BoardDto.builder()
                        .boardNo(entity.getBoardNo())
                        .boardCode(entity.getBoardCode())
                        .boardWriter(entity.getBoardWriter())
                        .boardTitle(entity.getBoardTitle())
                        .boardContent(entity.getBoardContent())
                        .createDate(TimeFormatter.formatTimeString(entity.getCreateDate()))
                        .boardStatus(entity.getBoardStatus())
                        .boardCount(entity.getBoardCount())
                        .build()
        );

        return dtoList;
    }

    @Override
    public void boardLike(BoardLikeDto boardLikeDto) {
        Optional<BoardLikeEntity> boardLikeEntity = boardLikeRepository.findByUserNo(boardLikeDto.getUserNo());
        if(boardLikeEntity.isEmpty()){
            boardLikeRepository.save(BoardLikeEntity.toBoardLikeEntity(boardLikeDto));
        }else{
            boardLikeRepository.delete(BoardLikeEntity.toBoardLikeEntity(boardLikeDto));
        }
    }
}
