package com.wuxingfei.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 吴星飞 on 2018/8/13.
 */
@Component
public class ReportTimeTask {
    private  static  final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm;ss");
   @Scheduled(cron ="1-31 * * * * ?")
    public void  testTiem(){

       System.out.println("现在时间："+dateFormat.format(new Date()) );

    }

}
