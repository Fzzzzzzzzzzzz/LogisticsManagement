package com.chenzhi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysWebsite;
import com.chenzhi.service.SysWebsiteService;
import com.chenzhi.mapper.SysWebsiteMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86199
* @description 针对表【sys_website】的数据库操作Service实现
* @createDate 2022-12-20 18:10:04
*/
@Service
public class SysWebsiteServiceImpl extends ServiceImpl<SysWebsiteMapper, SysWebsite>
    implements SysWebsiteService{

    @Resource
    private SysWebsiteMapper sysWebsiteMapper;

    //根据市来查询所有的区的网点信息
    @Override
    public Result getAllWebsitesOfCity(String websiteCity) {
        List<SysWebsite> sysWebsiteList = sysWebsiteMapper.selectList(new LambdaQueryWrapper<SysWebsite>().eq(SysWebsite::getWebsiteCity, websiteCity));
        if(sysWebsiteList.size()==0)
            return Result.fail(400,"该市没有网点信息",null);
        return Result.success(200,"获取市级所有网点信息成功",sysWebsiteList);
    }
}




