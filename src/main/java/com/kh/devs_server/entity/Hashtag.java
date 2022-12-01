package com.kh.devs_server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hashtag")
@Getter @Setter @ToString
public class Hashtag {
    @Id
    @Column(name = "hashtag_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tag;

    @OneToMany(mappedBy = "hashtag", fetch = FetchType.LAZY)
    private Set<HashtagCart> hashtagCartSet = new HashSet<>();
}
