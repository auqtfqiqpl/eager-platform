package com.jx.agile.basic.client.staff.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.jx.agile.basic.client.staff.model.entity.Staff;
import com.jx.agile.basic.client.staff.params.StaffQueryParam;
import java.util.Set;

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
public class StaffOptParam  extends  Staff {

    /**
    * save:增加，update：更新
    **/
    private String optType = "save";

    /**
    * 查询条件
    **/
    private StaffQueryParam condition;

    /**
    * 操作数据对象
    **/
    private  Staff  data;


}
