package com.jx.agile.core.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BizCostTime implements Serializable {

    private static final long serialVersionUID = 5262464919812990855L;

    //业务标识
    private String biz;

    //消耗时间
    private Long costTime;

    public BizCostTime(String biz, Long costTime) {
        this.biz = biz;
        this.costTime = costTime;
    }

}
