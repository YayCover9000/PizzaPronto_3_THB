package de.thb.dim.pizzaPronto;

import java.time.LocalDateTime;

public class Ordering implements IOrdering{
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

    /**Change*/
    @Override
    public OrderVO startNewOrder (CustomerVO customer) {
        if(menu == null) { menu = new MenuVO(); }

        // If customer is null, return null (error message will be handled by UI later)
        if (customer == null) {
            return null;
        }

        // Assign the customer
        this.currentCustomer = customer;


        //Bestellnummer generieren
        int currentYear = LocalDateTime.now().getYear();
        if(nextId == 0 || (nextId / 100000) < currentYear) {
            nextId = currentYear * 100000 +1;
        } else {
            nextId++;
        }

        this.currentOrder = new OrderVO(nextId, "started", LocalDateTime.now(), customer);

        // Set the order for the customer (assuming CustomerVO has setCurrentOrder method)
        customer.setOrder(this.currentOrder);

        return currentOrder;
    }

    @Override
    public void addDish(DishVO dish) {
        if (currentOrder == null) {
            System.out.println("There is no order.");
        }else if(currentOrder != null && "started".equals(currentOrder.getState())) {
            currentOrder.addDish(dish);
        }else if (currentOrder != null && !"started".equals(currentOrder.getState())) {
            System.out.println("Your order is complete, you can not add any dishes.");
        }
    }

    @Override
    public void deleteDish() {
        if(currentOrder == null) {
            System.out.println("There is no order.");
            return;
        }else if(currentOrder != null && !"started".equals(currentOrder.getState())) {
            System.out.println("Your order is complete, you can not delete any dishes.");
            return;
        }else if(currentOrder != null && "started".equals(currentOrder.getState())) {
            currentOrder.deleteDish();
        }

        if(!"started".equals(currentOrder.getState())) {
            System.out.println("Your order is complete, you can not delete any dishes.");
            return;
        }
        currentOrder.deleteDish();
    }

    @Override
    public float calculateTotalPrice() {
        if(currentOrder == null) {
            System.out.println("There is no order.");
            return 0.00f;
        }else{
            return currentOrder.calculatePriceDishes();
        }
    }
    /**Change*/
    @Override
    public void confirmOrder() {
        if (currentOrder == null) {
            System.out.println("There is no order.");
            return;
        }else if (currentOrder != null && "started".equals(currentOrder.getState())) {
            currentOrder.setState("confirmed");
            startService();
        }else {
            System.out.println("Your order can not be confirmed.");
        }
    }

    public void startService() {
        // Prüfen ob currentOrder null ist
        if (currentOrder == null) {
            System.out.println("There is no order.");
        }else if(currentOrder != null && "started".equals(currentOrder.getState())) {
            System.out.println("Your order can not be processed.");

        }
        if(currentOrder != null && "confirmed".equals(currentOrder.getState())) {
            kitchen.startService(currentOrder);
            System.out.println("Order completed: ");

        }
        if(currentOrder != null && "ready".equals(currentOrder.getState())) {
            delivery.startService(currentOrder);
            System.out.println("Order delivered: ");

        }
        if(currentOrder != null && currentOrder.getState().equals("delivered")) {
            currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
            currentOrder.setState("finished");
            System.out.println("Order completed: " + currentOrder);
        }


    }


    //Setter Getter

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
