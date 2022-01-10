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
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import com.jx.agile.auth.client.menu.params.MenuQueryParam;
import com.jx.agile.auth.client.menu.constant.MenuConstant;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jx.agile.auth.client.menu.params.MenuOptParam;
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
@Slf4j
public class MenuUpdateWrapper extends UpdateWrapper<Menu> implements Serializable  {

    private static final long serialVersionUID = 1L;
    /**
    * 查询参数
    */
    private MenuQueryParam queryParam;

    public MenuUpdateWrapper(){
    }

    public MenuUpdateWrapper(MenuOptParam optParam){

        if(null == optParam){
        log.info("Menu更新增加参数为空");
        }

        String optType = optParam.getOptType();

        if(StringUtils.isBlank(optType)){
        log.info("Menu操作类型参数为空");
        }

        MenuQueryParam condi = optParam.getCondition();
        log.info(optType+"Menu操作参数:{}",condi);
        if(null != condi){

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
        Menu data = optParam.getData();
        log.info(optType+"Menu操作数据:{}",data);

        if(null != data){
            if(null != queryParam.getId()){
                this.set(MenuConstant.ID,queryParam.getId());
            }
            if(null != queryParam.getCode()){
                this.set(MenuConstant.CODE,queryParam.getCode());
            }
            if(null != queryParam.getName()){
                this.set(MenuConstant.NAME,queryParam.getName());
            }
            if(null != queryParam.getLeaf()){
                this.set(MenuConstant.LEAF,queryParam.getLeaf());
            }
            if(null != queryParam.getIcon()){
                this.set(MenuConstant.ICON,queryParam.getIcon());
            }
            if(null != queryParam.getPath()){
                this.set(MenuConstant.PATH,queryParam.getPath());
            }
            if(null != queryParam.getParentId()){
                this.set(MenuConstant.PARENT_ID,queryParam.getParentId());
            }
            if(null != queryParam.getIsEnabled()){
                this.set(MenuConstant.IS_ENABLED,queryParam.getIsEnabled());
            }
            if(null != queryParam.getRemark()){
                this.set(MenuConstant.REMARK,queryParam.getRemark());
            }
            if(null != queryParam.getCreatedTime()){
                this.set(MenuConstant.CREATED_TIME,queryParam.getCreatedTime());
            }
            if(null != queryParam.getCreatedBy()){
                this.set(MenuConstant.CREATED_BY,queryParam.getCreatedBy());
            }
            if(null != queryParam.getCreatedByName()){
                this.set(MenuConstant.CREATED_BY_NAME,queryParam.getCreatedByName());
            }
            if(null != queryParam.getUpdatedTime()){
                this.set(MenuConstant.UPDATED_TIME,queryParam.getUpdatedTime());
            }
            if(null != queryParam.getUpdatedBy()){
                this.set(MenuConstant.UPDATED_BY,queryParam.getUpdatedBy());
            }
            if(null != queryParam.getUpdatedByName()){
                this.set(MenuConstant.UPDATED_BY_NAME,queryParam.getUpdatedByName());
            }
        }
    }
}
