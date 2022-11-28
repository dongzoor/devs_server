package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Study;
import com.kh.devs_server.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class StudyRepositoryTest {
    @Autowired
    private StudyRepository studyRepository;

    public User createUser() {
        User user = new User();
        user.setName("조동주");
        user.setEmail("asdasdqe@naver.com");
        user.setPwd("12345678");
        user.setRegDate(LocalDateTime.now());
        return user;
    }

    @Test
    @DisplayName("스터디 작성 테스트")
    public void regStudyTest() {
        for(int i = 1; i < 11; i ++) {
            Study study = new Study();
            User user = this.createUser();
            study.setUser(user);
            study.setTitle("테스트 제목" + i);
            study.setContent("테스트 내용" + i);
            study.setRegTime(LocalDateTime.now());
            studyRepository.save(study);
        }
    }
}
