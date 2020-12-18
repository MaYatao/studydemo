package com.example.kafka.topic;


import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaTopic {
//    private static final String topicName = "sunday";
    private static final String broker = "127.0.0.1:9092";
    public static AdminClient client;

    static void initClient() {
        if (client != null) {
            client.close();
            client = null;
        }
        try {
            Properties admainProp = new Properties();
            admainProp.put("bootstrap.servers", broker);
            client = AdminClient.create(admainProp);
            System.out.println("初始化KAFKA-Client成功!");
        } catch (Exception e) {
            System.out.println("初始化Client失败！");
        }
    }

    public static void main(String[] args) {
        initClient();
     // createTopic();
   // deleteTopic("flink_test");
   listAllTopic();
        System.out.println("----------------------");
    //    getTopicInfo("quick_start_m");
        deleteTopic("flink_test");
        System.out.println("----------------------");
        listAllTopic();
      // getdDescribeCluster();
    }

    private static void getdDescribeCluster() {
     DescribeClusterResult result=   client.describeCluster();
        try {
            System.out.println(result.clusterId().get());
            System.out.println(result.controller().get());
            System.out.println(result.nodes().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
    * 创建主题
    * kafka-topics.sh --zookeeper localhost:2181 --create --topic kafka-action --replication-factor 2 --partitions 3
    */
    private static void createTopic(String topicName) {
        try {
            NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);
            CreateTopicsOptions createTopicsOptions = new CreateTopicsOptions();
    //        createTopicsOptions.validateOnly(true);
            createTopicsOptions.timeoutMs(Integer.valueOf("1000"));
            client.createTopics(Arrays.asList(newTopic), createTopicsOptions);
            System.out.println("Topic创建成功！");
        } catch (Exception e) {
            System.out.println("创建失败：" + e.getMessage());
        }


    }

    /**
     * 除某主题
     * kafka-topics.sh --zookeeper localhost:2181 --topic kafka-action --delete
     */
    private static void deleteTopic(String topicName) {
        DeleteTopicsResult topicsResult= client.deleteTopics(Arrays.asList(topicName));
        System.out.println("topic删除成功！");

    }


    //得到topic
    public   static void getTopicInfo(String topicName) {
        DescribeTopicsResult topicsResult = client.describeTopics(Arrays.asList(topicName.split(",")));
        KafkaFuture<Map<String, TopicDescription>> allInfo = topicsResult.all();
        try {
            Map<String, TopicDescription> all = allInfo.get();
            System.out.println(all);
            TopicDescription t1 = all.get(topicName);
            System.out.println(t1.toString()+":"+t1.isInternal());
        } catch (Exception e) {
            System.out.println("查询topic信息失败！：" + e.getMessage());
        }

    }
    /**
     *
     * 查看所有主题    kafka-topics.sh --zookeeper localhost:2181 --list
     */
    public static void listAllTopic() {
        try {
            System.out.println("topics:"+client.listTopics().listings().get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
