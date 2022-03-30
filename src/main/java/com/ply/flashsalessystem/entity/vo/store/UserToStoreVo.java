package com.ply.flashsalessystem.entity.vo.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoPan
 * date: 2022/3/29 12:31
 * <p>
 * action:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="给小店看的user 也就是邀请的用户", description="")
public class UserToStoreVo {
    @ApiModelProperty(value = "账号iphone")
    private String iphone;

    @ApiModelProperty(value = "买家name")
    private String userName;
}
