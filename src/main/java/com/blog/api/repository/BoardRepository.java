package com.blog.api.repository;

import com.blog.api.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    public List<Board> findAll();

    public Optional<Board> findById(String id);

    public List<Board> findByTitleLike(String title);
}
