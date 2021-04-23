package com.blog.api.controller;

import com.blog.api.service.BoardService;
import com.blog.api.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
}
