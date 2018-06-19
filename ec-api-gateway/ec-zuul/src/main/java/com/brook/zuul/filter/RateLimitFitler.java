package com.brook.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Brook 😈
 * @since 2018/6/19
 */
@Component
@Slf4j
public class RateLimitFitler extends ZuulFilter {

  RateLimiter LOCAL_RATE_LIMITER = RateLimiter.create(1000); // 1000 r/s
  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER-1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {

    if(!LOCAL_RATE_LIMITER.tryAcquire()){
      final RequestContext ctx = RequestContext.getCurrentContext();
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
      ctx.setResponseBody(HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());
      ctx.set("success",false);
    }
    return null;
  }
}
