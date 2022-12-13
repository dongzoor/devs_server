package com.kh.devs_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "social")
public class Social {
    @Id
    @Column(name = "social_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long socialId;              // 게시글 id

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;            // 작성자 id

    @Column(name = "social_title", nullable = false)
    private String title;           // 게시글 제목
    @Column(name = "social_content", nullable = false)
    private String content;         // 게시글 내용
    @Column(name = "social_image")
    private String image;           // 첨부 이미지
    @Column(name = "social_tag")
    private String tag;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)// 해시태그
    @Column(name = "social_create")
    private LocalDateTime postDate; // 작성 일자
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "social_update")
    private LocalDateTime upDate;   // 수정 일자
    @Column(name = "social_like")
    private int like;               // 좋아요 수
    @Column(name = "social_view")
    private int view;               // 조회수
    @Column(name = "comment")
    private int comment;            // 댓글 수
    @Column(name = "social_saved")
    private int saved;              // 저장 횟수

    @OneToMany(mappedBy="social", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
}
