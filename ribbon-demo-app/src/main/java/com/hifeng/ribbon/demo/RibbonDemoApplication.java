package com.hifeng.ribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonDemoApplication {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RibbonDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello:"+port;
    }

    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://custom/hello", String.class);
    }
}
