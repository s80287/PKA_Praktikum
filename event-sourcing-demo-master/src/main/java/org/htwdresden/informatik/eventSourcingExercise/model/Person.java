package org.htwdresden.informatik.eventSourcingExercise.model;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
	  protected static final Logger log = LoggerFactory.getLogger(Person.class); 
	
	  private Name name;
	  private Address address;

	  
	  private Gender gender;
	  
	  
	  private LocalDate birthDate;
	  
	  public Gender getGender() {
			return gender;
	  }

	  public LocalDate getBirthDate() {
			return birthDate;
	  }
	  
	  public Name getName() { 
		  return name;
	  }
	  
	  public Address getAddress() {
		  return this.address;
	  }
	  
	 
	  
	  public void setGender(Gender gender) {
			this.gender = gender;
	  }
	  
	  public Person() {}

	  public Person(Person person) {
		  this.name = person.getName();
		  this.address = person.getAddress();
		  this.birthDate = person.getBirthDate();
		  this.gender = person.getGender();
	  }
	  
	  private Person(Name name, Address address) {
		  this.name = name;
		  this.address = address;
	  }
	  
	  public Person(Name name, Address address, Gender gender, LocalDate birthDate) {
		    this(name,address);
		    setGender(gender);
		    this.birthDate = birthDate;
	  }
	  
	
	 @Override
	 public boolean equals(Object obj) {
		 if(!(obj instanceof Person)) return false;
		 
		 Person p = (Person) obj;
		 
		 // Gleich wenn Name, Geburtsdatum und Adresse übereinstimmen
		 if(p.getName().equals(this.getName()))
			 if(p.getBirthDate().equals(this.getBirthDate()))
				if(p.getAddress().equals(this.getAddress()))
					return true;
		 
		 return false;
	}
	  
}