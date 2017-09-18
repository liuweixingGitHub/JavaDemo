package com.ax.spring.query;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

@SuppressWarnings("all")
public class PageResult {

    private Integer totalCount;
    private Integer pageSize = 10;
    private Integer currentPage = 1;
    private List result;
    private Integer totalPage;
    private Integer prev;
    private Integer next;

    public PageResult() {
        super();
    }

    public PageResult(Integer totalCount, Integer pageSize, Integer currentPage, List result) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.result = result;
    }


    public static PageResult empty(int pageSize){
        return new PageResult(0,pageSize,1,new ArrayList<>());

    }

    public Integer getTotalPage(){
        return Math.max((totalCount+pageSize-1)/pageSize,1);

    }

    public Integer getPrev(){
        return Math.max(currentPage-1,1);
    }

    public Integer getNext(){
        return Math.min(currentPage+1,getTotalPage());
    }


    @Override
    public String toString() {
        return "PageResult{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", result=" + result +
                '}';
    }
}