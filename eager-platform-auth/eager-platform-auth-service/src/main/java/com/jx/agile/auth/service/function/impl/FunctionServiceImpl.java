package com.jx.agile.auth.service.function.impl;

import com.jx.agile.auth.client.function.model.entity.Function;
import com.jx.agile.auth.mysql.mapper.FunctionMapper;
import com.jx.agile.auth.client.function.api.IFunctionService;
import org.springframework.stereotype.Service;
import com.jx.agile.core.common.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
* <p>
* 功能表 服务实现类
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-11
*/
@Slf4j
@Service
public class FunctionServiceImpl extends BaseServiceImpl<FunctionMapper, Function> implements IFunctionService {

}
