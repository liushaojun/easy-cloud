## Turbine Stream
> `Spring Cloud` 在封装 `Turbine` 的时候，还实现了基于消息代理的收集实现。所以，我们可以将所有需要收集的监控信息都输出到消息代理中，
然后 `Turbine` 服务再从消息代理中异步的获取这些监控信息，最后将这些监控信息聚合并输出到 `Hystrix Dashboard` 中。
如下架构图：

![](docs/turbine-stream.png)
