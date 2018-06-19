package com.brook.sample.stream.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageDTO {

  public Long id;
  public String body;

  public MessageDTO(long id, String body) {
    this.id = id;
    this.body = body;
    this.now = LocalDateTime.now();
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime now;
}
