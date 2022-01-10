package ${package.Constant};

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
public class ${entity}Constant {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
    /**
    * ${field.comment}
    */
    </#if>
    public static final String  ${field.name?upper_case} = "${field.name}";
</#list>
<#------------  END 字段循环遍历  ---------->
}
