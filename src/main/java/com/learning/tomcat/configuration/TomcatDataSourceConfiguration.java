package com.learning.tomcat.configuration;

import com.learning.tomcat.properties.DataSourceProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TomcatDataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(dataSourceProperties.getJdbcUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMaxIdle(dataSourceProperties.getMaxIdle());
        dataSource.setUsername(dataSourceProperties.getUserName());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate employeeJdbcTemplate(DataSource dataSource) throws Exception{
        log.info("DataSource URL: {} ", dataSource.getConnection().getMetaData().getURL());
        log.info("DataSource Username: {}", dataSource.getConnection().getMetaData().getUserName());
        log.info("DataSource Max Active Connections {}", dataSource.getMaxActive());
        return new NamedParameterJdbcTemplate(dataSource);
    }
}