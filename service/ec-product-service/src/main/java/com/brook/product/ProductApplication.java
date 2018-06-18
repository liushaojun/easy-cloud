package com.brook.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author brook
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class ProductApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class, args);
  }
}
