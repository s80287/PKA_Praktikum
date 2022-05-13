package pka.excercise.solution;

import pka.excercise.*;

public class Club {
	// attributes
	private Name name;
	private Address address;
	private Person chairperson;
	
	// constructor
	// default
	public Club()
	{
		this(new Name("Max", 'a', "Musterclub"),
				new Address("Musterstr.", 10, "01069", "Dresden"),
				new Person(new Name("Max", 'a', "Mustermann"),
						new Address("Musterstr.", 1, "01069", "Dresden")));
	}
	
	// parameter
	public Club(Name name, Address address, Person chairperson)
	{
		this.name = name;
		this.address = address;
		this.chairperson = chairperson;
	}
	
	// methods
	// getter setter
	// chairperson
	public void setClubChairperson(Person person)
	{
		this.chairperson = person;
	}
	
	public Person getClubChairperson()
	{
		return this.chairperson;
	}
}
