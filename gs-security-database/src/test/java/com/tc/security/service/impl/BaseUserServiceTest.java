package com.tc.security.service.impl;

import com.tc.security.GsSecurityDatabaseApplicationTest;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/17 16:12
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class BaseUserServiceTest extends GsSecurityDatabaseApplicationTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Test
    public void insert() {
    }

    @Test
    public void getByUsername() {

    }
    @Test
    public void password(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        //$2a$10$9yTd8ZfZ4Paf.Z7O43iC5e68.56Z/eLoDxWwIQi3XxtOZ8DZvK70.
        //$2a$10$jKhWpjea6nYcVr.eX.nul.BA1E6kTBLCTuIvhod1X8p8158b4ATQq
        //$2a$10$hLIL/nv7lJFYYemTWMM2De/CymJweUwNhYy5u5E3fbh7mHuJWetwW
        System.out.println(encode);
        boolean match = bCryptPasswordEncoder.matches("123456", "{bcrypt}$2a$10$hLIL/nv7lJFYYemTWMM2De/CymJweUwNhYy5u5E3fbh7mHuJWetwW");
        System.out.println(match);
        String bcrypt = String.format("{%s}%s", "bcrypt", "$2a$10$hLIL/nv7lJFYYemTWMM2De/CymJweUwNhYy5u5E3fbh7mHuJWetwW");
        System.out.println(bcrypt);
    }
    @Test
    public void testBCryptPasswordEncoder(){
        Map<String, PasswordEncoder> beansOfType = applicationContext.getBeansOfType(PasswordEncoder.class);
        System.out.println(beansOfType);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
