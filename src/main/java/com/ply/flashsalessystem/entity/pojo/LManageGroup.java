package com.ply.flashsalessystem.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="LManageGroup对象", description="")
public class LManageGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "管理人员id")
    @TableId(value = "manage_id", type = IdType.AUTO)
    private Integer manageId;

    @ApiModelProperty(value = "权限组id")
    private Integer authorityGroupId;


}
