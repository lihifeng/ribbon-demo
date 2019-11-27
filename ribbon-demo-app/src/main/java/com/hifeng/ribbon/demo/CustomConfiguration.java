package com.hifeng.ribbon.demo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.context.annotation.Bean;

public class CustomConfiguration {
    /**
     * 自定义ServerList （基于配置文件的ServerList）
     * @param config
     * @return
     */
    @Bean
    public ServerList<Server> serverList(IClientConfig config) {
        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
}
