package com.ply.flashsalessystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ply.flashsalessystem.entity.pojo.Manage;
import com.ply.flashsalessystem.entity.pojo.Store;
import com.ply.flashsalessystem.entity.pojo.User;
import com.ply.flashsalessystem.entity.result.Result;
import com.ply.flashsalessystem.service.ManageService;
import com.ply.flashsalessystem.service.StoreService;
import com.ply.flashsalessystem.service.UserService;
import com.ply.flashsalessystem.utils.Type;
import com.ply.flashsalessystem.utils.UserUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiaoPan
 * date: 2022/3/24 14:01
 * <p>
 * action:
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    StoreService storeService;

    @Autowired
    ManageService manageService;

    @PostMapping("user")
    @ApiOperation("用户登录")
    public Result userLogin(@RequestBody User user) {
        String iphone = user.getIphone();
        String pwd = user.getPwd();

        if ("".equals(iphone) ||
                iphone == null ||
                "".equals(pwd) ||
                pwd == null) {
            return Result.error();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("iphone",iphone);
        queryWrapper.eq("pwd",pwd);
        List<User> list = userService.list(queryWrapper);
        if (list.isEmpty()){
            return Result.error();
        }
        User user1 = list.get(0);

        UserUtils.addUserUtils(user1.getUserId(),user1.getUserName(), Type.TYPE_USER);
        return Result.ok();
    }

    @PostMapping("store")
    @ApiOperation("小店登录")
    public Result storeLogin(@RequestBody Store store) {
        String name = store.getSname();
        String pwd = store.getPwd();

        if ("".equals(name) ||
                name == null ||
                "".equals(pwd) ||
                pwd == null) {
            return Result.error();
        }
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("sname",name);
        queryWrapper.eq("pwd",pwd);

        List<Store> list = storeService.list(queryWrapper);
        if (list.isEmpty()){
            return Result.error();
        }
        Store store1 = list.get(0);

        UserUtils.addUserUtils(store1.getStoreId(),store1.getSname(), Type.TYPE_STORE);

        log.info("用户:{} 登陆成功",UserUtils.getUserName());

        return Result.ok();
    }

    @PostMapping("admin")
    @ApiOperation("管理员登录")
    public Result storeLogin(@RequestBody Manage manage) {
        String name = manage.getName();
        String pwd = manage.getPwd();

        if ("".equals(name) ||
                name == null ||
                "".equals(pwd) ||
                pwd == null) {
            return Result.error();
        }
        QueryWrapper<Manage> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name",name);
        queryWrapper.eq("pwd",pwd);

        List<Manage> list = manageService.list(queryWrapper);
        if (list.isEmpty()){
            return Result.error();
        }
        Manage manage1 = list.get(0);

        UserUtils.addUserUtils(Long.valueOf(manage1.getManageId()),manage1.getName(), Type.TYPE_ADMIN);
        return Result.ok();
    }


    @PostMapping("register")
    @ApiOperation("用户注册")
    public boolean register(@RequestBody User user,
                            @RequestParam(required = false)  Long StoreId){
        if (!(StringUtils.isEmpty(user.getUserName())
                || StringUtils.isEmpty(user.getPwd())
                || StringUtils.isEmpty(user.getIphone()) )){
            return false;
        }
        //todo 注册时 是否 需要 当时给 还是 过后 给店家钱
        //todo  这里可以添加 不允许注册的 条件
        //todo  可以使用正则优化 注册 过滤敏感词
        if (!StringUtils.isEmpty(StoreId)){
            user.setStoreId(StoreId);
        }

        return userService.save(user);
    }

    /**
     * 新增 小店 注册
     */
    @PostMapping("addStore")
    public Result addStore(@RequestParam("name") String name,
                           @RequestParam("pwd") String pwd
    ) {
        //todo  可以使用正则优化 注册


        return Result.ok();
    }



}
