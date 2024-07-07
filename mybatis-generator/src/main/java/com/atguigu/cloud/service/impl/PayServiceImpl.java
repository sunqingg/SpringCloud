package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.service.PayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
* @createDate 2024-07-06 18:26:44
*/
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay>
    implements PayService{

}




