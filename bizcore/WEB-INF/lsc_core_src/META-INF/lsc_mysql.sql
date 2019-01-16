-- BUILD WITH MODEL TIME 190116T1604
drop database  if exists lsc;
create database lsc;
alter  database lsc  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use lsc;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(32)                              comment '名称',
	introduction        	varchar(72)                              comment '介绍',
	current_version     	varchar(16)                              comment '当前版本',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transaction_type_data;
create table transaction_type_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	platform            	varchar(48)                              comment '平台',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists merchant_type_data;
create table merchant_type_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	platform            	varchar(48)                              comment '平台',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transport_task_status_data;
create table transport_task_status_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(12)                              comment '名称',
	platform            	varchar(48)                              comment '平台',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists location_data;
create table location_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(28)                              comment '名称',
	contact_person      	varchar(12)                              comment '联系人',
	contact_phone       	varchar(44)                              comment '联系电话',
	description         	longtext                                 comment '描述',
	platform            	varchar(48)                              comment '平台',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists merchant_data;
create table merchant_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(32)                              comment '名称',
	type                	varchar(48)                              comment '类型',
	platform            	varchar(48)                              comment '平台',
	description         	longtext                                 comment '描述',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transport_project_data;
create table transport_project_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(32)                              comment '名称',
	merchant            	varchar(48)                              comment '商人',
	platform            	varchar(48)                              comment '平台',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transport_item_data;
create table transport_item_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	quantity            	int                                      comment '数量',
	unit                	varchar(8)                               comment '单位',
	project             	varchar(48)                              comment '项目',
	merchant            	varchar(48)                              comment '商人',
	platform            	varchar(48)                              comment '平台',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transport_task_data;
create table transport_task_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(24)                              comment '名称',
	source              	varchar(48)                              comment '源',
	destination         	varchar(48)                              comment '目的地',
	remark              	varchar(20)                              comment '备注',
	status              	varchar(48)                              comment '状态',
	sender              	varchar(48)                              comment '发送方',
	receiver            	varchar(48)                              comment '接收机',
	platform            	varchar(48)                              comment '平台',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transport_task_track_data;
create table transport_task_track_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	latitude            	numeric(9,6)                             comment '纬度',
	longitude           	numeric(10,6)                            comment '经度',
	task                	varchar(48)                              comment '任务',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists merchant_account_data;
create table merchant_account_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	merchant            	varchar(48)                              comment '商人',
	create_time         	datetime                                 comment '创建时间',
	update_time         	datetime                                 comment '更新时间',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists transaction_data;
