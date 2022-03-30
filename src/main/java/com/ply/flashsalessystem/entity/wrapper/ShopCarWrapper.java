package com.ply.flashsalessystem.entity.wrapper;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/30 23:57
 * <p>
 * action:
 */
@Data
public class ShopCarWrapper {

    @ApiModelProperty(value = "商品 name")
    private String name;

    @ApiModelProperty(value = "分类 id")
    private Long tagId;

    @ApiModelProperty(value = "创建时间最小")
    private Date createTimeMin;

    @ApiModelProperty(value = "创建时间最大")
    private Date createTimeMax;

    @ApiModelProperty(value = "商品   剩余量 	( 可 售出量 )")
    private double remainNums;

    @ApiModelProperty(value = "商品数量")
    private double goodNum;

}
