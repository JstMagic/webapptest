package main.java.com.proquest.interview.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martin on 24/03/2018.
 */
@Entity
@Table(name = "PhoneBook")
public class PhoneBook implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "phoneBook")
    @JsonManagedReference
    private Set<Person> persons = new HashSet<>();

    public PhoneBook(){

    }

    public PhoneBook(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

    public Person findPerson(Long id){
        return persons.stream().filter(person -> person.getId().equals(id)).findAny().get();
    }

    @Override
    public String toString() {
        return "\n\tPhoneBook{" +
                "\n\tid=" + id +
                "\n\t, name='" + name + '\'' +
                ",\n\n\t people=" + "\n\n\t"+persons +
                '}';
    }
}
