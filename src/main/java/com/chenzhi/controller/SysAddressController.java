package com.chenzhi.controller;

import com.chenzhi.common.utils.GetLoginUser;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.dto.LoginUser;
import com.chenzhi.domain.entity.SysAddress;
import com.chenzhi.service.impl.SysAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/address")
public class SysAddressController {

    @Autowired
    private SysAddressServiceImpl sysAddressService;

    /**
     * 新增地址薄
     */
    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody SysAddress sysAddress,
                             HttpServletRequest request){
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        sysAddress.setUserId(userId);
        //对象需要校验，暂时不管
        if(!ObjectUtils.isEmpty(sysAddress)){
            return sysAddressService.addAddress(sysAddress);
        }
        return Result.fail(400,"地址薄为空！",null);
    }

    /**
     * 删除地址薄
     */
    @DeleteMapping("/delAddress/{id}")
    public Result delAddress(@PathVariable("id") Long id){
        return sysAddressService.delAddress(id);
    }

    /**
     * 更新地址薄
     */
    @PutMapping("/updateAddress")
    public Result updateAddress(@RequestBody SysAddress sysAddress,
                                HttpServletRequest request){
        if (sysAddress.getAddressId()==null){
            return Result.fail(400,"address_Id为空！",null);
        }
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        sysAddress.setUserId(userId);
        //对象需要校验，暂时不管
        if(!ObjectUtils.isEmpty(sysAddress)){
            return sysAddressService.updateAddress(sysAddress);
        }
        return Result.fail(400,"地址薄为空！",null);
    }

    /**
     * 根据id获取地址薄
     */
    @GetMapping("getAddress/{id}")
    public Result getAddress(@PathVariable("id") Long id){
        return sysAddressService.getAddressById(id);
    }

    /**
     * 获取个人所有的地址薄
     */
    @GetMapping("getAllAddress")
    public Result getAllAddress(HttpServletRequest request){
        //先获取个人的userId
        Long userId = GetLoginUser.getLoginUserNameInSession(request).getUserId();
        return sysAddressService.getAllAddress(userId);
    }
}
