package main.java.com.proquest.interview.controller;

import main.java.com.proquest.interview.entities.Person;
import main.java.com.proquest.interview.entities.PhoneBook;
import main.java.com.proquest.interview.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Martin on 25/03/2018.
 */
@RestController
@RequestMapping(value = "/phonebook")
public class PhonebookController {

    @Autowired
    PhoneBookService phoneBookService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllPhoneBook(){
        return new ResponseEntity<>(phoneBookService.findAll(), HttpStatus.OK);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getContactById(@PathVariable(value = "id")Long personId){
        return phoneBookService.findOneById(personId);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity deleteContactToPhoneBook(@PathVariable(value = "id")Long personId){
        phoneBookService.getPersonRepo().delete(personId);
        return new ResponseEntity<>(phoneBookService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add/{owner}/person", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity saveContactToPhoneBook(
            @PathVariable(value = "owner", required = true)String owner,
            @RequestParam(value = "name", required = true)String firstName,
            @RequestParam(value = "lastName", required = true)String lastName,
            @RequestParam(value = "phoneNumber", required = true)String phoneNumber,
            @RequestParam(value = "address", required = true)String address

            ){

        try{
            PhoneBook phoneBook = new PhoneBook(owner);
            Person person = new Person(firstName, lastName);
            person.setAddress(address);
            person.setPhoneNumber(phoneNumber);
            person.setPhoneBook(phoneBook);
            phoneBook.addPerson(person);
            return new ResponseEntity<>(phoneBookService.save(phoneBook), HttpStatus.OK);
        }catch (Exception exp){
            return new ResponseEntity<>("Unable to create phonebook or save contact", HttpStatus.BAD_REQUEST);
        }
    }

}
