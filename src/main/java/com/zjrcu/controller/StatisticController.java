package com.zjrcu.controller;

import com.zjrcu.entity.Statistic;
import com.zjrcu.service.StatisticService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * web层，接口访问次数实时展示
 */
@RestController
@RequestMapping("/access")
public class StatisticController {

    @Resource
    private StatisticService statisticService;

    @RequestMapping
    public List<Statistic> total() {
        return statisticService.select();
    }
}
