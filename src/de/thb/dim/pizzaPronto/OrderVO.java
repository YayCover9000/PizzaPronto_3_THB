package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderVO {
    private static final int MAX_DISHES = 10;
    private static int nextOrderNo = 0;
    private int orderNo;
    private int index;
    private LocalDateTime timestampStartedOrder;
    private LocalDateTime timestampDeliveredOrder;
    private PizzaVO[] shoppingBasket;
    private CustomerVO customer; // darf nicht mehr  null sein nach der erzeugung



//Konstruktoren
    public OrderVO() {
        this(null, null);
    }
    public OrderVO(LocalDateTime timestampStartedOrder, CustomerVO customer) {
        setCustomer(customer);
        setTimestampStartedOrder(timestampStartedOrder);
        shoppingBasket = new PizzaVO[MAX_DISHES];
        index = 0;

        int currentYear = LocalDate.now().getYear();
        int yearPart = currentYear;
        int counterPart = nextOrderNo % 100000; // nur die letzten 5 Ziffern als Laufnummer
        counterPart++; // erhöhe Zähler für diese Bestellung

        nextOrderNo = yearPart * 100000 + counterPart; // sichere neuen Wert
        orderNo = nextOrderNo;
    }





    public void addDish(PizzaVO dish) {
        if (shoppingBasket != null && dish != null) {
            if(index < MAX_DISHES) {
                shoppingBasket[index] = dish;
                index++;
            }
        }
    }
    public void deleteDish() {
        if(shoppingBasket != null && index > 0) {
            index--;
            shoppingBasket[index] = null;
        }
    }
    public PizzaVO getDish(int index) {
        if(index < MAX_DISHES && index > -1) {
            return shoppingBasket[index];
        }
        return null;
    }
    public int getNumberOfDishes() {
        return index;
    }



//Standartd Methoden
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderVO ").append(orderNo).append(" from ");
        sb.append(timestampStartedOrder);
        sb.append(" with delivery at ").append(timestampDeliveredOrder);
        sb.append(" of customer: ").append(customer.getFirstName()).append(" ").append(customer.getLastName());
        sb.append(", Id of customer: ").append(customer.getId());
        sb.append(" Ingredients [");
        //Algoritmus um alle Pizzen im Warenkorb hintereinander aufzulisten
        if(shoppingBasket != null) {
            for(PizzaVO pizza : shoppingBasket) {
                if(pizza != null) {
                    sb.append(pizza.toString()).append(",");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if(o == null || getClass() != o.getClass()) {return false;}
        OrderVO that = (OrderVO) o;
        return Objects.equals(orderNo, that.orderNo);
    }
    public int hashCode() {
        return Objects.hash(orderNo);
    }



    //Nur Getter
    public int getIndex() {return index;}
    public int getOrderNo() {
        return orderNo;
    }
    public static int getMAX_DISHES() {return MAX_DISHES;}
    //Anzahl der Gerichte Getter ?!

    //Getter und Setter
    public static int getNextOrderNo() {return nextOrderNo;}
    public LocalDateTime getTimestampStartedOrder() {return timestampStartedOrder;}
    public LocalDateTime getTimestampDeliveredOrder() {return timestampDeliveredOrder;}
    public PizzaVO[] getShoppingBasket() {return shoppingBasket;}
    public CustomerVO getCustomer() {return customer;}
    public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {this.timestampStartedOrder = timestampStartedOrder;}
    public void setTimestampDeliveredOrder(LocalDateTime DeliveredOrder) {this.timestampDeliveredOrder = DeliveredOrder;}

    private void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }
    public void setShoppingBasket(PizzaVO[] shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

}
