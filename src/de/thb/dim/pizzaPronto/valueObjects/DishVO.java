package de.thb.dim.pizzaPronto.valueObjects;

import java.util.Arrays;
import java.util.Objects;

public abstract class DishVO implements Comparable<DishVO> {
    protected int number;
    protected String name;
    protected String[] ingredients;
    protected float price;


    public DishVO() {
        this(0, null, 0.00f);
    }

    public DishVO(int number, String name, float price) {
        this(number, name, null, price); // falls keine Zutaten angegeben sind
    }

    public DishVO(int number, String name, String[] ingredients, float price) {
        setNumber(number);
        setName(name);
        setIngredients(ingredients);
        setPrice(price);
    }
    //Methoden aus Collections

    public int compareTo(DishVO o) {
        return this.getNameOfDish().compareTo(o.getNameOfDish());
    }


    // Standart Methoden

    public int hashCode() {
        return Objects.hash(number,name, Arrays.hashCode(ingredients),price);
    }
    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(obj == null ||getClass() != obj.getClass()) {return false;}
        DishVO other = (DishVO) obj;
        return number == other.number && Objects.equals(name, other.name) && Arrays.equals(ingredients, other.ingredients) && price == other.price;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DishVO [number=").append(getNumberOfDish())
                .append(", name=").append(getNameOfDish())
                .append(", ingredients=").append(ingredientsToString())
                .append(", price=").append(String.format("%.2f", getPrice()))
                .append(" Euro ]");
        return sb.toString();
    }

    /*
    //Abstrakte Methode
    public DishVO clone() {
        return new DisVO() {}
    };
*/
    public String ingredientsToString() {
        if(getIngredients() != null) {
            return String.join(", ", ingredients);
        }
        else {
            return "";
        }
    }


    public abstract String getNameOfDish();

    public abstract int getNumberOfDish();
    // Setter und Getter

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        } else{
            this.price = 0.00f;
        }
    }
}
