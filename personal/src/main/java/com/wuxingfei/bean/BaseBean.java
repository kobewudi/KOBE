package com.wuxingfei.bean;

/**
 * Created by Administrator on 2018/8/18 0018.
 */
public class BaseBean {
    private  int startPage;
    private  int size ;
    public static final int PAGE_SIZE =10;

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
