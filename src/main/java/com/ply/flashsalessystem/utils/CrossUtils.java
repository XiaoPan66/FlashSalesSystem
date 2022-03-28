package com.ply.flashsalessystem.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author XiaoPan
 * date: 2022/3/24 13:57
 * <p>
 * action:
 */
public class CrossUtils {
    public static void cross(HttpServletRequest request,
                             HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;Charset=utf-8");
        //允许跨域访问，通过response对象写回一些跨域访问的头信息
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
