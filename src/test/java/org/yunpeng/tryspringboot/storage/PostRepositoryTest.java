package org.yunpeng.tryspringboot.storage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yunpeng.tryspringboot.models.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void test() {
        postRepository.save(new Post("some news", "Here is the news body"));
        postRepository.save(new Post("another news", "Written by someone else"));

        assertEquals(2, postRepository.findAll().size());
    }
}