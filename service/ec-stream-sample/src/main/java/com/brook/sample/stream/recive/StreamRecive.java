package com.brook.sample.stream.recive;

import com.brook.sample.stream.client.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamRecive {

  @Autowired
  StreamClient streamClient;
  @StreamListener(value = StreamClient.INPUT,
  condition = "payload <10")
  public void routeInput(Integer val){
    streamClient.output().send(message(val));
  }


  @StreamListener(target = StreamClient.INPUT
  , condition = "payload >=10")
  public void routeAnotherOutput(Integer val){
    streamClient.anotherOutput().send(message(val));
  }


  public static final <T> Message<T> message(T val){
    return MessageBuilder.withPayload(val).build();
  }
}
