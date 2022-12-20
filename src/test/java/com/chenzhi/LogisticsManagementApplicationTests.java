package com.chenzhi;

import com.chenzhi.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogisticsManagementApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        userMapper.loadUserByUsername1("chenzhi");
    }

}
