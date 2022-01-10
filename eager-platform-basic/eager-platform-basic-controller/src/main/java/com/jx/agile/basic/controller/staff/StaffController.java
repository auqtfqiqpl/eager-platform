package com.jx.agile.basic.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jx.agile.basic.client.staff.api.IStaffService;
import com.jx.agile.basic.client.staff.model.entity.Staff;
import com.jx.agile.core.common.BaseController;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

import lombok.extern.slf4j.Slf4j;

/**
* <p>
* 人员信息表 前端控制器
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-05
*/
@Slf4j
@RestController
@RequestMapping("/staff")
public class StaffController extends BaseController<IStaffService,Staff>{

    @Autowired
    private IStaffService iStaffService;

    @GetMapping("/select.do")
    public Result test(){
        Result result = ResultUtils.success();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text","test");
        jsonObject.put("value",1);
        result.setData(jsonObject);
        return result;
    }

}