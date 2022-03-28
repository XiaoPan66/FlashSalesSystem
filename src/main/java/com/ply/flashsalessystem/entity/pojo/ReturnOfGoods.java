package com.ply.flashsalessystem.entity.pojo;

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
@ApiModel(value="ReturnOfGoods对象", description="")
public class ReturnOfGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "退单id")
    @TableId(value = "rog_id", type = IdType.AUTO)
    private Integer rogId;

    @ApiModelProperty(value = "订单id")
    private Integer orgId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "状态 默认0")
    private Integer status;


}
