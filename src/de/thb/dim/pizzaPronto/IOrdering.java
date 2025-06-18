package de.thb.dim.pizzaPronto;

public abstract interface IOrdering {
    public abstract OrderVO startNewOrder(CustomerVO customer);
    public abstract void addDish(DishVO dish);
    public abstract void deleteDish();
    public abstract float calculateTotalPrice();
    public abstract void confirmOrder();
}
