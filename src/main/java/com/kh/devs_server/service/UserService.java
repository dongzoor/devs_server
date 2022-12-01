package com.kh.devs_server.service;

import com.kh.devs_server.dao.UserRepository;
import com.kh.devs_server.entity.User;
import com.kh.devs_server.exception.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException(String.format("There is no Id : %s", userId)));
    };

    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundUserException(String.format("There is no email : %s, You need to SignUp", email)));
    };

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
