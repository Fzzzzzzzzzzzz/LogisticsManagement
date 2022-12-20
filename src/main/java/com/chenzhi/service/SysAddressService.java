package com.chenzhi.service;

import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【sys_address】的数据库操作Service
* @createDate 2022-12-18 19:35:56
*/
public interface SysAddressService extends IService<SysAddress> {

    Result addAddress(SysAddress sysAddress);

    Result delAddress(Long id);

    Result updateAddress(SysAddress sysAddress);

    Result getAddressById(Long id);

    Result getAllAddress(Long userId);
}
