# 网关作业
## 实现一个网关
> 基于 TCP 协议透明转发所有的报文到目标服务器

测试步骤：
```shell script
# 启动测试服务，服务默认监听 8088 端口
java -jar gateway-server-0.0.1-SHAPSHOT.jar

# 启动网关服务，网关服务默认监听 9991 端口
# 网关服务收到请求后，默认把报文透明转发到测试服务
mvn clean compile exec:java -Dexec.mainClass="io.github.yiwenlong.gateway.GatewayServer"

# 测试网关服务
curl http://127.0.0.1:9991/api/hello
```