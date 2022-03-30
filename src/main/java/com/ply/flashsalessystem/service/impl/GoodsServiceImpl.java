package com.ply.flashsalessystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.GoodsWrapper;
import com.ply.flashsalessystem.mapper.GoodsMapper;
import com.ply.flashsalessystem.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ply.flashsalessystem.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    TagService tagService;

    /**
     * 增加 商品
     */
    @Override
    @Transactional
    public boolean addGoods(Goods goods) {
        //todo 优化 这里 会出现异常  向前端 反应 异常的产生 以及解决   name,tag_id,put_away
        return goodsMapper.insert(goods) != 0;
    }

    /**
     * 修改商品
     */
    @Override
    public boolean updateGoods(Goods goods) {
        //todo 和增加一样会出现异常
        return goodsMapper.updateById(goods) != 0;
    }

    @Override
    public boolean deleteGoodsById(Long id) {
        return false;
    }

    @Override
    public Page<Goods> queryGoodsAll(long current, long limit, GoodsWrapper goodsWrapper) {
      return goodsMapper.queryGoodsAllPage(new Page<>(current,limit), goodsWrapper);
    }

    /**
     *  条件 分页 查询 商品
     * @param current 当前页
     * @param limit 当前页数量
     * @param goodsWrapper 查询条件
     */
    @Override
    public Result queryGoodsAllPageByOdds(long current, long limit, GoodsWrapper goodsWrapper) {
        Page<Goods> page = new Page<>(current, limit);

        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(goodsWrapper.getName())) {
            queryWrapper.like("name", goodsWrapper.getName());
        }
        if (!(StringUtils.isEmpty(goodsWrapper.getTagId()))){
            queryWrapper.eq("tagId", goodsWrapper.getTagId());
        }
        if (!(StringUtils.isEmpty(goodsWrapper.getMinPrice()))){
            queryWrapper.ge("price", goodsWrapper.getMinPrice());
        }

        if (!(StringUtils.isEmpty(goodsWrapper.getMaxPrice()))){
            queryWrapper.le("price", goodsWrapper.getMaxPrice());
        }

        //todo  剩下的条件还可以补充

        this.page(page, queryWrapper);

        return Result.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }
}
