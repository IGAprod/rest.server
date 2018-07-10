package com.mycompany.rest.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.mycompany.rest.server.repository")
public class DataBaseConfig {
}
