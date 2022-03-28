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
@ApiModel(value="Manage对象", description="")
public class Manage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "后台人员id")
    @TableId(value = "manage_id", type = IdType.AUTO)
    private Integer manageId;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "pwd")
    private String pwd;

    @ApiModelProperty(value = "逻辑删除")
    private Integer tombstone;


}
