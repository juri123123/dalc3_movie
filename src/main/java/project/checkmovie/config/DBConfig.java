package project.checkmovie.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("dalc2022");
        dataSourceBuilder.url("jdbc:mysql://springboot-db.ckzxwo2jkm2c.ap-northeast-2.rds.amazonaws.com:3306/checkmovie");
        return dataSourceBuilder.build();
    }
}
