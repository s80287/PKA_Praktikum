package org.htwdresden.informatik.eventSourcingExercise.model;

public class Club {
	private Long id;
	
	private String name;
    
    private Address address;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
	public Club(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public void print() {
		System.out.println(this.name+","+address.getFullAddress());
	}
	
	public static void main(String[] args) {
		Club c = new Club("Musterclub",  new Address("Musterstr", 24, "01069", "Dresden"));
		c.print();
	}
}
