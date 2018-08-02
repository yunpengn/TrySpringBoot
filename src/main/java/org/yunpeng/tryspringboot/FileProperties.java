package org.yunpeng.tryspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "file")
public class FileProperties {
    @Getter
    @Setter
    private String uploadDir;
}
