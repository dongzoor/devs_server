package com.kh.devs_server.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudyDTO {
    private String name;
    private String title;
    private String content;
    private LocalDateTime regTime;
}
