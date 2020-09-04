package com.zjrcu;

import com.zjrcu.service.HourStatisticService;
import com.zjrcu.service.impl.HourStatisticServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序运行入口
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2020, Calendar.SEPTEMBER, 3, 14, 20, 0);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                hourStatisticService.updateHourAccessStatistic();
//            }
//        }, calendar.getTime(), 10000);
    }
}
