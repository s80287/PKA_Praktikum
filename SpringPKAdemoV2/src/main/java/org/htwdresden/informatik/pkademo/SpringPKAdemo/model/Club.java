package org.htwdresden.informatik.pkademo.SpringPKAdemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	  // creates column with name "address_id" in db table
	  @JoinColumn(name = "address_id", referencedColumnName = "aid", foreignKey = @ForeignKey(name="FK_PADDRESS"))
	 */
    @OneToOne(cascade = CascadeType.ALL)
    // create column with name "address_id" in db table
    @JoinColumn(name = "address_id", referencedColumnName = "aid", foreignKey = @ForeignKey(name="FK_CADDRESS"))
	private Address address;
    
    
    // default constructor
    public Club() {
    	this("Musterclub", new Address("Musterstr.", 1, "01069", "Dresden"));
    }
    
    // constructor with parameter
	public Club(String name, Address address) {
		this.name = name;
		this.address = address;
	}
    
    // setter getter
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
	
	public void print() {
		System.out.println(this.name+"; "+address.getFullAddress());
	}
	
	/*
    @Override
    public String toString() {
        return String.format("Bike[frameNumber=%s]",frameNumber);
    }
	*/
	@Override
	public String toString() {
		return String.format("Club[name=%s]", name);
	}
	
	public static void main(String[] args) {
		Club c = new Club("Musterclub",  new Address("Musterstr", 24, "01069", "Dresden"));
		c.print();
	}
}
