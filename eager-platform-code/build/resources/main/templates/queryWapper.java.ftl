package ${package.QueryWapper};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDateTime;
import ${package.QueryParam}.${entity}QueryParam;
import ${package.Constant}.${entity}Constant;
import java.util.Set;
import ${package.Entity}.${entity};

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
public class ${entity}QueryWrapper extends QueryWrapper<${entity}> implements Serializable  {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
    /**
    * 查询参数
    */
    private ${entity}QueryParam queryParam;

    public ${entity}QueryWrapper(){
    }

    public ${entity}QueryWrapper(${entity}QueryParam queryParam){
<#list table.fields as field>
    <#if field.propertyType == "LocalDateTime" || field.propertyType == "Decimal">
        if(null != queryParam.getStart${field.propertyName?cap_first}() && null != queryParam.getEnd${field.propertyName?cap_first}()){
            this.between(${entity}Constant.${field.name?upper_case},queryParam.getStart${field.propertyName?cap_first}(),queryParam.getEnd${field.propertyName?cap_first}());
        }
        if(null != queryParam.getStart${field.propertyName?cap_first}()){
            this.gt(${entity}Constant.${field.name?upper_case},queryParam.getStart${field.propertyName?cap_first}());
        }
        if(null != queryParam.getEnd${field.propertyName?cap_first}()){
            this.lt(${entity}Constant.${field.name?upper_case},queryParam.getEnd${field.propertyName?cap_first}());
        }
    </#if>
<#------------ 说明有枚举值  ---------->

    <#if field.propertyType == "Boolean" || (field.propertyType == "Integer" && field.comment?index_of("枚举") gt -1)>
        if(CollectionUtils.isNotEmpty(queryParam.get${field.propertyName?cap_first}List())){
            this.in(${entity}Constant.${field.name?upper_case},queryParam.get${field.propertyName?cap_first}List());
        }
    </#if>
    <#if field.propertyType == "String">
        if(StringUtils.isNotBlank(queryParam.get${field.propertyName?cap_first}())){
            this.eq(${entity}Constant.${field.name?upper_case},queryParam.get${field.propertyName?cap_first}());
        }
    <#else>
        if(null != queryParam.get${field.propertyName?cap_first}()){
            this.eq(${entity}Constant.${field.name?upper_case},queryParam.get${field.propertyName?cap_first}());
        }
    </#if>
</#list>
    }
}
