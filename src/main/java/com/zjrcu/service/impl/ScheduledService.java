package com.zjrcu.service.impl;

import com.zjrcu.service.HourStatisticService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时器任务，每小时更新一次数据库（实际为每10分钟）
 */
@Component
public class ScheduledService {

    @Resource
    private HourStatisticService hourStatisticService;

    @Scheduled(fixedRate = 5000)
    public void schedule() {
        System.out.println("定时器正在执行...");
        hourStatisticService.updateHourAccessStatistic();
    }
}
