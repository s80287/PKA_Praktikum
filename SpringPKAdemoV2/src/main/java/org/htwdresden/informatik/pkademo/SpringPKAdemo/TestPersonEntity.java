package org.htwdresden.informatik.pkademo.SpringPKAdemo;


import java.time.LocalDate;

import org.htwdresden.informatik.pkademo.SpringPKAdemo.model.*;
import org.htwdresden.informatik.pkademo.SpringPKAdemo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestPersonEntity {

	private static final Logger log = LoggerFactory.getLogger(TestPersonEntity.class);
	private static final String Sort = null;
	
	public static void main(String[] args) {
		SpringApplication.run(TestPersonEntity.class, args);

	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository) {
		return (args) -> {
			
			personRepository.save(new Person(new Name("Max", ' ', "Mustermann"), Gender.MALE, LocalDate.of(2010, 10, 10),
					new Address("Musterstr.", 1, "01069", "Dresden")));
			personRepository.save(new Person(new Name("Helene", ' ', "Kaiser"), Gender.FEMALE, LocalDate.of(2004, 4, 4),
					new Address("Hochschulstr.", 2, "01069", "Dresden")));
			personRepository.save(new Person(new Name("Bin", ' ', "Clinton"), Gender.DIVERSE, LocalDate.of(2006, 6, 6),
					new Address("Marktstr.", 3, "01598", "Dresden")));
			
			
			
			log.info("Person found with findAll()");
			log.info("---------------------------");
			for (Person person : personRepository.findAll()) {
				log.info(person.toString());
			}
			log.info("");
			
			/*
			// sort
			log.info("Person after sort by birthdate");
			log.info("------------------------------");
			// Max Bin Helene
			for (Person person : personRepository.findByOrderByBirthDateDesc()) {
				log.info(person.toString());
			}
			log.info("");
			*/
			
			/*
			// findByBirthDate()
			// Helene
			log.info("Person found with findByBirthDate()");
			log.info("-----------------------------------");
			for (Person person : personRepository.findByBirthDate(LocalDate.of(2004, 4, 4))) {
				log.info(person.toString());
			}
			log.info("");
			*/
			
			/*
			// findByBirthDateGreaterThan()
			// Max Bin
			log.info("Person found with findByBirthDateGreaterThan()");
			log.info("----------------------------------------------");
			for (Person person : personRepository.findByBirthDateGreaterThan(LocalDate.of(2005, 5, 5)) ) {
				log.info(person.toString());
			}
			log.info("");
			*/
			
			/*
			// findByAddress_Zip()
			// Bin
			log.info("Person found with findByAddress_Zip()");
			log.info("-----------------------------");
			for (Person person : personRepository.findByAddress_Zip("01598")) {
				log.info(person.toString());
			}
			log.info("");
			*/
			
			/*
			// findByZip()
			// Bin
			log.info("Person found with findByZip()");
			log.info("-----------------------------");
			for (Person person : personRepository.findByZip("01598")) {
				log.info(person.toString());
			}
			log.info("");
			*/
			
			// findByBirthYear()
			// Max
			log.info("Person found with findByBirthYear()");
			log.info("-----------------------------------");
			for (Person person : personRepository.findByBirthYear(2010)) {
				log.info(person.toString());
			}
			log.info("");
			
		};
		
	}
	
}
