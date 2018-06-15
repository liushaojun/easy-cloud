package com.brook.consumer.ribbon.web;

import com.brook.consumer.ribbon.domain.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
@RestController
@Slf4j
public class GreetController {

  @Autowired
  private RestTemplate restTemplate;


  @Autowired
  @LoadBalanced // 注意： 必须加此注解
  private RestTemplate lbRestTemplate;

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @GetMapping("/lb")
  public String greetWithLb() {
    ServiceInstance instance = loadBalancerClient.choose("user-service");
    log.info("HOST: {}, PORT: {}", instance.getHost(), instance.getPort());
    return lbRestTemplate.getForObject("http://user-service/greet", String.class);
  }

  @GetMapping("/")
  public String greet() {
    return restTemplate.getForObject("http://localhost:8081/greet", String.class);

  }

  // 加入容错机制
  @HystrixCommand(fallbackMethod = "defaultUser")
  @GetMapping("/user/{id}")
  public UserInfo user(@PathVariable Long id) {
    log.info("Get user id :{}", id);
    if (id == 2) {
      throw new RuntimeException("Get user error");
    }
    return lbRestTemplate.getForObject("http://user-service/user/" + id, UserInfo.class);
  }

  public UserInfo defaultUser(Long id) {
    UserInfo user = new UserInfo();
    user.id = 0L;
    user.username = "easy-cloud";
    user.createAt = LocalDateTime.now().toString();
    return user;
  }
}
