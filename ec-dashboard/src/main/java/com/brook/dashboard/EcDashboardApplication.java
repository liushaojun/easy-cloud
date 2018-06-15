package com.brook.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EcDashboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcDashboardApplication.class, args);
  }
}
