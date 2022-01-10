package com.jx.agile.auth.client.menu.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.jx.agile.auth.client.menu.model.entity.Menu;
import com.jx.agile.auth.client.menu.params.MenuQueryParam;
import java.util.Set;

/**
* <p>
* 菜单表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-08
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuOptParam  extends  Menu {

    /**
    * save:增加，update：更新
    **/
    private String optType = "save";

    /**
    * 查询条件
    **/
    private MenuQueryParam condition;

    /**
    * 操作数据对象
    **/
    private  Menu  data;


}
