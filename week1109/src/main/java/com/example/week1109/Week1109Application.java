package com.example.week1109;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
public class Week1109Application {

    public static void main(String[] args) {
        SpringApplication.run(Week1109Application.class, args);
        JedisPool jedisPool = new JedisPool();
        String channelName = "ORDER";

        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }

}
