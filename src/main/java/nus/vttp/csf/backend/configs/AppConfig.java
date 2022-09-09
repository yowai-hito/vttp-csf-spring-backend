package nus.vttp.csf.backend.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
    

    private Logger log = LoggerFactory.getLogger(AppConfig.class.getName());

    @Value("${cors.pathMapping}")
    String pathMappings;

    @Value("${cors.origins}")
    String origins;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new CORSConfiguration(pathMappings, origins);
    }
}
