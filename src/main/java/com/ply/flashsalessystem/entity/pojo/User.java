package com.ply.flashsalessystem.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "买家id	")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "买家name")
    private String userName;

    @ApiModelProperty(value = "账号iphone")
    private String iphone;

    @ApiModelProperty(value = "买家密码")
    private String pwd;

    @ApiModelProperty(value = "邀请人id")
    private Long storeId;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "默认收货地址")
    private String dafaultAddress;

    @ApiModelProperty(value = "账户余额")
    private Double balanceMoney;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
