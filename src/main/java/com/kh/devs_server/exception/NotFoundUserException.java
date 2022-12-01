package com.kh.devs_server.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String msg) {
        super(msg);
    }
}
