package com.procesos.concessionaire.exceptionhandler;

import com.procesos.concessionaire.exception.BadRequestException;
import com.procesos.concessionaire.exception.NoDataFoundException;
import com.procesos.concessionaire.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.procesos.concessionaire.utils.message.Constants.BAD_REQUEST_EXCEPTION;
import static com.procesos.concessionaire.utils.message.Constants.MESSAGE;
import static com.procesos.concessionaire.utils.message.Constants.NO_VALUE_PRESENT;
import static com.procesos.concessionaire.utils.message.Constants.USER_ALREADY_EXISTS_EXCEPTION;
import static com.procesos.concessionaire.utils.message.Constants.USER_NOT_FOUND;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, USER_NOT_FOUND));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, BAD_REQUEST_EXCEPTION));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, USER_ALREADY_EXISTS_EXCEPTION));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, NO_VALUE_PRESENT));
    }

}
