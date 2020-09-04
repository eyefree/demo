package com.zjrcu.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import javax.sql.DataSource;

/**
 * 数据连接池配置
 */
@Configuration
@MapperScan(basePackages = "com.zjrcu.dao")
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * 读取application.yml，使用阿里云数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 读取mybatis配置文件，设置数据源
     * 又忘了，不要忘了添加新的配置文件！！！！！！！！！！
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        Resource[] mapperLocations = new Resource[3];
        mapperLocations[0] = new ClassPathResource("IUserDao.xml");
        mapperLocations[1] = new ClassPathResource("accessStatistic.xml");
        mapperLocations[2] = new ClassPathResource("hourAccessStatistic.xml");
        bean.setMapperLocations(mapperLocations);
        bean.setDataSource(dataSource());
        return bean;
    }

    /**
     * 事务管理自动配置
     * @return
     */
    @Bean
    public DataSourceTransactionManagerAutoConfiguration transactionManagerAutoConfiguration() {
        return new DataSourceTransactionManagerAutoConfiguration();
    }
}
