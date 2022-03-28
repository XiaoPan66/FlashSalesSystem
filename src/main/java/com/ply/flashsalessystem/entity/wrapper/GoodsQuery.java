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
public class GoodsQuery {
    private String name;

    private Long tagId;

    @ApiModelProperty(value = "小 商品售价")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "大 商品售价")
    private BigDecimal MaxPrice;

    @ApiModelProperty(value = "剩余量 	( 可 售出量 )")
    private BigDecimal remainNums;

    @ApiModelProperty(value = "月销量 ")
    private BigDecimal salesMonth;

    @ApiModelProperty(value = "总销量")
    private BigDecimal salesAll;
}
