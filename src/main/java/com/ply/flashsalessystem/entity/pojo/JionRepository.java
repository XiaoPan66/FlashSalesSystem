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
@ApiModel(value="JionRepository对象", description="")
public class JionRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库id")
    @TableId(value = "jr_id", type = IdType.AUTO)
    private Integer jrId;

    private Date createTime;


}
