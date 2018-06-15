## 服务网关 (api-gateway)
> API 网关是一个服务器，也可以说是进入系统的唯一节点。这与面向对象设计模式中的 Facade 模式很像。
  API 网关封装内部系统的架构，并且提供 API 给各个客户端。它还可能还具备授权、监控、负载均衡、缓存、请求分片和管理、静态响应处理等功能。
### 架构
![](http://blog.daocloud.io/wp-content/uploads/2016/05/Richardson-microservices-part2-3_api-gateway.png)
### 优缺点
- **优点**: 使用 API 网关的最大优点是，它封装了应用程序的内部结构。客户端只需要同网关交互，而不必调用特定的服务。
API 网关为每一类客户端提供了特定的API，这减少了客户端与应用程序间的交互次数，还简化了客户端代码。

- **缺点**: API 网关也有一些不足。它增加了一个我们必须开发、部署和维护的高可用组件。还有一个风险是，API 网关变成了开发瓶颈。
为了暴露每个微服务的端点，开发人员必须更新 API网关。API网关的更新过程要尽可能地简单，这很重要；
否则，为了更新网关，开发人员将不得不排队等待。不过，虽然有这些不足，但对于大多数现实世界的应用程序而言，使用 API 网关是合理的。

### 使用
> 基于 `Spring Cloud` 主要提供了两种 `spring-cloud-gateway` 和 `Zuul`。
- [spring-cloud-gateway](ec-cloud-gateway)
- [Zuul](ec-zuul)
