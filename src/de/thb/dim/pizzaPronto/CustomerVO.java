package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CustomerVO {
    private String lastName;
    private String firstName;
    private String gender;
    private LocalDate dateOfBirth;

    public CustomerVO() {
        this(null,null,null);
    }
    public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
        this(null,null,null,null);
        setLastName(lastName);
        setFirstName(firstName);
        setDateOfBirth(dateOfBirth);
    }
    public CustomerVO(String lastName, String firstName,String gender,LocalDate dateOfBirth) {
        setLastName(lastName);
        setFirstName(firstName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerVO that = (CustomerVO) o;
        return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(gender, that.gender) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, gender, dateOfBirth);
    }

    public String toString() {
        return lastName + "," + firstName + "," + gender + "," + dobToString();
    }

    public String dobToString() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
//Setter Getter
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(Objects.nonNull(lastName)) {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(Objects.nonNull(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender != null && !gender.isEmpty()) {
            this.gender = gender;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        }
    }

}
