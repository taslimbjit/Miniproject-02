package com.taslim.paymentservice.exception;

public class NoBooksFoundException extends RuntimeException{
    public NoBooksFoundException(String message){
        super(message);
    }
}