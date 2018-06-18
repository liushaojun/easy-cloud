package com.brook.common.spring;

import com.brook.common.time.TimeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Charsets;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */

@Configuration
public class MvcConfigAdaptor {

  @Bean
  RestTemplate restTemplate(RestTemplate restTemplate) {
    List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
    converters.removeIf(converter -> converter.equals(StringHttpMessageConverter.class));
    restTemplate.setMessageConverters(converters);
    return restTemplate;
  }

  @Bean
  @Primary
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper mapper = builder
        .build();
    mapper.registerModule(new JavaTimeModule());
    mapper.registerModule(new Jdk8Module());
    return mapper;
  }

}
