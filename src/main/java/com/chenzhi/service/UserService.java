package com.chenzhi.service;

import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.dto.UserRegistration;
import com.chenzhi.domain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2022-12-15 23:20:58
*/
public interface UserService extends IService<SysUser> {

    String login(String username, String password);

    Result getUserInfo(Long userId);

    Result registration(UserRegistration userRegistration);
}
