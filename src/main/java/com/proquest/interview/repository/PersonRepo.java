package main.java.com.proquest.interview.repository;

import main.java.com.proquest.interview.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Martin on 25/03/2018.
 */
@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{

    public Person findPersonByNameAndLastName(String name, String lastName);

    public Person findPersonById(Long id);
}
