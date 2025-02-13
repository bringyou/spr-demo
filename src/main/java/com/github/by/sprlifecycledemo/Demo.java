package com.github.by.sprlifecycledemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class Demo implements DisposableBean {
    private final RedisConnectionFactory connectionFactory;

    public Demo(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("begin destroy");
        String resp = connectionFactory.getConnection().ping();
    }
}
