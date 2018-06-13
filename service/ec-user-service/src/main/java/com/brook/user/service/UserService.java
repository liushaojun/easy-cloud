package com.brook.user.service;

import com.brook.user.domain.UserInfo;
import com.brook.user.domain.UserRepository;
import com.brook.user.support.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User service.
 *
 * @author Brook
 * @since 2018/6/12
 */
@Service
@RequiredArgsConstructor
public class UserService {

  final UserRepository userRepository;

  public Mono<UserInfo> save(UserInfo user) {
    if (user.id == null) {
      throw new RestException(HttpStatus.BAD_REQUEST);
    }
    return userRepository.save(user);
  }

  public Mono<UserInfo> findById(Long id) {
    return userRepository.findById(id);
  }

  public Flux<UserInfo> findAll() {
    return userRepository.findAll();
  }

  public Mono<UserInfo> modify(UserInfo user) {
    return userRepository.save(user);
  }

  public Mono<Void> delete(Long id) {
    return userRepository.deleteById(id);
  }
}
