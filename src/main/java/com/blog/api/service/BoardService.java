package com.blog.api.service;

import com.blog.api.repository.BoardRepository;
import com.blog.api.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<BoardVo> findAll() {
        List<BoardVo> board = boardRepository.findAll();
        return board;
    }

    public Optional<BoardVo> findById(String id) {
        Optional<BoardVo> board = boardRepository.findById(id);
        return board;
    }

    public List<BoardVo> findByTitleLike(String title) {
        List<BoardVo> board = boardRepository.findByTitleLike(title);
        return board;
    }
}
