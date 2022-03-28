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
 * action:  登录过滤器 生成token
 */
@Slf4j
public class LoginFile implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("现在进入{}过滤器中",LoginFile.class);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        CrossUtils.cross(request,response);

        filterChain.doFilter(servletRequest, servletResponse);


        String newToken = JWTUtil.sign(UserUtils.getUserId(),
                UserUtils.getUserName(),
                UserUtils.getUserType());
        //设置响应头
        response.setHeader("Token", newToken);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
