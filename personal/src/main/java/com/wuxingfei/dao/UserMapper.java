package com.wuxingfei.dao;

import com.wuxingfei.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

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

    public   List<User> findAllUserList(@RequestParam("params")  Map<String,Object> params);

    public    User findUser(User user);
    public  Long countUser(@RequestParam("params")  Map<String,Object> params);


}
