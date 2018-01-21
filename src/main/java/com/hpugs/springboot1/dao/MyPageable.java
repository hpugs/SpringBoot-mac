package com.hpugs.springboot1.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MyPageable implements Pageable {
    private int pageNumber;//当前请求分页
    private int pageSize;//页容量
    private Sort sort;//排序

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getOffset() {
        return (pageNumber-1)*pageSize;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        this.pageNumber = this.pageNumber+1;
        return this;
    }

    @Override
    public Pageable previousOrFirst() {
        this.pageNumber = 0 < this.pageNumber ? this.pageNumber-1 : 1;
        return this;
    }

    @Override
    public Pageable first() {
        this.pageNumber = 1;
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
