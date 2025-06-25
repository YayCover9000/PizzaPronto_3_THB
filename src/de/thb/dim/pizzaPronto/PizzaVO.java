package de.thb.dim.pizzaPronto;

import java.util.Arrays;
import java.util.Objects;

public class PizzaVO {
    private String name;
    private String [] ingredients;
    private float price;

    public PizzaVO(){
        this(null,null,0.0f);
    }
    public PizzaVO(String name, String [] ingredients, float price){
        setName(name);
        setIngredients(ingredients);
        setPrice(price);
    }

    //clone
    public PizzaVO clone() {
        return new PizzaVO(name, Arrays.copyOf(ingredients, ingredients.length), price);
    }


    @Override
    public String toString() {
        return name + " " + Arrays.toString(ingredients) + " " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PizzaVO pizzaVO = (PizzaVO) obj;
        return Float.compare(pizzaVO.price, price) == 0 && Objects.equals(name, pizzaVO.name) && Arrays.equals(ingredients, pizzaVO.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(ingredients), price);
    }

    //Setter Getter
        public String getName () {
            return name;
        }
        public void setName (String name){
            if(Objects.nonNull(name)){
                this.name = name;
            }
        }
        public String[] getIngredients () {
            return ingredients;
        }
        public void setIngredients (String[]ingredients){
            if(ingredients != null) {
                this.ingredients = ingredients;
            }
        }
        public float getPrice () {
            return price;
        }
        public void setPrice ( float price){
            if(price >= 0.0f) { // price sollte nicht negativ sein
                this.price = price;
//            } else {
//                this.price = 0.0f;
            }
        }

}


