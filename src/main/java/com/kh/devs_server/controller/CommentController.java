package com.kh.devs_server.controller;

import com.kh.devs_server.dto.CommentDTO;
import com.kh.devs_server.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<CommentDTO> commentList(Long socialId) {
        CommentDTO commentDTO = commentService.getCommentList(socialId);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }

}
