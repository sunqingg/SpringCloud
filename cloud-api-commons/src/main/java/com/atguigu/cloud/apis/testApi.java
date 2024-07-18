package com.atguigu.cloud.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "config-nacos-client")
public interface testApi {
    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id);
}
