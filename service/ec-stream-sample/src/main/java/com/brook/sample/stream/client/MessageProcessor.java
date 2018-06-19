package com.brook.sample.stream.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
public interface MessageProcessor {

  String MESSAGE_INPUT = "message-input";
  String MESSAGE_OUTPUT = "message-output";

  @Input(MESSAGE_INPUT)
  SubscribableChannel input();

  @Output(MESSAGE_OUTPUT)
  MessageChannel output();

}
