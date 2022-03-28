package com.ply.flashsalessystem.service;

import com.ply.flashsalessystem.entity.pojo.OrderForGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.wrapper.WrapperOrder;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
public interface OrderForGoodsService extends IService<OrderForGoods> {

    Result queryOrder(Integer current, Integer limit, WrapperOrder wrapperOrder);

    boolean updateOrderStatusById(List<Integer> orderIdList, Integer storeDoSign);

}
