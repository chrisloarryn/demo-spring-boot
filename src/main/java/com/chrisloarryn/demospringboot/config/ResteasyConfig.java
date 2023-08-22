package com.chrisloarryn.demospringboot.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/")
public class ResteasyConfig extends Application {
}
