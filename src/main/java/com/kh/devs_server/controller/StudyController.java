package com.kh.devs_server.controller;
import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dto.StudyDTO;
import com.kh.devs_server.entity.Study;
import com.kh.devs_server.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/studies")
@RequiredArgsConstructor
public class StudyController {
    private final StudyService studyService;
    private final StudyRepository studyRepository;

    @GetMapping("")
    public ResponseEntity<List<Study>> studyList(){
        List<Study> list = studyService.getStudyList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{studyId}")
    public ResponseEntity<StudyDTO> study(@PathVariable Long studyId) {
        StudyDTO studyDTO = studyService.getStudy(studyId);
        return new ResponseEntity(studyDTO, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<StudyDTO> writeStudy(@PathVariable Long userId, @RequestBody StudyDTO studyDTO) {
        //로그인 파트에서 세션으로 주면 받아올 예정
        boolean result = studyService.writeStudy(userId, studyDTO);

        if(result){
            return new ResponseEntity(true, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{studyId}")
    public void deleteStudy(@PathVariable Long studyId) {
        studyRepository.deleteById(studyId);
    }
}
