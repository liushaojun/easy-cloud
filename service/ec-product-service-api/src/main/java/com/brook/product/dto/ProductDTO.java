package com.brook.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@ApiModel("Product info model.")
@Data
public class ProductDTO {

  @ApiModelProperty(value = "ID", example = "1", required = true)
  public Long id;
  @NotBlank
  @ApiModelProperty(value = "产品名称", example = "iPhoneX", required = true)
  public String productName;
  @ApiModelProperty(value = "产品描述", example = "非常漂亮的手机")
  public String remark;
  @ApiModelProperty(value = "产品价格", example = "8000", required = true)
  public BigDecimal price;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty(value = "更新日期", example = "2018-01-01 00:00:00")
  public LocalDateTime updateAt;

  @ApiModelProperty(value = "创建日期", example = "2018-01-01 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime createAt;
  @Enumerated(EnumType.ORDINAL)
  public ProductStatus status;
}
