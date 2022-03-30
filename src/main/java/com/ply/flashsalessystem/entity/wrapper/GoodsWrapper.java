package com.ply.flashsalessystem.entity.wrapper;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author XiaoPan
 * date: 2022/3/24 18:29
 * <p>
 * action:   分页显示商品 条件
 */
@Data
public class GoodsWrapper {
    @ApiModelProperty(value = "商品 name")
    private String name;

    @ApiModelProperty(value = "分类 id")
    private Integer tagId;

    @ApiModelProperty(value = "小 商品售价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "大 商品售价")
    private BigDecimal MaxPrice;

    @ApiModelProperty(value = "剩余量 	( 可 售出量 )")
    private BigDecimal remainNums;
}
