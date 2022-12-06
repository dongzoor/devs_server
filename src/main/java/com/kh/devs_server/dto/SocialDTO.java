package com.kh.devs_server.dto;

import com.kh.devs_server.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SocialDTO {
    private Long socialId;        // 게시글 id
    private User user;            // 작성자 id
    private String title;           // 게시글 제목
    private String content;         // 게시글 내용
    private LocalDateTime postDate; // 작성 일자
    private LocalDateTime upDate;   // 수정 일자
    private int like;               // 좋아요 수
    private int view;               // 조회수
    private int comment;            // 댓글 수
    private int saved;              // 저장 횟수
    private String tag;             // 해시태그
    private String image;           // 첨부 이미지
}
