package org.yunpeng.tryspringboot.storage;

import javax.naming.Name;

import org.springframework.data.repository.CrudRepository;
import org.yunpeng.tryspringboot.models.Person;

public interface PersonRepository extends CrudRepository<Person, Name> {
}
