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
@MapperScan(basePackages = {"com.ax.db.mapper.db2"},
        sqlSessionFactoryRef = "twoSqlSessionFactoryBean")

public class DataSource2Config {

    @Bean(name = "twoDataSource")
    @Qualifier("twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "twoTransaction")
    public DataSourceTransactionManager db2TransactionManager(
            @Qualifier("twoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Resource(name = "twoDataSource")
    private DataSource dataSourceTwo;

//    private static final String XFFQ_XML = "classpath:mapper/db2/*.xml";

	@Value("${mybatis.db2.mapper-locations}")
	private String XFFQ_XML;


    @Bean(name = "twoSqlSessionFactoryBean")
    @ConfigurationProperties(prefix = "mybatis.db2")
    public SqlSessionFactory twoSqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSourceTwo);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(XFFQ_XML));
        return sessionFactoryBean.getObject();


    }

}
