package com.icommerce.shopcard.delivery.impl.rest;

import com.icommerce.shopcard.core.shared.ConstantUtils;
import com.icommerce.shopcard.core.shared.ResourceNotFoundException;
import com.icommerce.shopcard.delivery.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<BaseResponse<String>> constraintViolationExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.BAD_REQUEST), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<BaseResponse<String>> resourceNotFoundExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.BAD_REQUEST), ConstantUtils.RESOURCE_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseResponse<String>> globalExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), ConstantUtils.INTERNAL_SERVER);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
