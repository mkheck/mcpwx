package com.thehecklers.mcpwx;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

@Service
public class WeatherTools {
    @Value("${weather.key:No valid key}")
    private String key;

    @Value("${weather.url:No valid URL}")
    private String url;

    @Value("${weather.host:No valid host}")
    private String host;

    @Tool(name = "getWeatherForCity", description = "Get current weather for location")
    public String getWeather(String location) throws IOException, InterruptedException {
//        return "Warm and sunny in " + location + "!"; // Placeholder response
//    }

        var request = HttpRequest.newBuilder()
                .uri(URI.create("%s?city=%s&lang=EN".formatted(url, location.replaceAll(" ", "%20"))))
                .header("X-RapidAPI-Key", key)
                .header("X-RapidAPI-Host", host)
                .build();

        return newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();
    }
}
