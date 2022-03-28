package com.ply.flashsalessystem.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author XiaoPan
 * date: 2022/1/15 14:18
 * <p>
 * action:
 * <p>
 * 两种方法 一样的 获取 getRequest 的本质也是 ThreadLocal 里面的 存储的   并且在最后   会被 spring 自动清除
 * <p>
 * 都一样 在 都是 在request 中  存储 和 取出
 */
public class UserUtils {
    private static final String USERNAME = "Name";
    private static final String USERID = "Id";
//    用户类型
    private static String TYPE = "type";

    public static String getUserName() {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//       return userIdL.get();
        return (String) ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getAttribute(USERNAME);
    }

    public static void setUserName(String userName) {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//        userIdL.set(userId);
        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().setAttribute(USERNAME, userName);
    }


    public static long getUserId() {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//       return userIdL.get();
        return (long) ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getAttribute(USERID);
    }

    public static void setUserId(Long userId) {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//        userIdL.set(userId);
        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().setAttribute(USERID, userId);
    }

    public static String getUserType() {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//       return userIdL.get();
        return  (String) ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getAttribute(TYPE);
    }

    public static void setUserType(String type) {
//        ThreadLocal<Integer> userIdL = new ThreadLocal<>();
//        userIdL.set(userId);
        ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().setAttribute(TYPE, type);
    }


    public static void addUserUtils(long id, String name, String type){
        UserUtils.setUserId(id);
        UserUtils.setUserName(name);
        UserUtils.setUserType(type);
    }






    static void clear() {}
}
