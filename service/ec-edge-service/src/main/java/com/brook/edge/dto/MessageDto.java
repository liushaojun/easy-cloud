package com.brook.edge.dto;

import com.brook.common.time.TimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
@Data
public class MessageDto {

  private Long id;
  private boolean enabled;
  private String name;
  @JsonFormat(pattern = TimeUtil.PATTERN_ON_DATETIME_VALUE)
  private LocalDateTime createAt;
}
