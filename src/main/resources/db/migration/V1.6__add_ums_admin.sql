CREATE TABLE `ums_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(64) NOT NULL COMMENT '用户账号',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `icon` varchar(500) NULL COMMENT '用户头像',
  `email` varchar(100) NULL COMMENT '用户邮箱',
  `cellphone` varchar(64) NOT NULL COMMENT '用户手机',
  `remark` varchar(255) NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL COMMENT '用户状态: 0->禁用;1->启用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `login_time` datetime NOT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户表';

INSERT INTO `benxiaojia`.`ums_admin`(`id`, `username`, `password`, `icon`, `email`, `cellphone`, `remark`, `status`, `create_time`, `login_time`) VALUES (1, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', NULL, '15999727725', NULL, 1, '2018-09-29 13:55:30', '2018-09-29 13:55:39');








