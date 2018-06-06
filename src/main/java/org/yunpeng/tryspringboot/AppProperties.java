package org.yunpeng.tryspringboot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Value("${org.yunpeng.try-spring-boot.name}")
    @Getter
    private String name;

    @Value("${org.yunpeng.try-spring-boot.title}")
    @Getter
    private String title;
}
