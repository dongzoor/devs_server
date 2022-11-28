package com.kh.devs_server.entity;

import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Rollback( value = false)
@Slf4j
public class UserTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 생성 테스트")
    public void createUser() {
        User user = new User();
        user.setName("조동주");
        user.setEmail("asdasdqe@navr.com");
        user.setPwd("12345678");
        user.setRegDate(LocalDateTime.now());
        userRepository.save(user);
    }


}
