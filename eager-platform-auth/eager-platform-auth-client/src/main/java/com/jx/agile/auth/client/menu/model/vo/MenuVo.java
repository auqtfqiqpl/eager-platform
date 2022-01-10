package com.jx.agile.auth.client.menu.model.vo;
/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/08/17:51
 * @Description:
 */

import java.util.List;

import com.jx.agile.auth.client.menu.model.entity.Menu;

import lombok.Data;

/**
 * 菜单页面展示对象
 * @author auqtfqiqpl
 * @date 2021/03/08 17:51
 **/

@Data
public class MenuVo extends Menu {

    /**
     * 子菜单集合
     */
    private List<MenuVo> subMenuList;

    /**
     * 是否有子菜单
     */
    private boolean hasSubMenu;

}
