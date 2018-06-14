package com.brook.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@Document(collection = "user_info")
@ApiModel("用户信息")
public class UserInfo {

  @Id
  @ApiModelProperty(value = "用户ID",example = "1",required = true)
  @NotNull
  public Long id;
  @NotBlank
  @Indexed(unique = true)
  @ApiModelProperty(value = "用户名", example = "zhangsan",required = true)
  public String username;
  @Pattern(regexp = "\\d{11}" , message = "The mobile is incorrect.")
  @ApiModelProperty(value = "手机号", example = "18610000000", required = true)
  public String mobile;
  @ApiModelProperty(value = "密码", example = "123456", required = true)
  public String password = "123456";
  @ApiModelProperty(value = "邮箱", example = "test@easy-cloud.com")
  @Email
  public String email;
  @ApiModelProperty(value = "生日", example = "1999-09-09")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  public LocalDate birthday;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  @ApiModelProperty(value = "更新日期", example = "2018-01-01 00:00:00")
  public LocalDateTime updateAt;

  @ApiModelProperty(value = "创建日期", example = "2018-01-01 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  public LocalDateTime createAt;

}
