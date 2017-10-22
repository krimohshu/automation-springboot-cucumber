package com.yogi.config;


import com.yogi.pageobjects.DvlaSearch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration for autowired objects
 */
@Configuration
@ComponentScan("com.yogi.config")
//@PropertySource(value = {"classpath:properties.${ENV_SYSTEM:qa}/props-for-api-tests.properties", "classpath:properties.${ENV_SYSTEM:qa}/props-for-ui-tests.properties"})
public class TestConfigPageObjects {
    @Bean
    public DvlaSearch dvlaSearch() {
        return new DvlaSearch();
    }



}
