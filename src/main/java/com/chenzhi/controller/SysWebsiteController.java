package com.chenzhi.controller;


import com.chenzhi.common.utils.Result;
import com.chenzhi.service.impl.SysWebsiteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/website")
public class SysWebsiteController {

    @Resource
    private SysWebsiteServiceImpl sysWebsiteService;

    /**
     *根据市来查询所有的区的网点信息
     */
    @GetMapping("getAllWebsitesOfCity")
    public Result getAllWebsitesOfCity(@RequestParam("websiteCity") String websiteCity){
        return sysWebsiteService.getAllWebsitesOfCity(websiteCity);
    }

}
