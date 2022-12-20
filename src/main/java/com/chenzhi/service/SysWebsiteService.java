package com.chenzhi.service;

import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysWebsite;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86199
* @description 针对表【sys_website】的数据库操作Service
* @createDate 2022-12-20 18:10:04
*/
public interface SysWebsiteService extends IService<SysWebsite> {

    Result getAllWebsitesOfCity(String websiteCity);
}
