package com.kh.devs_server.dto;

import com.kh.devs_server.entity.Social;
import com.kh.devs_server.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {
    private Long id;            // 댓글 ID
    private String content;     // 댓글 내용
    private User user;        // 댓글 작성 USER
    private LocalDateTime postDate; // 댓글 작성일
    private Social socialId;   // social 게시글 ID
}
