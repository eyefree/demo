package com.zjrcu;

import com.zjrcu.util.Constants;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 不能在这里写定时器，因为它们不是被一个类加载器加载的
 * 要想让多个类共享一个静态变量，这里的解决方法是写在一个main方法里
 * --------------此类已废弃-----------
 */
public class UpdateDatabaseTimer {
    public volatile static int selectCount = 0;
    public static void main(String[] args) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.SEPTEMBER, 3, 9, 27, 30);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "-----" + selectCount);
            }
        }, calendar.getTime(), 10000);
    }
}
