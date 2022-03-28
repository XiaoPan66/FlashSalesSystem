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
@ApiModel(value="LGroupAuthprity对象", description="")
public class LGroupAuthprity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "authority_group_id", type = IdType.AUTO)
    private Integer authorityGroupId;

    private Integer authorityId;


}
