package com.ply.flashsalessystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.GoodsQuery;
import com.ply.flashsalessystem.mapper.GoodsMapper;
import com.ply.flashsalessystem.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean deleteGoodsById(Long id) {
        return false;
    }

    /**
     *  条件 分页 查询 商品
     * @param current 当前页
     * @param limit 当前页数量
     * @param goodsQuery 查询条件
     */
    @Override
    public Result queryGoodsAllPageByOdds(long current, long limit, GoodsQuery goodsQuery) {
        Page<Goods> page = new Page<>(current, limit);

        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(goodsQuery.getName())) {
            queryWrapper.like("name", goodsQuery.getName());
        }
        if (!(StringUtils.isEmpty(goodsQuery.getTagId()))){
            queryWrapper.eq("tagId", goodsQuery.getTagId());
        }
        if (!(StringUtils.isEmpty(goodsQuery.getMinPrice()))){
            queryWrapper.ge("price", goodsQuery.getMinPrice());
        }

        if (!(StringUtils.isEmpty(goodsQuery.getMaxPrice()))){
            queryWrapper.le("price", goodsQuery.getMaxPrice());
        }

        //todo  剩下的条件还可以补充

        this.page(page, queryWrapper);

        return Result.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }
}
