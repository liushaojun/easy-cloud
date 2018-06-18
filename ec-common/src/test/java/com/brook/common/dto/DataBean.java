package com.brook.common.dto;

import com.google.common.collect.Lists;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dozer.OptionValue;
import org.dozer.util.MappingOptions;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
@NoArgsConstructor
@ToString
@Data
// 不复制null

@MappingOptions(mapNull = OptionValue.OFF)
public class DataBean {

  public Long id;
  public String name;
  public int age;
  public GENDER sex;
  public Date now;
  public DataRef ref;
  public List<String> names = Lists.newArrayList();
  @ToString
  @Data
  public static class DataBeanVO {
    public String id;
    public String name;
    public GENDER sex;
    public int age;
    public LocalDateTime now;
    public DataRef ref;
    public List<String> names = Lists.newArrayList();
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class DataRef {
    public String id;
    public String name;
  }
  public enum GENDER{
    MAN,WOMAN
  }
}
