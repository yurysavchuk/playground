package com.foo.mavenproject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MavenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenProjectApplication.class, args);
	}

}

@Configuration
class MyConfig {
	@Bean
	PersonFetcher personFetcher() {
		return new PersonFetcher();
	}

	@Bean
	PersonPrinter personPrinter() {
		return new PersonPrinter(personFetcher());
	}
}

class PersonPrinter {
	private final PersonFetcher personFetcher;

	public PersonPrinter(PersonFetcher personFetcher) {
		this.personFetcher = personFetcher;
	}

	String print() {
		return this.personFetcher.fetchPeople()
				.stream()
				.map(person -> person.name)
				.collect(Collectors.joining("\n"));
	}
}

class PersonFetcher {
	List<Person> fetchPeople() {
		return Arrays.asList(
				new Person("marcin", "g"),
				new Person("john", "d")
		);
	}
}

class Person {
	String name, surname;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
}
