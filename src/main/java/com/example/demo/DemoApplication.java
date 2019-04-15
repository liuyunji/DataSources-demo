package com.example.demo;

import com.example.demo.aop.DynamicDataSourceAnnotationAdvisor;
import com.example.demo.aop.DynamicDataSourceAnnotationInterceptor;
import com.example.demo.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@MapperScan("com.example.demo.repository")
@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor(){
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
