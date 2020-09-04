package com.zjrcu.dao;

import com.zjrcu.entity.Statistic;

import java.util.List;

/**
 * 接口访问次数统计的持久层接口
 */
public interface StatisticDao {

    /**
     * 查询总访问次数
     * @return
     */
    List<Statistic> select();

    /**
     * 如果数据库中没有当前时间则先进行插入再进行下边的更新
     * @param date
     * @return
     */
    boolean insert(String date);

    /**
     * 更新selectCount
     * @return
     * @param date
     */
    boolean updateSelectCount(String date);

    /**
     * 更新insertCount
     * @return
     * @param date
     */
    boolean updateInsertCount(String date);

    /**
     * 更新updateCount
     * @return
     * @param date
     */
    boolean updateUpdateCount(String date);

    /**
     * 更新deleteCount
     * @return
     * @param date
     */
    boolean updateDeleteCount(String date);

    /**
     * 更新insertBatchCount
     * @return
     * @param date
     */
    boolean updateInsertBatchCount(String date);

    /**
     * 更新updateBatchCount
     * @param date
     * @return
     */
    boolean updateUpdateBatchCount(String date);

    /**
     * 更新deleteBatchCount
     * @param date
     * @return
     */
    boolean updateDeleteBatchCount(String date);
}
