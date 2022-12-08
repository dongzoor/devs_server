package com.kh.devs_server.entity;

import com.kh.devs_server.constant.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(unique = true, nullable = false)
    private String adminEmail;

    @Column(nullable = false)
    private String adminNickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(name = "profileImage")
    private String profileImage;


    @Column(name = "userRole")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}

