package com.brook.consumer.client;

import com.brook.consumer.domain.UserDTO;
import com.google.common.collect.Lists;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
public class UserClientFallback implements UserClient {

  public static final UserDTO DEFAULT_USER = new UserDTO();
  static {
    DEFAULT_USER.id = 0L;
    DEFAULT_USER.mobile = "18600000000";
    DEFAULT_USER.createAt = LocalDateTime.now();
  }

  @Override
  public UserDTO info(Long id) {
    return DEFAULT_USER;
  }

  @Override
  public List<UserDTO> users() {
    return Lists.newArrayList(DEFAULT_USER);
  }

  @Override
  public UserDTO save(UserDTO user) {
    return DEFAULT_USER;
  }

  @Override
  public UserDTO modify(UserDTO user) {
    return DEFAULT_USER;
  }

  @Override
  public void delete(Long id) {
  }
}
