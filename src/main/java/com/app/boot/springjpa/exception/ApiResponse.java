package com.app.boot.springjpa.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

    private boolean success;
    private String message;

}
