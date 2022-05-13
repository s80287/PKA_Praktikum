package pka.excercise;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import pka.excercise.solution.Gender;

// Quelle: https://cs.nyu.edu/courses/spring10/V22.0101-003/Person.java
//mit leichten Anpassungen
// TODO Implement Comparable interface



public class Person implements Comparable<Person> {
	  private Name name;
	  private Address address;

	  // TODO BEGIN
	  private LocalDate birthday;
	  private Gender gender;
	  private String email;
	  private String tel;
	  
	  
	  // TODO END
	  /** Construct a person with default properties */
	  public Person() {
	    this(new Name("Max",'a',"Mustermann"),
	      new Address("Musterstr", 24, "01069", "Dresden"));
	  }
	
	 
	  /** Construct a person with specified name and address */
	  public Person(Name name, Address address) {
	    this.name = name;
	    this.address = address;
	  }
	  
	  // constructor with name only
	  public Person (Name name) {
		  this.name = name;
	  }
	  
	  // constructor with birthday only
	  public Person (LocalDate birthday) {
		  this.birthday = birthday;
	  }
	  
	  /** Return name */
	  public Name getName() {
	    return name;
	  }

	  /** Set a new name */
	  public void setName(Name name) {
	    this.name = name;
	  }

	  /** Return address */
	  public Address getAddress() {
	    return address;
	  }

	  /** Set a new address */
	  public void setAddress(Address address) {
	    this.address = address;
	  }
 
	  // getter setter birthday
	  public void setBirthday(LocalDate date)
	  {
		  this.birthday = date;
	  }
	  
	  public LocalDate getBirthday()
	  {
		  return this.birthday;
	  }
	  
	  // getter setter gender
	  public void setGender(Gender gender)
	  {
		  this.gender = gender;
	  }
	  
	  public Gender getGender()
	  {
		  return this.gender;
	  }
	  
	  // getter setter email, tel
	  public void setEmail(String email)
	  {
		  this.email = email;
	  }
	  
	  public void setTel(String tel)
	  {
		  this.tel = tel;
	  }
	  
	  public String getEmail()
	  {
		  return this.email;
	  }
	  
	  public String getTel()
	  {
		  return this.tel;
	  }
	  
	  /** Override the toString method */
	  @Override
	  public String toString() {

	    return '\n' + name.getFullName() + '\n' +
	      address.getFullAddress() + '\n';
	  }
	  
	  // Override compareTo method
	  @Override
	  public int compareTo(Person other) {
		  return (this.birthday).compareTo(other.birthday);
	  }
	  
	}