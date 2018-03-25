package main.java.com.proquest.interview.services;

import main.java.com.proquest.interview.entities.Person;
import main.java.com.proquest.interview.entities.PhoneBook;
import main.java.com.proquest.interview.repository.PersonRepo;
import main.java.com.proquest.interview.repository.PhoneBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 24/03/2018.
 */
@Service
public class PhoneBookService {

    @Autowired
    PhoneBookRepo phoneBookRepo;

    @Autowired
    PersonRepo personRepo;

    public List<Person> findAll(){
        /**
         * get all phonebook and for each of the phonebook retrieve everyone on theat list
         * for each of the people then get everyone stored on that list
         */
        List<Person> persons = new ArrayList<>();
        for(PhoneBook book : phoneBookRepo.findAll()){
           persons.addAll(book.getPersons());
        }
        return persons;
    }

    /**
     * find a person from person id
     * @param id
     * @return
     */
    public Person findOneById(Long id){
        /**
         * fetched all entries of phonebook
         * lookup every entries in the phonebook to get the person list
         * loop through each person and check if given person id matches with one on record
         */
        for(PhoneBook book : phoneBookRepo.findAll()){
            for(Person person : book.getPersons()){
                if(person.getId().equals(id)){
                    /**
                     * if person is found then return person
                     */
                    return person;
                }
            }
        }
        /**
         * if no person found return a null;
         */
        return null;
    }

    /**
     * find person who matches with given firstname and or lastname
     * @param firstName
     * @param lastName
     * @return
     */
    public Person findPerson(String firstName, String lastName){

        /**
         * fetched all entries of phonebook
         * lookup every entries in the phonebook to get the person list
         * loop through each person and check if given person firstname or lastname matches with one on record
         */
        for(PhoneBook book : phoneBookRepo.findAll()){
            for(Person person : book.getPersons()){
                if(person.getName().equals(firstName) || person.getName().equals(lastName)){
                    return person;
                }
            }
        }
        return null;
    }

    /**
     * save the phonebook to record
     * @param phoneBook
     * @return
     */
    public PhoneBook save(PhoneBook phoneBook){

        /**
         * create a new phonebook object
         */

        PhoneBook book = null;

        for(PhoneBook phoneB : phoneBookRepo.findAll()){
            if(phoneB.getName().trim().equals(phoneBook.getName())){
                book = phoneB;
            }
        }

        if(book == null){
            book = phoneBookRepo.save(phoneBook);
        }

        /**
         * get all contacts on phonebook
         */
        for(Person person : phoneBook.getPersons()) {
            if (person.getId() == null) {
                /**
                 * check if contact is already stored
                 * if contact stored then get contact and set id to current person
                 */
                Person p = personRepo.findPersonById(person.getId());
                if (p == null) {
                    p = personRepo.findPersonByNameAndLastName(person.getName(), person.getLastName());

                }

                if (p != null) {
                    person.setId(p.getId());
                }
            }
            /**
             * set book to person for reference
             */
            person.setPhoneBook(book);
        }

        /**
         * save all the contact on that phonebook
         */
        personRepo.save(phoneBook.getPersons());

        System.out.println("\nPhoneBook Saved\n\nRetrieving PhoneBook...");
        System.out.print("\n\n\t"+phoneBook+"\n");
        return phoneBook;
    }

    public PersonRepo getPersonRepo(){
        return personRepo;
    }

}
