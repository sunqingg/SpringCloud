package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Autowired
    private PayService payService;


//    @RequestMapping("pay")
//    @Operation(summary = "CRUD集合")
//    public ResultData pay(HttpServletRequest request, @RequestBody Pay pay) {
//        if (request.getMethod().equalsIgnoreCase("POST")){
//            int i = payService.add(pay);
//            System.out.println("插入成功 = " + i);
//        } else if (request.getMethod().equalsIgnoreCase("DELETE")) {
//            int i = payService.delte(pay);
//            System.out.println("删除成功 = " + i);
//        } else if (request.getMethod().equalsIgnoreCase("PUT")) {
//            int i = payService.update(pay);
//            System.out.println("修改成功 = " + i);
//        } else if (request.getMethod().equalsIgnoreCase("GET")) {
////            if (pay.getId() == -4) throw new RuntimeException();
//            Pay i = payService.get(pay);
//            return ResultData.ok(i);
//        }
//
//        return ResultData.ok(null);
//    }

    @RequestMapping("pay/add")
    public ResultData add(@RequestBody Pay pay){
        return payService.add(pay);
    }
    @RequestMapping("pay/delete")
    public ResultData delete(@RequestBody Pay pay){
        return payService.delete(pay);
    }
    @RequestMapping("pay/update")
    public ResultData update(@RequestBody Pay pay){
        return payService.update(pay);
    }
    @RequestMapping("pay/get/{id}")
    public ResultData get(@PathVariable("id") int id){
        try {
            Thread.sleep(62000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return payService.get(id);
    }

    @RequestMapping("pay/readConfig")
    public ResultData readConfig(@Value("${spring.info}") String info){
        try {
            Thread.sleep(62000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResultData.ok(info);
    }
    @RequestMapping("pay/get/info")
    public ResultData info(@Value("${spring.info}") String info){
        return ResultData.ok(info + "8001");
    }
}
