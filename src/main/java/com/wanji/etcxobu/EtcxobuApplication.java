package com.wanji.etcxobu;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.wanji.etcxobu.mapper")
public class EtcxobuApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtcxobuApplication.class, args);
    }

}
