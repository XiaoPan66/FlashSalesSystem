package com.ply.flashsalessystem.service;

import com.ply.flashsalessystem.entity.pojo.Store;
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
public interface StoreService extends IService<Store> {


    boolean updateStoreDynamic(Store store);

    boolean toCash(Store store,Double money);

    boolean storeIsConfirmationOfReceipt(List<Integer> orderId);
}
