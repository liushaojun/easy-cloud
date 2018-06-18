package com.brook.consumer.client;

import com.brook.consumer.config.FeignConfig;
import com.brook.consumer.domain.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Brook 😈
 * @since 2018/6/16
 */
@FeignClient(value = "edge-service",configuration = FeignConfig.class)
public interface EdgeClient {

  /**
   * 获取信息
   * @return MessageDto
   */
  @GetMapping(value = "/message")
  MessageDto message();

}



