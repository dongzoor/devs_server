package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Study;
import com.kh.devs_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study, Long> {
    List<Study> findByUser(User user);
    Optional<Study> findById(Long studyId);
}
