package com.brook.product.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.boot.jackson.JsonComponent;

/**
 * @author Brook 😈
 * @since 2018/6/13
 */
@JsonComponent
public class JsonConfig {

  public static class BigDecimalSerialize extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator jsonGenerator, SerializerProvider
        serializerProvider) throws IOException {
      jsonGenerator.writeNumber(
          value.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
  }
}
