package com.ply.flashsalessystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ply.flashsalessystem.entity.pojo.OrderForGoods;
import com.ply.flashsalessystem.entity.pojo.Store;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.status.OrderStatus;
import com.ply.flashsalessystem.entity.vo.OrderForStoreVo;
import com.ply.flashsalessystem.entity.vo.StoreVo;
import com.ply.flashsalessystem.entity.wrapper.WrapperOrder;
import com.ply.flashsalessystem.service.OrderForGoodsService;
import com.ply.flashsalessystem.service.StoreService;
import com.ply.flashsalessystem.utils.UserUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/store")
@Slf4j
@CrossOrigin
public class StoreController {

    @Autowired
    OrderForGoodsService orderForGoodsService;

    @Autowired
    StoreService storeService;

    //邀请用户注册(生成邀请码 也就是id)
    @GetMapping("inviteUser")
    @ApiOperation("邀请用户注册")
    public Result inviteUser() {
        log.info("用户:{}  id为: {}", UserUtils.getUserName(), UserUtils.getUserId());
        return Result.ok().data("data", UserUtils.getUserId());
    }


    /**
     * 0    邀请用户注册(生成邀请码)
     * 1    查询订单 (分页条件查询)
     * 2    确定收货(送货员)  (每个订单 单个确认   所有订单一起 确认)
     * 3    确定收货(买家)        (暂时不写 service 是写到user中的 调用 user 中的方法)
     * 4    退货申请( 买家的 )     (暂时不写)
     * 5    查询余额
     * 6    提现
     * 7    查看邀请成功的用户
     * 8    修改地址(很少会用到)
     * 9    修改密码
     */


    /**
     * 1     查看 当天的 我的地址的 订单 分为 已签收 和 未签收      查看当天的订单
     * 前提条件: 订单状态   店家 已签收
     *
     * @param current      当前页码
     * @param limit        每页的条数
     * @param wrapperOrder 查询条件
     * @return 返回总页数 total 和  当前页的 订单信息
     */
    //todo 出现415 错误  实体类 日期类型写错了
    @PostMapping("queryOrder/{current}/{limit}")
    @ApiOperation("条件分页查询 订单")
    public Result queryOrder(@PathVariable("current") Integer current,
                             @PathVariable("limit") Integer limit,
                             @RequestBody(required = false) WrapperOrder wrapperOrder) {

        log.info("wrapperOrder:{}", wrapperOrder);
        if (wrapperOrder == null) {
            wrapperOrder = new WrapperOrder();
        }

        //保证 查询 条件    是我的店里面的
        wrapperOrder.setStoreId(UserUtils.getUserId());
        // 保证查询条件
        return orderForGoodsService.queryOrder(current, limit, wrapperOrder);
    }

//     * 2    确定收货(送货员)  (每个订单 单个确认   所有订单一起 确认)

    /**
     * 确定收货的
     *
     * @param orderId id 列表
     * @return 成功或者失败
     */
    //todo 需要添加事务 一条没成功 就所有没有成功
    @PostMapping("storeIsConfirmationOfReceipt")
    @ApiOperation("商家确定收货")
    public Result storeIsConfirmationOfReceipt(@RequestBody List<Integer> orderId) {
        //判断订单的 状态 是否是 店家未签收 只有店家未签收 时 才可以签收  其他的状态 都是 操作失败
        List<Integer> orderIdList = new ArrayList<>();

        for (Integer integer : orderId) {
            QueryWrapper<OrderForGoods> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ofg_id",integer);
            queryWrapper.eq("status",OrderStatus.STORE_NO_SIGN);
            OrderForGoods orderForGoods = orderForGoodsService.getOne(queryWrapper);
            if (orderForGoods != null){
                orderIdList.add(orderForGoods.getOfgId());
            }

        }

        boolean b = orderForGoodsService.updateOrderStatusById(orderIdList, OrderStatus.STORE_DO_SIGN);

        if (b) {
            return Result.ok();
        }
        return Result.error();
    }

    /**
     * 查询 信息
     */
    @GetMapping("Store")
    @ApiOperation("商家查询自己的信息")
    public Result queryStore() {
        Store store = storeService.getById(UserUtils.getUserId());
        StoreVo storeVo = StoreVo.add(store);

        return Result.ok().data("storeVo", storeVo);
    }

    /**
     * 修改信息  name, 地址呀
     */
    @PutMapping("Store")
    @ApiOperation("商家修改自己的信息")
    public Result queryStore(@RequestBody StoreVo storeVo) {
        Store store = new Store();

        store.setStoreId(UserUtils.getUserId());

        store.setStoreAddress(storeVo.getStoreAddress());
        //name iphone 需要判断 是否存在 存在这个name 则不允许修改  name 是唯一的
        store.setSname(storeVo.getSname());
        store.setIphone(storeVo.getIphone());

        boolean b = storeService.updateStoreDynamic(store);
        if (b) {
            return Result.ok();
        }
        return Result.error();
    }

    @PutMapping("toCash/{money}")
    @ApiOperation("商家提现")
    public Result toCash(@PathVariable("money") Double money) {
        // 判断 和 合法不合法
        Store store = storeService.getById(UserUtils.getUserId());
        if (money <= 0 || money > store.getBalanceMoney()) {
            return Result.error().message("提现金额 问题");
        }

        boolean b = storeService.toCash(store,money);

        if (b){
            return Result.ok().message("提现成功: " + money);
        }

        return Result.error().message("提现失败");
    }




}

