package com.jx.agile.basic.service.staff.wrapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
import com.jx.agile.basic.client.staff.params.StaffQueryParam;
import com.jx.agile.basic.client.staff.constant.StaffConstant;
import java.util.Set;
import com.jx.agile.basic.client.staff.model.entity.Staff;

/**
* <p>
* 人员信息表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StaffQueryWrapper extends QueryWrapper<Staff> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private StaffQueryParam queryParam;

    public StaffQueryWrapper(){
    }

    public StaffQueryWrapper(StaffQueryParam queryParam){

        if(null != queryParam.getId()){
            this.eq(StaffConstant.ID,queryParam.getId());
        }

        if(StringUtils.isNotBlank(queryParam.getCode())){
            this.eq(StaffConstant.CODE,queryParam.getCode());
        }

        if(StringUtils.isNotBlank(queryParam.getName())){
            this.eq(StaffConstant.NAME,queryParam.getName());
        }

        if(StringUtils.isNotBlank(queryParam.getJobNum())){
            this.eq(StaffConstant.JOB_NUM,queryParam.getJobNum());
        }

        if(StringUtils.isNotBlank(queryParam.getJob())){
            this.eq(StaffConstant.JOB,queryParam.getJob());
        }

        if(null != queryParam.getTelphone()){
            this.eq(StaffConstant.TELPHONE,queryParam.getTelphone());
        }

        if(StringUtils.isNotBlank(queryParam.getEMail())){
            this.eq(StaffConstant.E_MAIL,queryParam.getEMail());
        }

        if(StringUtils.isNotBlank(queryParam.getAddress())){
            this.eq(StaffConstant.ADDRESS,queryParam.getAddress());
        }

        if(StringUtils.isNotBlank(queryParam.getRemark())){
            this.eq(StaffConstant.REMARK,queryParam.getRemark());
        }

        if(StringUtils.isNotBlank(queryParam.getOrgId())){
            this.eq(StaffConstant.ORG_ID,queryParam.getOrgId());
        }

        if(CollectionUtils.isNotEmpty(queryParam.getIsEnabledList())){
            this.in(StaffConstant.IS_ENABLED,queryParam.getIsEnabledList());
        }
        if(null != queryParam.getIsEnabled()){
            this.eq(StaffConstant.IS_ENABLED,queryParam.getIsEnabled());
        }
        if(null != queryParam.getStartCreatedTime() && null != queryParam.getEndCreatedTime()){
            this.between(StaffConstant.CREATED_TIME,queryParam.getStartCreatedTime(),queryParam.getEndCreatedTime());
        }
        if(null != queryParam.getStartCreatedTime()){
            this.gt(StaffConstant.CREATED_TIME,queryParam.getStartCreatedTime());
        }
        if(null != queryParam.getEndCreatedTime()){
            this.lt(StaffConstant.CREATED_TIME,queryParam.getEndCreatedTime());
        }

        if(null != queryParam.getCreatedTime()){
            this.eq(StaffConstant.CREATED_TIME,queryParam.getCreatedTime());
        }

        if(null != queryParam.getCreatedBy()){
            this.eq(StaffConstant.CREATED_BY,queryParam.getCreatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getCreatedByName())){
            this.eq(StaffConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
        }
        if(null != queryParam.getStartUpdatedTime() && null != queryParam.getEndUpdatedTime()){
            this.between(StaffConstant.UPDATED_TIME,queryParam.getStartUpdatedTime(),queryParam.getEndUpdatedTime());
        }
        if(null != queryParam.getStartUpdatedTime()){
            this.gt(StaffConstant.UPDATED_TIME,queryParam.getStartUpdatedTime());
        }
        if(null != queryParam.getEndUpdatedTime()){
            this.lt(StaffConstant.UPDATED_TIME,queryParam.getEndUpdatedTime());
        }

        if(null != queryParam.getUpdatedTime()){
            this.eq(StaffConstant.UPDATED_TIME,queryParam.getUpdatedTime());
        }

        if(null != queryParam.getUpdatedBy()){
            this.eq(StaffConstant.UPDATED_BY,queryParam.getUpdatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getUpdatedByName())){
            this.eq(StaffConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
        }
    }
}
