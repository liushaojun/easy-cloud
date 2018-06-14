package com.brook.product.web;

import com.brook.product.domain.ProductInfo;
import com.brook.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * User api.
 *
 * @author Brook 😈
 * @since 2018/6/12
 */
@RequestMapping(value = "/product"
    , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequiredArgsConstructor
public class ProductController {

  final ProductService productService;

  @GetMapping("/{id:\\d+}")
  public ProductInfo info(@PathVariable Long id) {
    return productService.findById(id);
  }

  @GetMapping
  public List<ProductInfo> products() {
    return productService.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ProductInfo save(@Validated @RequestBody ProductInfo info) {
    return productService.save(info);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ProductInfo modify(@Validated @RequestBody ProductInfo info) {
    return productService.modify(info);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}
