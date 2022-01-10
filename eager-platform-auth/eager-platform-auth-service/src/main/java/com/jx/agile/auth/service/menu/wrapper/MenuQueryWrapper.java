package com.jx.agile.auth.service.menu.wrapper;

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
import com.jx.agile.auth.client.menu.params.MenuQueryParam;
import com.jx.agile.auth.client.menu.constant.MenuConstant;
import java.util.Set;
import com.jx.agile.auth.client.menu.model.entity.Menu;

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
public class MenuQueryWrapper extends QueryWrapper<Menu> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private MenuQueryParam queryParam;

    public MenuQueryWrapper(){
    }

    public MenuQueryWrapper(MenuQueryParam queryParam){

        if(null != queryParam.getId()){
            this.eq(MenuConstant.ID,queryParam.getId());
        }

        if(StringUtils.isNotBlank(queryParam.getCode())){
            this.eq(MenuConstant.CODE,queryParam.getCode());
        }

        if(StringUtils.isNotBlank(queryParam.getName())){
            this.eq(MenuConstant.NAME,queryParam.getName());
        }

        if(CollectionUtils.isNotEmpty(queryParam.getLeafList())){
            this.in(MenuConstant.LEAF,queryParam.getLeafList());
        }
        if(null != queryParam.getLeaf()){
            this.eq(MenuConstant.LEAF,queryParam.getLeaf());
        }

        if(StringUtils.isNotBlank(queryParam.getIcon())){
            this.eq(MenuConstant.ICON,queryParam.getIcon());
        }

        if(StringUtils.isNotBlank(queryParam.getPath())){
            this.eq(MenuConstant.PATH,queryParam.getPath());
        }

        if(null != queryParam.getParentId()){
            this.eq(MenuConstant.PARENT_ID,queryParam.getParentId());
        }

        if(CollectionUtils.isNotEmpty(queryParam.getIsEnabledList())){
            this.in(MenuConstant.IS_ENABLED,queryParam.getIsEnabledList());
        }
        if(null != queryParam.getIsEnabled()){
            this.eq(MenuConstant.IS_ENABLED,queryParam.getIsEnabled());
        }

        if(StringUtils.isNotBlank(queryParam.getRemark())){
            this.eq(MenuConstant.REMARK,queryParam.getRemark());
        }
        if(null != queryParam.getStartCreatedTime() && null != queryParam.getEndCreatedTime()){
            this.between(MenuConstant.CREATED_TIME,queryParam.getStartCreatedTime(),queryParam.getEndCreatedTime());
        }
        if(null != queryParam.getStartCreatedTime()){
            this.gt(MenuConstant.CREATED_TIME,queryParam.getStartCreatedTime());
        }
        if(null != queryParam.getEndCreatedTime()){
            this.lt(MenuConstant.CREATED_TIME,queryParam.getEndCreatedTime());
        }

        if(null != queryParam.getCreatedTime()){
            this.eq(MenuConstant.CREATED_TIME,queryParam.getCreatedTime());
        }

        if(null != queryParam.getCreatedBy()){
            this.eq(MenuConstant.CREATED_BY,queryParam.getCreatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getCreatedByName())){
            this.eq(MenuConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
        }
        if(null != queryParam.getStartUpdatedTime() && null != queryParam.getEndUpdatedTime()){
            this.between(MenuConstant.UPDATED_TIME,queryParam.getStartUpdatedTime(),queryParam.getEndUpdatedTime());
        }
        if(null != queryParam.getStartUpdatedTime()){
            this.gt(MenuConstant.UPDATED_TIME,queryParam.getStartUpdatedTime());
        }
        if(null != queryParam.getEndUpdatedTime()){
            this.lt(MenuConstant.UPDATED_TIME,queryParam.getEndUpdatedTime());
        }

        if(null != queryParam.getUpdatedTime()){
            this.eq(MenuConstant.UPDATED_TIME,queryParam.getUpdatedTime());
        }

        if(null != queryParam.getUpdatedBy()){
            this.eq(MenuConstant.UPDATED_BY,queryParam.getUpdatedBy());
        }

        if(StringUtils.isNotBlank(queryParam.getUpdatedByName())){
            this.eq(MenuConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
        }
    }
}
