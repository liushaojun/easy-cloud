package com.brook.user.web;

import com.brook.user.UserServiceApplicationTests;
import com.brook.user.domain.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends UserServiceApplicationTests {

  @Autowired
  private WebTestClient webClient;
  @Test
  public void info() {
    webClient.get()
        .uri("/user/1")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.username").isEqualTo("lisi");

  }

  @Test
  public void users() {
    webClient.get()
        .uri("/user")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .expectBodyList(UserInfo.class)
        .hasSize(1);
  }

  @Test
  public void save() {
    UserInfo user = new UserInfo();
    user.id = 1L;
    user.username = "lisi";
    user.mobile ="18600000001";
    webClient.post()
        .uri("/user")
        .body(Mono.just(user),UserInfo.class)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().is2xxSuccessful()
        .expectBody(UserInfo.class);
  }

  @Test
  public void modify_should_on_id() {
    UserInfo user = new UserInfo();
    user.username = "lisi";
    user.email = "lisi@easy-cloud.com";
    webClient.put()
        .uri("/user")
        .body(Mono.just(user), UserInfo.class)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(UserInfo.class);
  }
  @Test
  public void modify() {
    UserInfo user = new UserInfo();
    user.id = 1L;
    user.username = "lisi";
    user.email = "lisi@easy-cloud.com";
    webClient.put()
        .uri("/user")
        .body(Mono.just(user), UserInfo.class)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().is2xxSuccessful()
        .expectBody(UserInfo.class);
  }

  @Test
  public void delete() {
    webClient.delete()
        .uri("/user/1")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().is2xxSuccessful();
  }
}