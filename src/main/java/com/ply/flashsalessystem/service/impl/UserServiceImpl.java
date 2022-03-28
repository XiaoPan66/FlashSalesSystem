package com.ply.flashsalessystem.service.impl;

import com.ply.flashsalessystem.entity.pojo.User;
import com.ply.flashsalessystem.mapper.UserMapper;
import com.ply.flashsalessystem.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
