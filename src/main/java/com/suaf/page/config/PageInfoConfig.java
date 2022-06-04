package com.suaf.page.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

/**
 * <br>
 *
 * @author Suaf
 * @date 2022/6/4 14:38
 * @verson
 */
@Configuration
public class PageInfoConfig {

    @Autowired(required = false)
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void init() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();

        properties.setProperty("helperDialect","mysql");
        //分页合理化参数，默认为false
        properties.setProperty("reasonable","true");
        //多数据源使用
        properties.setProperty("autoRuntimeDialect","false");
        //默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0 就会查询出全部的结果
        properties.setProperty("pageSizeZero","true");
        //为了支持startPage(Object params)方法，增加了该参数来配置参数映射，用于从对象中根据属性名取值，
        //可以配置 pageNum,pageSize,count,pageSizeZero,reasonable，不配置映射的用默认值，
        //默认值为pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero。
        //我建议将分页插件参数和自己写的一样，这样通过 PageHelper.startPage(cityPageDto);设置分页
        properties.setProperty("params","pageNum=startPage;pageSize=pageSize;count=countSql");
        pageInterceptor.setProperties(properties);
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);
        }
    }

}
