package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import com.jx.agile.core.common.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
* <p>
* ${table.comment!} 服务实现类
* </p>
*
* @author ${author}
* @since ${date}
*/
@Slf4j
@Service
public class ${table.serviceImplName} extends BaseServiceImpl<${table.mapperName}, ${entity}> implements ${table.serviceName} {

}
