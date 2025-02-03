package com.deng.kafka.spring.boot.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyConsummer {

    @KafkaListener(topics = "my-replicated-topic",groupId = "MyGroup1")
    public void listenGroup(ConsumerRecord<String, String> record, Acknowledgment ack) { // record 对每一条消息进行操作 ack 只有手动提交才有用
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        // 手动提交offset 如果不做手动提交 消息会被重复消费
        ack.acknowledge();
    }

    @KafkaListener(groupId = "testGroup", topicPartitions = { // 多主题消费
            @TopicPartition(topic = "topic1", partitions = {"0", "1"}), // 可消费topic1主题的0号和1号分区
            @TopicPartition(topic = "topic2", partitions = "0", // 可消费topic2主题的0号分区
                partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))}, concurrency = "3") // 指定消费 : 消耗1号分区的时候偏移量是100，也就是1号分区的第100条开始消费
    // concurrency就是创建同组(testGroup)的消费者个数(3个)，就是并发消费数，建议小于等于分区总数
    public void listenGroupPro(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        //手动提交offset
        ack.acknowledge();
    }
}
