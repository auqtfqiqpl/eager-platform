package ${package.UpdateWapper};

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
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import ${package.QueryParam}.${entity}QueryParam;
import ${package.Constant}.${entity}Constant;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import ${package.OptParam}.${entity}OptParam;
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
@Slf4j
public class ${entity}UpdateWrapper extends UpdateWrapper<${entity}> implements Serializable  {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
    /**
    * 查询参数
    */
    private ${entity}QueryParam queryParam;

    public ${entity}UpdateWrapper(){
    }

    public ${entity}UpdateWrapper(${entity}OptParam optParam){

        if(null == optParam){
        log.info("${entity}更新增加参数为空");
        }

        String optType = optParam.getOptType();

        if(StringUtils.isBlank(optType)){
        log.info("${entity}操作类型参数为空");
        }

        ${entity}QueryParam condi = optParam.getCondition();
        log.info(optType+"${entity}操作参数:{}",condi);
        if(null != condi){
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
        ${entity} data = optParam.getData();
        log.info(optType+"${entity}操作数据:{}",data);

        if(null != data){
        <#list table.fields as field>
            <#if field.propertyType == "string">
            if(StringUtils.isNotBlank(queryParam.get${field.propertyName?cap_first}())){
                this.set(${entity}Constant.${field.name?upper_case},queryParam.get${field.propertyName?cap_first}());
            }
            <#else>
            if(null != queryParam.get${field.propertyName?cap_first}()){
                this.set(${entity}Constant.${field.name?upper_case},queryParam.get${field.propertyName?cap_first}());
            }
        </#if>
    </#list>
        }
    }
}
