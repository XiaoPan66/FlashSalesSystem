package com.ply.flashsalessystem.entity.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/29 12:00
 * <p>
 * action:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User条件查询对象", description="")
public class UserWrapper {

    @ApiModelProperty(value = "买家name")
    private String userName;

    @ApiModelProperty(value = "账号iphone")
    private String iphone;

    @ApiModelProperty(value = "邀请人id")
    private Long storeId;

    @ApiModelProperty(value = "查询时间最小")
    private Date createTimeMin;

    @ApiModelProperty(value = "查询时间最大")
    private Date createTimeMax;

}
