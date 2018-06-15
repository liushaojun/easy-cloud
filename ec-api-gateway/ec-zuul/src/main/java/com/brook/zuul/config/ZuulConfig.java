package com.brook.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
@Configuration
public class ZuulConfig {

  /**
   * zuul 动态刷新
   * @return zuulProperties
   */
  @ConfigurationProperties("zuul")
  @RefreshScope
  public ZuulProperties zuulProperties(){
    return new ZuulProperties();
  }
}
