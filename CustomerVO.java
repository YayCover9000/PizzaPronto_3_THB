package de.thb.dim.pizzaPronto;
import de.thb.dim.pizzaPronto.OrderVO;
import de.thb.dim.pizzaPronto.PersonVO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * CustomerVO represents objects of customer.
 * @author Robert Fischer, Gabriele Schmidt
 * @version 4.0
 *
 */
public class CustomerVO  extends PersonVO {
	
	private static int nextId = 0;
	private int id;
	
	private String gender;
	private LocalDate dateOfBirth;
	
	private OrderVO order;

	/**
	 * initializing constructor
	 */
	public CustomerVO(String lastName, String firstName, String street, int houseNumber, String gender, LocalDate dob) {
		super(lastName, firstName, street, houseNumber);
		id = nextId;
		nextId++;
		setGender(gender);
		setDateOfBirth(dob);

	}
	
	/**
	 * initializing constructor
	 */
	public CustomerVO(String lastName, String firstName, LocalDate dob) {
		this(lastName, firstName, null, 0, null, dob);

	}
	
	

	/**
	 * default constructor 
	 * calls initializing constructor with default values for instance attributes
	 * 
	 */
	public CustomerVO() {
		this(null, null, null);
		
	}
	
	/**
	 * the age of customer is a drived attribute, i.e. age is only calculated 
	 * in the method and is not a instance variable
	 * 
	 * @return age - short
	 */
	public short calculateAge() {
		short alter = -1;
		Period age;
		LocalDate today = LocalDate.now();

		if (dateOfBirth != null) {
			age = Period.between(dateOfBirth, today);
			alter = (short) age.getYears();
		}
		return alter;
	}
	
	/**
	 * Checks whether there is a current orderVO or not
	 * 
	 * @return true => orderVO available, false => there is no orderVO
	 * 
	 */
	public boolean hasOrder() {
		if (order != null) return true;
		else return false;
	}
	
	//Java default operations
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dateOfBirth);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth);
	}


	
	@Override
	public String toString() {
		return String.format("Customer:\n" + "\tId: %d\n" + 
				"\t%s"
				+ "\tGender: %s\n" + "\tDate of Birth: %s\n" + "\tAge: %d\n"
						+ "\thas a current order: %b",
				this.getId(), super.toString(),
				this.getGender(), this.dobToString(),
				this.calculateAge(),
				hasOrder());
	}
	

	/**
	 * Returns the birth date in human-readable form.
	 * 
	 * @return - the complete string
	 *  
	 */
	private String dobToString() {
		return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
	}
	
	//Setter getter
	//only getter für nextID and id
	public static int getNextId() {
		return nextId;
	}
	
	public int getId() {
		return id;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	

	/**
	 * older than 17 years else dateOfBirth is set null
	 * 
	 * @param dateOfBirth
	 *        -     java.time.LocalDate
	 */
	public void setDateOfBirth(LocalDate dob) {
		this.dateOfBirth = dob;
		if (this.calculateAge() < 18)
			this.dateOfBirth = null;
	}
	
	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO orderVO) {
		this.order = orderVO;
	}
	

	
} // end of class