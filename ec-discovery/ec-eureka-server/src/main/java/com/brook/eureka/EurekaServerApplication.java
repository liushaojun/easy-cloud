package com.brook.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Brook 😈 [liushaojun@qianbao.com]
 * @since 2018/6/11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main(String... args) {
    SpringApplication.run(EurekaServerApplication.class,args);
  }

  @Configuration
  public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().ignoringAntMatchers("/eureka/**");
      super.configure(http);
    }
  }
}
