package pka.excercise;

//Quelle: https://cs.nyu.edu/courses/spring10/V22.0101-003/Address.java
// mit leichten Anpassungen

public final class Address {
	  private String street;
	  private int streetNumber;
	  private String zip;
	  private String city;
	 
	  
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