package com.votingforlunch.util.exception;

public class DuplVoteException extends RuntimeException{

    public DuplVoteException(String message) {
        super(message);
    }
}
