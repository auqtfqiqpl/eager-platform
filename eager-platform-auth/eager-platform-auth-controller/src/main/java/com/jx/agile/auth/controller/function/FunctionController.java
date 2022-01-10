package com.jx.agile.auth.controller.function;

import org.springframework.web.bind.annotation.RequestMapping;
import com.jx.agile.core.common.BaseController;
import com.jx.agile.auth.client.function.api.IFunctionService;
import com.jx.agile.auth.client.function.model.entity.Function;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
* <p>
* 功能表 前端控制器
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-11
*/
@Slf4j
@RestController
@RequestMapping("/auth/function")
public class FunctionController extends BaseController<IFunctionService,Function>{

    @Autowired
    private IFunctionService iFunctionService;

}