# easy-cloud

[![Build Status](https://www.travis-ci.org/liushaojun/easy-cloud.svg?branch=master)](https://www.travis-ci.org/liushaojun/easy-cloud.svg?branch=master)
![Easy Cloud](https://img.shields.io/badge/Easy%20Cloud-v1.0-blue.svg)

> `Easy Cloud` 基于 `Spring Cloud Finchley` ,`Spring Boot 2.x` 搭建的简单微服务示例。



## 源码地址
[github](http://github.com/liushaojun/easy-cloud)
[码云](http://gitee.com/liushaojun/easy-cloud)

## 简单示例
### 基础组件
|   服务组件                              |       端口          |
|  ------------                         | :---------------:    |
| [Eureka Server](./ec-discovery/ec-eureka-server)         | 8761                |
| [Config Server](./ec-config)                         | 8888                |
| [Spring Boot Admin](./ec-admin)                      | 9000                |
| [Hystrix Dashboard](ec-dashboard)                      | 9001                |
| [Turbine Stream](ec-turbine-stream)                        | 8099                |
| Zipkin Server                          | 9411                |
| [api-gateway zuul](ec-api-gateway/ec-zuul)                       | 8080                |

### 业务服务

|   服务组件              |       端口          |
| ------------          |   :---------------:  |
| [User Service](service/ec-user-service)          | 8081                |
| [Product Service](service/ec-product-service)       | 8090                |
| [Consumer Service](service/ec-consumer)      | 8001                |
| [Edge Service](service/ec-edge-service)          | 8070                |

## 部署
### docker-compose
1. `mvn clean install -DskipTests`
2. `docker-compose up -d`

## 参考
- [Spring cloud](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html)
- [Spring Boot](https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/htmlsingle/)
- [Spring4all](http://www.spring4all.com/)
