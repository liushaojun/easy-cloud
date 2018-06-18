package com.brook.consumer.domain;

import com.brook.common.time.TimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
public class UserDTO {
  public Long id;
  @NotBlank
  public String username;
  @Pattern(regexp = "\\d{11}", message = "The mobile is incorrect.")
  public String mobile;
  public String password = "123456";
  @Email
  public String email;
  @JsonFormat(pattern = TimeUtil.PATTERN_ON_DATETIME_VALUE)
  public LocalDateTime updateAt;
  @JsonFormat(pattern = TimeUtil.PATTERN_ON_DATETIME_VALUE)
  public LocalDateTime createAt;
}
