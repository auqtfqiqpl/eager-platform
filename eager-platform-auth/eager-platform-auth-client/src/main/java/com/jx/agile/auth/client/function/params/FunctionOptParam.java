package com.jx.agile.auth.client.function.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.jx.agile.auth.client.function.model.entity.Function;
import com.jx.agile.auth.client.function.params.FunctionQueryParam;
import java.util.Set;

/**
* <p>
* 功能表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-11
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FunctionOptParam  extends  Function {

    /**
    * save:增加，update：更新
    **/
    private String optType = "save";

    /**
    * 查询条件
    **/
    private FunctionQueryParam condition;

    /**
    * 操作数据对象
    **/
    private  Function  data;


}
