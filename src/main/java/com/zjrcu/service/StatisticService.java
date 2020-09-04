package com.zjrcu.service;

import com.zjrcu.entity.Statistic;

import java.util.List;

/**
 * 接口访问次数统计的服务层接口
 */
public interface StatisticService {

    /**
     * 查询接口访问总量
     * @return
     */
    List<Statistic> select();

    /**
     * 更新selectCount
     * @return
     */
    boolean updateSelectCount();

    /**
     * 更新insertCount
     * @return
     */
    boolean updateInsertCount();

    /**
     * 更新updateCount
     * @return
     */
    boolean updateUpdateCount();

    /**
     * 更新deleteCount
     * @return
     */
    boolean updateDeleteCount();

    /**
     * 更新insertBatchCount
     * @return
     */
    boolean updateInsertBatchCount();

    /**
     * 更新updateBatchCount
     * @return
     */
    boolean updateUpdateBatchCount();

    /**
     * 更新deleteBatchCount
     * @return
     */
    boolean updateDeleteBatchCount();
}
