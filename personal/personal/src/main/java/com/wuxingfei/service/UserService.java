package com.wuxingfei.service;

import com.wuxingfei.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public interface UserService {
    public    User getById(User id);

    public  void insertUser(User user);

    public  void deleteAll();

    public   void updateUser(User user);    

    public   List<User> findAllUserList();

    public   User findUser(User user);

    public Long countUser(User user);

}
