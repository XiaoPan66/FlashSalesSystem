package com.ply.flashsalessystem.service;

import com.ply.flashsalessystem.entity.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.GoodsQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
public interface GoodsService extends IService<Goods> {

    /**
     *  查询所有商品 条件 分页
     */
//    Result queryGoods(QueryGoodsWrapper queryWrapper);

    /**
     * 增加商品
     */
    boolean addGoods(Goods goods);

    /**
     * 修改商品 (tag_id, name,price,remain_nums,details, images)
     */
    boolean updateGoods(Goods goods);


    /**
     * tombstone
     * 逻辑删除
     * 删除商品
     */
    boolean deleteGoodsById(Long id);


    Result queryGoodsAllPageByOdds(long current, long limit, GoodsQuery goodsQuery);
}
