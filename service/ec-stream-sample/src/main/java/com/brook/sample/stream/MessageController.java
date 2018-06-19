package com.brook.sample.stream;

import com.brook.sample.stream.client.MessageProcessor;
import com.brook.sample.stream.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@RestController
public class MessageController {
  @Autowired
  MessageProcessor pip;

  @GetMapping
  public void send() {
    final Message<MessageDTO> message =
        MessageBuilder.withPayload(new MessageDTO(1,"Test a stream message."))
        .build();
    pip.input().send(message);
  }
}
