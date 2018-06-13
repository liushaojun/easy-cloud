package com.brook.user.config;

import com.brook.user.support.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

  @ExceptionHandler(RestException.class)
  public Mono<ServerResponse> handler(RestException e) {
    log.warn("Rest error: {}",e.getMessage());
    return ServerResponse.status(e.getStatus()).build();
  }

}
