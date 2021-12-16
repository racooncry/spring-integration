package com.shenfeng.yxw.springintegration.config;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.config.CuratorFrameworkFactoryBean;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

/**
 * @Author: yangxiaowei37
 * @Date: 16/12/2021 上午11:25
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class ZookeeperLockConfiguration {
    @Value("${zookeeper.host}")
    private String zkUrl;


    @Bean
    public CuratorFrameworkFactoryBean curatorFrameworkFactoryBean() {
        return new CuratorFrameworkFactoryBean(zkUrl);
    }

    @Bean
    public ZookeeperLockRegistry zookeeperLockRegistry(CuratorFramework curatorFramework) {
        return new ZookeeperLockRegistry(curatorFramework, "/zookeeper-lock");
    }
}