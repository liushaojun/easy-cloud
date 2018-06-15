## Spring Cloud Config
> 为分布式系统中的外部配置提供服务器和客户端支持。使用 `Config Server`，您可以在所有环境中管理应用程序的外部属性。
客户端和服务器上的概念映射与 `Spring Environment` 和 `PropertySource` 抽象相同，因此它们与 `Spring`
应用程序非常契合，但可以与任何以任何语言运行的应用程序一起使用。
### 架构图
![](http://blog.didispace.com/assets/5-7.png)
### 加密/解密
#### 对称加解密
1. 环境准备
如果由于“非法密钥大小”而导致异常，并且您使用Sun的JDK，则需要安装Java加密扩展（JCE）无限制强制管辖权策略文件。
[Java 8 JCE](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)
2. 测试加密
` curl localhost:8888/encrypt -d foo`
3. 测试解密
` curl localhost:8888/decrypt -d `

#### 非对称加解密
1. 创建秘钥
` keytool -genkeypair -alias easy-cloud -keyalg RSA \
   -dname "CN=easy-cloud,OU=company,O=Organization,L=City,S=State,C=china" \
   -keypass 123456 -keystore config-server.jks -storepass 123456  -validity 365`
2. 配置秘钥
```yaml
encrypt:
  keyStore:
    location: classpath:/server.jks
    password: 123456
    alias: config-server
    secret: 123456
```
3. 增加加密内容
```yaml
# foo-dev.yml
foo: '{cipher}AQBDc4myyblLVSp8x50hyeGj/k/2Q2F0U2sAiWrodXegevFaWWbwLaXKTuU1mPVUC6h2a/SrZ5MzIwle7EiFpq3PcRVFQ1Y+Fk3RugcGg4WnRrGJgrQWC8PA0Dw6VyqwInkXro1QOn0U28SfqAsP53YDviv63SVHN52uFjjBpRpTGLsKBa5RATYOglE7hl7+K2k9TbDnZ2218WGlwx6RQb4551EoBVqWsHtKhusrFVsnoHt/4uI1PT1nr+yr7fYN9fxHK5utIn8XtGxpMe8MCyeo3Zl1zlctqU+1RwC5DW1OZF9Rj7jXQOHFv1OYRUf8lJ3mWGhhpWMTCgEfOPMa4RItkXW1v3OfKtehiJN/7gcqAGcYBJ+AY6ppA61PSVZwhc4='
```
4. 增加消息总线
```
```
