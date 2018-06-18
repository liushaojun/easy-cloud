package com.brook.product.api;

import com.brook.product.dto.ProductDTO;
import com.brook.product.form.ProductForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

/**
 * user 接口
 *
 * @author Brook 😈
 * @since 2018/6/18
 */
@Api(tags = "Product", description = "Contains product queries/add/delete/modify operations.")
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public interface ProductApi {

  @GetMapping("/{id}")
  @ApiOperation("Gets product info.")
  ProductDTO info(@PathVariable("id") Long id);

  @GetMapping
  @ApiOperation("Gets all products list.")
  List<ProductDTO> products();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation("Save a new product.")
  ProductDTO save(@Validated @RequestBody ProductForm info);

  @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation("Modify update info.")
  ProductDTO modify(@Validated @RequestBody ProductForm info);

  @DeleteMapping(value = "/{id:\\d+}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @ApiOperation("Delete a product.")
  void delete(@PathVariable("id") Long id);
}