package com.zjrcu.service;

/**
 * （按小时更新）接口访问次数服务层接口
 */
public interface HourStatisticService {

    /**
     * 每小时更新一次数据库
     */
    void updateHourAccessStatistic();
}
