package com.ply.flashsalessystem.filter;

import com.alibaba.fastjson.JSONObject;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.utils.CrossUtils;
import com.ply.flashsalessystem.utils.JWTUtil;
import com.ply.flashsalessystem.utils.Type;
import com.ply.flashsalessystem.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author XiaoPan
 * date: 2022/3/24 10:47
 * <p>
 * action:  User登录
 */
@Slf4j
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("现在进入{}过滤器中", UserFilter.class);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        CrossUtils.cross(request, response);

//        String token = request.getHeader("Token");

        //todo 测试环节 关闭token
//        使用 店家token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicGx5IiwiaWQiOjEsInR5cGUiOiJhZG1pbiIsImV4cCI6MTY0ODUyMTcyMH0.0DQk6kQvjUQO_qd0m-nNBJx0Xp8NBO08JyOfyERjUU8";



        if (null == token || token.equals("")) {
            response.getWriter().write((JSONObject.toJSONString(Result.error())));
            log.info("没有token");
            return;
        }
        if (!JWTUtil.verifyToken(token, Type.TYPE_USER)) {
            response.getWriter().write((JSONObject.toJSONString(Result.error())));
            log.info("验证失败");
            return;
        }

        // 放入到 UserUtil 中去
//        UserUtils.addUserUtils(JWTUtil.getId(token),JWTUtil.getUsername(token),JWTUtil.getType(token));


        String newToken = JWTUtil.sign(UserUtils.getUserId(),
                UserUtils.getUserName(),
                UserUtils.getUserType());

        //设置响应头
        response.setHeader("Token", newToken);
        log.info("成功");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
