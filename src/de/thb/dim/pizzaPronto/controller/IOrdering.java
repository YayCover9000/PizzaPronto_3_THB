package de.thb.dim.pizzaPronto.controller;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

import java.util.List;

public abstract interface IOrdering{
    public abstract OrderVO startNewOrder(CustomerVO customer) throws NullPointerException;
    public abstract void addDish(DishVO dish) throws NoOrderException, IllegalArgumentException;
    public abstract void deleteDish(DishVO dish) throws NoOrderException, IllegalArgumentException;
    public abstract float calculateTotalPrice()throws NoOrderException;
    public abstract void confirmOrder() throws NoOrderException, NoCustomerException,IllegalArgumentException;
    public abstract List <DishVO> sortShoppingBasket() throws NoOrderException;
    public abstract List <DishVO> sortShoppingBasketByNumber() throws NoOrderException;
    public abstract List<DishVO> sortShoppingBasketByPrice() throws NoOrderException;
}
