package com.employee_system.exception;

import com.employee_system.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerDepartmentNotFoundException(DepartmentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(ex.getMessage(), null));
    }
    @ExceptionHandler(DuplicateEmployeeException.class)
    public ResponseEntity<ApiResponse> handlerDuplicateEmployeeException(DuplicateEmployeeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse(ex.getMessage(), null));
    }
        @ExceptionHandler(EmployeeNotFoundException.class)
                public ResponseEntity<ApiResponse> handlerEmployeeNotFoundException (EmployeeNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(ex.getMessage(), null));
        }
    }

