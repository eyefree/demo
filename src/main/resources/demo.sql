# 用户信息表
create table user
(
    id       int auto_increment
        primary key,
    name     varchar(100) null,
    gender   char         null,
    birthday datetime     null
);

# 接口访问次数统计表(每次点击都更新数据库）
create table access_statistic
(
    date             varchar(100) not null
        primary key,
    selectCount      int          null,
    insertCount      int          null,
    updateCount      int          null,
    deleteCount      int          null,
    insertBatchCount int          null,
    updateBatchCount int          null,
    deleteBatchCount int          null
);

#接口访问次数统计表(每小时更新一次数据库）
create table hour_access_statistic
(
    date             varchar(100) not null,
    selectCount      int          null,
    insertCount      int          null,
    updateCount      int          null,
    deleteCount      int          null,
    insertBatchCount int          null,
    updateBatchCount int          null,
    deleteBatchCount int          null
);