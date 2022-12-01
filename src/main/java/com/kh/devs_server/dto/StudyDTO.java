package com.kh.devs_server.dto;


import com.kh.devs_server.entity.StudyApply;
import lombok.Builder;
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
    private int readCount;
    private boolean studyApply;
    private int studyApplyCount;
}
