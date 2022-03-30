package com.ply.flashsalessystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ply.flashsalessystem.entity.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ply.flashsalessystem.entity.wrapper.UserWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XiaoPan
 * @since 2022-03-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> getUserAll(Page<User> userPage,@Param("uw") UserWrapper userWrapper);
}
