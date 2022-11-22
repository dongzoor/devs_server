package com.kh.devs_server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table( name = "hashtag")
@Getter @Setter @ToString
public class Hashtag {
    @Id
    @Column(name = "hashtag_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
