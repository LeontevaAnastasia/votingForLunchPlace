package com.votingforlunch.util.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;

public class DuplVoteException extends AppException{

    public DuplVoteException(String message) {
        super(HttpStatus.BAD_REQUEST, message, ErrorAttributeOptions.of(MESSAGE));
    }
}
