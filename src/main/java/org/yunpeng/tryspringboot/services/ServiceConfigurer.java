package org.yunpeng.tryspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yunpeng.tryspringboot.FileProperties;

@Configuration("ServiceConfigurer")
@EnableConfigurationProperties(FileProperties.class)
public class ServiceConfigurer {
    @Autowired
    private FileProperties fileProperties;

    @Bean
    public FileStorageService fileStorageService() {
        return new FileStorageService(fileProperties.getUploadDir());
    }
}
