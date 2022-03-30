package com.ply.flashsalessystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.Goods;
import com.ply.flashsalessystem.entity.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ply.flashsalessystem.entity.vo.user.OrderForUserVo;
import com.ply.flashsalessystem.entity.vo.user.ShopCarForGoodsVo;
import com.ply.flashsalessystem.entity.wrapper.GoodsWrapper;
import com.ply.flashsalessystem.entity.wrapper.ShopCarWrapper;
import com.ply.flashsalessystem.entity.wrapper.UserWrapper;

/**
 * <p>
 *  用户service
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
public interface UserService extends IService<User> {

//    Page<User> getUserToStore(Integer current, Integer limit, UserWrapper userWrapper);

    Page<User> getUserAll(Integer current, Integer limit, UserWrapper userWrapper);

    /**
     * 用户 增删改查
     * 1    用户注册
     * 2    修改密码    修改默认地址    name    iphone  头像avatar
     * 3    分页条件查询 上面写过了
     * 4    查询自己的信息
     *
     * 流程1 购买商品
     *
     * 1    查看商品(调用商品service)
     * 2    加入购物车(购物车 增加方法 )
     * 3    删除购物车的物品(购物车 增加方法 )
     * 4    清空购物车 下订单(生成订单 订单的增加 订单详情的增加)
     * 5    付款(  调用订单 付款方法  )
     * 6    确认收货(调用订单 方法 确认收货)
     *
     * 7    退货申请( 调用? 不知道 订单 还是 订单详情service)
     */

    /**
     * 用户注册
     * @param user user对象
     * @return 注册成功是否
     */
    boolean addUser(User user);

    /**
     * 修改密码
     * @param oldPwd 原先密码
     * @param newPwd 新密码
     * @return  修改成功是否
     */
    boolean updatePwd(String oldPwd,String newPwd);

    /**
     * 修改默认地址    name    iphone  头像avatar
     * @param user 新的用户信息
     * @return      修改成功是否
     */
    boolean updateUser(User user);

    /**
     * 条件 分页查询 用户 只会给管理员看的吧
     * @param current 当前页
     * @param limit   每页的个数
     * @param userWrapper 条件
     * @return  返回的数据  需要对 其处理
     */
    //todo userWrapper对象不可以为null 在controller 控制好
    Page<User> getUserToStore(Integer current, Integer limit, UserWrapper userWrapper);

    /**
     * 查询自己的信息
     * @param id 用户id  一般从 工具类中取
     * @return 返回 user 的所有信息
     */
    User getUser(long id);


    /**
     * 条件 分页查询 商品
     * @param current 当前页
     * @param limit   每页的个数
     * @param goodsWrapper 商品条件
     * @return  返回的数据  需要对 其处理
     */
    Page<Goods> getGoodsPage(Integer current, Integer limit, GoodsWrapper goodsWrapper);

    /**
     * 添加商品 到 购物车
     * @param goodsId 商品id
     * @param goodsNums 商品数量
     * @return 添加成功是否
     *
     * 注: 想要添加进购物车  先查询 goods 的 余量 看看 是否可以添加  不够 返回 false
     *      还有商品的 起售 情况
     */
    boolean addShopCar(long goodsId, double goodsNums);

    /**
     * 将商品从 购物车 中删除
     * @param shopCarId 购物车id
     * @return 删除成功与否
     *
     * 注: 在购物车中 还需 有一个 方法 将 所有物品 清空 的 方法 便于 用户
     */
    boolean deleteGoodsInShopCar(Integer shopCarId);

    /**
     * 分页条件查询购物车
     * @param current 当前页
     * @param limit   每页的个数
     * @param shopCarWrapper 购物车条件
     * @return 返回购物车中的商品
     */
    Page<ShopCarForGoodsVo> getGoodsOfShopCar(Integer current, Integer limit, ShopCarWrapper shopCarWrapper);

    /**
     * 生成订单
     * @param shopCarId 购物车id
     * @return  是否成功
     *
     * 清除购物车
     * 新建order orderDetails (判断 用户是否 有未支付 的订单)
     */
    boolean createOld(Integer shopCarId);

    /**
     * 获取 用户订单
     * @return 订单详情信息
     *
     * 注 :   不可以 在一个订单 未支付的情况下 在创建 另一个订单
     */
    OrderForUserVo getOrder();

    /**
     * 为订单 付款
     * @param ofgID 订单 id
     * @return 付款成功与否
     */
    boolean payForOrder(Integer ofgID);

    /**
     * 用户确认 收货
     * @param ofgID 订单 id
     *
     *  注: 需要判断 订单状态 只有 小店签收 后  才开始  进入 用户签收  默认两天后自动签收
     */
    boolean confirmationOfReceiptForUser(Integer ofgID);




}
