package com.kh.devs_server.entity;

import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
@Rollback(value = false)
public class StudyTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    StudyRepository studyRepository;

    @Test
    @DisplayName("스터디 생성 테스트")
    public void createStudy() {
        Study study = new Study();
        User user = userRepository.findById(2L).get();
        study.setTitle("테스트 제목1");
        study.setContent("테스트 내용1");
        study.setUser(user);
        study.setRegTime(LocalDateTime.now());
        studyRepository.saveAndFlush(study);
    }
}
