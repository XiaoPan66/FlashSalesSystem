package com.ply.flashsalessystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.OrderForGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ply.flashsalessystem.entity.vo.OrderForStoreVo;
import com.ply.flashsalessystem.entity.wrapper.WrapperOrder;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Mapper
public interface OrderForGoodsMapper extends BaseMapper<OrderForGoods> {
    Page<OrderForStoreVo> findAndPage(Page<OrderForStoreVo> page,@Param("wr") WrapperOrder wrapperOrder);

    boolean updateStatusById(@Param("id") Integer id,
                             @Param("status") Integer status);


}
