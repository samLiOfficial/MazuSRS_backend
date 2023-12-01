// src/main/java/com/example/demo/CorsConfig.java

// Import necessary libraries and classes
package com.samli.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// This class is marked as a configuration class
@Configuration
public class CorsConfig {

    // This method creates and configures a CorsFilter bean
    @Bean
    public CorsFilter corsFilter() {
        // Create a UrlBasedCorsConfigurationSource to define CORS configurations
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Create a CorsConfiguration object and set it to allow credentials
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        // Add an allowed origin (in this case, the React server address)
        config.addAllowedOrigin("http://localhost:3000");

        // Allow all headers and methods
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // Register the CORS configuration for all URL paths
        source.registerCorsConfiguration("/**", config);

        // Create and return a CorsFilter using the configured source
        return new CorsFilter(source);
    }
}
