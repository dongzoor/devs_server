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

    public Boolean writeStudy(StudyDTO studyDTO) {

        User user = userService.findById(studyDTO.getUserId());
        Study study = Study.builder()
                .title(studyDTO.getTitle())
                .content(studyDTO.getContent())
                .regTime(LocalDateTime.now())
                .goalTime(LocalDateTime.now())
                .cnt(0)
                .writer(user.getName())
                .build();
        Study rst = studyRepository.save(study);
        log.warn(rst.toString());
        return true;
    }
    public List<Study> getStudyList() {
        return studyRepository.findAll();
    }

    public Optional<Study> getStudy(Long id) {
        Study study = studyRepository.findById(id).orElseThrow(() -> new NotFoundStudyException("study is not Found!"));
        return Optional.ofNullable(study);
    }

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



}
