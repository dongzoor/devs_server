package com.kh.devs_server.dao;

import com.kh.devs_server.entity.CartStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartStudyRepository extends JpaRepository<CartStudy, Long> {
}
