package com.turan.common;


import java.io.Serializable;

public class PageReq implements Serializable
{
    private static final long serialVersionUID = 1L;

    // 页码
    private int page = 1;

    // 每页大小
    private int pageSize = 10;

    // 排序字段
    private String sortField = "";

    // 排序类型
    private SortType sortType = SortType.ASC;

    public enum SortType
    {
        DESC,
        ASC
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getSortField()
    {
        return sortField;
    }

    public void setSortField(String sortField)
    {
        this.sortField = sortField;
    }

    public SortType getSortType()
    {
        return sortType;
    }

    public void setSortType(SortType sortType)
    {
        this.sortType = sortType;
    }
}
