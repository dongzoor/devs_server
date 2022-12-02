package com.kh.devs_server.service;

import com.kh.devs_server.constant.UserRole;
import com.kh.devs_server.dao.UserRepository;
import com.kh.devs_server.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional // 메소드 종료시 commit or rollback
@Service
@Slf4j
public class UserService {
    // Repository와 연결
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원가입
    public boolean regUser(String userEmail, String userNickname, String password, String phone, String profileImage) {
        // User Entity와 연결
        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserNickname(userNickname);
        user.setPassword(password);
        user.setPhone(phone);
        user.setProfileImage(profileImage);
        user.setCreateDate(LocalDateTime.now());
        user.setUserRole(UserRole.USER);
        User rst = userRepository.save(user);
        log.warn(rst.toString());
        return true;
    }

    // 회원 조회
    public List<User> userSearch(String userEmail) {
        List<User> user = userRepository.findByUserEmail(userEmail);
        return user;
    }

    // 로그인 체크
    public List<User> loginCheck(String userEmail, String password) {
        List<User> memberList = userRepository.findByUserEmailAndPassword(userEmail, password);

        return memberList;
    }

    //회원정보 수정
    @Transactional
    public String UserUpdate(User user) {
        User userDb = user;
        userDb.setUserNickname(user.getUserNickname());
        userDb.setPassword(user.getPassword());
        userDb.setPhone(user.getPhone());
        userDb.setProfileImage(user.getProfileImage());
        userDb.setModifyDate(LocalDateTime.now());
        userRepository.save(userDb);
        return user.getUserEmail();
    }
}
