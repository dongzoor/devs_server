package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Social;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialRepository extends JpaRepository<Social, Long> {// <엔티티, key 의 자료형>

    Social findBySocialId(Long socialId);

    void delete(Social socialId);
}
