package com.ericsson.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    LoadBalancerClient loadBalancerClient;

    private String serverId = "nacos-restful-provider";
    @GetMapping("/consumer")
    public String testConsumer(){
        ServiceInstance instance = loadBalancerClient.choose(serverId);
        URI uri = instance.getUri();

        String result = restTemplate.getForObject(uri + "/provider", String.class);

        return result;
    }
}
