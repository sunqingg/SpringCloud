package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
//    public static final String url = "http://localhost:8001/";
    public static final String  url = "http://cloud-payment-service/";
    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(url + "pay/add", payDTO, ResultData.class);
    }
    @RequestMapping("pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url + "pay/get/" + id, ResultData.class, id);
    }
    @RequestMapping("pay/delete")
    public ResultData deletePay(PayDTO payDTO){
        return restTemplate.postForObject(url + "pay/delete", payDTO, ResultData.class);
    }
    @RequestMapping("pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return restTemplate.postForObject(url + "pay/update", payDTO, ResultData.class);
    }

    @RequestMapping("pay/getConfig")
    public ResultData getConfig(){
        return restTemplate.getForObject(url + "pay/readConfig", ResultData.class);
    }

    @RequestMapping("pay/get/info")
    public ResultData info(){
        return restTemplate.getForObject(url + "pay/get/info", ResultData.class);
    }

    @GetMapping("discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }
        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
