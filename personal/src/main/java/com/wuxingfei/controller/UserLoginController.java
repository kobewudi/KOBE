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

import javax.servlet.http.HttpSession;
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

   @PostMapping("/login")
   public String toMain(@RequestParam("userName") String userName ,
                              @RequestParam("password") String password , ModelMap model,HttpSession session) {
       if (!StringUtils.isEmpty(userName) && null != password) {
           logger.info("正在验证登录身份信息。。");
           User user = new User();
           user.setUserName(userName);
           user.setPassword(password);
           currentUser = userService.findUser(user);
           if (currentUser != null) {
               logger.info("身份认证成功。");
               model.addAttribute("currentUser", currentUser);
               session.setAttribute("userSession",currentUser);
               return "index";
           }
       }
       return "login";
   }
 @PostMapping("/findAllUserList")
    @ResponseBody
public  PageBean<User> findAllUserList( Integer page , ModelMap modelMap){

     Map<String,Object> params = new HashMap<String,Object>();

     PageBean<User> pageBean = new PageBean<>();

     if(page==null){
         page=1;
     }

     int size = pageBean.getPageSize();
     params.put("size",size);
     int startRow = size*(page-1);
     params.put("startRow",startRow);
     Long count  =  userService.countUser(params);
     pageBean.setPage(page);//当前页
     pageBean.setRecords(count.intValue());
     int total =( count.intValue()+size -1)/size;
     pageBean.setTotal(total);//总页数
     pageBean.setPageSize(size);
     pageBean.setStartRow(startRow);
     List<User> list =  userService.findAllUserList(params);
     pageBean.setRecords(count.intValue());//总条数
     pageBean.setRows(list);//实际数据
     return pageBean;

    }

    //注册用户
    @PostMapping("/register")
    public  String register(User user){

    logger.info(user.toString());
        userService.insertUser(user);
    return "login";
    }
    @GetMapping("/index")
    public  String  index(HttpSession session){
        logger.info("即将进入主页面");
        return "index";
    }
    @GetMapping("/toLogin")
    public  String toLogin(){
        return "login";
    }

    @GetMapping(value = "/userList")
    public String userList(){
        return "userList";

    }
}
