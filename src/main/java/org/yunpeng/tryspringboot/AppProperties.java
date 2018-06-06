package org.yunpeng.tryspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Value("${org.yunpeng.try-spring-boot.name}")
    private String name;
    @Value("${org.yunpeng.try-spring-boot.title}")
    private String title;
}
