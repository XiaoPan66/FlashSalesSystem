package com.ply.flashsalessystem.entity.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author XiaoPan
 * date: 2022/3/31 0:04
 * <p>
 * action: 购物车 商品 显示 实体类
 */
@Data
public class ShopCarForGoodsVo {
    @ApiModelProperty(value = "商品 name")
    private String name;

    @ApiModelProperty(value = "分类 id")
    private Integer tagId;

    @ApiModelProperty(value = "商品售价")
    private BigDecimal price;

    @ApiModelProperty(value = "剩余量 	( 可 售出量 )")
    private BigDecimal remainNums;
}
