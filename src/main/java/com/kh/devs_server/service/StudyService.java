package com.kh.devs_server.service;

import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dto.StudyDTO;
import com.kh.devs_server.entity.Study;
import com.kh.devs_server.entity.User;
import com.kh.devs_server.exception.NotFoundStudyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyService {
    private final StudyRepository studyRepository;
    private final UserService userService;

//    public Boolean writeStudy(Long userId, StudyDTO studyDTO) {

//        User user = userService.findById(userId);
//
//        Study study = new Study();
//        study.setTitle(studyDTO.getTitle());
//        study.setContent(studyDTO.getContent());
//        study.setRegTime(LocalDateTime.now());
//        study.setGoalTime(LocalDateTime.now());
//        study.setCnt(0);
//        study.setWriter(user.getName());
//
//        Study study = Study.builder()
//                .title(studyDTO.getTitle())
//                .content(studyDTO.getContent())
//                .regTime(LocalDateTime.now())
//                .goalTime(LocalDateTime.now())
//                .cnt(0)
//                .writer(user.getName())
//                .build();
//        Study rst = studyRepository.save(study);
//        log.warn(rst.toString());
//        return true;
//    }
//    public List<Study> getStudyList() {
//        return studyRepository.findAll();
//    }
//

//    public List<StudyDTO> getStudyList(){
//        List<StudyDTO> studyDTOS = new ArrayList<>();
//        List<Study> studyList = studyRepository.findAll();
//        for(Study e: studyList) {
//            StudyDTO studyDTO = new StudyDTO();
//            studyDTO.setName(e.getUser().getName());
//            studyDTO.setTitle(e.getTitle());
//            studyDTO.setContent(e.getContent());
//            studyDTO.setRegTime(LocalDateTime.now());
//            studyDTOS.add(studyDTO);
//        }
//        return studyDTOS;
//    }
//
//    public StudyDTO getStudy(Long id) {
//        StudyDTO studyDTO = new StudyDTO();
//        Study study = studyRepository.findById(id).orElse(null);
//        assert study != null;
//        studyDTO.setName(study.getUser().getName());
//        studyDTO.setTitle(study.getTitle());
//        studyDTO.setContent(study.getContent());
//        studyDTO.setRegTime(LocalDateTime.now());
//
//        return studyDTO;
//    }

//    }
}



