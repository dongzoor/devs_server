package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findBySocialId(Long socialId);
}
