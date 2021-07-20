

#工单表

create table `worker_order` (
	`id` int unsigned NOT NULL AUTO_INCREMENT ,
	`apply_user` bigint(20) NOT NULL COMMENT '申请人id',
	`order_type` varchar(100) DEFAULT 'REPAIR' COMMENT '订单类型',
	`order_approval_user` bigint(20) NOT NULL COMMENT '审批人id',
	`order_cc_user` bigint(20) COMMENT '订单抄送人id',
	`cur_status` varchar(20) DEFAULT 'CREATED' COMMENT '目前订单的状态',
	`tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
	`create_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()  COMMENT '创建时间',
	`update_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()  COMMENT '更新时间',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#工单流水表
create table `worker_order_flow` (
	`id` int unsigned NOT NULL AUTO_INCREMENT ,
	`order_id` int unsigned NOT NULL COMMENT '订单id',
	`ori_status` varchar(20) DEFAULT 'CREATED' COMMENT '之前订单的状态',
	`cur_status` varchar(20) DEFAULT 'CREATED' COMMENT '目前订单的状态',
	`updater` bigint(20) NOT NULL COMMENT '更新id',
	`tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
	`create_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()  COMMENT '创建时间',
	`update_time`  datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()  COMMENT '更新时间',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;