package com.jx.agile.auth.controller.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jx.agile.auth.client.menu.api.IMenuService;
import com.jx.agile.auth.client.menu.model.entity.Menu;
import com.jx.agile.auth.client.menu.model.vo.MenuVo;
import com.jx.agile.core.common.BaseController;
import com.jx.agile.core.constant.ResultMsgConstant;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

import lombok.extern.slf4j.Slf4j;

/**
* <p>
* 菜单表 前端控制器
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-08
*/
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<IMenuService,Menu>{

    @Autowired
    private IMenuService iMenuService;

    /**
     * 获取所有数据
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
        //获取所有的菜单信息
        List<Menu> allMenuList = (List<Menu>) super.getAll().getData();
        //先排序
        if(CollectionUtils.isEmpty(allMenuList)){
            return ResultUtils.success(ResultMsgConstant.EMPTY);
        }

        //排序
        allMenuList.sort((Menu s1, Menu s2) -> {
            return s1.getSort().compareTo(s2.getSort());
        });

        List<MenuVo> menuVoList = new ArrayList<>();
        //数据转换
        allMenuList.stream().forEach(menu-> {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(menu,menuVo);
            menuVoList.add(menuVo);
        });
        List<MenuVo> submMenuVoList = new ArrayList<>(menuVoList);
        //寻找子菜单

        Iterator<MenuVo> menuIterator = menuVoList.iterator();
        while (menuIterator.hasNext()){

            MenuVo menuVo = menuIterator.next();

            if(menuVo.getLeaf()){
                menuIterator.remove();
                continue;
            }
            Iterator<MenuVo> subMenuIterator = submMenuVoList.iterator();

            menuVo.setSubMenuList(new ArrayList<>());
            menuVo.setHasSubMenu(false);

            while (subMenuIterator.hasNext()) {

                MenuVo sourceMenu = subMenuIterator.next();
                Long menuId = menuVo.getId();
                if (menuId.equals(sourceMenu.getId())) {
                    subMenuIterator.remove();
                    continue;
                }
                if (menuId.equals(sourceMenu.getParentId())) {
                    menuVo.setHasSubMenu(true);
                    menuVo.getSubMenuList().add(sourceMenu);
                    if (sourceMenu.getLeaf()) {
                        subMenuIterator.remove();
                    }else{
                        subMenuIterator.remove();
                    }
                }
            }

        }

        return ResultUtils.success(menuVoList);
    }

    @GetMapping("/select.do")
    public Result test(){
        Result result = ResultUtils.success();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text","test");
        jsonObject.put("value",1);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        result.setData(jsonArray);
        return result;
    }

}