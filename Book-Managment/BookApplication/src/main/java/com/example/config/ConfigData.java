package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "ron.inetpsa")
public record ConfigData(String developer, String comment) { }
