package com.brook.product.config;

import com.brook.product.support.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

  @ExceptionHandler(RestException.class)
  public ResponseEntity<String> handler(RestException e) {
    log.warn("Rest error: {}",e.getMessage());
    return new ResponseEntity<>(e.getMessage(),e.getStatus());
  }

}
