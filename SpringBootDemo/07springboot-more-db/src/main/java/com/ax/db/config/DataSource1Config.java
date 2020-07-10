package com.ax.db.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.ax.db.mapper.db1"},
        sqlSessionFactoryRef = "oneSqlSessionFactoryBean")
public class DataSource1Config {

    //指定名称
    @Bean(name = "oneDataSource")
    @Qualifier("oneDataSource")
    //指定配置的前缀
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSourceOne() {
        //这里使用DruidDataSourceBuilder
        return DruidDataSourceBuilder.create().build();
    }

    //分别配置事物管理
    @Bean(name = "oneTransaction")
    public DataSourceTransactionManager db1TransactionManager(
            @Qualifier("oneDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Resource(name = "oneDataSource")
    private DataSource dataSource;

//	private static final String MAPPER_XML = "classpath:mapper/db1/*.xml";

    @Value("${mybatis.db1.mapper-locations}")
    private String MAPPER_XML;


    @Bean(name = "oneSqlSessionFactoryBean")
    @ConfigurationProperties(prefix = "mybatis.db1")
    public SqlSessionFactory oneSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(MAPPER_XML));
        return sessionFactory.getObject();
    }

}
