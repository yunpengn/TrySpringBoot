package org.yunpeng.tryspringboot.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;

        // Checks whether initial list of users is empty.
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // Creates a new user.
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "someone")
                .param("age", "30");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // Checks the new user.
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"someone\",\"age\":30}]")));

        // Updates the new user.
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "someone1")
                .param("age", "20");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // Checks the updated user.
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"someone1\",\"age\":20}]")));

        // Deletes the updated user.
        request = MockMvcRequestBuilders.delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // Checks whether the list of users is empty.
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
