package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
* @createDate 2024-07-06 18:26:44
*/
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay>
    implements PayService{

    @Autowired
    private PayMapper payMapper;
    @Override
    public ResultData add(Pay pay) {
        int i = payMapper.insert(pay);
        return ResultData.ok(i);
    }

    @Override
    public ResultData delete(Pay pay) {
        int i = payMapper.deleteById(pay);
        return ResultData.ok(i);
    }

    @Override
    public ResultData update(Pay pay) {
        return ResultData.ok(payMapper.updateById(pay));
    }

    @Override
    public ResultData get(int id) {
        LambdaQueryWrapper<Pay> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Pay::getId,id);
        Pay one = payMapper.selectOne(wrapper);
        return ResultData.ok(one);
    }
}




