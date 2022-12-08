package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Social;
import com.kh.devs_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialRepository extends JpaRepository<Social, Long> {// <엔티티, key 의 자료형>

//    Social findBySocialId(Long socialId);

//    void delete(Social socialId);

    List<Social> findAll();
}
