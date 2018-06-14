package com.brook.product.service;

import com.brook.product.domain.ProductInfo;
import com.brook.product.domain.ProductRepository;
import com.brook.product.support.RestException;
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

  public ProductInfo save(ProductInfo info) {
    return productRepository.save(info);
  }

  public ProductInfo findById(Long id) {

    return productRepository.findById(id)
        .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "The product [{}] not found."));
  }

  public List<ProductInfo> findAll() {
    return productRepository.findAll();
  }

  public ProductInfo modify(ProductInfo info) {
    if (info.id == null) {
      throw new RestException(HttpStatus.BAD_REQUEST,"info.id is required.");
    }
    ProductInfo dest = this.findById(info.id);
    dest.productName = info.productName;
    dest.price = info.price;
    dest.status = info.status;
    return productRepository.saveAndFlush(dest);
  }

  public void delete(Long id) {
    productRepository.deleteById(id);
  }

}
