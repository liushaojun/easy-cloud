package com.brook.product.service;

import com.brook.common.mapper.BeanMapper;
import com.brook.product.domain.ProductInfo;
import com.brook.product.domain.ProductRepository;
import com.brook.product.dto.ProductDTO;
import com.brook.product.form.ProductForm;
import com.brook.product.support.RestException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Product service.
 *
 * @author Brook
 * @since 2018/6/12
 */
@Service
@RequiredArgsConstructor
public class ProductService {

  final ProductRepository productRepository;

  public ProductDTO save(ProductForm form) {
    final ProductInfo info = BeanMapper.map(form, ProductInfo.class);
    info.createAt = LocalDateTime.now();
    ProductInfo result = productRepository.save(info);
    return BeanMapper.map(result, ProductDTO.class);
  }

  public ProductDTO findById(Long id) {
    ProductInfo info = productRepository.findById(id)
        .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "The product [{}] not found."));
    return BeanMapper.map(info, ProductDTO.class);
  }

  public List<ProductDTO> findAll() {
    return BeanMapper.mapList(productRepository.findAll(), ProductDTO.class);
  }

  public ProductDTO modify(ProductForm form) {
    if (form.id == null) {
      throw new RestException(HttpStatus.BAD_REQUEST, "info.id is required.");
    }
    ProductInfo dest = productRepository.findById(form.id)
        .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND));
    BeanMapper.map(form, dest);
    dest.updateAt = LocalDateTime.now();
    productRepository.saveAndFlush(dest);
    return BeanMapper.map(dest, ProductDTO.class);
  }

  public void delete(Long id) {
    productRepository.deleteById(id);
  }

}
