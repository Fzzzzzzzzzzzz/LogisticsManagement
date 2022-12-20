package com.chenzhi.mapper;

import com.chenzhi.domain.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86199
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2022-12-15 23:20:58
* @Entity com.chenzhi.domain.entity.SysUser
*/
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {

    SysUser loadUserByUsername1(String userName);
}




