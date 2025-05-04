package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static java.time.Period.between;

public class CustomerVO {
    private static int nextId = 0;
    private String lastName;
    private String firstName;
    private String gender;
    private LocalDate dateOfBirth;
    private int id;

    public CustomerVO() {
        this(null, null, null);
    }

    public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
        this(lastName,firstName,null,dateOfBirth);
    }

    public CustomerVO(String lastName, String firstName, String gender, LocalDate dateOfBirth) {
        setLastName(lastName);
        setFirstName(firstName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        this.id = nextId;
        nextId++;
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
@Override
    public String toString() {
        return lastName + "," + firstName + "," + gender + "," + dobToString() + "," + calculateAge() + "," + id;
    }
    //Hilfsmethode
    private String dobToString() {
        if (dateOfBirth == null) {
            return "";
        }
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
    //calculate Age
    public short calculateAge() {
        if (dateOfBirth == null) {
            return -1;
        } else {
            LocalDate today = LocalDate.now();
            int years = today.getYear() - dateOfBirth.getYear();

            // Wenn der Geburtstag in diesem Jahr noch nicht war, 1 Jahr abziehen
            if (today.getDayOfYear() < dateOfBirth.getDayOfYear()) {
                years--;
            }

            return (short) years;
        }
    }

//Setter Getter


    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (Objects.nonNull(lastName)) {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (Objects.nonNull(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && !gender.isEmpty()) {
            this.gender = gender;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
            short age = calculateAge();
            if (age < 18) {
                this.dateOfBirth = null;
            }
    }

}
