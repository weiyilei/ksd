package com.kasuoda.bullyingsystem;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/kasuoda/bullyingsystem/campus_management/dao")
public class BullyingsystemApplication {
  private static final Logger logger = LoggerFactory.getLogger(BullyingsystemApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(BullyingsystemApplication.class, args);
  }

}
