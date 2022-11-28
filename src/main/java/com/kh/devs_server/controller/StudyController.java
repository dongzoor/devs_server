package com.kh.devs_server.controller;
import com.kh.devs_server.dto.StudyDTO;
import com.kh.devs_server.entity.Study;
import com.kh.devs_server.service.StudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudyController {
    private StudyService studyService;
    public StudyController(StudyService studyService) {  // 의존성 주입
        this.studyService = studyService;
    }

    @GetMapping("/Study/list")
    public ResponseEntity<List<StudyDTO>> studyList(){
        List<StudyDTO> list = studyService.getStudyList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
