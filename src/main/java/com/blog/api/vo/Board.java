package com.blog.api.vo;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
public class Board {

    /**
     *  게시글 - ID
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;


    /**
     *  게시글 - 제목
     */
    @Column(name = "title", nullable = false)
    private String title;


    /**
     *  게시글 - 작성자
     */
    @Column(name = "author", nullable = false)
    private String author;


    /**
     *  게시글 - 내용
     */
    @Column(name = "contents", nullable = false)
    private String contents;


    /**
     *  게시글 - 조회 수
     */
    @Column(name = "view_count", nullable = false)
    private int viewCount;


    /**
     *  게시글 - 조회 수
     */
    @Column(name = "create_dtm")
    private String createDtm;


    /**
     *  게시글 - 조회 수
     */
    @Column(name = "update_dtm")
    private String updateDtm;
}
