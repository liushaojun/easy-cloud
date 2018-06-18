package com.brook.product.web;

import com.brook.product.api.ProductApi;
import com.brook.product.dto.ProductDTO;
import com.brook.product.form.ProductForm;
import com.brook.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User api.
 *
 * @author Brook 😈
 * @since 2018/6/12
 */
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

  final ProductService productService;

  @Override
  public ProductDTO info(@PathVariable Long id) {
    return productService.findById(id);
  }

  @Override
  public List<ProductDTO> products() {
    return productService.findAll();
  }

  @Override
  public ProductDTO save(@Validated @RequestBody ProductForm info) {
    return productService.save(info);
  }

  @Override
  public ProductDTO modify(@Validated @RequestBody ProductForm info) {
    return productService.modify(info);
  }

  @Override
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}
