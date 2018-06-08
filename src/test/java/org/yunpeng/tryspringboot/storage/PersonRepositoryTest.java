package org.yunpeng.tryspringboot.storage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yunpeng.tryspringboot.models.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        Person person = new Person();
        person.setUid("1");
        person.setSurname("Chris");
        person.setCommonName("Li Lei");
        person.setUserPassword("123456");
        personRepository.save(person);

        assertEquals(2, personRepository.findAll().spliterator().getExactSizeIfKnown());
    }
}
