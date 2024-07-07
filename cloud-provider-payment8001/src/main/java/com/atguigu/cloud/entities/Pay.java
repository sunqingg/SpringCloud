package com.atguigu.cloud.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @TableId
    private Integer id;
    @Schema(title = "支付流水号")
    private String payNo;
    @Schema(title = "订单流水号")
    private String orderNo;
    @Schema(title = "用户账号ID")
    private Integer userId;

    private BigDecimal amount;

    private Integer deleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}