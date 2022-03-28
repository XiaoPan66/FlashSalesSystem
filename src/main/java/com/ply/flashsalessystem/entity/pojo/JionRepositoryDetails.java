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
@ApiModel(value="JionRepositoryDetails对象", description="")
public class JionRepositoryDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库明细表")
    @TableId(value = "jr_d_id", type = IdType.AUTO)
    private Integer jrDId;

    @ApiModelProperty(value = "入库id")
    private Integer jrId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "数量")
    private BigDecimal nums;

    @ApiModelProperty(value = "花费总金额")
    private BigDecimal allCost;


}
