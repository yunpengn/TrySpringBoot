package org.yunpeng.tryspringboot;

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

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrySpringBootApplicationTests {
    private MockMvc mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

    @Autowired
    private AppProperties appProperties;

    @Test
    public void contextLoads() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello world")));
    }

    @Test
    public void testProperties() {
        Assert.assertEquals("Try Spring Boot", appProperties.getName());
        Assert.assertEquals("My first attempt to Spring Boot", appProperties.getTitle());
        Assert.assertEquals(8080, appProperties.getPort());
    }
}
