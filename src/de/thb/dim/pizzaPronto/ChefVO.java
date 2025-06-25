package de.thb.dim.pizzaPronto;

import java.awt.*;
import java.util.Objects;

public class ChefVO {
    private String lastName;
    private String firstName;
    private Color colorApron;

    public ChefVO() {
        this(null, null, null) ;
    }
    public ChefVO(String lastName, String firstName, Color colorApron) {
        setLastName(lastName);
        setFirstName(firstName);
        setColorApron(colorApron);
    }
    public String getLastName() {
        return lastName;
    }

    //StandartMethoden
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChefVO chefVO = (ChefVO) o;
        return Objects.equals(lastName, chefVO.lastName) && Objects.equals(firstName, chefVO.firstName) && Objects.equals(colorApron, chefVO.colorApron);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, colorApron);
    }

    //Setter Getter
    public void setLastName(String lastName) {
        if(Objects.nonNull(lastName)) {
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
    public Color getColorApron() {
        return colorApron;
    }
    public void setColorApron(Color colorApron) {
        if (Objects.nonNull(colorApron)) {
            this.colorApron = colorApron;
        }
    }

}