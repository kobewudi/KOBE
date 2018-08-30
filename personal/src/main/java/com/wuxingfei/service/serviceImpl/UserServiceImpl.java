package com.wuxingfei.service.serviceImpl;

import com.wuxingfei.bean.PageBean;
import com.wuxingfei.bean.User;
import com.wuxingfei.dao.UserMapper;
import com.wuxingfei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User getById(User id) {
        return userMapper.getById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void deleteAll() {
        userMapper.deleteAll();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> findAllUserList(Map<String,Object> params) {
        return userMapper.findAllUserList(params);
    }

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public Long countUser(Map<String,Object> params) {

        return userMapper.countUser(params);
    }

}
