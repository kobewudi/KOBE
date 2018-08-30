/**
 * Created by Administrator on 2018/8/20.
 */
$(function () {
    initGridTable();
})


function initGridTable() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";
    $(grid_selector).jqGrid({
        /*height: 220,*/
        url: '/user/findAllUserList',
        datatype : "json",
        mtype : "post",
        colNames: ['编号', '姓名', '生日', '职位', '籍贯','手机','关系','是否可用'],
        colModel: [
        {  name: 'id', index:"id", width: 100 ,sorttype: 'in'},
        { name: 'userName',index:"userName" , width: 150, },
        { name: 'birthday', index: 'birthday', width: 200 },
        { name: 'job', index: 'job', width: 250,  },
        {name: 'nativePlace', index: 'nativePlace', width: 200 },
        {name: 'phone', index: 'phone', width: 200 },
        {name: 'relation', index: 'relation', width: 200 },
        { name: 'isUse', index: 'isUse', width: 100, formatter:formatterUse }
    ],
        width:"100%",
        autowidth:true,
        height:"100%",
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 15, 20, 25],
        loadonce: false,
        pager: pager_selector,
        altRows: true,
        jsonReader: {
            total: 'total',
            records: 'records',
            root: 'rows',
            repeatitems: true
        },
        //multikey: "ctrlKey",
        multiselect: true,
        multiboxonly: false,
        pgbuttons:true,
        loadComplete: function (data) {
            //得设置页面尺寸
        },
        gridComplete: function () {
            var ids = $(grid_selector).jqGrid('getDataIDs');
        },
    });
    //数据格式化
    function formatterUse(isUse) {
        var result ="";
        switch (parseInt(isUse)){
             case 0:
                result = "禁用" ;
                 break;
            case 1:
                result = "启用" ;
                break;
            default:
                result= "";
                break;
         }
    return result ;
    }

}