package com.brook.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Brook 😈
 * @since 2018/6/16
 */

@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
