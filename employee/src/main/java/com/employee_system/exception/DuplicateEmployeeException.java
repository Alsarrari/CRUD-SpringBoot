package com.employee_system.exception;

public class DuplicateEmployeeException extends RuntimeException{
    public DuplicateEmployeeException(String message){
        super(message);
    }
}
