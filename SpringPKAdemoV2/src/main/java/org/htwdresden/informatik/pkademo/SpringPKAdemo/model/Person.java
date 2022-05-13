package org.htwdresden.informatik.pkademo.SpringPKAdemo.model;



import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


/*
     All entity classes must define 
         - a primary key
         - must have a non-arg constructor 
         - are not allowed to be final. Keys can be a single field or a combination of fields.
 */

@Entity
public class Person {
	
	@Convert(converter = NameAttributeConverter.class)
	@Column
	  private Name name;
	  
	  @Enumerated(EnumType.STRING)
	  private Gender gender;
	  
	  @Convert(converter = LocalDateAttributeConverter.class)
	  @Column
	  private LocalDate birthDate;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  // creates column with name "address_id" in db table
	  @JoinColumn(name = "address_id", referencedColumnName = "aid", foreignKey = @ForeignKey(name="FK_PADDRESS"))
	  private Address address;

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	     
	  
	  
	  /** Construct a person with default properties */
	  public Person() {
	    this(new Name("Max",'a', "Mustermann"), Gender.MALE,LocalDate.of(2020, 4, 2), new Address("Musterstr.", 12, "01069", "Dresden"));
	  }
	
	  public Person(Name name, Gender gender, LocalDate birthDate, Address address) {
		    this.name = name;
		    this.gender = gender;
		    this.birthDate = birthDate;
		    this.address = address;
	  }
	  
	  // constructor with name only
	  /*
	  public Person(Name name) {
		  this.name = name;
	  }
	  */
	  
	  /** Construct a person with specified name and address */
	  /*
	  public Person(Name name, Address address) {
	    this.name = name;
	    this.address = address;
	  }
	  */

	  /** Return name */
	  public Name getName() {
	    return name;
	  }

	  /** Set a new name */
	  public void setName(Name name) {
	    this.name = name;
	  }

	  /** Return address */
	  /*
	  public Address getAddress() {
	    return address;
	  }
	  */

	  /** Set a new address */
	  /*
	  public void setAddress(Address address) {
	    this.address = address;
	  }
	  */

	  /** Override the toString method */
	  @Override
	  public String toString() {

	    return '\n' + name.getFullName() + '\n' + "";
	      // address.getFullAddress() + '\n';
	  }
	  
	public static void main(String[] args) {
		Person p = new Person(new Name("Max", ' ', "Mustermann"), Gender.MALE, LocalDate.of(2001, 1, 1),
				new Address("Hochschulstr.", 1, "01069", "Dresden"));
		System.out.println(p.toString());
	}
	  
}