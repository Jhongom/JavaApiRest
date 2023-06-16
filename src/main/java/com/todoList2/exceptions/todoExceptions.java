package com.todoList2.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class todoExceptions extends RuntimeException{

    public String message;
    public HttpStatus httpStatus;


    public todoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
