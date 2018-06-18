package com.brook.consumer;

import com.brook.consumer.domain.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Brook 😈
 * @since 2018/6/15
 */
@JsonTest
@Slf4j
@RunWith(SpringRunner.class)
public class JsonSerialTest {

  @Test
  public void test() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    MessageDto dto = new MessageDto();
    dto.setId(1L);
    dto.setCreateAt(LocalDateTime.now());
    String json = mapper.writeValueAsString(dto);
    log.info("json: {}",json);
    MessageDto result = mapper.readValue(json,MessageDto.class);
    log.info("createAt: {}",result.getCreateAt());
  }
}
