package com.icommerce.product.delivery.impl.rest;

import com.icommerce.product.core.shared.AccessDeniedException;
import com.icommerce.product.core.shared.BadRequestException;
import com.icommerce.product.core.shared.ConstantUtils;
import com.icommerce.product.core.shared.ResourceNotFoundException;
import com.icommerce.product.delivery.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({BadRequestException.class, HttpMediaTypeNotSupportedException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<BaseResponse<String>> badRequestExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.BAD_REQUEST), ConstantUtils.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

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

    @ExceptionHandler({AccessDeniedException.class, AccessDeniedException.class})
    public ResponseEntity<BaseResponse<String>> accessDeniedExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.FORBIDDEN), ConstantUtils.ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseResponse<String>> globalExceptionHandler(Throwable ex, HttpServletRequest request) {
        final BaseResponse<String> response = new BaseResponse<>(ConstantUtils.FAILURE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), ConstantUtils.INTERNAL_SERVER);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
