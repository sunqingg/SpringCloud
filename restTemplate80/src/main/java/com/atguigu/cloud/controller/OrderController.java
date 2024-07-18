package com.atguigu.cloud.controller;


//import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.apis.PayFeignSentinelApi;
import com.atguigu.cloud.apis.testApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    public static final String url = "http://127.0.0.1:8001/";

    @GetMapping("/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id)
    {
        String result = restTemplate.getForObject("http://localhost:8001" + "/pay/get/" + id, String.class);
        return result+"\t"+"    我是OrderNacosController83调用者。。。。。。";
    }
    @RequestMapping("pay/get/{id}")
    public String getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url + "pay/get/" + id, String.class, id);
    }

//    @Autowired
//    private com.atguigu.cloud.apis.testApi testApi;

    @Resource
    private PayFeignSentinelApi sentinelApi;

    @GetMapping(value = "/consumer/test/{orderNo}")
    public ResultData test(@PathVariable("orderNo") String orderNo)
    {
        return sentinelApi.getPayByOrderNo(orderNo);
    }

}
