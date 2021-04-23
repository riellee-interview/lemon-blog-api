package com.blog.api.service;

import com.blog.api.repository.BoardRepository;
import com.blog.api.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findAll() {
        List<Board> board = boardRepository.findAll();
        return board;
    }

    public Optional<Board> findById(String id) {
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    public List<Board> findByTitleLike(String title) {
        List<Board> board = boardRepository.findByTitleLike(title);
        return board;
    }

    @Transactional
    public void save(Board reqBoard) {
        boardRepository.save(reqBoard);
    }
}
