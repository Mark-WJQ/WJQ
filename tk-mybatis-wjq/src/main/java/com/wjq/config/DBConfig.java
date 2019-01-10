package com.wjq.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by wangjianqiang on 2019/1/4.
 */
@Configuration
@MapperScan(basePackages = {"com.wjq.order.dao"},sqlSessionFactoryRef = "sqlSessionFactory",properties = {"notEmpty=false","IDENTITY=MYSQL","mappers=tk.mybatis.mapper.common.Mapper"})
public class DBConfig {


    @Autowired
    private ApplicationContext context;

    @Bean
    public DataSource getDataSource(HikariConfig properties){
        HikariDataSource dataSource = new HikariDataSource(properties);
       // HikariDataSource dataSource =  DataSourceBuilder.create().type(HikariDataSource.class).url(properties.getUrl()).driverClassName(properties.getDriverClassName()).username(properties.getUsername()).password(properties.getPassword()).build();
        return dataSource;
    }



    @Bean
    @ConfigurationProperties
   public HikariConfig hikariConfig(){
        return new HikariConfig();
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        try {
            context.getResources("classpath*:/mapper*//*.xml");

        //TODO 添加插件
        //factory.setPlugins();、
       // factory.setTransactionFactory();
            return factory.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Bean
    public SqlSession sqlSession(DataSource dataSource){
        SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactory(dataSource));
        return sqlSession;
    }



   /* @Bean
    @Primary
    @ConfigurationProperties(prefix = "primary")
    public DataSource primaryDataSource(){
      return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "second")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }*/



   /* @Bean
    public SqlSessionFactory primaryFactory() throws Exception {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(primaryDataSource());
        //配置文件
        //factory.setConfigLocation();
        //设置mapper文件位置
        factory.setMapperLocations(context.getResources("classpath*:/mapper*//*.xml"));
        //TODO 添加插件
        //factory.setPlugins();、
        // factory.setTransactionFactory();
        return factory.getObject();
    }

    @Bean
    public SqlSessionFactory secondFactory() throws Exception {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(secondDataSource());
        factory.setMapperLocations(context.getResources("classpath*:/mapper1*//*.xml"));
        //TODO 添加插件
        //factory.setPlugins();、
        // factory.setTransactionFactory();
        return factory.getObject();
    }*/


    //DataSourceTransactionManager



   /* @Bean
    public JdbcTemplate primaryJdbcTemplate(DataSource primaryDataSource){
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public JdbcTemplate secondJdbcTemplate(DataSource secondDataSource){
        return new JdbcTemplate(secondDataSource);
    }*/






   /* @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.wjq.order.dao");//扫描该路径下的dao
        Properties properties = new Properties();
        //properties.setProperty("mappers", "com.blueskykong.mybatis.config.BaseDao");//通用dao
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }*/
}
