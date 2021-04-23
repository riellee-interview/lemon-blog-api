package com.blog.api.vo;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board")
public class BoardVo {

    @Id
    private String id;
    private String title;
    private String author;
    private String contents;
    private int viewCount;
    private String createDtm;
    private String updateDtm;
}
