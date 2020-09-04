package com.zjrcu.service.impl;

import com.zjrcu.dao.HourStatisticDao;
import com.zjrcu.entity.Statistic;
import com.zjrcu.service.HourStatisticService;
import com.zjrcu.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * （每小时更新一次数据库）接口访问次数统计的服务层
 */
@Service
public class HourStatisticServiceImpl implements HourStatisticService {

    @Resource
    private HourStatisticDao hourStatisticDao;

    /**
     * 更新数据
     */
    @Override
    public void updateHourAccessStatistic() {
        Statistic statistic = new Statistic();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        statistic.setDate(simpleDateFormat.format(date));
        statistic.setSelectCount(Constants.selectCount);
        statistic.setInsertCount(Constants.insertCount);
        statistic.setUpdateCount(Constants.updateCount);
        statistic.setDeleteCount(Constants.deleteCount);
        statistic.setInsertBatchCount(Constants.insertBatchCount);
        statistic.setUpdateBatchCount(Constants.updateBatchCount);
        statistic.setDeleteBatchCount(Constants.deleteBatchCount);
        System.out.println(statistic);
        hourStatisticDao.hourInsert(statistic);
        Constants.selectCount = 0;
        Constants.insertCount = 0;
        Constants.updateCount = 0;
        Constants.deleteCount = 0;
        Constants.insertBatchCount = 0;
        Constants.updateBatchCount = 0;
        Constants.deleteBatchCount = 0;
    }
}
