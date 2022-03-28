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
@ApiModel(value="Sort对象", description="")
public class Sort implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分拣id")
    @TableId(value = "sort_id", type = IdType.AUTO)
    private Integer sortId;

    @ApiModelProperty(value = "订单详情id")
    private Integer orgDId;

    @ApiModelProperty(value = "入库表id")
    private Integer jrId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
