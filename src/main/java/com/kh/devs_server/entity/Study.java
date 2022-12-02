package com.kh.devs_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Table(name = "study") @Getter @NoArgsConstructor( access = AccessLevel.PROTECTED)
public class Study {

    @Id
    @Column(name = "study_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "writer")
    private String writer;

    @Lob
    @Column(nullable = false)
    private String content;

    private int cnt; //조회수
    private String imgUrl;

    private LocalDateTime regTime;   // 생성일
    private LocalDateTime updateTime; // 수정일
    private LocalDateTime goalTime; // 스터디 시작일

    private String coordinate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")  // user_id FK 설정
    private User user;

    @OneToMany(mappedBy = "study", fetch = FetchType.LAZY)
    private Set<HashtagCart> hashtagCartSet = new HashSet<>();
//
//    public void createdByUser(User user) {
//        this.user = user;
//    }
    @Builder
    public Study(Long id, String title, String content, String writer, String imgUrl, int cnt, LocalDateTime regTime,
                 LocalDateTime updateTime, LocalDateTime goalTime, String coordinate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.imgUrl = imgUrl;
        this.cnt = cnt;
        this.regTime = regTime;
        this.updateTime = updateTime;
        this.goalTime = goalTime;
        this.coordinate = coordinate;
    }

}
