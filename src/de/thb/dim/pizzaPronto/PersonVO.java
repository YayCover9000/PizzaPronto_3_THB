package de.thb.dim.pizzaPronto;

import java.util.Objects;

/**
 * PersonVO is the superclass containing basic attributes
 * 
 * @author Gabrile Schmidt
 * @version 3.0
 * @since 30.03.2023
 *
 */

public abstract class PersonVO {
	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;

	//Standart Methoden
	@Override
	public String toString(){
		return String.format("Name: %s %s\n\tStreet: %s %s\n", firstName, lastName, street,houseNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, houseNumber, lastName, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(firstName, other.firstName) && houseNumber == other.houseNumber
				&& Objects.equals(lastName, other.lastName) && Objects.equals(street, other.street);
	}
	
	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		setLastName(lastName);
		setFirstName(firstName);
		setStreet(street);
		setHouseNumber(houseNumber);
	}
	
	public PersonVO(String lastName, String firstName){
		this(lastName, firstName, null, 0);
	}
	
	public PersonVO() {
		this(null, null);
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	


}
