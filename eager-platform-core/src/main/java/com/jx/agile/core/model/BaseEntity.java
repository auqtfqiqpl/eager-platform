package com.jx.agile.core.model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/04/17:28
 * @Description: 共用的entity属性
 */
@Data
public class BaseEntity extends Model<BaseEntity> {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Integer version;

    @ApiModelProperty(value = "是否有效0:无效 1:有效")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "创建人")
    @TableField("created_by")
    private Integer createdBy;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("created_by_name")
    private String createdByName;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "更新人")
    @TableField("updated_by")
    private Integer updatedBy;

    @ApiModelProperty(value = "更新人姓名")
    @TableField("updated_by_name")
    private String updatedByName;

}
