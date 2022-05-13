package org.htwdresden.informatik.pkademo.SpringPKAdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Quelle: https://cs.nyu.edu/courses/spring10/V22.0101-003/Address.java
// mit leichten Anpassungen

@Entity
/*
All entity classes must define 
    - a primary key
    - must have a non-arg constructor 
    - are not allowed to be final. Keys can be a single field or a combination of fields.
*/

public final class Address {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long aid;
	  @Column
	  private String street;
	  @Column
	  private int streetNumber;
	  @Column
	  private String zip;
	  @Column
	  private String city;
	 
	  
	  private Address() { }
	  
	  /** Create an address with street, streetnumber, zip, city */
	  public Address(String street, int streetNumber, String zip, String city) {
	    this.street = street;
	    this.streetNumber = streetNumber;
	    this.city = city;
	    this.zip = zip;
	  }

	  /** Return street */
	  public String getStreet() {
	    return street;
	  }

	  /** Return city */
	  public String getCity() {
	    return city;
	  }

	  /** Return street number */
	  public int getStreetNumber() {
		return streetNumber;
	  }
	
	  /** Return zip */
	  public String getZip() {
	    return zip;
	  }

	  /** Get full address */
	  public String getFullAddress() {
	    return street + ' ' + streetNumber + ", " + zip + " "+city + '\n';
	  }
	}