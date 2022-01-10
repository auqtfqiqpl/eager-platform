CREATE TABLE `t_basic_account` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '账号',
  `pwd` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(50) NOT NULL DEFAULT '' COMMENT '盐',
  `tenancy_id` bigint NOT NULL DEFAULT '0' COMMENT '租户',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统账号';

CREATE TABLE `t_basic_dictionary` (
  `id` bigint NOT NULL COMMENT '主键',
  `type_code` varchar(50) NOT NULL DEFAULT '' COMMENT '类型编码',
  `type_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `key` varchar(50) NOT NULL DEFAULT '' COMMENT '字典索引',
  `value` varchar(500) NOT NULL DEFAULT '' COMMENT '字典值',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础字典';

CREATE TABLE `t_basic_function` (
  `id` bigint NOT NULL COMMENT 'ID',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `api` varchar(100) NOT NULL DEFAULT '' COMMENT '请求api',
  `tenancy_id` bigint NOT NULL DEFAULT '0' COMMENT '租户',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='功能表';


CREATE TABLE `t_basic_menu` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父菜单',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';


CREATE TABLE `t_basic_organization` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父级ID',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci  COMMENT='组织表';

CREATE TABLE `t_basic_role` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci  COMMENT='角色表';



CREATE TABLE `t_basic_staff` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `job_num` varchar(50) NOT NULL DEFAULT '' COMMENT '工号',
  `job` varchar(50) NOT NULL DEFAULT '' COMMENT '职位',
  `telphone` int NOT NULL DEFAULT '0' COMMENT '手机号码',
  `e_mail` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `address` varchar(500) NOT NULL DEFAULT '' COMMENT '住址',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `org_id` varchar(20) NOT NULL DEFAULT '0' COMMENT '组织ID',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci    COMMENT='人员信息表';


CREATE TABLE `t_basic_tenancy` (
  `id` bigint NOT NULL COMMENT '主键',
  `code` varchar(50) NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效0:无效 1:有效',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` int NOT NULL DEFAULT '0' COMMENT '创建人',
  `created_by_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updated_by` int NOT NULL DEFAULT '0' COMMENT '更新人',
  `updated_by_name` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='租户信息';





