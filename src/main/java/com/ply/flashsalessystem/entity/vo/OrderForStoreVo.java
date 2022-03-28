package com.ply.flashsalessystem.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/27 13:17
 * <p>
 * action:
 */
@Data
public class OrderForStoreVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "ofg_id", type = IdType.AUTO)
    private Integer ofgId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户联系电话")
    private String iphone;

    @ApiModelProperty(value = "应付金额")
    private BigDecimal amountDue;

    @ApiModelProperty(value = "已付金额")
    private BigDecimal amountPaid;

    @ApiModelProperty(value = "已退金额")
    private BigDecimal amountReturn;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "订单时间")
    private Date createTime;

    @ApiModelProperty(value = "取货地址")
    private String storeAddress;
}
