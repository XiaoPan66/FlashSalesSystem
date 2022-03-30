package com.ply.flashsalessystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ply.flashsalessystem.entity.wrapper.GoodsWrapper;
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
public interface GoodsMapper extends BaseMapper<Goods> {

    Page<Goods> queryGoodsAllPage(Page<Goods> goodsPage,@Param("gq") GoodsWrapper goodsWrapper);
}
