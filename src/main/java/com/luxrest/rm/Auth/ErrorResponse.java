package com.luxrest.rm.Auth;

import lombok.Builder;

@Builder
public class ErrorResponse {
    private Integer status;
    private String error;
    private String message;
}