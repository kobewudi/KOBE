/**
 * Created by Administrator on 2018/8/3.
 */
var loginOk =false;
function  login() {
    var userName= $("#index-userName").val();
    var  password =$("#index-password").val();
    $.ajax({
        url:"/user/login",
        type: "post",
       data:{"userName":userName,"password":password},
        success:function (data) {
            if(data=="success"){
                window.href = "index";
            }else {
                window.href = "login";
            }
        }
    });
}
function loginUserNameBlur(){
    var userName= $.trim($("#index-userName").val());

    if(!userName){
        $("#login-tip").html("登录名不能为空").css("color","red");
        loginOk= false;
        $("#index-userName").focus();

    }else {
        $("#login-tip").html("");

    }
}
function loginPasswordBlur(){
    var password= $.trim($("#index-password").val().trim());

    if(!password){
        $("#login-tip").html("用户密码不能为空").css("color","red");
        $("#index-password").focus();
        loginOk= false;
    } else {
        $("#login-tip").html("");
    }
}

function CurrentTime()
{
    var now = new Date();

    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日

    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var ss = now.getSeconds();           //秒
    var week = now.getDay();             //星期
    var clock = year + "年";

    if(month < 10)
        clock += "0";

    clock += month + "月";

    if(day < 10)
        clock += "0";

    clock += day + "日";

    if(hh < 10)
        clock += "0";

    clock += hh + "时";
    if (mm < 10) clock += '0';
    clock += mm + "分";

    if (ss < 10) clock += '0';
    clock += ss+"秒";
   var wwek = weekToChinese(week);
    var str =clock+"      "+wwek;
    $("#index-date").html(str);
}
function weekToChinese (week) {
    var result = "";
  switch (week ){

      case 0:
           result = "星期日";
           break;
      case 1:
          result = "星期一";
          break;
      case 2:

          result = "星期二";
          break;
      case 3:
          result = "星期三";
          break;
      case 4:
          result = "星期四";
          break;
      case 5:
          result = "星期五";
          break;
      case 6:
          result = "星期六";
          break;
      default:
          result;

  }
    return result;
}



//初始化bootstrap-table的内容

function initUserTable(){
    var $table;
    var rows= 2;
    //记录页面bootstrap-table全局变量$table，方便应用
    var queryUrl = '/user/findAllUserList',
    $table = $('#table').bootstrapTable({

        url: queryUrl,                      //请求后台的URL（*）
        method: 'POST',                      //请求方式（*）
        //toolbar: '#toolbar',              //工具按钮用哪个容器
       contentType : "application/x-www-form-urlencoded",
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: rows,                     //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        showExport: true,                     //是否显示导出
        exportDataType: "basic",
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                rows: params.limit,                         //页面大小
                page: (params.offset / params.limit) + 1,   //页码
                sort: params.sort,      //排序列名
                sortOrder: params.order //排位命令（desc，asc）
            };
            return temp;
        },
        columns: [{
            checkbox: true,
            visible: true                  //是否显示复选框
        },{
            field: 'id',
            title: '编号',
            sortable: true
        }, {
            field: 'userName',
            title: '姓名',
            sortable: true
        }, {
                field: 'age',
                title: '年龄',
                sortable: true
        },
            {
                field: 'birthday',
                title: '出生日期',

                formatter: function (value) {
                    return formatBirthDate(value)
                }
            },
            {
                field: 'nativePlace',
                title: '籍贯',
                sortable: true
            },
            {
                field: 'phone',
                title: '电话',
                sortable: true
            },
            {
                field: 'job',
                title: '工作',
                sortable: true
            },
            {
                field: 'nativePlace',
                title: '籍贯',
                sortable: true
            },
            {
                field: 'isUse',
                title: '是否启用',
                formatter: function (value ) {
                    return formatIsUse(value)
                }

            },
            {
                field: 'remark',
                title: '备注',
                sortable: true
            },
    ]
    });
}
function formatIsUse(value) {
   if(value==1){
       return "启用";
   }else{
       return "禁用";
   }

}
function formatBirthDate(value) {
    if (value != null) {
        var date = new Date(value);
        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
    }
}
function userEditModalBtn(){
   var  $table =$('#table');
    var row = $.map($table.bootstrapTable('getSelections'), function(row) {
        return row ;
    });
    if(row.length!=1){
        alert("必须且只能选择一行");
        return false;
    }
    $("#user_edit_userName").val(row[0].userName);
    $("#user_edit_age").val(row[0].age);
    $('#userEditModal').modal('show');

}
function btn_user_add(id){

}
function btn_user_add (id) {

}

function imgvrifyKaptcha() {
    var tryCode = $("#index-imgvrify").val();
    $.ajax({
        url:"/imgvrifyControllerDefaultKaptcha",
        type: "post",
        data:{"tryCode":tryCode},
        success:function (data) {
            if(data=="successImgCheck"){
               $("#login-tip").html("验证码正确").css("color","green");;

                loginOk= true;
                 $("#index-login").removeAttr("disabled");
            }else {
                $("#login-tip").html("验证码错误").css("color","red");
                loginOk =false;
               $("#index-imgvrify").focus();
            }
        }
    });

}
function userSerch() {

}