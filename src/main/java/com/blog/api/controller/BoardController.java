package com.blog.api.controller;

import com.blog.api.service.BoardService;
import com.blog.api.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Board>> getAllBoard() {
        List<Board> board = boardService.findAll();
        return new ResponseEntity<List<Board>>(board, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Board> getBoard(@PathVariable("id") String id) {
        Optional<Board> board = boardService.findById(id);
        return new ResponseEntity<Board>(board.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/title/{title}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Board>> getBoardLikeTitle(@PathVariable("title") String title ) {
        List<Board> board = boardService.findByTitleLike(title);
        return new ResponseEntity<List<Board>>(board, HttpStatus.OK);
    }

    @PostMapping(value = "/insertBoard")
    public ResponseEntity<Map<String, Object>> insertBoard(@RequestBody Board reqBoardMap) {
        Map<String, Object> response = new HashMap<>();
        try {
            boardService.save(reqBoardMap);
            response.put("returnCd", "0000");
            response.put("returnMsg", "게시글 저장 완료.");
        } catch (Exception ex) {
            response.put("returnCd", "0001");
            response.put("returnMsg", "게시글 저장 실패.");
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
