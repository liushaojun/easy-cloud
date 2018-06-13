package com.brook.user.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author 😈 Brook
 * @since 2018/6/12
 */
public interface UserRepository extends ReactiveCrudRepository<UserInfo,Long> {

}