create table transaction_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(8)                               comment '名称',
	amount              	numeric(9,2)                             comment '金额',
	transaction_type    	varchar(48)                              comment '交易类型',
	account             	varchar(48)                              comment '账户',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(16)                              comment '名称',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'ID',
	user_identity       	varchar(40)                              comment '用户身份',
	user_special_functions	varchar(200)                             comment '用户特殊功能',
	domain              	varchar(48)                              comment '域',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'ID',
	login               	varchar(20)                              comment '登录',
	mobile              	varchar(11)                              comment '手机号码',
	email               	varchar(76)                              comment '电子邮件',
	pwd                 	varchar(64)                              comment '密码',
	verification_code   	int                                      comment '验证码',
	verification_code_expire	datetime                                 comment '验证码过期',
	last_login_time     	datetime                                 comment '最后登录时间',
	domain              	varchar(48)                              comment '域',
	blocking            	varchar(48)                              comment '屏蔽',
	current_status      	varchar(28)                              comment '当前状态',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'ID',
	who                 	varchar(52)                              comment '谁',
	block_time          	datetime                                 comment '块时间',
	comments            	varchar(96)                              comment '评论',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(300)                             comment '标题',
	sec_user            	varchar(48)                              comment '安全用户',
	app_icon            	varchar(36)                              comment '应用程序图标',
	full_access         	tinyint                                  comment '完全访问',
	permission          	varchar(16)                              comment '许可',
	object_type         	varchar(108)                             comment '访问对象类型',
	object_id           	varchar(40)                              comment '对象ID',
	location            	varchar(48)                              comment '位置',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(200)                             comment '名称',
	internal_name       	varchar(200)                             comment '内部名称',
	read_permission     	tinyint                                  comment '读权限',
	create_permission   	tinyint                                  comment '创建权限',
	delete_permission   	tinyint                                  comment '删除权限',
	update_permission   	tinyint                                  comment '更新许可',
	execution_permission	tinyint                                  comment '执行权限',
	app                 	varchar(48)                              comment '应用程序',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'ID',
	name                	varchar(28)                              comment '名称',
	object_type         	varchar(112)                             comment '访问对象类型',
	list1               	varchar(80)                              comment '列表1',
	list2               	varchar(80)                              comment '列表2',
	list3               	varchar(80)                              comment '列表3',
	list4               	varchar(80)                              comment '列表4',
	list5               	varchar(80)                              comment '列表5',
	list6               	varchar(80)                              comment '列表6',
	list7               	varchar(80)                              comment '列表7',
	list8               	varchar(80)                              comment '列表8',
	list9               	varchar(80)                              comment '列表9',
	app                 	varchar(48)                              comment '应用程序',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'ID',
	login_time          	datetime                                 comment '登录时间',
	from_ip             	varchar(44)                              comment '来自IP',
	description         	varchar(16)                              comment '描述',
	sec_user            	varchar(48)                              comment '安全用户',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(20)                              comment '标题',
	description         	varchar(48)                              comment '描述',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(24)                              comment '标题',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'ID',
	title               	varchar(16)                              comment '标题',
	parameter_name      	varchar(16)                              comment '参数名称',
	form                	varchar(48)                              comment '形式',
	level               	varchar(28)                              comment '水平',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'ID',
	label               	varchar(12)                              comment '标签',
	locale_key          	varchar(44)                              comment '语言环境的关键',
	parameter_name      	varchar(16)                              comment '参数名称',
	type                	varchar(36)                              comment '类型',
	form                	varchar(48)                              comment '形式',
	placeholder         	varchar(48)                              comment '占位符',
	default_value       	varchar(12)                              comment '默认值',
	description         	varchar(48)                              comment '描述',
	field_group         	varchar(16)                              comment '字段组',
	minimum_value       	varchar(60)                              comment '最小值',
	maximum_value       	varchar(72)                              comment '最大值',
	required            	tinyint                                  comment '要求',
	disabled            	tinyint                                  comment '禁用',
	custom_rendering    	tinyint                                  comment '自定义渲染',
	candidate_values    	varchar(12)                              comment '候选人的价值观',
	suggest_values      	varchar(12)                              comment '建议值',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'ID',
	label               	varchar(8)                               comment '标签',
	locale_key          	varchar(16)                              comment '语言环境的关键',
	action_key          	varchar(24)                              comment '行动的关键',
	level               	varchar(28)                              comment '水平',
	url                 	varchar(168)                             comment 'url',
	form                	varchar(48)                              comment '形式',
	version             	int                                      comment '版本',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','物流综合服务平台','一个连通货主和司机的物流综合服务平台','V1.0','1');

	
