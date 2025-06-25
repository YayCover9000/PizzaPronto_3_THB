package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.controller.IOrdering;
import de.thb.dim.pizzaPronto.valueObjects.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Ordering implements IOrdering {
    private static MenuVO menu;
    private static int nextId = 0;

    //Vom Typ CustomerVO
    private CustomerVO currentCustomer;

    //Vom Typ IService
    private IService kitchen;
    private IService delivery;

    //Vom Typ OrderVO
    private OrderVO currentOrder;

    public Ordering() {
        this.menu = new MenuVO();
        currentOrder = null;
        currentCustomer = null;
        this.kitchen = new Kitchen();
        this.delivery = new Delivery();
    }

    @Override
    public OrderVO startNewOrder(CustomerVO customer) throws NullPointerException{
        if (menu == null)
            menu = new MenuVO();

        Objects.requireNonNull(customer, "Customer must not be null.");

        if (nextId == 0 || nextId / 100000 < LocalDate.now().getYear()) {
            nextId = (LocalDate.now().getYear() * 100000) + 1;
        } else
            nextId++;
        currentOrder = new OrderVO(nextId, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
        currentCustomer = customer;
        currentCustomer.setOrder(currentOrder);

        return currentOrder;
    }

    @Override
    public void addDish(DishVO dish) throws NoOrderException, IllegalStateException {
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        if (currentOrder.getState() == StateOfOrderVO.STARTED)
            currentOrder.addDish(dish);
        if (currentOrder.getState() != StateOfOrderVO.STARTED) {
            throw new IllegalStateException("Your order is complete, you can not add any dishes.");
        }
    }

    @Override
    public void deleteDish(DishVO dish) throws NoOrderException, IllegalStateException {
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        if (currentOrder.getState() == StateOfOrderVO.STARTED)
            currentOrder.deleteDish(dish);

        if (currentOrder.getState() != StateOfOrderVO.STARTED) {
            throw new IllegalStateException("Your order is complete, you can not delete any dishes.");
        }
    }

    @Override
    public float calculateTotalPrice() throws NoOrderException{
        if(currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }else{
            return currentOrder.calculatePriceDishes();
        }
    }

    @Override
    public void confirmOrder() throws NoOrderException, NoCustomerException,IllegalStateException {
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }else if (currentOrder != null && StateOfOrderVO.STARTED.equals(currentOrder.getState())) {
            currentOrder.setState(StateOfOrderVO.CONFIRMED);
            try {
                startService();
            }catch(NoOrderException | NoCustomerException | IllegalStateException e) {
               System.err.println("Internal error by processing an order: " + e.getMessage());
            }
        }else {
            throw new NoOrderException("Your order can not be confirmed.");
        }
    }

    public void startService() throws NoOrderException, NoCustomerException , IllegalStateException{
        // Prüfen ob currentOrder null ist
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        if(StateOfOrderVO.STARTED.equals(currentOrder.getState())) {
            throw new IllegalStateException("The order can not be processed.");
        }
        if(StateOfOrderVO.CONFIRMED.equals(currentOrder.getState())) {
            kitchen.startService(currentOrder);
            //System.out.println("Order completed: ");

        }
        if(StateOfOrderVO.READY.equals(currentOrder.getState())) {
            delivery.startService(currentOrder);
            //System.out.println("Order delivered: ");

        }
        if(StateOfOrderVO.DELIVERED.equals(currentOrder.getState())) {
            currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
            currentOrder.setState(StateOfOrderVO.FINISHED);
            System.out.println("Order completed: " + currentOrder);
        }


    }
    @Override
    public List<DishVO> sortShoppingBasket() throws NoOrderException {
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        List<DishVO> shoppingBasket = currentOrder.getShoppingBasket();
        Collections.sort(shoppingBasket);
        return shoppingBasket;
    }

    @Override
    public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException{
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        List<DishVO> shoppingBasket = currentOrder.getShoppingBasket();
        Collections.sort(shoppingBasket,new Comparator<DishVO>() {
            public int compare(DishVO d1, DishVO d2) {
                return Integer.compare(d1.getNumberOfDish(), d2.getNumberOfDish());
            }
        });
        return shoppingBasket;

    }

    @Override
    public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException {
        if (currentOrder == null) {
            throw new NoOrderException("There is no order.");
        }
        List<DishVO> shoppingBasket = currentOrder.getShoppingBasket();
        shoppingBasket.sort((DishVO d1, DishVO d2)->Float.compare(d1.getPrice(), d2.getPrice()));
        return shoppingBasket;
    }



    //Setter Getter
    public int getNumberOfDish() {
        return this.currentOrder.getNumberOfDishes();
    }



    public OrderVO getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(OrderVO currentOrder) {
        this.currentOrder = currentOrder;
    }

    public IService getDelivery() {
        return delivery;
    }

    public void setDelivery(IService delivery) {
        this.delivery = delivery;
    }

    public IService getKitchen() {
        return kitchen;
    }

    public void setKitchen(IService kitchen) {
        this.kitchen = kitchen;
    }

    public CustomerVO getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(CustomerVO currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public static int getNextId() {
        return nextId;
    }

    public static MenuVO getMenu() {
        return menu;
    }


}
