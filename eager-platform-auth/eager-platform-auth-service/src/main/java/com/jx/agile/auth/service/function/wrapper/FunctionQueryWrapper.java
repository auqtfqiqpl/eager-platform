package com.jx.agile.auth.service.function.wrapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.time.LocalDateTime;
import com.jx.agile.auth.client.function.params.FunctionQueryParam;
import com.jx.agile.auth.client.function.constant.FunctionConstant;
import java.util.Set;
import com.jx.agile.auth.client.function.model.entity.Function;

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
public class FunctionQueryWrapper extends QueryWrapper<Function> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private FunctionQueryParam queryParam;

    public FunctionQueryWrapper(){
    }

    public FunctionQueryWrapper(FunctionQueryParam queryParam){

        if(null != queryParam.getId()){
            this.eq(FunctionConstant.ID,queryParam.getId());
        }

        if(StringUtils.isNotBlank(queryParam.getCode())){
            this.eq(FunctionConstant.CODE,queryParam.getCode());
        }

        if(StringUtils.isNotBlank(queryParam.getName())){
            this.eq(FunctionConstant.NAME,queryParam.getName());
        }

        if(StringUtils.isNotBlank(queryParam.getApi())){
            this.eq(FunctionConstant.API,queryParam.getApi());
        }

        if(null != queryParam.getTenancyId()){
            this.eq(FunctionConstant.TENANCY_ID,queryParam.getTenancyId());
        }

        if(CollectionUtils.isNotEmpty(queryParam.getIsEnabledList())){
            this.in(FunctionConstant.IS_ENABLED,queryParam.getIsEnabledList());
        }
        if(null != queryParam.getIsEnabled()){
            this.eq(FunctionConstant.IS_ENABLED,queryParam.getIsEnabled());
        }

        if(StringUtils.isNotBlank(queryParam.getRemark())){
            this.eq(FunctionConstant.REMARK,queryParam.getRemark());
        }
        if(null != queryParam.getStartCreatedTime() && null != queryParam.getEndCreatedTime()){
            this.between(FunctionConstant.CREATED_TIME,queryParam.getStartCreatedTime(),queryParam.getEndCreatedTime());
        }
        if(null != queryParam.getStartCreatedTime()){
            this.gt(FunctionConstant.CREATED_TIME,queryParam.getStartCreatedTime());
        }
        if(null != queryParam.getEndCreatedTime()){
            this.lt(FunctionConstant.CREATED_TIME,queryParam.getEndCreatedTime());
        }

        if(null != queryParam.getCreatedTime()){
            this.eq(FunctionConstant.CREATED_TIME,queryParam.getCreatedTime());
        }

        if(null != queryParam.getCreatedBy()){
            this.eq(FunctionConstant.CREATED_BY,queryParam.getCreatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getCreatedByName())){
            this.eq(FunctionConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
        }
        if(null != queryParam.getStartUpdatedTime() && null != queryParam.getEndUpdatedTime()){
            this.between(FunctionConstant.UPDATED_TIME,queryParam.getStartUpdatedTime(),queryParam.getEndUpdatedTime());
        }
        if(null != queryParam.getStartUpdatedTime()){
            this.gt(FunctionConstant.UPDATED_TIME,queryParam.getStartUpdatedTime());
        }
        if(null != queryParam.getEndUpdatedTime()){
            this.lt(FunctionConstant.UPDATED_TIME,queryParam.getEndUpdatedTime());
        }

        if(null != queryParam.getUpdatedTime()){
            this.eq(FunctionConstant.UPDATED_TIME,queryParam.getUpdatedTime());
        }

        if(null != queryParam.getUpdatedBy()){
            this.eq(FunctionConstant.UPDATED_BY,queryParam.getUpdatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getUpdatedByName())){
            this.eq(FunctionConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
        }

        if(null != queryParam.getVersion()){
            this.eq(FunctionConstant.VERSION,queryParam.getVersion());
        }
    }
}
