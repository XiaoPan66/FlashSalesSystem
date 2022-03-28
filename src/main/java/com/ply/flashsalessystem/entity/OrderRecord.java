package com.ply.flashsalessystem.entity;

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
 * @since 2022-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrderRecord对象", description="")
public class OrderRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单记录表")
    @TableId(value = "order_record_id", type = IdType.AUTO)
    private Integer orderRecordId;

    @ApiModelProperty(value = "修改时间")
    private Date createTime;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "订单id")
    private Integer ofgId;


}
