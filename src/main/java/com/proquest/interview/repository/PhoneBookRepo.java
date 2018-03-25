package main.java.com.proquest.interview.repository;

import main.java.com.proquest.interview.entities.PhoneBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * this class gives the ability to execute crud operation on the phoneBook entity
 */
public interface PhoneBookRepo extends CrudRepository<PhoneBook, Long>{

}
