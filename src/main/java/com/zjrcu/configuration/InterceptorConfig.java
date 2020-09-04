package com.zjrcu.configuration;

import com.zjrcu.controller.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;

/**
 * 采用拦截器对接口访问次数进行统计，在这里配置所有的拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private SelectControllerInterceptor selectControllerInterceptor;

    @Resource
    private InsertControllerInterceptor insertControllerInterceptor;

    @Resource
    private UpdateControllerInterceptor updateControllerInterceptor;

    @Resource
    private DeleteControllerInterceptor deleteControllerInterceptor;

    @Resource
    private InsertBatchControllerInterceptor insertBatchControllerInterceptor;

    @Resource
    private UpdateBatchControllerInterceptor updateBatchControllerInterceptor;

    @Resource
    private DeleteBatchControllerInterceptor deleteBatchControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器和路径
        //不要加上服务器的路径...老是踩这个路径的坑
        registry.addInterceptor(selectControllerInterceptor).addPathPatterns("/user/select");
        registry.addInterceptor(insertControllerInterceptor).addPathPatterns("/user/insert");
        registry.addInterceptor(updateControllerInterceptor).addPathPatterns("/user/update");
        registry.addInterceptor(deleteControllerInterceptor).addPathPatterns("/user/delete");
        registry.addInterceptor(insertBatchControllerInterceptor).addPathPatterns("/user/insertBatch");
        registry.addInterceptor(updateBatchControllerInterceptor).addPathPatterns("/user/updateBatch");
        registry.addInterceptor(deleteBatchControllerInterceptor).addPathPatterns("/user/deleteBatch");
    }
}
