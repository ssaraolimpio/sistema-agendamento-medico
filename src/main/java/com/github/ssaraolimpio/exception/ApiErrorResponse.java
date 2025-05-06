package com.github.ssaraolimpio.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private int status;
    private String message;
    private String details;

    public ApiErrorResponse(int status, String message, String details){
        this.status = status;
        this.message = message;
        this.details = details;
    }

}
