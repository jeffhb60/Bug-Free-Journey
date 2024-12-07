package com.jeffhb60.bugfreejourney.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfiguration {

    @Configuration
    public static class AppConfig {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

}
