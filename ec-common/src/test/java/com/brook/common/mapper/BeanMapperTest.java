package com.brook.common.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.brook.common.dto.DataBean;
import com.brook.common.dto.DataBean.DataBeanVO;
import com.brook.common.dto.DataBean.DataRef;
import com.brook.common.dto.DataBean.GENDER;
import com.google.common.collect.Lists;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;

/**
 * @author Brook 😈
 * @since 2018/6/18
 */
public class BeanMapperTest {

  @Test
  public void copySingleObject() {
    DataBean dataBean = new DataBean();
    dataBean.id = 1L;
    dataBean.age = 12;
    dataBean.name = "tom";
    dataBean.sex = GENDER.WOMAN;
    dataBean.now = null;
    dataBean.names = Lists.newArrayList("tom","lili");
    dataBean.ref = new DataRef("1","wangwu");
    DataBeanVO beanVO = new DataBeanVO();
    beanVO.now = LocalDateTime.now();
    BeanMapper.map(dataBean, beanVO);
    assertThat(beanVO.id).isEqualTo("1");
    assertThat(beanVO.name).isEqualTo("tom");
    assertThat(beanVO.age).isEqualTo(12);
    assertThat(beanVO.names).hasSize(2);

    System.out.println("output:>>>" + beanVO);
  }

  @Test
  public void copyListObject() {
    DataBean dataBean1 = new DataBean();
    dataBean1.id = 1L;
    dataBean1.age = 12;
    dataBean1.name = "tom";
    dataBean1.names = Lists.newArrayList("tom", "lili");
    dataBean1.ref = new DataRef("1","zhangsan");
    DataBean dataBean2 = new DataBean();
    dataBean2.id = 2L;
    dataBean2.age = 24;
    dataBean2.name = "lili";
    dataBean2.names = Lists.newArrayList("tom", "lili");
    dataBean2.ref = new DataRef("2", "wangwu");

    List<DataBean> beans = Lists.newArrayList(dataBean1, dataBean2);

    List<DataBeanVO> beanVos = BeanMapper.mapList(beans, DataBeanVO.class);
    assertThat(beanVos).hasSize(2);

    DataBeanVO beanVO = beanVos.get(1);

    assertThat(beanVO.name).isEqualTo("lili");
    assertThat(beanVO.age).isEqualTo(24);
    assertThat(beanVO.names.get(0)).isEqualTo("tom");
    assertThat(beanVO.ref).hasFieldOrPropertyWithValue("name","wangwu");
    assertThat(dataBean1.ref).isNotSameAs(beanVos.get(0).ref);
  }

}