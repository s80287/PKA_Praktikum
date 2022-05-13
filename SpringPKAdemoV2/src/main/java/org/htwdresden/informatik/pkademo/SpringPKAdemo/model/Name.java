package org.htwdresden.informatik.pkademo.SpringPKAdemo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

//Quelle: https://cs.nyu.edu/courses/spring10/V22.0101-003/Name.java

// REMOVE EMBEDDABLE IF CONVERTER IS PRESENT
//@Embeddable

// Without Serializable a WARNING would appear if AttributeConverter is used
// see https://hibernate.atlassian.net/browse/HHH-10858
public final class Name implements Comparable, Serializable {
	  private String firstName;
	  private char mi;
	  private String lastName;

	  /** Construct a name with firstName, mi, and lastName */
	  public Name(String firstName, char mi, String lastName) {
	    this.firstName = firstName;
	    this.mi = mi;
	    this.lastName = lastName;
	  }

	  /*
      public Name() {
      }
      */
	  /*
	  // setter
	  void setFirstName(String fname) {
		  this.firstName = fname;
	  }
	  
	  void setLastName(String lname) {
		  this.lastName = lname;
	  }
	  */

	/** Return firstName */
	  public String getFirstName() {
	    return firstName;
	  }

	  /** Return middle name initial */
	  public char getMi() {
	    return mi;
	  }

	  /** Return lastName */
	  public String getLastname() {
	    return lastName;
	  }

	  /** Obtain full name */
	  public String getFullName() {
	    return firstName + ' ' + mi + ' ' + lastName;
	  }

	  /** Implement compareTo in the Comparable interface */
	  public int compareTo(Object o) {
	    if (!lastName.equals(((Name)o).lastName)) {
	      return lastName.compareTo(((Name)o).lastName);
	    }
	    else if (!firstName.equals(((Name)o).firstName)) {
	      return firstName.compareTo(((Name)o).firstName);
	    }
	    else {
	      return mi - ((Name)o).mi;
	    }
	  }
	}
