package com.ply.flashsalessystem.entity.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author XiaoPan
 * date: 2022/3/31 0:34
 * <p>
 * action:
 */
@Data
public class OrderDetailsUserVo {
    @ApiModelProperty(value = "商品name")
    private String name;

    @ApiModelProperty(value = "订单数量")
    private BigDecimal goodsOrderNums;

    @ApiModelProperty(value = "实际数量")
    private BigDecimal goodsRealNums;

    @ApiModelProperty(value = "应付金额 也就是总金额")
    private BigDecimal amountDue;

    @ApiModelProperty(value = "已付金额")
    private BigDecimal amountPaid;

    @ApiModelProperty(value = "已退金额")
    private BigDecimal amountReturn;

//    @ApiModelProperty(value = "状态")
//    private Integer status;

}
