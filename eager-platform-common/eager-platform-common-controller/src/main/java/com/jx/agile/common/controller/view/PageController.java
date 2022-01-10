package com.jx.agile.common.controller.view;/**
 * @Auther: ly-jiangxh
 * @Date: 2021/03/26/11:32
 * @Description:
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jx.agile.core.common.BaseController;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面配置控制器
 * @author jiangxh
 * @date 2021/03/26 11:32
 **/
@RequestMapping("/page")
@RestController
public class PageController extends BaseController {

    @GetMapping("/select.do")
    public Result test(){
        Result result = ResultUtils.success();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text","test");
        jsonObject.put("value",1);
        result.setData(jsonObject);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertBuyName("东凤汽车223"));

    }
    private static String convertBuyName(String buyName){
        Map<String,String> convertMap = new HashMap<String,String>(){{
            put("东凤日产","东风日产");
            put("东凤汽车","东风汽车");
        }};
        for(String key : convertMap.keySet()){
            if(buyName.indexOf(key) > -1){
                buyName = buyName.replace(key,convertMap.get(key));
            }
        }
        return  buyName;
    }
}
