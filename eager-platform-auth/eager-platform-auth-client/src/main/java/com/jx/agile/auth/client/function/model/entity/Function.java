package com.jx.agile.auth.client.function.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
* 功能表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-11
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_auth_function")
@ApiModel(value="Function对象", description="功能表")
public class Function extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请求api")
    @TableField("api")
    private String api;

    @ApiModelProperty(value = "租户")
    @TableField("tenancy_id")
    private Long tenancyId;



}
