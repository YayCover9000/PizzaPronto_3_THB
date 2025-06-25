package de.thb.dim.pizzaPronto.valueObjects;

import java.util.Arrays;
import java.util.Objects;


public class PizzaVO extends DishVO {
	private int size;

	public PizzaVO() {
		this(0,null, null, 0.0f);
	}

	public PizzaVO(int number, String name, String[] ingredients, float price) {
		this(0,null,null,0.0f,0);
	}

	public PizzaVO(int number, String name, String[] ingredients, float price, int size) {
		setNumber(number);
		setName(name);
		setIngredients(ingredients);
		setPrice(price);
		setSize(size);
	}
	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pizza: ");

		if (size == 1) {
			sb.append(getName()).append(" - Normal");
		}else sb.append(getName()).append(" - Grande");

		return sb.toString();
	}
	@Override
	public int getNumberOfDish() {
		return number * 10 + size;
	}


	// Standart Methoden

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
		return Objects.equals(number,other.number) && Arrays.equals(ingredients, other.ingredients) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && Objects.equals(size, other.size);
	}

	// Setter und Getter


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
