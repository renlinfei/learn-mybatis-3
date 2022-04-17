drop table if exists `t_user`;
create table `t_user` (
    `userId` bigint(20) not null,
    `userName` varchar(255) default null,
    `sex` int(11) default null,
    `role` varchar(255) default null,
    primary key(`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;