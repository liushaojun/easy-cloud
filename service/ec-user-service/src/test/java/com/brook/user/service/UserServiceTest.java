package com.brook.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.brook.user.UserServiceApplicationTests;
import com.brook.user.domain.UserInfo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@Slf4j
public class UserServiceTest  extends UserServiceApplicationTests {

  @Autowired
  UserService userService;
  @Test
  public void save() {
    final UserInfo userMono = userService.save(buildUser())
        .block();
  }

  private UserInfo buildUser() {
    UserInfo info = new UserInfo();
    info.id = 1L;
    info.username = "zhangsan";
    info.birthday = LocalDate.of(1989,1,1);
    info.createAt = LocalDateTime.now();
    info.password = "123456";
    info.mobile = "18600000000";
    info.email = "zhangsan@ec.com";
    return info;
  }

  @Test
  public void findById() {
   UserInfo user = userService.findById(1L).block();
   assertThat(user).hasFieldOrPropertyWithValue("username","zhangsan");
  }

  @Test
  public void findAll() {
    final UserInfo userInfo = userService.findAll().blockFirst();
    assertThat(userInfo).isNotNull();
  }

  @Test
  public void modify() {
    UserInfo user = userService.findById(1L).block();
    user.updateAt = LocalDateTime.now();
    user.email = "zhangsan@easy-cloud.com";
    user.mobile = "18600000000";
    userService.modify(user).block();
    UserInfo newUser = userService.findById(1L).block();
    assertThat(newUser)
        .hasFieldOrPropertyWithValue("mobile","18600000000");
  }

  @Test
  public void delete() {
   userService.delete(1L).block();
  }
}