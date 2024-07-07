package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("feign")
public class OrderController {
    @Autowired

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

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO)
    {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @RequestMapping("pay/get/{id}")
    public ResultData getInfo(@PathVariable("id") int id) {
        return payFeignApi.getPayInfo(id);
    }

    @RequestMapping("pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
        return payFeignApi.updatePay(payDTO);
    }

    @RequestMapping("pay/readConfig")
    public ResultData readConfig(){
        try {
            System.out.println("time: " + new Date());
            return payFeignApi.readConfig();
        }catch (Exception e){
            System.out.println("e = " + e.getMessage());
            System.out.println("time: " + new Date());
            return ResultData.fail(ReturnCodeEnum.RC500);
        }

    }


    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping(value = "/pay/mylb")
    public String mylb()
    {
        return payFeignApi.mylb();
    }
}
