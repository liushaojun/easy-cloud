package com.brook.turbine.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineStreamApplication {

  public static void main(String... args) {
    SpringApplication.run(TurbineStreamApplication.class);
  }
}
