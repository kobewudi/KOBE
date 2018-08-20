package com.wuxingfei.dao;

import com.wuxingfei.bean.PageBean;
import com.wuxingfei.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
@Component(value = "userMapper")
public interface UserMapper {
    public User getById(User id);

    public  void insertUser(User user);

    public  void deleteAll();

    public   void updateUser(User user);

    public   List<User> findAllUserList(Map<String,Object> params);

    public    User findUser(User user);
    public  Long countUser(Map<String,Object> params);


}
