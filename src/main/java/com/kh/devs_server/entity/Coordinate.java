package com.kh.devs_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity @Getter @Setter
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coordinate_id")
    private Long id;

    private int xCoordinate;
    private int yCoordinate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "study_id")
    private Study study;

}
