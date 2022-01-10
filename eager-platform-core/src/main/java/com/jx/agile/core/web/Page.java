package com.jx.agile.core.web;

import lombok.Data;

@Data
public class Page<T> extends BasePage{


    //总大小
    private int total;

    //总页数
    private int totalPage;

    //数据
    private T data;

    public Page() {
    }

}
