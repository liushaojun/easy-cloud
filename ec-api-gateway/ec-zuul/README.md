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

#### 开启熔断


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
