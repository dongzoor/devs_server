package com.kh.devs_server.service;

import com.kh.devs_server.dao.UserRepository;
import com.kh.devs_server.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean regUser(String pwd, String name, String mail) {
        User user = new User();
        user.setPwd(pwd);
        user.setName(name);
        user.setEmail(mail);
        user.setRegDate(LocalDateTime.now());
        User rst = userRepository.save(user);
        log.warn(rst.toString());
        return  true;
    }
}
