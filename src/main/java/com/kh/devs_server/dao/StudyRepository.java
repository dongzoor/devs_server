package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
