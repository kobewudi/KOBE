/**
 * Created by Administrator on 2018/8/31.
 */

function alertmsg(type, msg) {
    var time = 4000;
    if(msg.length>=10){
        time = 5000;
    }
    $("#alertButton").manhua_msgTips({
        Event: "click",	//响应的事件
        timeOut: time,		//提示层显示的时间
        msg: msg,			//显示的消息
        speed: 800,		//滑动速度
        type: type			//提示类型（1、success 2、error 3、warning）

    });
    $("#alertButton").click();
}