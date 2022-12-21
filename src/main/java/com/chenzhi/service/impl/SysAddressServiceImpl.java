package com.chenzhi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhi.common.utils.Result;
import com.chenzhi.domain.entity.SysAddress;
import com.chenzhi.service.SysAddressService;
import com.chenzhi.mapper.SysAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86199
* @description 针对表【sys_address】的数据库操作Service实现
* @createDate 2022-12-18 19:35:56
*/
@Service
public class SysAddressServiceImpl extends ServiceImpl<SysAddressMapper, SysAddress>
    implements SysAddressService{

    @Resource
    private SysAddressMapper sysAddressMapper;

    //新增地址薄
    @Override
    public Result addAddress(SysAddress sysAddress) {
        //再新增地址薄之前判断是否设置新的地址薄为默认的地址薄
        //如果是默认地址,先对数据库里面的数据进行更改
        if(sysAddress.getIsDefault()==1){
            List<SysAddress> sysAddressList = sysAddressMapper.selectList(
                            new LambdaQueryWrapper<SysAddress>()
                            .eq(SysAddress::getUserId, sysAddress.getUserId())
                            .eq(SysAddress::getIsDefault, 1)
                            .eq(SysAddress::getCollectOrsend,sysAddress.getCollectOrsend())
                        );
            //2.1找出默认地址将其改为非默认地址
            for (SysAddress sysAddressTemp: sysAddressList) {
                sysAddressTemp.setIsDefault(0);
                sysAddressMapper.updateById(sysAddressTemp);
            }
        }
        int insert = sysAddressMapper.insert(sysAddress);
        if (insert>0)
            return Result.success(200,"新增地址薄成功！",null);
        return Result.fail(400,"新增地址薄失败！" ,null);
    }
    //删除地址薄
    @Override
    public Result delAddress(Long id) {
        int i = sysAddressMapper.deleteById(id);
        if (i>0)
            return Result.success(200,"删除地址薄成功！",null);
        return Result.fail(400,"删除地址薄失败！",null);
    }

    //更新地址薄
    @Override
    public Result updateAddress(SysAddress sysAddress) {
        int insert = sysAddressMapper.updateById(sysAddress);
        if (insert>0)
            return Result.success(200,"更新地址薄成功！",null);
        return Result.fail(400,"更新地址薄失败！",null);
    }

    //根据Id地址薄
    @Override
    public Result getAddressById(Long id) {
        SysAddress sysAddress = sysAddressMapper.selectById(id);
        if(ObjectUtils.isEmpty(sysAddress))
            return Result.fail(400,"没有该地址薄",null);
        return Result.success(200,"查询地址薄成功",sysAddress);
    }

    //获取个人所有的地址薄
    @Override
    public Result getAllAddress(Long userId) {
        LambdaQueryWrapper<SysAddress> sysAddressQueryWrapper = new LambdaQueryWrapper<>();
        sysAddressQueryWrapper.eq(SysAddress::getUserId,userId);
        List<SysAddress> sysAddressList= sysAddressMapper.selectList(sysAddressQueryWrapper);
        if(sysAddressList.size()==0)
            Result.success(400,"个人所有的地址薄为空！",null);
        return Result.success(200,"获取个人所有的地址薄成功！",sysAddressList);
    }


}




