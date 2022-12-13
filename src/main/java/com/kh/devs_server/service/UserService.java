package com.kh.devs_server.service;

import com.kh.devs_server.constant.UserRole;
import com.kh.devs_server.dao.AdminRepository;
import com.kh.devs_server.dao.UserRepository;
import com.kh.devs_server.dto.SocialDTO;
import com.kh.devs_server.dto.UserDTO;
import com.kh.devs_server.entity.Admin;
import com.kh.devs_server.entity.Social;
import com.kh.devs_server.entity.Study;
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



    // 어드민 유저 조회
    // 어드민 유저 상세조회
    public UserDTO getAdUserList(Long userId) {
        User user = userRepository.findById(userId).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserNickname(user.getUserNickname());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setProfileImage(user.getProfileImage());
        userDTO.setCreateDate(user.getCreateDate());
        log.warn(userDTO.toString()); // 터미널 창
        System.out.println(userDTO);
        return userDTO;
    }

    // 로그인 체크
    public List<User> loginCheck(String userEmail, String password) {
        List<User> userList = userRepository.findByUserEmailAndPassword(userEmail, password);

        return userList;
    }

    // 어드민이 회원정보 수정
    @Transactional
    public boolean updateAdUser(Long userId ,String userNickname , String password , String phone ,String profileImage) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->{
                    return new IllegalArgumentException("아이디 찾기 실패: 아이디를 찾을 수 없습니다.");
                });
        user.setUserNickname(userNickname);
        user.setPassword(password);
        user.setPhone(phone);
        user.setProfileImage(profileImage);
        user.setModifyDate(LocalDateTime.now());  // 수정일 정보 자동 기입
        return true;
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

   //유저 전체조회
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
