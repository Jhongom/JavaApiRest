package com.todoList2.context;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
/*
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("To do List")
                .pathsToMatch("com/todoList2")
                .build();
    }
*/
    @Bean
    public OpenAPI todolist(){
        return new OpenAPI().info(new Info()
                .title("To do List API")
                .description("This is an API using Spring Boot and Swagger"));
    }


}
