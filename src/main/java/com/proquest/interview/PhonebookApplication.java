package main.java.com.proquest.interview;
import main.java.com.proquest.interview.entities.Person;
import main.java.com.proquest.interview.entities.PhoneBook;
import main.java.com.proquest.interview.services.PhoneBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration()
public class PhonebookApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PhonebookApplication.class, args);

		PhoneBookService phoneBookService = context.getBean(PhoneBookService.class);

		PhoneBook phoneBook = new PhoneBook("Mart");

		Person Chris = new Person("Chris", "Johnson");
		Chris.setAddress("452 Freeman Drive, Algonac, MI");
		Chris.setPhoneNumber("(321) 231-7876");
		Chris.setPhoneBook(phoneBook);

		Person Dave = new Person("Dave", "Williams");
		Dave.setAddress("285 Huron St, Port Austin, MI");
		Dave.setPhoneNumber("(231) 502-1236");
		Dave.setPhoneBook(phoneBook);

		phoneBook.addPerson(Chris);
		phoneBook.addPerson(Dave);
		phoneBook = phoneBookService.save(phoneBook);

		System.out.println("\n End database init\n\n");

		System.out.println("\n Create person objects and put them in the PhoneBook and database \n");

		/**
		 * create the persons objects
		 */
		Person johnSmith = new Person("John", "Smith");
		johnSmith.setPhoneNumber("(248) 123-4567");
		johnSmith.setAddress("1234 Sand Hill Dr, Royal Oak, MI");
		johnSmith.setPhoneBook(phoneBook);

		Person cynthiaSmith = new Person("Cynthia", "Smith");
		cynthiaSmith.setPhoneNumber("(824) 128-8758");
		cynthiaSmith.setAddress("875 Main St, Ann Arbor, MI");
		cynthiaSmith.setPhoneBook(phoneBook);

		/**
		 * add both created people to the phonebook
		 */
		phoneBook.addPerson(johnSmith);
		phoneBook.addPerson(cynthiaSmith);

		/**
		 * print out the phone boot
		 */
		System.out.println("\nPrint the phone book out to System.out\n");

		System.out.println(phoneBook);

		/**
		 * print out only Cynthia matching on firstName and lastName before saving records
		 */
		System.out.println("\nfind Cynthia Smith and print out just her entry\n");

		phoneBook.getPersons().stream().filter(person -> person.getName().equals("Cynthia")
				&& person.getLastName().equals("Smith")).forEach(System.out::println);

		phoneBookService.save(phoneBook);

		/**
		 * after saving the details to find someone based on their first and last name use
		 */

		System.out.println();
		System.out.println("\n find Cynthia Smith after saving all records");
		System.out.println(phoneBookService.getPersonRepo().findPersonByNameAndLastName("Cynthia","Smith"));
	}

}
