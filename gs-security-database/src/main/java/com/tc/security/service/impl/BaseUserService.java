package com.tc.security.service.impl;

import com.tc.security.mapper.UserMapper;
import com.tc.security.pojo.User;
import com.tc.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
public class BaseUserService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    @Override
    public void insert(User user) {
        String username = user.getUsername();
        if (exist(username)){
            throw new RuntimeException("用户名已存在！");
        }
        userMapper.insert(user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())));
    }

    @Override
    public User getByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        return userMapper.selectOneByExample(example);
    }

    /**
     * 判断用户是否存在
     */
    private boolean exist(String username){
        User user = getByUsername(username);
        return (user != null);
    }

}
