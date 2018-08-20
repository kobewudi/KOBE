package com.wuxingfei.service;

import com.wuxingfei.bean.PageBean;
import com.wuxingfei.bean.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public interface UserService {
    public    User getById(User id);

    public  void insertUser(User user);

    public  void deleteAll();

    public   void updateUser(User user);    

    public   List<User> findAllUserList(Map<String,Object> params);

    public   User findUser(User user);

    public Long countUser(Map<String,Object> params);

}
