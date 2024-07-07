package com.atguigu.cloud.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName t_pay
 */
@TableName(value ="t_pay")
@Data
public class Pay implements Serializable {
    private Integer id;

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;

    private Integer deleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}