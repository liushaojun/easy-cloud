package com.brook.sample.stream.client;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
public interface MessageProcessor {

  String MESSAGE_INPUT = "message-input";
  String MESSAGE_OUTPUT = "message-output";
// 这跟旧版本不一样，必须注释
//  @Input(MESSAGE_INPUT)
//  SubscribableChannel input();

  @Output(MESSAGE_INPUT)
  MessageChannel output();

}
