package com.tc.security.mapper;


import com.tc.security.GsSecurityDatabaseApplicationTest;
import com.tc.security.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/17 11:38
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class UserMapperTest extends GsSecurityDatabaseApplicationTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}