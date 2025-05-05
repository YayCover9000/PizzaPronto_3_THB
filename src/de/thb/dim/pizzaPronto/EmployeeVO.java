package de.thb.dim.pizzaPronto;

import java.util.Objects;

/**
 * EmployeeVO represents an object of employees and inherits from PersonVO 
 * @author Robert Fischer
 * @version 2.0
 */
public  class EmployeeVO extends PersonVO {
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		setPersonnelNo(personnelNo);
	}

	
	public EmployeeVO() {
		this(null, null, null);
	}
	
	//Java standard operations
	
	// Only personnelNo, do not call hashCode of superclass
	@Override
	public int hashCode() {
		return Objects.hash(personnelNo);
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((personnelNo == null) ? 0 : personnelNo.hashCode());
//		return result;
//	}


	// Only personnelNo, do not call equals of superclass
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return Objects.equals(personnelNo, other.personnelNo);
	}
	
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null)
//			return false;
//		if (this == obj)
//			return true;
//		if (getClass() != obj.getClass()) {
//			return false;}
//		EmployeeVO other = (EmployeeVO) obj;
//		if (personnelNo == null) {
//			if (other.personnelNo != null)
//				return false;
//		} else if (!personnelNo.equals(other.personnelNo))
//			return false;
//		return true;
//	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(getPersonnelNo() + " ");

		sb.append(super.toString());

		sb.append("\tSalary: " + getSalary() + "\n");
		sb.append("\tNumber of vacation days: " + getVacationDays());

		return sb.toString();
	}



	//
	// Setter und Getter
	//
	public String getPersonnelNo() {
		return personnelNo;
	}

	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
} 
