CREATE TABLE `ums_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) NULL COMMENT '父级权限id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `value` varchar(255) NOT NULL COMMENT '权限值',
  `icon` varchar(500) NULL COMMENT '图标',
  `type` tinyint(1) NOT NULL COMMENT '权限类型:0->目录;1->菜单;2->按钮;',
  `url` varchar(255) NOT NULL COMMENT '请求路径',
  `status` tinyint(1) NOT NULL COMMENT '状态:0->禁用;1->启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `sort` int(1) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '权限表';
