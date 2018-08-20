/**
 * Created by Administrator on 2018/8/20.
 */
$(function () {
    initUserListGrid();
})
function  initUserListGrid() {
    var grid_selector = "#jqGrid";
    var pager_selector = "#gjqGridPager";
    $("#jqGrid").jqGrid({
        url: '/user/findAllUserList',
        datatype : "json",
        mtype : "POST",
        datatype: "json",
        colNames: ['编号', '姓名', '年龄', '职位', '是否可用'],
        colModel: [
            {  name: 'id', index:"id", width: 100 ,sorttype: 'in'},
            { name: 'userName',index:"userName" , width: 150, },
            { name: 'age', index: 'age', width: 200 },
            { name: 'job', index: 'job', width: 250,  },
            { name: 'isUse', index: 'isUse', width: 100,  }
        ],
        viewrecords: true, //是否显示行数
        loadonce: true,
        altRows:true,
        cellEdit:true,
        page:1,
        rowNum: 10,
        rowList:[5,10,15],
        jsonReader:
            {
                total: 'total',
                records:'records',
                root:'rows',
                repeatitems:true
            },
        pager:pager_selector,
        height: 'auto',
        multiselect: true,
        multiboxonly: false,
        caption:"用户列表"
    });

}