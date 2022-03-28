package com.ply.flashsalessystem.entity.wrapper;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/26 23:46
 * <p>
 * action:
 */
@Data
public class WrapperOrder {
    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户电话")
    private String iphone;

    @ApiModelProperty(value = "店家id")
    private long storeId;

    //状态 未签收的
    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

}
