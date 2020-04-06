package cn.wfc.security.service.impl;

import cn.wfc.security.bean.User;
import cn.wfc.security.mapper.UserMapper;
import cn.wfc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
