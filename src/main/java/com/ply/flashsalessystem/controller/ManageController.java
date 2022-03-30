package com.ply.flashsalessystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.GoodsWrapper;
import com.ply.flashsalessystem.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@RestController
@RequestMapping("/flashsalessystem/manage")
public class ManageController {
    @Autowired
    GoodsService goodsService;


    /**
     * 对商品的管理 增删改查
     */
    //todo 删除没有写 可以逻辑删除
    @PostMapping("goods")
    public Result addGoods(@RequestBody Goods goods){
        //增加的时候 不需要商品id
        goods.setGoodsId(null);
        return goodsService.addGoods(goods)
                ?Result.ok().message("商品添加成功")
                :Result.error().message("商品添加失败");
    }

    @DeleteMapping("goods/{storeId}")
    public Result delete(@PathVariable("storeId") Long storeId){

        return Result.ok();
    }

    /**
     * 修改商品
     */

    @PutMapping("goods")
    public Result updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods)
                ?Result.ok().message("商品修改成功")
                :Result.error().message("商品修改失败");
    }

    /**
     * 查询商品 manage
     */
    @ApiOperation("条件分页所有商品列表")
    @GetMapping("queryGoodsAllPageByOdds/{current}/{limit}")
    public Result queryGoodsAllPageByOdds(@PathVariable("current") long current,
                                               @PathVariable("limit") long limit,
                                               @RequestBody(required = false) GoodsWrapper goodsWrapper) {
        if (goodsWrapper == null){
            goodsWrapper = new GoodsWrapper();
        }
        Page<Goods> page = goodsService.queryGoodsAll(current, limit, goodsWrapper);

        return Result.ok()
                .message("查询成功")
                .data("total", page.getTotal())
                .data("rows",page.getRecords());
    }

    /**
     * 1    查看所有的订单 信息 (条件分页查询)
     * 2    根据订单id 查询 所有的订单详情
     * 3    对 tag 表的 增改查
     */



















}

