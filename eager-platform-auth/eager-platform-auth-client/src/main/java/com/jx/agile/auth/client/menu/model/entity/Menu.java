package com.jx.agile.auth.client.menu.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jx.agile.core.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 菜单表
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-08
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_auth_menu")
@ApiModel(value="Menu对象", description="菜单表")
public class Menu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "0:非叶子节点1：叶子节点")
    @TableField("leaf")
    private Boolean leaf;

    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "请求路径")
    @TableField("path")
    private String path;

    @ApiModelProperty(value = "父菜单")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

}
