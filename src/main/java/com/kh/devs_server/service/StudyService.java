package com.kh.devs_server.service;

import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dto.StudyDTO;
import com.kh.devs_server.entity.Study;
import com.kh.devs_server.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;


    public Study saveStudy(Study study) {
        return studyRepository.save(study);
    }

    public boolean regStudy(String title, String content, User user) {
        Study study = new Study();
        study.setUser(user);
        study.setTitle(title);
        study.setContent(content);
        Study rst = studyRepository.save(study);
        return true;
    }

    public List<StudyDTO> getStudyList(){
        List<StudyDTO> studyDTOS = new ArrayList<>();
        List<Study> studyList = studyRepository.findAll();
        for(Study e: studyList) {
            StudyDTO studyDTO = new StudyDTO();
            studyDTO.setName(e.getUser().getName());
            studyDTO.setTitle(e.getTitle());
            studyDTO.setContent(e.getContent());
            studyDTO.setRegTime(LocalDateTime.now());
            studyDTOS.add(studyDTO);
        }
        return studyDTOS;
    }

    public StudyDTO getStudy(Long id) {
        StudyDTO studyDTO = new StudyDTO();
        Study study = studyRepository.findById(id).orElse(null);
        assert study != null;
        studyDTO.setName(study.getUser().getName());
        studyDTO.setTitle(study.getTitle());
        studyDTO.setContent(study.getContent());
        studyDTO.setRegTime(LocalDateTime.now());

        return studyDTO;
    }
}
