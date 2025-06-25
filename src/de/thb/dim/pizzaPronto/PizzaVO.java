package de.thb.dim.pizzaPronto;

import java.util.Arrays;
import java.util.Objects;

/**
 * The methods of the class PizzaVO are tested.
 * 
 * Special assert statements are used for testing <br>
 * 
 * @author Gabriele Schmidt
 * @version 4.0 10.03.2020
 */
public class PizzaVO {
	private String name;
	private float price;
	private String[] ingredients;

	/**
	 * initializing constructor
	 * Initialize all instance attributes with values. 
	 * 
	 * @param name        - Name of the pizza
	 * @param ingredients - ingredients of the pizza
	 * @param price       - price of the pizza
	 * 
	 */
	public PizzaVO(String name, String[] ingredients, float price) {
		setName(name);
		setIngredients(ingredients);
		setPrice(price);
	}

	/**
	 * default constructor calls initializing constructor with default values for
	 * instance attributes
	 * 
	 */
	public PizzaVO() {
		this(null, null, 0.0f);
	}

	// Standard methods of Java

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + Objects.hash(name, price);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVO other = (PizzaVO) obj;
		return Arrays.equals(ingredients, other.ingredients) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}
	
	@Override
	public PizzaVO clone() {
		PizzaVO retVal = new PizzaVO(this.name, this.ingredients, this.price);
		return retVal;
	}


	@Override
	public String toString() {
		return "PizzaVO [name=" + name + ", price=" + price + ", ingredients=" + Arrays.toString(ingredients) + "]";
	}

	//
	// Setter und Getter
	//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = (price > 0) ? price : 0;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

} // End of class
