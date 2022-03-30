package com.ply.flashsalessystem.entity.vo.manage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author XiaoPan
 * date: 2022/3/29 15:12
 * <p>
 * action:
 */
@Data
public class GoodsForManageVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    @ApiModelProperty(value = "商品 name")
    private String name;

    @ApiModelProperty(value = "tag name")
    private Integer tagName;

    @ApiModelProperty(value = "商品售价")
    private BigDecimal price;

    @ApiModelProperty(value = "剩余量  ( 可 售出量 )")
    private BigDecimal remainNums;

    @ApiModelProperty(value = "details详情")
    private String details;

    @ApiModelProperty(value = "商品上下架, 0表示下架的情况 1表示上架的情况")
    private Integer putAway;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "最少起售 单位 克g")
    private double minSales;

}
