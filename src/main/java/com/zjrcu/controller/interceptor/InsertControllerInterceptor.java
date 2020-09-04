package com.zjrcu.controller.interceptor;

import com.zjrcu.service.StatisticService;
import com.zjrcu.util.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过拦截器实现访问次数统计
 * insert接口访问次数统计
 */
@Component
public class InsertControllerInterceptor implements HandlerInterceptor {

    @Resource
    private StatisticService statisticService;

    /**
     * 在调用接口前进行次数自增
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //更新服务器（常量类）上的值
        Constants.insertCount++;
        //更新数据库
        return statisticService.updateInsertCount();
    }

    /**
     * 完成后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("数据库insert接口访问次数已更新");
    }

}
