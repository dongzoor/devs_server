package com.kh.devs_server.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "user") @Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String pwd;

    private String phone;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
