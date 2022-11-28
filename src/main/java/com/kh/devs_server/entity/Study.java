package com.kh.devs_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "study")
@Data
public class Study {

    @Id
    @Column(name = "study_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
