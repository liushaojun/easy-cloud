package com.brook.product.domain;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 😈 Brook
 * @since 2018/6/12
 */
public interface ProductRepository extends JpaRepository<ProductInfo,Long> {

}
