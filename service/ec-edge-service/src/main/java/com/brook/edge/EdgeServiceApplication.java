package com.brook.edge;

import com.brook.edge.dto.MessageDto;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brook
 */
@RestController
@SpringCloudApplication
@Slf4j
public class EdgeServiceApplication {

  @GetMapping("/greet")
  public String greet(String name){
    return "Greet,"+ name;
  }
  public static void main(String[] args) {
    SpringApplication.run(EdgeServiceApplication.class, args);
  }

  @GetMapping("/message")
  public MessageDto message(){
    MessageDto dto = new MessageDto();
    dto.setId(1L);
    dto.setEnabled(false);
    dto.setName("测试消息");
    dto.setCreateAt(LocalDateTime.now());
    return dto;
  }
}
