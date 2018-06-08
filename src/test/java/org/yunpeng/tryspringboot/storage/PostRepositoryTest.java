package org.yunpeng.tryspringboot.storage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.yunpeng.tryspringboot.models.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void simpleTest() {
        postRepository.save(new Post("some1", "Here is the news body"));
        postRepository.save(new Post("12345", "Written by someone else"));

        assertEquals(2, postRepository.findAll().size());
        assertEquals("Here is the news body", postRepository.findByTitle("some1").getBody());
        assertEquals("Written by someone else", postRepository.findByTitle("12345").getBody());

        postRepository.deleteAll();
        assertEquals(0, postRepository.findAll().size());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testTransaction() {
        tryTransaction();
        assertEquals(0, postRepository.findAll().size());
        postRepository.deleteAll();
    }

    @Transactional(isolation = Isolation.DEFAULT)
    void tryTransaction() {
        postRepository.save(new Post("12345", "456"));
        postRepository.save(new Post("23456", "456"));
        postRepository.save(new Post("34567", "456"));
        postRepository.save(new Post("123456", "456"));
        postRepository.save(new Post("45678", "456"));
    }
}
