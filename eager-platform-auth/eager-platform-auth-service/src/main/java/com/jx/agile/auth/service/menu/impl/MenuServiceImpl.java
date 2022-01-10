package com.jx.agile.auth.service.menu.impl;

import com.jx.agile.auth.client.menu.model.entity.Menu;
import com.jx.agile.auth.mysql.mapper.MenuMapper;
import com.jx.agile.auth.client.menu.api.IMenuService;
import org.springframework.stereotype.Service;
import com.jx.agile.core.common.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
* <p>
* 菜单表 服务实现类
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-08
*/
@Slf4j
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements IMenuService {

}
