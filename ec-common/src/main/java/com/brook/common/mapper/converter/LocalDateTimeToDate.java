package com.brook.common.mapper.converter;

import com.brook.common.time.TimeUtil;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.dozer.DozerConverter;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
public class LocalDateTimeToDate extends DozerConverter<LocalDateTime, Date> {


  /**
   * Defines two types, which will take part transformation.
   * As Dozer supports bi-directional mapping it is not known which of the classes is source and
   * which is destination. It will be decided in runtime.
   *
   * @param prototypeA type one
   * @param prototypeB type two
   */
  public LocalDateTimeToDate(Class<LocalDateTime> prototypeA, Class<Date> prototypeB) {
    super(prototypeA, prototypeB);
  }

  @Override
  public Date convertTo(LocalDateTime source, Date destination) {
    if (source != null) {
      return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }
    return null;
  }

  @Override
  public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
    if (source != null) {
      return TimeUtil.asLocalDateTime(source);
    }
    return null;
  }
}
