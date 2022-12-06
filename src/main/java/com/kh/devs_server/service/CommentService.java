package com.kh.devs_server.service;

import com.kh.devs_server.dao.CommentRepository;
import com.kh.devs_server.dao.SocialRepository;
import com.kh.devs_server.dto.CommentDTO;
import com.kh.devs_server.entity.Comment;
import com.kh.devs_server.entity.Social;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final SocialRepository socialRepository;

    // 댓글 전체조회
    public CommentDTO getCommentList(Long socialId) {
        Comment comment = commentRepository.findBySocialId(socialId); // 레파지토리에 정보 요청해서 해당 DB정보가 그대로 Entity에 들어옴
        CommentDTO commentDTOS = new CommentDTO();
        commentDTOS.setId(comment.getId());
        commentDTOS.setUser(comment.getUser());
        commentDTOS.setContent(comment.getContent());
        commentDTOS.setPostDate(comment.getPostDate());
        commentDTOS.setSocialId(comment.getSocialId());
        return commentDTOS;
    }
}
