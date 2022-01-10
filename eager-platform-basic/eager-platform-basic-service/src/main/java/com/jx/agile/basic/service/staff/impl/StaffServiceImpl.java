package com.jx.agile.basic.service.staff.impl;

import com.jx.agile.basic.client.staff.model.entity.Staff;
import com.jx.agile.basic.mysql.mapper.StaffMapper;
import com.jx.agile.basic.client.staff.api.IStaffService;
import org.springframework.stereotype.Service;
import com.jx.agile.core.common.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
* <p>
* 人员信息表 服务实现类
* </p>
*
* @author auqtfqiqpl
* @since 2021-03-05
*/
@Service
@Slf4j
public class StaffServiceImpl extends BaseServiceImpl<StaffMapper, Staff> implements IStaffService {

}