insert into transaction_type_data values ('TT000001','支出','P000001','1');
insert into transaction_type_data values ('TT000002','收入','P000001','1');

	
insert into merchant_type_data values ('MT000001','司机','P000001','1');
insert into merchant_type_data values ('MT000002','渠道','P000001','1');
insert into merchant_type_data values ('MT000003','综合','P000001','1');
insert into merchant_type_data values ('MT000004','平台','P000001','1');

	
insert into transport_task_status_data values ('TTS000001','初始','P000001','1');
insert into transport_task_status_data values ('TTS000002','招标','P000001','1');
insert into transport_task_status_data values ('TTS000003','抢单','P000001','1');
insert into transport_task_status_data values ('TTS000004','执行中','P000001','1');
insert into transport_task_status_data values ('TTS000005','完成','P000001','1');

	
insert into location_data values ('L000001','河南橡胶二号仓','西蒙罗','18788887777','    一段样例文字。
可以分段。

可以空行。

','P000001','2018-12-29 05:07:41','2019-01-10 15:58:12','1');
insert into location_data values ('L000002','河南橡胶二号仓0002','西蒙罗0002','13900000002','    一段样例文字。
可以分段。

可以空行。

','P000001','2019-01-06 15:47:03','2019-01-11 09:33:04','1');

	
insert into merchant_data values ('M000001','王司机','MT000001','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-01-12 10:45:32','2018-12-30 10:05:35','1');
insert into merchant_data values ('M000002','青白江物流代理点','MT000002','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-01-01 13:03:50','2019-01-08 05:11:53','1');
insert into merchant_data values ('M000003','王司机','MT000003','P000001','    一段样例文字。
可以分段。

可以空行。

','2019-01-15 21:23:08','2018-12-26 13:22:22','1');
insert into merchant_data values ('M000004','青白江物流代理点','MT000004','P000001','    一段样例文字。
可以分段。

可以空行。

','2018-12-31 23:15:56','2019-01-01 15:08:33','1');

	
insert into transport_project_data values ('TP000001','李先生的大批货物','M000001','P000001','2019-01-11 18:07:31','2019-01-04 22:49:33','1');
insert into transport_project_data values ('TP000002','李先生的大批货物0002','M000001','P000001','2018-12-31 17:14:01','2019-01-09 12:42:36','1');
insert into transport_project_data values ('TP000003','李先生的大批货物0003','M000002','P000001','2019-01-09 18:24:12','2019-01-13 03:46:05','1');
insert into transport_project_data values ('TP000004','李先生的大批货物0004','M000002','P000001','2019-01-12 20:47:20','2019-01-03 20:53:59','1');
insert into transport_project_data values ('TP000005','李先生的大批货物0005','M000003','P000001','2018-12-30 03:10:14','2019-01-04 04:59:00','1');
insert into transport_project_data values ('TP000006','李先生的大批货物0006','M000003','P000001','2019-01-11 18:40:45','2018-12-28 05:06:34','1');
insert into transport_project_data values ('TP000007','李先生的大批货物0007','M000004','P000001','2019-01-09 00:17:17','2019-01-15 22:12:12','1');
insert into transport_project_data values ('TP000008','李先生的大批货物0008','M000004','P000001','2018-12-26 06:24:19','2018-12-27 19:52:26','1');

	
insert into transport_item_data values ('TI000001','橡胶','915','吨','TP000001','MT000001','P000001','2019-01-06 19:02:07','2018-12-29 20:14:06','1');
insert into transport_item_data values ('TI000002','橡胶0002','993','立方','TP000001','MT000001','P000001','2018-12-29 07:48:00','2019-01-13 06:02:13','1');
insert into transport_item_data values ('TI000003','橡胶0003','798','吨','TP000002','MT000001','P000001','2019-01-15 15:54:49','2019-01-01 20:41:40','1');
insert into transport_item_data values ('TI000004','橡胶0004','797','立方','TP000002','MT000001','P000001','2018-12-27 19:00:09','2019-01-02 23:00:17','1');
insert into transport_item_data values ('TI000005','橡胶0005','779','吨','TP000003','MT000002','P000001','2019-01-09 13:40:22','2019-01-09 05:48:13','1');
insert into transport_item_data values ('TI000006','橡胶0006','911','立方','TP000003','MT000002','P000001','2018-12-31 07:50:14','2018-12-28 21:40:06','1');
insert into transport_item_data values ('TI000007','橡胶0007','832','吨','TP000004','MT000002','P000001','2019-01-01 13:35:16','2019-01-08 21:39:10','1');
insert into transport_item_data values ('TI000008','橡胶0008','948','立方','TP000004','MT000002','P000001','2019-01-08 07:34:39','2019-01-02 11:48:35','1');
insert into transport_item_data values ('TI000009','橡胶0009','867','吨','TP000005','MT000003','P000001','2019-01-14 04:46:39','2019-01-11 11:28:14','1');
insert into transport_item_data values ('TI000010','橡胶0010','895','立方','TP000005','MT000003','P000001','2019-01-13 03:54:13','2019-01-11 07:26:38','1');
insert into transport_item_data values ('TI000011','橡胶0011','956','吨','TP000006','MT000003','P000001','2019-01-12 09:18:16','2019-01-03 05:41:54','1');
insert into transport_item_data values ('TI000012','橡胶0012','928','立方','TP000006','MT000003','P000001','2019-01-06 00:43:33','2018-12-29 05:08:33','1');
insert into transport_item_data values ('TI000013','橡胶0013','801','吨','TP000007','MT000004','P000001','2019-01-02 01:34:31','2019-01-09 13:50:05','1');
insert into transport_item_data values ('TI000014','橡胶0014','967','立方','TP000007','MT000004','P000001','2019-01-01 08:45:13','2018-12-27 20:41:06','1');
insert into transport_item_data values ('TI000015','橡胶0015','826','吨','TP000008','MT000004','P000001','2018-12-26 17:01:27','2019-01-15 07:37:44','1');
insert into transport_item_data values ('TI000016','橡胶0016','967','立方','TP000008','MT000004','P000001','2019-01-04 04:19:04','2019-01-01 06:02:05','1');

	
insert into transport_task_data values ('TT000001','橡胶运输任务','L000001','L000001','在二号通道','TTS000001','M000001','M000001','P000001','2019-01-14 15:02:26','2019-01-04 23:17:30','1');
insert into transport_task_data values ('TT000002','橡胶运输任务0002','L000001','L000001','在二号通道0002','TTS000001','M000001','M000001','P000001','2019-01-11 03:51:08','2019-01-06 09:31:44','1');
insert into transport_task_data values ('TT000003','橡胶运输任务0003','L000001','L000001','在二号通道0003','TTS000002','M000002','M000002','P000001','2018-12-31 11:00:51','2018-12-26 00:21:47','1');
insert into transport_task_data values ('TT000004','橡胶运输任务0004','L000001','L000001','在二号通道0004','TTS000002','M000002','M000002','P000001','2018-12-29 19:04:31','2018-12-29 01:16:30','1');
insert into transport_task_data values ('TT000005','橡胶运输任务0005','L000002','L000002','在二号通道0005','TTS000003','M000003','M000003','P000001','2019-01-12 20:05:08','2019-01-11 11:21:40','1');
insert into transport_task_data values ('TT000006','橡胶运输任务0006','L000002','L000002','在二号通道0006','TTS000004','M000003','M000003','P000001','2019-01-16 00:24:22','2019-01-06 14:57:05','1');
insert into transport_task_data values ('TT000007','橡胶运输任务0007','L000002','L000002','在二号通道0007','TTS000004','M000004','M000004','P000001','2019-01-10 03:04:54','2019-01-08 20:22:08','1');
insert into transport_task_data values ('TT000008','橡胶运输任务0008','L000002','L000002','在二号通道0008','TTS000005','M000004','M000004','P000001','2019-01-10 10:02:16','2018-12-28 06:19:30','1');

	
insert into transport_task_track_data values ('TTT000001','陕西宝鸡','40.876575609469704','130.00954188173884','TT000001','2018-12-29 11:28:36','2018-12-26 16:39:21','1');
insert into transport_task_track_data values ('TTT000002','陕西宝鸡0002','40.35657293932738','132.10881293783913','TT000001','2018-12-28 15:12:07','2018-12-30 19:13:37','1');
insert into transport_task_track_data values ('TTT000003','陕西宝鸡0003','41.84555346111789','130.639560289115','TT000002','2019-01-04 21:11:42','2018-12-31 04:45:41','1');
insert into transport_task_track_data values ('TTT000004','陕西宝鸡0004','40.54128688292514','132.00490962716776','TT000002','2019-01-05 22:52:14','2019-01-14 16:16:02','1');
insert into transport_task_track_data values ('TTT000005','陕西宝鸡0005','41.44596582669013','131.17095935848795','TT000003','2019-01-13 20:38:32','2019-01-09 22:46:19','1');
insert into transport_task_track_data values ('TTT000006','陕西宝鸡0006','42.50479881693595','129.32816503124775','TT000003','2019-01-06 03:23:24','2019-01-04 21:13:50','1');
insert into transport_task_track_data values ('TTT000007','陕西宝鸡0007','40.35882841637728','130.46592229233272','TT000004','2019-01-13 00:26:30','2019-01-11 14:15:47','1');
insert into transport_task_track_data values ('TTT000008','陕西宝鸡0008','42.523713812442026','130.13961670857293','TT000004','2019-01-15 04:34:18','2019-01-07 19:27:02','1');
insert into transport_task_track_data values ('TTT000009','陕西宝鸡0009','42.727111958531005','129.90374075519316','TT000005','2018-12-26 10:42:31','2019-01-06 17:20:43','1');
insert into transport_task_track_data values ('TTT000010','陕西宝鸡0010','41.776941215353524','129.54776771044388','TT000005','2018-12-31 02:23:27','2019-01-02 04:51:53','1');
insert into transport_task_track_data values ('TTT000011','陕西宝鸡0011','42.69121082237564','130.4033055530381','TT000006','2019-01-03 01:14:39','2019-01-16 06:01:07','1');
insert into transport_task_track_data values ('TTT000012','陕西宝鸡0012','40.897245775093864','129.59164205664848','TT000006','2019-01-11 18:45:01','2018-12-28 01:17:39','1');
insert into transport_task_track_data values ('TTT000013','陕西宝鸡0013','41.104037390092536','131.15012581499116','TT000007','2018-12-29 20:40:05','2019-01-12 16:07:51','1');
insert into transport_task_track_data values ('TTT000014','陕西宝鸡0014','40.96609660240286','129.51391638907526','TT000007','2019-01-16 09:30:12','2019-01-12 23:21:47','1');
insert into transport_task_track_data values ('TTT000015','陕西宝鸡0015','39.89058656407917','130.83647089140638','TT000008','2019-01-12 20:34:41','2019-01-11 21:51:32','1');
insert into transport_task_track_data values ('TTT000016','陕西宝鸡0016','42.29165852646194','130.107720637012','TT000008','2019-01-13 18:55:23','2019-01-04 09:04:16','1');

	
insert into merchant_account_data values ('MA000001','商户账户','M000001','2018-12-29 08:45:23','2018-12-30 21:29:10','1');
insert into merchant_account_data values ('MA000002','商户账户0002','M000001','2019-01-04 00:37:41','2019-01-14 12:01:45','1');
insert into merchant_account_data values ('MA000003','商户账户0003','M000002','2019-01-11 10:52:55','2019-01-11 13:21:48','1');
insert into merchant_account_data values ('MA000004','商户账户0004','M000002','2019-01-08 21:00:38','2018-12-26 07:26:09','1');
insert into merchant_account_data values ('MA000005','商户账户0005','M000003','2019-01-09 10:20:08','2019-01-04 08:09:20','1');
insert into merchant_account_data values ('MA000006','商户账户0006','M000003','2019-01-03 15:24:51','2018-12-25 23:47:12','1');
insert into merchant_account_data values ('MA000007','商户账户0007','M000004','2019-01-08 19:27:20','2019-01-15 01:19:37','1');
insert into merchant_account_data values ('MA000008','商户账户0008','M000004','2018-12-29 14:37:59','2019-01-06 08:49:23','1');

	
insert into transaction_data values ('T000001','收入','12155.40','TT000001','MA000001','1');
insert into transaction_data values ('T000002','支出','11015.79','TT000001','MA000001','1');
insert into transaction_data values ('T000003','收入','8850.81','TT000001','MA000002','1');
insert into transaction_data values ('T000004','支出','9318.29','TT000001','MA000002','1');
insert into transaction_data values ('T000005','收入','8909.06','TT000001','MA000003','1');
insert into transaction_data values ('T000006','支出','9187.67','TT000001','MA000003','1');
insert into transaction_data values ('T000007','收入','9540.76','TT000001','MA000004','1');
insert into transaction_data values ('T000008','支出','9289.91','TT000001','MA000004','1');
insert into transaction_data values ('T000009','收入','10068.48','TT000002','MA000005','1');
insert into transaction_data values ('T000010','支出','11552.54','TT000002','MA000005','1');
insert into transaction_data values ('T000011','收入','10277.83','TT000002','MA000006','1');
insert into transaction_data values ('T000012','支出','12183.15','TT000002','MA000006','1');
insert into transaction_data values ('T000013','收入','9400.93','TT000002','MA000007','1');
insert into transaction_data values ('T000014','支出','10535.01','TT000002','MA000007','1');
insert into transaction_data values ('T000015','收入','11601.54','TT000002','MA000008','1');
insert into transaction_data values ('T000016','支出','10868.35','TT000002','MA000008','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-01-04 18:06:45','2019-01-08 13:58:47','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-01-06 01:48:44','2019-01-06 23:47:17','UD000001',NULL,'BLOCKED0002','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-01-05 23:29:08','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000006','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

	
insert into login_history_data values ('LH000001','2019-01-10 15:13:58','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-01-04 14:32:06','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2018-12-29 11:52:00','192.168.1.1','登陆成功0003','SU000002','1');
insert into login_history_data values ('LH000004','2018-12-28 03:53:02','192.168.1.2','登陆成功0004','SU000002','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_transaction_type_version on transaction_type_data(id, version);

alter table transaction_type_data add constraint transaction_type4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_merchant_type_version on merchant_type_data(id, version);

alter table merchant_type_data add constraint merchant_type4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transport_task_status_version on transport_task_status_data(id, version);

alter table transport_task_status_data add constraint transport_task_status4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_location_version on location_data(id, version);

alter table location_data add constraint location4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_merchant_version on merchant_data(id, version);

alter table merchant_data add constraint merchant4type_fk
	foreign key(type) references merchant_type_data(id) on delete cascade on update cascade;
alter table merchant_data add constraint merchant4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transport_project_version on transport_project_data(id, version);

alter table transport_project_data add constraint transport_project4merchant_fk
	foreign key(merchant) references merchant_data(id) on delete cascade on update cascade;
alter table transport_project_data add constraint transport_project4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transport_item_version on transport_item_data(id, version);

alter table transport_item_data add constraint transport_item4project_fk
	foreign key(project) references transport_project_data(id) on delete cascade on update cascade;
alter table transport_item_data add constraint transport_item4merchant_fk
	foreign key(merchant) references merchant_type_data(id) on delete cascade on update cascade;
alter table transport_item_data add constraint transport_item4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transport_task_version on transport_task_data(id, version);

alter table transport_task_data add constraint transport_task4source_fk
	foreign key(source) references location_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4destination_fk
	foreign key(destination) references location_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4status_fk
	foreign key(status) references transport_task_status_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4sender_fk
	foreign key(sender) references merchant_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4receiver_fk
	foreign key(receiver) references merchant_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_transport_task_track_version on transport_task_track_data(id, version);

alter table transport_task_track_data add constraint transport_task_track4task_fk
	foreign key(task) references transport_task_data(id) on delete cascade on update cascade;
create unique index idx_merchant_account_version on merchant_account_data(id, version);

alter table merchant_account_data add constraint merchant_account4merchant_fk
	foreign key(merchant) references merchant_data(id) on delete cascade on update cascade;
create unique index idx_transaction_version on transaction_data(id, version);

alter table transaction_data add constraint transaction4transaction_type_fk
	foreign key(transaction_type) references transaction_type_data(id) on delete cascade on update cascade;
alter table transaction_data add constraint transaction4account_fk
	foreign key(account) references merchant_account_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4version_idx on platform_data(version);
create index transaction_type4version_idx on transaction_type_data(version);
create index merchant_type4version_idx on merchant_type_data(version);
create index transport_task_status4version_idx on transport_task_status_data(version);
create index location4contact_phone_idx on location_data(contact_phone);
create index location4create_time_idx on location_data(create_time);
create index location4update_time_idx on location_data(update_time);
create index location4version_idx on location_data(version);
create index merchant4create_time_idx on merchant_data(create_time);
create index merchant4update_time_idx on merchant_data(update_time);
create index merchant4version_idx on merchant_data(version);
create index transport_project4create_time_idx on transport_project_data(create_time);
create index transport_project4update_time_idx on transport_project_data(update_time);
create index transport_project4version_idx on transport_project_data(version);
create index transport_item4quantity_idx on transport_item_data(quantity);
create index transport_item4create_time_idx on transport_item_data(create_time);
create index transport_item4update_time_idx on transport_item_data(update_time);
create index transport_item4version_idx on transport_item_data(version);
create index transport_task4create_time_idx on transport_task_data(create_time);
create index transport_task4update_time_idx on transport_task_data(update_time);
create index transport_task4version_idx on transport_task_data(version);
create index transport_task_track4latitude_idx on transport_task_track_data(latitude);
create index transport_task_track4longitude_idx on transport_task_track_data(longitude);
create index transport_task_track4create_time_idx on transport_task_track_data(create_time);
create index transport_task_track4update_time_idx on transport_task_track_data(update_time);
create index transport_task_track4version_idx on transport_task_track_data(version);
create index merchant_account4create_time_idx on merchant_account_data(create_time);
create index merchant_account4update_time_idx on merchant_account_data(update_time);
create index merchant_account4version_idx on merchant_account_data(version);
create index transaction4amount_idx on transaction_data(amount);
create index transaction4version_idx on transaction_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','u000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','平台','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 8
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 8
insert into sec_user_data values('SU000002','u000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','商人','SU000002','address-book',1,'MXWR','Merchant','M000001','/link/to/app','1'); -- REFER COUNT: 4
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 4
insert into sec_user_data values('SU000003','u000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','用户域','SU000003','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000004','u000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','用户屏蔽','SU000004','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|平台|13900000001|DoubleChain!y1|
|商人|13900000002|DoubleChain!y1|
|用户域|13900000003|DoubleChain!y1|
|用户屏蔽|13900000004|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/lsc.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

