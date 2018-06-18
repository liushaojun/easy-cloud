package com.brook.common.mapper;

import com.brook.common.mapper.converter.LocalDateTimeToDate;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

/**
 * Bean copy 工具类
 * 禁止使用 Apache Common Utils 的 BeanUtils ，因为它非常慢。
 * orika性能比Dozer快近十倍，也不需要Getter函数与无参构造函数，
 * 但是不兼容不同类型的同名属性。
 * 这里采用稳定的 Dozer ，但是它必须提供 Getter ,Setter 函数。
 *
 * @author Brook 😈
 * @since 2018/6/18
 */
public class BeanMapper {

  private static Mapper mapper = DozerBeanMapperBuilder.create()
      .withMappingFiles("dozer-java8.xml")
      .withCustomConverter(new LocalDateTimeToDate(LocalDateTime.class,Date.class))
      .build();

  /**
   * 简单的复制出新类型对象.
   */
  public static <S, D> D map(S source, Class<D> destinationClass) {
    return mapper.map(source, destinationClass);
  }

  /**
   * 简单的复制出新类型对象.
   */
  public static <S, D> void map(S source, D destination) {
     mapper.map(source, destination);
  }
  /**
   * 简单的复制出新对象ArrayList
   */
  public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
    List<D> destionationList = new ArrayList<D>();
    for (S source : sourceList) {
      if (source != null) {
        destionationList.add(mapper.map(source, destinationClass));
      }
    }
    return destionationList;
  }

  /**
   * 简单复制出新对象数组
   */
  public static <S, D> D[] mapArray(final S[] sourceArray, final Class<D> destinationClass) {
    D[] destinationArray = (D[]) Array.newInstance(destinationClass, sourceArray.length);

    int i = 0;
    for (S source : sourceArray) {
      if (source != null) {
        destinationArray[i] = mapper.map(sourceArray[i], destinationClass);
        i++;
      }
    }

    return destinationArray;
  }
}
