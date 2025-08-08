package com.thehecklers.mcpwx;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpwxApplication {

    @Bean
    public ToolCallbackProvider myTools(WeatherTools weatherTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(weatherTools)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(McpwxApplication.class, args);
    }

}
