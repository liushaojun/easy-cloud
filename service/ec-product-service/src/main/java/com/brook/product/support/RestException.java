package com.brook.product.support;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
public class RestException extends RuntimeException {

  @Getter
  private HttpStatus status;

  public RestException(String msg) {
    super(msg);
    this.status = HttpStatus.BAD_REQUEST;
  }


  public RestException(HttpStatus status, String msg) {
    this(msg);
    this.status = status;
  }

  public RestException(HttpStatus status) {
    this(status, status.getReasonPhrase());
    this.status = status;
  }
}
