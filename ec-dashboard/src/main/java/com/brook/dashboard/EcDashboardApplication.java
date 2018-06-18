package com.brook.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author brook
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableTurbine
public class EcDashboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcDashboardApplication.class, args);
  }
}
