package com.brook.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Brook 😈 [liushaojun@qianbao.com]
 * @since 2018/6/11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main(String... args) {
    new SpringApplicationBuilder(EurekaServerApplication.class)
        .run(args);
  }
}
