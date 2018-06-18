package com.brook.product.form;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@Data
public class ProductForm {

  @ApiModelProperty(value = "ID", example = "1", required = false)
  public Long id;
  @NotBlank
  @ApiModelProperty(value = "产品名称", example = "iPhoneX", required = true)
  public String productName;
  @ApiModelProperty(value = "产品描述", example = "非常漂亮的手机")
  public String remark;
  @ApiModelProperty(value = "产品价格", example = "8000", required = true)
  public BigDecimal price;
}