CREATE TABLE `ums_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(100) NOT NULL COMMENT '角色名',
  `description` varchar(255) NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL COMMENT '角色状态:0->禁用;1->启用',
  `sort` int(1) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '角色表';

INSERT INTO `benxiaojia`.`ums_role`(`id`, `role_name`, `description`, `create_time`, `status`, `sort`) VALUES (1, '系统管理员', '系统管理员', '2020-08-21 15:46:11', 1, 0);
