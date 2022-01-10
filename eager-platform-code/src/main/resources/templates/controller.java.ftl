package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import com.jx.agile.core.common.BaseController;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
* <p>
* ${table.comment!} 前端控制器
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
@Slf4j
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} extends BaseController<${table.serviceName},${entity}>{

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

}