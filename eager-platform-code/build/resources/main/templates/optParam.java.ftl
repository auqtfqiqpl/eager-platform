package ${package.OptParam};

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ${package.Entity}.${entity};
import ${package.QueryParam}.${entity}QueryParam;
import java.util.Set;

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if entityLombokModel>
@Data
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
<#else>
@EqualsAndHashCode(callSuper = false)
</#if>
@Accessors(chain = true)
</#if>
public class ${entity}OptParam  extends  ${entity} {

    /**
    * save:增加，update：更新
    **/
    private String optType = "save";

    /**
    * 查询条件
    **/
    private ${entity}QueryParam condition;

    /**
    * 操作数据对象
    **/
    private  ${entity}  data;


}
