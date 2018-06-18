package com.brook.consumer.client;

import com.brook.consumer.domain.UserDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@FeignClient(name = "user-service", path = "/user", fallback = UserClientFallback.class)
public interface UserClient {

  @GetMapping("/{id}")
  UserDTO info(@PathVariable("id") Long id);

  @GetMapping
  List<UserDTO> users();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  UserDTO save(@RequestBody UserDTO user);

  @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  UserDTO modify(@RequestBody UserDTO user);
  @DeleteMapping(value = "/{id}")
  void delete(@PathVariable("id") Long id);
}