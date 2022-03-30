package com.ply.flashsalessystem.entity.vo.user;

import com.ply.flashsalessystem.entity.pojo.Goods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author XiaoPan
 * date: 2022/3/31 0:17
 * <p>
 * action:
 */
@Data
public class OrderForUserVo {

    @ApiModelProperty(value = "用户name")
    private String userName;

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

    @ApiModelProperty(value = "订单详情")
    List<OrderDetailsUserVo> detailsUserVos;




}
