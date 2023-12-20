package com.charthome.board.controller;

import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/list/{boardCode}")
    public String getBoardList(@PageableDefault(page = 1) Pageable pageable, @PathVariable String boardCode, Model model) {
        Page<BoardDTO> boardPages = boardService.boardList(pageable,boardCode);

        int blockLimit = 5; // 변경된 페이지 범위 설정
        int startPage = (((int) Math.ceil(((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = Math.min((startPage + blockLimit - 1), boardPages.getTotalPages());

        model.addAttribute("boardPages", boardPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/boardlist";
    }

    @GetMapping("/write/{boardCode}")
    public String boardWriteForm(@PathVariable String boardCode, Model model) {
        return "board/boardwrite";
    }

    @PostMapping("/write")
    @ResponseBody
    public ResponseEntity<String> boardWrite(@RequestBody final BoardDTO board) {

        BoardEntity boardEntity = BoardEntity.toBoardEntity(board);
        boardService.save(boardEntity);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/views/{boardCode}/{boardNo}")
    public String getBoardItem(@PathVariable String boardCode, Model model, @PathVariable Long boardNo){
        BoardEntity boardItem = boardService.getBoardItem(boardNo);
        log.info("보드아이템 = {} ",boardItem);
        model.addAttribute("boardItem",boardItem);
        return "board/boardDetailView";
    }
}
