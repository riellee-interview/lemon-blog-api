package com.blog.api.repository;

import com.blog.api.vo.BoardVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardVo, String> {

    public List<BoardVo> findAll();

    public Optional<BoardVo> findById(String id);

    public List<BoardVo> findByTitleLike(String title);
}
