package main.java.com.proquest.interview.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Person")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "firstName")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "phonebook_id", nullable = false)
	private PhoneBook phoneBook;

	public Person(){

	}
	public Person(String name, String lastName){
		this.name = name; this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PhoneBook getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	@Override
	public String toString() {
		return "\n\tPerson{" +
				"\n\tid=" + id +
				"\n\tname='" + name + '\'' +
				"\n\tlastName='" + lastName + '\'' +
				"\n\tphoneNumber='" + phoneNumber + '\'' +
				"\n\taddress='" + address + '\'' +
				"\n\tphoneBook name=" + phoneBook.getName() +
				'}'+"\n\n";
	}
}
