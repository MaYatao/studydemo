package com.es.demo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InitClient {


    private static TransportClient client;

    public static TransportClient getClient() throws UnknownHostException {

        if(client == null) {
            //client = new PreBuiltTransportClient(Settings.EMPTY)

            // 连接集群的设置
            Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch_tao") //如果集群的名字不是默认的elasticsearch，需指定
                    .put("client.transport.sniff", false) //自动嗅探
                    .build();
            client = new PreBuiltTransportClient(settings)
                  .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
                  //  .addTransportAddress(new TransportAddress(InetAddress.getByName("start.com"), 9300));

            //可用连接设置参数说明
            /*
            cluster.name
                指定集群的名字，如果集群的名字不是默认的elasticsearch，需指定。
            client.transport.sniff
                设置为true,将自动嗅探整个集群，自动加入集群的节点到连接列表中。
            client.transport.ignore_cluster_name
                Set to true to ignore cluster name validation of connected nodes. (since 0.19.4)
            client.transport.ping_timeout
                The time to wait for a ping response from a node. Defaults to 5s.
            client.transport.nodes_sampler_interval
                How often to sample / ping the nodes listed and connected. Defaults to 5s.
            */

        }
        return client;
    }


}

