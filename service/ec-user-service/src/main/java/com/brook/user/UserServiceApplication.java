package com.brook.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brook
 */
@SpringCloudApplication
@RefreshScope
@RestController
public class UserServiceApplication {

  @GetMapping("/greet")
  public String greet() {
    return "hello ,greet!";
  }

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
