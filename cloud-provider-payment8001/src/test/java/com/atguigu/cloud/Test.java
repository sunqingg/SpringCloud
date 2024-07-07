package com.atguigu.cloud;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test {

    @Autowired
    private PayMapper payMapper;

    @org.junit.jupiter.api.Test
    public void test1(){
        List<Pay> payList = payMapper.selectList(null);
        payList.forEach(System.out::println);
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        ReturnCodeEnum rc202 = ReturnCodeEnum.RC202;
        String code = rc202.getEnumCode("200");
        System.out.println("code = " + code);
    }
}
