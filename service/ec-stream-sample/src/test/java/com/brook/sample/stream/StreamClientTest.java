package com.brook.sample.stream;

import static org.junit.Assert.assertEquals;

import com.brook.sample.stream.client.MessageProcessor;
import com.brook.sample.stream.client.StreamClient;
import com.brook.sample.stream.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
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
public class StreamClientTest {

  @Autowired
  StreamClient streamClient;

  @Autowired
  private MessageCollector messageCollector;

  @Autowired
  MessageProcessor messageProcessor;

  @Test
  public void sendMessage(){
    final Message<MessageDTO> message =
        MessageBuilder.withPayload(new MessageDTO(1, "Test a stream message."))
            .build();
    messageProcessor.output().send(message);
  }
  @Test
  public void whenSendMessage_thenResponseIsInOutput() {
    whenSendMessage(1);
    thenPayloadInChannelIs(streamClient.output(), "1");
  }

  @Test
  public void whenSendMessage_thenResponseIsInAnotherOutput() {
    whenSendMessage(11);
    thenPayloadInChannelIs(streamClient.anotherOutput(), "11");
  }

  private void whenSendMessage(Integer val) {
    streamClient.input().send(MessageBuilder.withPayload(val).build());
  }

  private void thenPayloadInChannelIs(MessageChannel channel, String expectedValue) {
    Object payload = messageCollector.forChannel(channel).poll().getPayload();
    assertEquals(expectedValue, payload);
  }

}
