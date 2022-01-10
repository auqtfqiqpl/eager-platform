package com.jx.agile.basic.client.staff.params;

import java.time.LocalDateTime;
import java.util.Set;

import com.jx.agile.basic.client.staff.model.entity.Staff;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class StaffQueryParam extends  Staff {

    private Set<Boolean> isEnabledList;

    private LocalDateTime startCreatedTime;

    private LocalDateTime endCreatedTime;

    private LocalDateTime startUpdatedTime;

    private LocalDateTime endUpdatedTime;

}