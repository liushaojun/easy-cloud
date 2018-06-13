package com.brook.user.web;

import com.brook.user.domain.UserInfo;
import com.brook.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User api.
 * @author Brook 😈
 * @since 2018/6/12
 */
@RequestMapping(value = "/user"
    ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequiredArgsConstructor
public class UserController {

  final UserService userService;
  @GetMapping("/{id}")
  public Mono<UserInfo> info(@PathVariable Long id){
    return userService.findById(id);
  }

  @GetMapping
  public Flux<UserInfo> users(){
    return userService.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<UserInfo> save(@Validated @RequestBody UserInfo user){
    return userService.save(user);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<UserInfo> modify(@Validated @RequestBody UserInfo user) {
    return userService.save(user);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono delete(@PathVariable Long id){
    return userService.delete(id);
  }
}
