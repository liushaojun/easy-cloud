package com.brook.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.brook.product.BaseTest;
import com.brook.product.domain.ProductInfo;
import com.brook.product.dto.ProductDTO;
import com.brook.product.form.ProductForm;
import com.brook.product.support.RestException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Brook 😈
 * @since 2018/6/12
 */
@Slf4j
@Transactional
public class ProductServiceTest  extends BaseTest {

  @Autowired
  ProductService productService;
  @Test
  public void save() {
    final ProductDTO info = productService.save(buildEntity());
    assertThat(info).isNotNull()
        .hasFieldOrProperty("id");
  }

  private ProductForm buildEntity() {
    ProductForm info = new ProductForm();
    info.productName = "iPhoneX";
    info.price = BigDecimal.valueOf(8000);
    return info;
  }

  @Test
  public void findById() {
    ProductDTO info = productService.findById(1L);
    assertThat(info).isNotNull();
  }

  @Test
  public void findAll() {
    final List<ProductDTO> userInfo = productService.findAll();
    assertThat(userInfo).isNotEmpty();
  }

  @Test
  public void modify() {
    ProductForm info = new ProductForm();
    info.id = 1L;
    info.productName= "aa";
    info.price = BigDecimal.ZERO;
    productService.modify(info);
  }

  @Test
  public void delete() {
    productService.delete(1L);
    assertThatThrownBy(()->productService.findById(1L))
        .isExactlyInstanceOf(RestException.class);
  }
}