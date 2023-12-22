package com.charthome.board.controller;

import com.charthome.board.model.dto.BoardDto;
import com.charthome.board.model.dto.BoardLikeDto;
import com.charthome.board.model.service.BoardService;
import com.charthome.reply.model.dto.ReplyDto;
import com.charthome.reply.model.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ReplyService replyService;
    @GetMapping("/list/{boardCode}")
    public String getBoardList(@PageableDefault(page = 1) Pageable pageable, @PathVariable String boardCode, Model model) {
        Page<BoardDto> boardPages = boardService.boardList(pageable,boardCode);

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
    public ResponseEntity<String> boardWrite(@RequestBody final BoardDto board) {
        boardService.boardWrite(board);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/views/{boardCode}/{boardNo}")
    public String getBoardItem(@PathVariable String boardCode, Model model, @PathVariable Long boardNo, HttpServletRequest req,
                               HttpServletResponse res){
        BoardDto boardItem = boardService.getBoardItem(boardNo,req,res);
        /* 수정 요망 */
        List<ReplyDto> replyList = replyService.replyList(boardNo);
        model.addAttribute("replyList",replyList);
        model.addAttribute("boardItem",boardItem);
        return "board/boardDetailView";
    }

    @PostMapping("/like")
    @ResponseBody
    public ResponseEntity<String> boardLike(@RequestBody final BoardLikeDto boardLikeDto){
        boardService.boardLike(boardLikeDto);
        return ResponseEntity.ok("success");
    }

}
