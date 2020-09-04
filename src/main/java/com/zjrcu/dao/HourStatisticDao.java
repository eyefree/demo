package com.zjrcu.dao;

import com.zjrcu.entity.Statistic;

/**
 * 每小时更新一次数据库
 * 接口访问次数统计的持久层接口
 */
public interface HourStatisticDao {

    /**
     * 每小时在数据库中插入一条数据
     * @param statistic
     */
    void hourInsert(Statistic statistic);
}
