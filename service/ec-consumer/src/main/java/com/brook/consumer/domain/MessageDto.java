package com.brook.consumer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MessageDto {

  private Long id;
  private boolean enabled;
  private String name;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private LocalDateTime createAt;
}