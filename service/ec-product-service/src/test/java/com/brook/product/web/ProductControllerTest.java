package com.brook.product.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.brook.product.BaseTest;
import com.brook.product.domain.ProductInfo;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest extends BaseTest {

  @TestConfiguration
  static class Config {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
      return new RestTemplateBuilder()
          .setConnectTimeout(5000)
          .setReadTimeout(5000);
    }

  }
  @Autowired
  private TestRestTemplate restTemplate;
  @Test
  public void info() {
    ProductInfo info = restTemplate.getForObject("/product/1",ProductInfo.class);
    assertThat(info).isNotNull();

  }

  @Test
  public void products() {
    final List<ProductInfo> products = restTemplate
        .exchange("/product", HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductInfo>>() {
            }).getBody();
    assertThat(products).isNotEmpty();

  }

  @Test
  public void save() {
    ProductInfo product = new ProductInfo();
    product.productName = "iPhoneX";
    product.price = BigDecimal.valueOf(8000);
    ProductInfo result = restTemplate.postForObject("/product",product,ProductInfo.class);
    assertThat(result).hasFieldOrProperty("id");
  }



  @Test
  public void modify() {
    ProductInfo product = new ProductInfo();
    product.id = 1L;
    product.productName = "iPhoneX";
    product.price = BigDecimal.valueOf(5000);
    ProductInfo result = restTemplate.postForObject("/product", product, ProductInfo.class);
    assertThat(result)
        .hasFieldOrPropertyWithValue("price",BigDecimal.valueOf(5000));
  }

  @Test
  public void delete() {
     restTemplate.delete("/product/1");
  }
}