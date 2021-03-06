package com.ply.flashsalessystem.entity.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Goods对象", description="")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    @ApiModelProperty(value = "商品 name")
    private String name;

    @ApiModelProperty(value = "分类 id")
    private Integer tagId;

    @ApiModelProperty(value = "商品售价")
    private BigDecimal price;

    @ApiModelProperty(value = "剩余量 	( 可 售出量 )")
    private BigDecimal remainNums;

    @ApiModelProperty(value = "商品上下架, 0表示下架的情况 1表示上架的情况")
    private Integer putAway;

    @ApiModelProperty(value = "details详情")
    private String details;

    private String image;

    @ApiModelProperty(value = "最少起售 单位 克g")
    private double minSales;
}
