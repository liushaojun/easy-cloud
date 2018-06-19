## Zuul
> `Zuul` 是一种提供动态路由，监控，弹性，安全性等的边缘服。它是 `Netflix` 家族提供, 现在版本zuul2 是基于异步。

### 快速开始
#### maven 依赖
```
    <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
		</dependency>
```
#### 开启zuul

```java
@EnableEurekaClient
@EnableZuulProxy
public class EcZuulApplication {
  //...
}
```
#### 自定义路由规则
```yaml
zuul:
  routes: # 默认 以 eureka 注册的服务名进行访问
#    sensitiveHeaders: 如果需要下游Cookies ,headers 配置此敏感头
     user-service: /user/** # Simple
     config-server: /config/**
#     user:
#        path: /user/**
#        service-id: user-service
     product:
        path: /product/**
        service-id: product-service
     baidu:
        url: http://baidu.com
```
#### 忽略某些服务
`ignored-services: foo-service` 此服务不会被zuul路由
#### 使用正则路由
```java
@Bean
public PatternServiceRouteMapper serviceRouteMapper() {
    return new PatternServiceRouteMapper(
        "(?<name>^.+)-(?<version>v.+$)",
        "${version}/${name}");
}
```
规则： `/foo-v1 ==> /v1/foo`

### 添加前缀
要为所有映射添加前缀，请将 `zuul.prefix`设置为一个值，例如 /api。
默认情况下，请求被转发之前，代理前缀被删除（使用 `zuul.stripPrefix=false` 关闭此行为）。
您还可以关闭从各路线剥离服务特定的前缀，例如
```yaml
zuul:
  prefix: api
  routes:
      users:
        path: /user-api/**
        stripPrefix: false
```
注意： `zuul.stripPrefix` 仅适用于 `zuul.prefix` 中设置的前缀。它对给定路由 `path` 中定义的前缀有影响。

#### 自定义过滤器
zuul 主要是通过过滤器去实现的。它的生命周期是 `PRE`,`ROUTING`,`POST` 和 `ERROR`.
zuul 默认已经实现了很多过滤功能。如下：

| 类型     | 顺序  | 过滤器                   | 功能                        |
| :----: | :----: | ----------------------- | --------------------------  |
| PRE     | -3   | ServletDetectionFilter  | 标记处理Servlet的类型         |
| PRE     | -2   | Servlet30WrapperFilter  | 包装HttpServletRequest请求   |
| PRE     | -1   | FormBodyWrapperFilter   | 包装请求体                    |
| ROUTING | 1    | DebugFilter             | 标记调试标志                  |
| ROUTING | 5    | PreDecorationFilter     | 处理请求上下文供后续使用        |
| ROUTING | 10   | RibbonRoutingFilter     | ServiceId请求转发            |
| ROUTING | 100  | SimpleHostRoutingFilter | url请求转发                  |
| ROUTING | 500  | SendForwardFilter       | forward请求转发              |
| POST    | 0    | SendErrorFilter         | 处理有错误的请求响应           |
| POST    | 1000 | SendResponseFilter      | 处理正常的请求响应             |



```
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
    // 限流
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
```
#### 路由熔断


### FQA
#### routes 端点问题
参考 [Spring Boot Actuator 2.x](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Migration-Guide#endpoints)
如果访问 `/routes` 返回 404,如果是 `Spring Boot 2.x` 则需要添加
```yaml
management:
  endpoints:
    web:
      exposure:
        include: routes,filters
```
然后访问 `/actuator/routes` 就出现配置的路由了。

