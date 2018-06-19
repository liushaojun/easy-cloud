package com.brook.sample.stream;

import com.brook.sample.stream.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@Slf4j
public class StreamSampleApplicationTest {

  @Autowired
  private Processor pipe;
  @Autowired
  private MessageCollector messageCollector;

  @Test
  public void whenSendMessage_thenResponseShouldUpdateText() {
    Message<MessageDTO> payload = MessageBuilder.withPayload(new MessageDTO(1, "This is my "
        + "message")).build();
    pipe.input().send(payload);
    final Message<?> poll = messageCollector.forChannel(pipe.output()).poll();

    log.info("result: " + poll.getPayload());
  }

}