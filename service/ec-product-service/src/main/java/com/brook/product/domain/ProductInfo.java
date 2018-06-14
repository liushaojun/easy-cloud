package com.brook.product.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

/**
 *{@code @DynamicUpdate} 注解不生效，我测试时发现它必须先查询，然后在放到session中。
 * @author Brook 😈
 * @since 2018/6/12
 */
@ApiModel("产品信息")
@ToString
@Entity
@DynamicInsert
//@DynamicUpdate
public class ProductInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "ID",example = "1",required = true)
  public Long id;
  @NotBlank
  @ApiModelProperty(value = "产品名称", example = "iPhoneX",required = true)
  public String productName;
  @ApiModelProperty(value = "产品描述", example = "非常漂亮的手机")
  public String remark;
  @ApiModelProperty(value = "产品价格", example = "8000", required = true)
  public BigDecimal price;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  @ApiModelProperty(value = "更新日期", example = "2018-01-01 00:00:00")
  public LocalDateTime updateAt;

  @ApiModelProperty(value = "创建日期", example = "2018-01-01 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  public LocalDateTime createAt;
  @Enumerated(EnumType.ORDINAL)
  public ProductStatus status;

}
