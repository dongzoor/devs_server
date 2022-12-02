package com.kh.devs_server.exception;

public class NotFoundStudyException extends RuntimeException {
    public NotFoundStudyException(String msg) {
        super(msg);
    }
}