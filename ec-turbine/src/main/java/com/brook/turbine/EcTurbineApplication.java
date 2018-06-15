package com.brook.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author brook
 */
@SpringBootApplication
@EnableTurbine
public class EcTurbineApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcTurbineApplication.class, args);
  }
}
