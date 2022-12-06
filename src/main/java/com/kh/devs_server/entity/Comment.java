package com.kh.devs_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Comment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        // 댓글 id

    @Column(name = "comment_content")
    private String content;     // 댓글 내용

//    @ManyToOne
    @Column(name = "user_id")
    private String user;      // 댓글 작성자

    @Column(name = "comment_create")
    private LocalDateTime postDate;// 댓글 작성일

//    @ManyToOne
    @Column(name = "social_id")
    private Long socialId;     // 게시글 번호
}
