package com.zjrcu.service.impl;

import com.zjrcu.dao.StatisticDao;
import com.zjrcu.entity.Statistic;
import com.zjrcu.service.StatisticService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 接口访问次数统计的服务层，处理业务逻辑
 * 在进行更新数据时，每次点击都写入数据库，但按小时对接口访问数据归档
 */
@Service
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticDao statisticDao;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");

    /**
     * 查询总的接口访问量
     * @return
     */
    @Override
    public List<Statistic> select() {
        return statisticDao.select();
    }

    /**
     * 更新selectCount
     * @return
     */
    @Override
    public boolean updateSelectCount() {
        Date date = new Date();
        insertCurrentTime();
        return statisticDao.updateSelectCount(dateFormat.format(date));
    }

    /**
     * 更新insertCount
     * @return
     */
    @Override
    public boolean updateInsertCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateInsertCount(dateFormat.format(date));
    }

    /**
     * 更新updateCount
     * @return
     */
    @Override
    public boolean updateUpdateCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateUpdateCount(dateFormat.format(date));
    }

    /**
     * 更新deleteCount
     * @return
     */
    @Override
    public boolean updateDeleteCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateDeleteCount(dateFormat.format(date));
    }

    /**
     * 更新insertBatchCount
     * @return
     */
    @Override
    public boolean updateInsertBatchCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateInsertBatchCount(dateFormat.format(date));
    }

    @Override
    public boolean updateUpdateBatchCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateUpdateBatchCount(dateFormat.format(date));
    }

    @Override
    public boolean updateDeleteBatchCount() {
        insertCurrentTime();
        Date date = new Date();
        return statisticDao.updateDeleteBatchCount(dateFormat.format(date));
    }

    /**
     * 数据库有当前时间则插入，没有则不插入
     */
    private void insertCurrentTime() {
        List<Statistic> statistics = statisticDao.select();
        boolean flag = true;
        Date date = new Date();
        if (statistics.isEmpty()) {
            //当数据库刚开始没有数据时
            statisticDao.insert(dateFormat.format(date));
        } else {
            for (Statistic statistic :
                    statistics) {
                //这里判断了所有的时间，其实只需要判断当前时间和数据库最后一行的时间是否相等即可
                //因为时间只可能往前走，不是嘛o(*￣▽￣*)o
                if (statistic.getDate().equals(dateFormat.format(date))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                //如果数据库没有该时间
                statisticDao.insert(dateFormat.format(date));
            }
        }
    }

}
