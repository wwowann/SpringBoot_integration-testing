package com.myLesson.demo.config;

import com.myLesson.demo.service.SystemProfile;
import com.myLesson.demo.service.profile.DevProfile;
import com.myLesson.demo.service.profile.ProductionProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean(name = "devProfile")
    @ConditionalOnProperty(prefix = "com.myLesson.demo", name = "dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean(name = "productionProfile")
    @ConditionalOnProperty(prefix = "com.myLesson.demo", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

