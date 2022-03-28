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
@ApiModel(value="StoreAmount对象", description="")
public class StoreAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店家资金进出流水记录表")
    @TableId(value = "store_amount_id", type = IdType.AUTO)
    private Integer storeAmountId;

    private Long storeId;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "默认是 0")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
