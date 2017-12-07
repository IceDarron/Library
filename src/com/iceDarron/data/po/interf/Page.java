package com.iceDarron.data.po.interf;

/**
 * Description: 分页
 * Author: liuzh
 * Update: liuzh(2014-04-16 10:56)
 */
public class Page {

    private int pageNo = 1;

    private int pageSize = 10;

    private long total = 0;

    private int pages = 0;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
