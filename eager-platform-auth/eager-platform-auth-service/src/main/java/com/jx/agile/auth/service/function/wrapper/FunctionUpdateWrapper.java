package com.jx.agile.auth.service.function.wrapper;

import java.io.Serializable;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jx.agile.auth.client.function.constant.FunctionConstant;
import com.jx.agile.auth.client.function.model.entity.Function;
import com.jx.agile.auth.client.function.params.FunctionOptParam;
import com.jx.agile.auth.client.function.params.FunctionQueryParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class FunctionUpdateWrapper extends UpdateWrapper<Function> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private FunctionQueryParam queryParam;

    public FunctionUpdateWrapper(){
    }

    public FunctionUpdateWrapper(FunctionOptParam optParam){

        if(null == optParam){
        log.info("Function更新增加参数为空");
        }

        String optType = optParam.getOptType();

        if(StringUtils.isBlank(optType)){
        log.info("Function操作类型参数为空");
        }

        FunctionQueryParam condi = optParam.getCondition();
        log.info(optType+"Function操作参数:{}",condi);
        if(null != condi){

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
        Function data = optParam.getData();
        log.info(optType+"Function操作数据:{}",data);

        if(null != data){
            if(null != queryParam.getId()){
                this.set(FunctionConstant.ID,queryParam.getId());
            }
            if(null != queryParam.getCode()){
                this.set(FunctionConstant.CODE,queryParam.getCode());
            }
            if(null != queryParam.getName()){
                this.set(FunctionConstant.NAME,queryParam.getName());
            }
            if(null != queryParam.getApi()){
                this.set(FunctionConstant.API,queryParam.getApi());
            }
            if(null != queryParam.getTenancyId()){
                this.set(FunctionConstant.TENANCY_ID,queryParam.getTenancyId());
            }
            if(null != queryParam.getIsEnabled()){
                this.set(FunctionConstant.IS_ENABLED,queryParam.getIsEnabled());
            }
            if(null != queryParam.getRemark()){
                this.set(FunctionConstant.REMARK,queryParam.getRemark());
            }
            if(null != queryParam.getCreatedTime()){
                this.set(FunctionConstant.CREATED_TIME,queryParam.getCreatedTime());
            }
            if(null != queryParam.getCreatedBy()){
                this.set(FunctionConstant.CREATED_BY,queryParam.getCreatedBy());
            }
            if(null != queryParam.getCreatedByName()){
                this.set(FunctionConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
            }
            if(null != queryParam.getUpdatedTime()){
                this.set(FunctionConstant.UPDATED_TIME,queryParam.getUpdatedTime());
            }
            if(null != queryParam.getUpdatedBy()){
                this.set(FunctionConstant.UPDATED_BY,queryParam.getUpdatedBy());
            }
            if(null != queryParam.getUpdatedByName()){
                this.set(FunctionConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
            }
            if(null != queryParam.getVersion()){
                this.set(FunctionConstant.VERSION,queryParam.getVersion());
            }
        }
    }
}
