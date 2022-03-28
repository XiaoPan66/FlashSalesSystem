package com.ply.flashsalessystem.mapper;

import com.ply.flashsalessystem.entity.OrderRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-28
 */
@Mapper
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {
    void addOrderRecord(@Param("ofgId") Integer ofgId,
                        @Param("storeDoSign") Integer status);

}
