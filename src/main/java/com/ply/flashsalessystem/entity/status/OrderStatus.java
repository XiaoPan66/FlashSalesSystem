package com.ply.flashsalessystem.entity.status;

/**
 * @author XiaoPan
 * date: 2022/3/27 12:25
 * <p>
 * action:  订单状态
 */
public interface OrderStatus {
    /**
     * 查看 我的 地址的 订单 可分页
     * 0  未付款
     * 1  已付款  (未发货)
     * 2  已发货
     * 3  店家未签收
     * 4  店家已签收  (买家未签收)
     * 5  买家已签收
     * 6  订单异常
     * 7  订单结束  (签收后 两天自动结束订单)
     */
    Integer NO_PAY = 0;

    Integer DO_PAY = 1;

//    Integer delivery = 0;
    Integer DELIVERY = 2;

    Integer STORE_NO_SIGN = 3;

    Integer STORE_DO_SIGN = 4;

    Integer USER_DO_SIGN = 5;

    Integer ORDER_ERROR = 6;
    Integer ORDER_END = 7;


    Integer ORDER_MAX = 7;

}
