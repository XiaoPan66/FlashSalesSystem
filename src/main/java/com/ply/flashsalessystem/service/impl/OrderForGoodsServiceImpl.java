package com.ply.flashsalessystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.OrderForGoods;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.entity.status.OrderStatus;
import com.ply.flashsalessystem.entity.vo.store.OrderForStoreVo;
import com.ply.flashsalessystem.entity.wrapper.WrapperOrder;
import com.ply.flashsalessystem.mapper.OrderForGoodsMapper;
import com.ply.flashsalessystem.mapper.OrderRecordMapper;
import com.ply.flashsalessystem.service.OrderForGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Service
@Slf4j
public class OrderForGoodsServiceImpl extends ServiceImpl<OrderForGoodsMapper, OrderForGoods> implements OrderForGoodsService {
    @Autowired
    OrderForGoodsMapper orderForGoodsMapper;

    @Autowired
    OrderRecordMapper orderRecordMapper;

    /**
     * 分页条件查询 订单信息
     *
     * @param current      当前页
     * @param limit        每页的条数
     * @param wrapperOrder 查询条件
     * @return total: 总条数  rows: 总记录数
     */
    @Override
    public Result queryOrder(Integer current, Integer limit, WrapperOrder wrapperOrder) {
        Page<OrderForStoreVo> andPage = orderForGoodsMapper.findAndPage(new Page<>(current, limit), wrapperOrder);
        return Result.ok().data("total", andPage.getTotal()).data("rows", andPage.getRecords());
    }

    /**
     * 更新订单状态
     *
     * @param orderIdList   所有要修改的订单
     * @param status 要修改的状态
     * @return 修改成功 失败
     */
    @Override
    public boolean updateOrderStatusById(List<Integer> orderIdList, Integer status) {
        if (orderIdList == null || !statusLimit(status)) {
            return false;
        }
        //todo 批量更新 可以优化 sql 语句
        for (Integer ofgId : orderIdList) {
            boolean b = orderForGoodsMapper.updateStatusById(ofgId, status);
            // 一旦修改成功的话 就必须添加到 订单 状态修改 表中去
            if (b){
                orderRecordMapper.addOrderRecord(ofgId,status);
            }
            log.info("{}:修改:{}",ofgId,b);
        }
        return true;
    }


    /**
     * 判断 要修改的状态值 是否合理
     * @param orderStatus 状态值
     * @return
     */
    private boolean statusLimit(Integer orderStatus) {
        return orderStatus >= 0 && orderStatus <= OrderStatus.ORDER_MAX;
    }
}
