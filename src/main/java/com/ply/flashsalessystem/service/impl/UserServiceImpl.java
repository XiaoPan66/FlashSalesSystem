package com.ply.flashsalessystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.pojo.User;
import com.ply.flashsalessystem.entity.vo.user.OrderForUserVo;
import com.ply.flashsalessystem.entity.vo.user.ShopCarForGoodsVo;
import com.ply.flashsalessystem.entity.wrapper.GoodsWrapper;
import com.ply.flashsalessystem.entity.wrapper.ShopCarWrapper;
import com.ply.flashsalessystem.entity.wrapper.UserWrapper;
import com.ply.flashsalessystem.mapper.UserMapper;
import com.ply.flashsalessystem.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ply.flashsalessystem.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 查询 被邀请 用户 用于商家
     */
    @Override
    public Page<User> getUserToStore(Integer current, Integer limit, UserWrapper userWrapper) {
        userWrapper.setStoreId(UserUtils.getUserId());
        return getUserAll(current,limit,userWrapper);
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public Page<Goods> getGoodsPage(Integer current, Integer limit, GoodsWrapper goodsWrapper) {
        return null;
    }

    @Override
    public boolean addShopCar(long goodsId, double goodsNums) {
        return false;
    }

    @Override
    public boolean deleteGoodsInShopCar(Integer shopCarId) {
        return false;
    }

    @Override
    public Page<ShopCarForGoodsVo> getGoodsOfShopCar(Integer current, Integer limit, ShopCarWrapper shopCarWrapper) {
        return null;
    }

    @Override
    public boolean createOld(Integer shopCarId) {
        return false;
    }

    @Override
    public OrderForUserVo getOrder() {
        return null;
    }

    @Override
    public boolean payForOrder(Integer ofgID) {
        return false;
    }

    @Override
    public boolean confirmationOfReceiptForUser(Integer ofgID) {
        return false;
    }


    /**
     * 查询 所有 用户的 所有信息
     */
    @Override
    public Page<User> getUserAll(Integer current, Integer limit, UserWrapper userWrapper) {
        return userMapper.getUserAll(new Page<>(current, limit),userWrapper);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updatePwd(String oldPwd, String newPwd) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
