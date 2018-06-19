package com.brook.sample.stream.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
public interface StreamClient {

  String INPUT = "my-input";
  String OUTPUT = "my-output";
  String ANOTHER_OUTPUT = "another-output";

  @Input(INPUT)
  SubscribableChannel input();
  @Output(ANOTHER_OUTPUT)
  MessageChannel output();

  @Output(OUTPUT)
  MessageChannel anotherOutput();


}
