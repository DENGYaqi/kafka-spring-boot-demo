## Language

[English version](./README.md)

## 启动项目

这是一个kafka demo，包含了基础配置和简易的Controller和消费者。

### 1. 下载与安装Kafka

- 官网[下载与安装](https://kafka.apache.org/downloads), 二进制2.4.1版本
- 在./conf内修改server.properties配置文件的服务器id`broker.id=0`, 端口与application集群的端口一致`listeners=PLAINTEXT://localhost:9092`, zookeeper地址`zookeeper.connect=localhost:2181`
- 集群配置 : 如需测试集群，则新增多两个配置文件server1.properties, server2.properties, 修改内容与上方一致
- 启动kafka服务器，创建主题"my-replicated-topic", 并发送些消息。这样当你启动该项目，则可立即收取到消息作为测试。

### 2. 修改application.yml

- 更换集群ip和redis主机ip

### 3. 发送校验

- http://localhost:8089/msg/send

### 4. Kafka原理解析

[Kafka原理解析与实战](https://dengyaqi.github.io/posts/kafka/)