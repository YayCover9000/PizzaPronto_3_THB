package de.thb.dim.pizzaPronto.valueObjects;

public class DessertVO extends DishVO {

    public DessertVO(){
        this(0,null,0.0f);
    }
    public DessertVO(int number, String name, float price) {
        super(number, name, price);
    }

    @Override
    public String getNameOfDish() {
        return getName();
    }
    @Override
    public int getNumberOfDish() {
        return getNumber();
    }



}
