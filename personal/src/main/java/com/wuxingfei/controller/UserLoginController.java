package com.wuxingfei.controller;

import com.wuxingfei.bean.PageBean;
import com.wuxingfei.bean.User;
import com.wuxingfei.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 吴星飞 on 2018/7/20.
 */


@Controller
@RequestMapping("/user")
public class UserLoginController  {

    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    private UserService userService;
    private User currentUser;

   @PostMapping("/index")
   public String toMain(@RequestParam("userName") String userName ,
                              @RequestParam("password") String password , ModelMap model) {
       if (!StringUtils.isEmpty(userName) && null != password) {
           logger.info("正在验证登录身份信息。。");
           User user = new User();
           user.setUserName(userName);
           user.setPassword(password);
           currentUser = userService.findUser(user);
           if (currentUser != null) {
               logger.info("身份认证成功。");
               model.addAttribute("currentUser", currentUser);
               return "login";
           }
       }
       return "index";
   }

   @PostMapping("/findAllUserList")
@ResponseBody
public  PageBean<User> findAllUserList(){
    List<User> list =  userService.findAllUserList();

       PageBean<User> pageBean = new PageBean<>();
       User user =new User();
       Long count  =  userService.countUser(user);
     /*   int offset = 2;
        int  limit =2;*/
       pageBean.setRows(list);
       pageBean.setTotal(2L);
    return pageBean;
    }

}
