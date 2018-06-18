package com.brook.consumer.client;

import com.brook.product.api.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@FeignClient(value = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient extends ProductApi {

}
