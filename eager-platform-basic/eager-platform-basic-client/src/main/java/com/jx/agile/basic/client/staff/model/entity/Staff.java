package com.jx.agile.basic.client.staff.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.jx.agile.core.model.BaseEntity;

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
@TableName("t_basic_staff")
@ApiModel(value="Staff对象", description="人员信息表")
public class Staff extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工号")
    @TableField("job_num")
    private String jobNum;

    @ApiModelProperty(value = "职位")
    @TableField("job")
    private String job;

    @ApiModelProperty(value = "手机号码")
    @TableField("telphone")
    private Integer telphone;

    @ApiModelProperty(value = "邮箱")
    @TableField("e_mail")
    private String eMail;

    @ApiModelProperty(value = "住址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    private String orgId;



}
