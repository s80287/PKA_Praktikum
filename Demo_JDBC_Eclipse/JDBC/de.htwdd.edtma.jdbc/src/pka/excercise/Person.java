package pka.excercise;



import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

// Quelle: https://cs.nyu.edu/courses/spring10/V22.0101-003/Person.java
//mit leichten Anpassungen
// TODO Implement Comparable interface



public class Person {
	  private Name name;
	  private Address address;

	  // TODO BEGIN
		
		
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

	  /** Override the toString method */
	  @Override
	  public String toString() {

	    return '\n' + name.getFullName() + '\n' +
	      address.getFullAddress() + '\n';
	  }
	  
	  
	}