package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【t_pay(支付交易表)】的数据库操作Service
* @createDate 2024-07-06 18:26:44
*/
public interface PayService extends IService<Pay> {

    ResultData add(Pay pay);

    ResultData delete(Pay pay);

    ResultData update(Pay pay);

    ResultData get(int id);
}
