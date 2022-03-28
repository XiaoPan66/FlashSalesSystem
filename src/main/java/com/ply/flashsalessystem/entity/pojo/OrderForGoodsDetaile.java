package com.ply.flashsalessystem.entity.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="OrderForGoodsDetaile对象", description="")
public class OrderForGoodsDetaile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单明细id")
    @TableId(value = "org_d_id", type = IdType.AUTO)
    private Integer orgDId;

    @ApiModelProperty(value = "订单id")
    private Integer ofgId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "订单数量")
    private BigDecimal goodsOrderNums;

    @ApiModelProperty(value = "实际数量")
    private BigDecimal goodsRealNums;

    @ApiModelProperty(value = "应付金额")
    private BigDecimal amountDue;

    @ApiModelProperty(value = "已付金额")
    private BigDecimal amountPaid;

    @ApiModelProperty(value = "已退金额")
    private BigDecimal amountReturn;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "状态")
    private Integer status;


}
