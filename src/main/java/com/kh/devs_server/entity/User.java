package com.kh.devs_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String pwd;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime regDate;

}
