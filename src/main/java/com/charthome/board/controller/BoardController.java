package com.charthome.board.controller;

import com.charthome.board.model.dto.BoardDTO;
import com.charthome.board.model.entity.BoardEntity;
import com.charthome.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/list/{boardCode}")
    public String getBoardList(@PathVariable String boardCode, Model model) {
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

    @GetMapping("/views/{boardCode}")
    public String getBoardItem(@PathVariable String boardCode, Model model){
        return "board/boardDetailView";
    }
}
