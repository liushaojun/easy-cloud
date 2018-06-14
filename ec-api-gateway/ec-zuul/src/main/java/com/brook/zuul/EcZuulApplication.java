package com.brook.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author brook
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class EcZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcZuulApplication.class, args);
	}
}
