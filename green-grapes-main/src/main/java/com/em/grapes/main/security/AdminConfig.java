package com.em.grapes.main.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    @Value("${admin.password}") String adminPassword;
}
