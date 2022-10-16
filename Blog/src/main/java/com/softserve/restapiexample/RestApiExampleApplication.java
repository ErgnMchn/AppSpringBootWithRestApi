package com.softserve.restapiexample;

import com.softserve.restapiexample.mapper.Mapper;
import com.softserve.restapiexample.mapper.MapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class RestApiExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApiExampleApplication.class, args);
  }

  @Bean
  public Mapper mapper(){
    return new MapperImpl();
  }
}