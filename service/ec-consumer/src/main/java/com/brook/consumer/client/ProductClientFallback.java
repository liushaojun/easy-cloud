package com.brook.consumer.client;

import com.brook.product.api.ProductApi;
import com.brook.product.dto.ProductDTO;
import com.brook.product.form.ProductForm;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
public class ProductClientFallback implements ProductApi {

  static final  ProductDTO DEFAULT_PRODUCT = new ProductDTO();
  static {
    DEFAULT_PRODUCT.id = 1L;
    DEFAULT_PRODUCT.productName = "默认产品";
    DEFAULT_PRODUCT.price = BigDecimal.valueOf(5000);
    DEFAULT_PRODUCT.createAt = LocalDateTime.now();
  }
  @Override
  public ProductDTO info(Long id) {
    return DEFAULT_PRODUCT;
  }

  @Override
  public List<ProductDTO> products() {
    return Lists.newArrayList(DEFAULT_PRODUCT);
  }

  @Override
  public ProductDTO save(ProductForm info) {
    return DEFAULT_PRODUCT;
  }

  @Override
  public ProductDTO modify(ProductForm info) {
    return DEFAULT_PRODUCT;
  }

  @Override
  public void delete(Long id) {
  }
}
