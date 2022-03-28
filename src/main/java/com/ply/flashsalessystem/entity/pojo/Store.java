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
@ApiModel(value="Store对象", description="")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店家id")
    @TableId(value = "store_id", type = IdType.AUTO)
    private Long storeId;

    @ApiModelProperty(value = "name")
    private String sname;

    @ApiModelProperty(value = "pwd")
    private String pwd;

    @ApiModelProperty(value = "iphone")
    private String iphone;


    @ApiModelProperty(value = "地址")
    private String storeAddress;

    @ApiModelProperty(value = "账户余额 默认为0")
    private Double balanceMoney;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "0 未删除1: 删除 默认为0")
    private Integer tombstone;


}
