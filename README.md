## Language

[简体中文](./README_zh.md)

## Start project

This is a project of kafka demo, it contains basic configuration and a simple controller and consumer. 

### 1. download Kafka

- [Download kafka](https://kafka.apache.org/downloads), version binary 2.4.1
- in path ./conf, completed these attribute : `broker.id=0`, `listeners=PLAINTEXT://localhost:9092`, `zookeeper.connect=localhost:2181`
- cluster configuration : copy two more file : server1.properties, server2.properties
- start kafka server, and create topic "my-replicated-topic", and send some message. Then, when you run this project, you can receive immediately some message.

### 1. replace attribute of application.yml

- replace bootstrap-servers host and redis host

### 2. send api verify

- http://localhost:8089/msg/send

### 3. Kafka documentation

[Kafka原理解析与实战](https://dengyaqi.github.io/posts/kafka/)