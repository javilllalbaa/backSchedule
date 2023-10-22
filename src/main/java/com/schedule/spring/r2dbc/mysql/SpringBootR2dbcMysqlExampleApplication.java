package com.schedule.spring.r2dbc.mysql;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@EnableWebFlux
@SpringBootApplication
public class SpringBootR2dbcMysqlExampleApplication {

  @Bean
  ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

    return initializer;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootR2dbcMysqlExampleApplication.class, args);
  }

}
