package com.brook.consumer.ribbon.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
@Data
public class UserInfo {

  public Long id;
  @NotBlank
  public String username;
  @Pattern(regexp = "\\d{11}", message = "The mobile is incorrect.")
  public String mobile;
  public String password = "123456";
  @Email
  public String email;
  public String updateAt;

  public String createAt;
}
