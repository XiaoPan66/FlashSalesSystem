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
@ApiModel(value="UserAmount对象", description="")
public class UserAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "买家资金进出流水记录表id")
    @TableId(value = "user_amount_id", type = IdType.AUTO)
    private Integer userAmountId;

    @ApiModelProperty(value = "user")
    private Long userId;

    private BigDecimal amount;

    @ApiModelProperty(value = "默认 0")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
