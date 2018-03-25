webapptest
==========

How to run

this test has been migrated to use Spring framework, the reason is to be able to demonstrate my skills with the spring framework

There is a Jar file included in this project and this is located in :
        target/interview-0.0.1-SNAPSHOT.jar

to run the jar file in command prompt issue the following command while inside the target folder
        java -jar interview-0.0.1-SNAPSHOT.jar

to run using maven, within the project directory issue the following command
        mvn clean install spring-boot:run
if port 8080 is in use then use the following command
        mvn clean install spring-boot:run -Drun.jvmArguments='-Dserver.port=8085'

There is an embeded server (Tomcat) and embeded database (HSQL), no configuration needed


if you aren't too keen on viewing the result in the console you can view the result on the browser
       to view everyone in all phonebook
         http://localhost:8080/phonebook/
       to view a single contact based on person id
        link =  http://localhost:8080/phonebook/1
       to delete a contact
        http://localhost:8080/phonebook/remove/2
       to add a contact
        http://localhost:8080/phonebook/add/Mart/person?name=Ben&lastName=Joe&address=21 millers road&phoneNumber=0792638521

this project was re-written using IntelliJ but can be easily be ported into eclipse by click file and import project
scan the directory for a maven file or run mvn clean build in command prompt within the directory after importing the project
Some of the classes have been marked as Deprecated for backward compatibility but there isnt any need for this in this project


Scope of test
Test for interviews

This test is designed to give an overview of your capabilities as a java developer.  The ultimate goal of the test is spelled out in the main method of src/com/proquest/interview/phonebook/PhoneBookImpl.

Implement the TODO comments to the best of your ability.  In addition, you should be looking at how to improve this program.  The DatabaseUtil class should not need to be significantly refactored, although you may do so as long as you do not destroy it's functionality.

You can download this project, make your changes, zip/tar it up and send it back to us, or if you want to impress us, fork it, put your changes in, and send along the url.

This test should take less than an hour.


Thank you.
