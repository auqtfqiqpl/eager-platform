package com.jx.agile.basic.controller.staff;/**
 * @Auther: ly-jiangxh
 * @Date: 2021/03/26/16:50
 * @Description:
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * aa
 * @author ly-jiangxh
 * @date 2021/03/26 16:50
 **/
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

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
