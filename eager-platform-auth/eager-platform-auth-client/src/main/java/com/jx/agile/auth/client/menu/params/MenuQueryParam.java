package com.jx.agile.auth.client.menu.params;

import java.time.LocalDateTime;
import java.util.Set;

import com.jx.agile.auth.client.menu.model.entity.Menu;

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
public class MenuQueryParam extends  Menu {

    private Set<Boolean> leafList;

    private Set<Boolean> isEnabledList;

    private LocalDateTime startCreatedTime;

    private LocalDateTime endCreatedTime;

    private LocalDateTime startUpdatedTime;

    private LocalDateTime endUpdatedTime;

}