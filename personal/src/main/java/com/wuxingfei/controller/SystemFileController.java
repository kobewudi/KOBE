package com.wuxingfei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by 吴星飞 on 2018/8/15.
 */
@Controller
    @RequestMapping("/sys")
    public class SystemFileController {
    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    @GetMapping("/fileManage")
    public  String  fileManage(){
        logger.info("进入文件管理页面");
        return "system/fileManage";
    }

   @PostMapping("/pictureSave")
    public  String  pictureSave(@RequestParam("files") MultipartFile[] files){
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
          int len =files.length;
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //保存文件
      String  oldName =      file.getOriginalFilename();
      logger.info(oldName);
            }
        }
        return "login";
    }
}

