package com.brook.consumer.web;

import com.brook.consumer.client.EdgeClient;
import com.brook.consumer.client.ProductClient;
import com.brook.consumer.client.UserClient;
import com.brook.consumer.client.UserClientFallback;
import com.brook.consumer.domain.MessageDto;
import com.brook.consumer.domain.UserDTO;
import com.brook.product.dto.ProductDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.time.LocalDateTime;
import java.util.List;
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
  UserClient userClient;
  @Autowired
  @LoadBalanced // 注意： 必须加此注解
  private RestTemplate lbRestTemplate;

  @Autowired
  LoadBalancerClient loadBalancerClient;

  @Autowired
  EdgeClient edgeClient;
  @Autowired
  ProductClient productClient;

  @GetMapping("/lb")
  public String greetWithLb() {
    ServiceInstance instance = loadBalancerClient.choose("user-service");
    log.info("HOST: {}, PORT: {}", instance.getHost(), instance.getPort());
    return lbRestTemplate.getForObject("http://edge-service/greet", String.class);
  }

  @GetMapping("/")
  public String greet() {
    return restTemplate.getForObject("http://localhost:8070/greet", String.class);

  }

  @HystrixCommand(fallbackMethod = "defaultMessage")
  @GetMapping("/message")
  public MessageDto message() {
    return edgeClient.message();
  }

  public MessageDto defaultMessage(){
    MessageDto dto = new MessageDto();
    dto.setId(0L);
    dto.setCreateAt(LocalDateTime.now());
    dto.setEnabled(false);
    dto.setName("默认消息");
    return dto;
  }
  // 加入容错机制
  @HystrixCommand(fallbackMethod = "defaultUser")
  @GetMapping("/user/{id}")
  public UserDTO user(@PathVariable Long id) {
    log.info("Get user id :{}", id);
    if (id == 2) {
      throw new RuntimeException("Get user error");
    }
    return lbRestTemplate.getForObject("http://user-service/user/" + id, UserDTO.class);
  }

  @GetMapping("/user")
  public List<UserDTO> users() {
    return userClient.users();
  }

  @GetMapping("/product/{id}")
  public ProductDTO products(@PathVariable Long id) {
    return productClient.info(id);
  }
  @GetMapping("/product")
  public List<ProductDTO> products(){
    return productClient.products();
  }
  public UserDTO defaultUser(Long id) {
    return UserClientFallback.DEFAULT_USER;
  }
}
