package com.nail.decoplanner.config;
import com.nail.decoplanner.domain.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.testDatabaseConnection();
        };
    }
}
