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

    private Integer tagId;

    private String name;

    @ApiModelProperty(value = "商品售价")
    private BigDecimal price;

    @ApiModelProperty(value = "剩余量 	( 可 售出量 )")
    private BigDecimal remainNums;

    @ApiModelProperty(value = "details详情")
    private String details;

    private String image;

    @ApiModelProperty(value = "月销量 ")
    private BigDecimal salesMonth;

    @ApiModelProperty(value = "总销量")
    private BigDecimal salesAll;


}
