package com.brook.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author brook
 */
@SpringBootApplication
@SpringCloudApplication
public class EcConsumerRibbonApplication {

  /**
   * Spring webflux 中可以配置：
   * <p>
   * Example:
   * <pre>
   *
   *   @Autowired
   *   private LoadBalancerExchangeFilterFunction lbFunction;
   *
   *   public Mono<String> doOtherStuff() {
   *     return WebClient.builder().baseUrl("http://stores")
   *         .filter(lbFunction)
   *         .build()
   *         .get()
   *         .uri("/stores")
   *         .retrieve()
   *         .bodyToMono(String.class);
   *    </pre>
   */
  @LoadBalanced
  @Bean
  RestTemplate lbRestTemplate() {
    return new RestTemplate();
  }


  @Primary
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }


  public static void main(String[] args) {
    SpringApplication.run(EcConsumerRibbonApplication.class, args);
  }
}
