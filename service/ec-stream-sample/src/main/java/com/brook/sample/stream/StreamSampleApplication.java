package com.brook.sample.stream;

import com.brook.sample.stream.model.MessageDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@SpringBootApplication
// 这里绑定了两个通道
@EnableBinding(Processor.class)
public class StreamSampleApplication {


  @StreamListener(Processor.INPUT)
  @SendTo(Processor.OUTPUT)
  public MessageDTO message(MessageDTO message) {
    return new MessageDTO(1,message.body);
  }

  public static void main(String[] args) {
    SpringApplication.run(StreamSampleApplication.class,args);
  }
}
