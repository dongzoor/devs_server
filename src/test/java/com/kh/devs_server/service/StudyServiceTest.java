package com.kh.devs_server.service;

import com.kh.devs_server.dao.StudyRepository;
import com.kh.devs_server.dto.StudyDTO;
import com.kh.devs_server.entity.Study;
import com.kh.devs_server.entity.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional  // 실행 후 db 롤백
@RequiredArgsConstructor
public class StudyServiceTest {

    private final StudyService studyService;
    @Autowired
    private StudyRepository studyRepository;


}
