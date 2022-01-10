package ${package.QueryParam};

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ${package.Entity}.${entity};
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
public class ${entity}QueryParam extends  ${entity} {
<#-- ----------  BEGIN 字段循环遍历  ---------->

<#list table.fields as field>
    <#if field.propertyType == "LocalDateTime">
    private LocalDateTime start${field.propertyName?cap_first};

    private LocalDateTime end${field.propertyName?cap_first};

    </#if>
    <#if field.propertyType == "Boolean">
    private Set<${field.propertyType}> ${field.propertyName}List;

    </#if>
    <#if field.propertyType == "Decimal">
    private LocalDateTime start${field.propertyName?cap_first};

    private LocalDateTime end${field.propertyName?cap_first};

    </#if>
    <#if field.propertyType == "Integer" && field.comment?index_of("枚举") gt -1>
    private Set<${field.propertyType}> ${field.propertyName}List;

    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->
}