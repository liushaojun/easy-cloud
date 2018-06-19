package com.brook.sample.stream.recive;

import com.brook.sample.stream.client.MessageProcessor;
import com.brook.sample.stream.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */

@Component
@EnableBinding(MessageProcessor.class)
@Slf4j
public class MessageReceive {
  @StreamListener(MessageProcessor.MESSAGE_INPUT)
  public void processor(MessageDTO message) {
    log.info("Receive message: {}",message);
  }

}
