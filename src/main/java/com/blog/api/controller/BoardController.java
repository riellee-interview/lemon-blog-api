package com.blog.api.controller;

import com.blog.api.service.BoardService;
import com.blog.api.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardVo>> getAllBoard() {
        List<BoardVo> board = boardService.findAll();
        return new ResponseEntity<List<BoardVo>>(board, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardVo> getBoard(@PathVariable("id") String id) {
        Optional<BoardVo> board = boardService.findById(id);
        return new ResponseEntity<BoardVo>(board.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/title/{title}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardVo>> getBoardLikeTitle( @PathVariable("title") String title ) {
        List<BoardVo> board = boardService.findByTitleLike(title);
        return new ResponseEntity<List<BoardVo>>(board, HttpStatus.OK);
    }
}
