package org.yunpeng.tryspringboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrySpringBootApplicationTests {
    @Autowired
    private AppProperties appProperties;

    @Test
    public void testProperties() {
        Assert.assertEquals("Try Spring Boot", appProperties.getName());
        Assert.assertEquals("My first attempt to Spring Boot", appProperties.getTitle());
        Assert.assertEquals(8080, appProperties.getPort());
    }
}
