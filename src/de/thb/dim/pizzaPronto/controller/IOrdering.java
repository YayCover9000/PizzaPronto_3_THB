package de.thb.dim.pizzaPronto.controller;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

import java.util.List;

public abstract interface IOrdering {
    public abstract OrderVO startNewOrder(CustomerVO customer);
    public abstract void addDish(DishVO dish);
    public abstract void deleteDish(DishVO dish);
    public abstract float calculateTotalPrice();
    public abstract void confirmOrder();
    public abstract List <DishVO> sortShoppingBasket();
    public abstract List <DishVO> sortShoppingBasketByNumber();
    public abstract List<DishVO> sortShoppingBasketByPrice();
}
