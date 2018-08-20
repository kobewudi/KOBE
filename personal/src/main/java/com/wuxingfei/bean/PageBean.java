package com.wuxingfei.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class PageBean<T> {

    /** 行实体类 */
    private List<T> rows = new ArrayList<T>();

    /**
     * 每页行数
     */

    /**
     * 当前页
     */
    private int page;
    /**
     * 排序列
     */
    private String sidx;
    /**
     * 排序类型
     */
    private String sord;
    /**
     * 总记录数
     */
    private int records;
    private int  total;
    //起始下标
    private int  startRow ;
    //页面大小
    private  int  pageSize = BaseBean.PAGE_SIZE;
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 开始于第几行，由当前页和每页的记录数计算而得
     * @return
     */
    public int getStartRow() {
        return (this.getPage()-1)* this.getPageSize();
    }

    public int getPage() {
        return page; }

    public  void  setPage(int _page) {
        page =_page;

    }

    public String getSidx() { return sidx; }

    public void setSidx(String _sidx) {
        sidx = _sidx;

    }

    public String getSord() { return sord; }

    public  void setSord(String _sord) {
        sord = _sord;

    }
    /// <summary>
    /// 总记录数
    /// </summary>
    public int getRecords() { return records; }

    public  void setRecords(int _records) {
        records = _records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
