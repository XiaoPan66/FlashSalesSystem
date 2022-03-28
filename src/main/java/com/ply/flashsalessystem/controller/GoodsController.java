package com.ply.flashsalessystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.GoodsQuery;
import com.ply.flashsalessystem.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@RestController
@RequestMapping("/flashsalessystem/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation("所有商品列表")
    @GetMapping("queryGoodsAll")
    public Result queryGoodsAll() {
        List<Goods> rows = goodsService.list();
        return Result.ok().data("rows", rows);
    }

    @ApiOperation("分页所有商品列表")
    @GetMapping("pageGoods/{current}/{limit}")
    public Result queryGoodsAllPage(@PathVariable("current") long current,
                                    @PathVariable("limit") long limit) {

        if (!(current >= 0 && limit >= 0)) {
            return Result.error();
        }

        Page<Goods> page = new Page<>(current, limit);
        goodsService.page(page, null);

        return Result.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }


    // 分 管理员 还是 普通用户 普通用户 不需要 所有数据 有些数据 普通用户 不需要看 重新建vo类 给普通用户
    @ApiOperation("条件分页所有商品列表")
    @GetMapping("queryGoodsAllPageByOdds/{current}/{limit}")
    public Result queryGoodsAllPageByOdds(@PathVariable("current") long current,
                                          @PathVariable("limit") long limit,
                                          @RequestBody GoodsQuery goodsQuery) {
        if (!(current >= 0 && limit >= 0)) {
            return Result.error();
        }
        return  goodsService.queryGoodsAllPageByOdds(current,limit,goodsQuery);
    }


}

