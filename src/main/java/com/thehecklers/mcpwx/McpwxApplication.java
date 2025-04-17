package com.thehecklers.mcpwx;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpwxApplication {
    @Bean
    List<ToolCallback> toolCallbacks(WeatherTools tools) {
        // This will register all the tools in the WeatherTools class
        return List.of(ToolCallbacks.from(tools));
    }

//    @Bean
//    public ToolCallbackProvider myTools(WeatherTools weatherTools) {
//        List<ToolCallback> tools = List.of(ToolCallbacks.from(weatherTools));
//        return ToolCallbackProvider.from(tools);
//    }

    public static void main(String[] args) {
        SpringApplication.run(McpwxApplication.class, args);
    }

}
