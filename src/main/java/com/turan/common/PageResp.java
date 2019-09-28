package com.turan.common;


import java.io.Serializable;
import java.util.List;

public class PageResp<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    // 当前页码
    private int page;

    // 每页大小
    private int pageSize;

    // 总记录数
    private long totalEle;

    // 总页数
    private int totalPage;

    // 查询结果
    private List<T> content;

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

    public long getTotalEle()
    {
        return totalEle;
    }

    public void setTotalEle(long totalEle)
    {
        this.totalEle = totalEle;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public List<T> getContent()
    {
        return content;
    }

    public void setContent(List<T> content)
    {
        this.content = content;
    }
}
