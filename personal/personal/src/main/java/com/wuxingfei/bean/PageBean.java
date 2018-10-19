package com.wuxingfei.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class PageBean<T> {

    /** 行实体类 */
    private List<T> rows = new ArrayList<T>();
    /** 总条数 */

    private Long total;
  public PageBean() {
        super();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


}
