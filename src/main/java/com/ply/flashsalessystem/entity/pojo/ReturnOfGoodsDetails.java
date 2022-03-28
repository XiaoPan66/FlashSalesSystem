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
@ApiModel(value="ReturnOfGoodsDetails对象", description="")
public class ReturnOfGoodsDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "退单明细id")
    @TableId(value = "rog_d_id", type = IdType.AUTO)
    private Integer rogDId;

    @ApiModelProperty(value = "退单id")
    private Integer rogId;

    @ApiModelProperty(value = "订单详情id")
    private Integer orgDId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "状态 默认0")
    private Integer status;


}
