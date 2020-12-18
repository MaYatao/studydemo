package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class AutoCommitConsumer {
    private static Properties getProps(){
        Properties props =  new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "test_3");
        props.put("session.timeout.ms", 30000);       // 如果其超时，将会可能触发rebalance并认为已经死去，重新选举Leader
        props.put("enable.auto.commit", "true");      // 开启自动提交
        props.put("auto.commit.interval.ms", "1000"); // 自动提交时间
        props.put("auto.offset.reset","earliest"); // 从最早的offset开始拉取，latest:从最近的offset开始消费
        props.put("client.id", "consumer-2"); // 发送端id,便于统计
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }

    public static void main(String[] args) {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getProps())) {
            List<String> topics = new ArrayList<>();
            topics.add("producer-syn");
            consumer.subscribe(topics);
            // 拉取任务超时时间
            for(;;) {
                // 拉取任务超时时间
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord consumerRecord : records) {
                    System.out.println("partition:" + consumerRecord.partition());
                    System.out.println("offset:" + consumerRecord.offset());
                    System.out.println("key:" + consumerRecord.key());
                    System.out.println("value:" + consumerRecord.value());
                }

            }
        }
    }

}
