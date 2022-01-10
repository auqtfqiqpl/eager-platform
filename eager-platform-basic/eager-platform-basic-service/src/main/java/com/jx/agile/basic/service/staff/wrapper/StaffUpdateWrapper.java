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
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import com.jx.agile.basic.client.staff.params.StaffQueryParam;
import com.jx.agile.basic.client.staff.constant.StaffConstant;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jx.agile.basic.client.staff.params.StaffOptParam;
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
@Slf4j
public class StaffUpdateWrapper extends UpdateWrapper<Staff> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private StaffQueryParam queryParam;

    public StaffUpdateWrapper(){
    }

    public StaffUpdateWrapper(StaffOptParam optParam){

        if(null == optParam){
        log.info("Staff更新增加参数为空");
        }

        String optType = optParam.getOptType();

        if(StringUtils.isBlank(optType)){
        log.info("Staff操作类型参数为空");
        }

        StaffQueryParam condi = optParam.getCondition();
        log.info(optType+"Staff操作参数:{}",condi);
        if(null != condi){

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
        Staff data = optParam.getData();
        log.info(optType+"Staff操作数据:{}",data);

        if(null != data){
            if(null != queryParam.getId()){
                this.set(StaffConstant.ID,queryParam.getId());
            }
            if(null != queryParam.getCode()){
                this.set(StaffConstant.CODE,queryParam.getCode());
            }
            if(null != queryParam.getName()){
                this.set(StaffConstant.NAME,queryParam.getName());
            }
            if(null != queryParam.getJobNum()){
                this.set(StaffConstant.JOB_NUM,queryParam.getJobNum());
            }
            if(null != queryParam.getJob()){
                this.set(StaffConstant.JOB,queryParam.getJob());
            }
            if(null != queryParam.getTelphone()){
                this.set(StaffConstant.TELPHONE,queryParam.getTelphone());
            }
            if(null != queryParam.getEMail()){
                this.set(StaffConstant.E_MAIL,queryParam.getEMail());
            }
            if(null != queryParam.getAddress()){
                this.set(StaffConstant.ADDRESS,queryParam.getAddress());
            }
            if(null != queryParam.getRemark()){
                this.set(StaffConstant.REMARK,queryParam.getRemark());
            }
            if(null != queryParam.getOrgId()){
                this.set(StaffConstant.ORG_ID,queryParam.getOrgId());
            }
            if(null != queryParam.getIsEnabled()){
                this.set(StaffConstant.IS_ENABLED,queryParam.getIsEnabled());
            }
            if(null != queryParam.getCreatedTime()){
                this.set(StaffConstant.CREATED_TIME,queryParam.getCreatedTime());
            }
            if(null != queryParam.getCreatedBy()){
                this.set(StaffConstant.CREATED_BY,queryParam.getCreatedBy());
            }
            if(null != queryParam.getCreatedByName()){
                this.set(StaffConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
            }
            if(null != queryParam.getUpdatedTime()){
                this.set(StaffConstant.UPDATED_TIME,queryParam.getUpdatedTime());
            }
            if(null != queryParam.getUpdatedBy()){
                this.set(StaffConstant.UPDATED_BY,queryParam.getUpdatedBy());
            }
            if(null != queryParam.getUpdatedByName()){
                this.set(StaffConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
            }
        }
    }
}
