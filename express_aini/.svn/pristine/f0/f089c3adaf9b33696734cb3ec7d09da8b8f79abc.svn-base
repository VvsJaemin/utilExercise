package com.aini.express.configs;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.aini.express.common.annotations.Mapper;

@Configuration
@MapperScan(value = "com.aini.express.mapper",
            annotationClass = Mapper.class,
            sqlSessionFactoryRef = "expressSqlSessionFactory")
public class DatabaseConfig {
    
    @Autowired
    private Environment env;
    
    @SuppressWarnings("static-access")
    @Bean(name="expressDataSource")
    @Primary
    public DataSource expressDataSource() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
    
    @Bean(name="expressSqlSessionFactory")
    public SqlSessionFactory expressSqlSessionFactory(@Qualifier("expressDataSource") DataSource expressDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(expressDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/sqlmap/*.xml"));
        sessionFactory.setConfigLocation(resolver.getResource("classpath:/config/mybatis_config.xml"));
        SqlSessionFactory factory = sessionFactory.getObject();
        factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return factory;
    }
    
    @Bean(name="expressSqlSessionTemplate")
    public SqlSessionTemplate expressSqlSessionTemplate(@Qualifier("expressSqlSessionFactory") SqlSessionFactory expressSqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(expressSqlSessionFactory);
        return sqlSessionTemplate;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception{
        return new DataSourceTransactionManager(expressDataSource());
    }
}
