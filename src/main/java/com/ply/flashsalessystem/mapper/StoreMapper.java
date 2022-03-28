package com.ply.flashsalessystem.mapper;

import com.ply.flashsalessystem.entity.pojo.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface StoreMapper extends BaseMapper<Store> {

    boolean updateStoreDynamic(@Param("store") Store store);
}
