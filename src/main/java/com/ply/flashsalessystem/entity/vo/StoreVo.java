package com.ply.flashsalessystem.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ply.flashsalessystem.entity.pojo.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/28 16:11
 * <p>
 * action:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="前端显示store对象", description="")
public class StoreVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店家id 需要隐藏")
    @TableId(value = "store_id", type = IdType.AUTO)
    private Long storeId;

    @ApiModelProperty(value = "name")
    private String sname;

    @ApiModelProperty(value = "地址")
    private String storeAddress;

    @ApiModelProperty(value = "iphone")
    private String iphone;

    @ApiModelProperty(value = "账户余额 默认为0")
    private Double balanceMoney;

    public static StoreVo add(Store store){
        StoreVo storeVo = new StoreVo();
        storeVo.setStoreId(store.getStoreId());
        storeVo.setSname(store.getSname());
        storeVo.setStoreAddress(store.getStoreAddress());
        storeVo.setIphone(store.getIphone());
        storeVo.setBalanceMoney(store.getBalanceMoney());
        return storeVo;
    }
}
