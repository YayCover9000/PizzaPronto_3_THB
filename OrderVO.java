package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderVO {

	private static final int MAX_DISHES = 10;
	private static int nextOrderNo = 0;
	private int orderNo;
	private String state;
	private int index;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private DishVO[] shoppingBasket;
	private CustomerVO customer;

	// Konstruktor ohne timestampDeliveredOrder, state wird auf "started" gesetzt
	public OrderVO(LocalDateTime timestampStartedOrder, CustomerVO customer) {
		if (nextOrderNo == 0 || (nextOrderNo / 100000 < LocalDate.now().getYear())) {
			nextOrderNo = LocalDateTime.now().getYear() * 100000;
		}
		this.orderNo = ++nextOrderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.customer = customer;
		this.state = "started";
		this.index = 0;
		this.shoppingBasket = new DishVO[MAX_DISHES];
	}

	// Berechnet den Gesamtpreis aller Gerichte im Warenkorb
	public float calculatePriceDishes() {
		float total = 0;
		for (int i = 0; i < index; i++) {
			if (shoppingBasket[i] != null) {
				total += shoppingBasket[i].getPrice();
			}
		}
		return total;
	}

	// Verwaltungsmethoden für shoppingBasket
	public void addDish(DishVO dish) {
		if (index < MAX_DISHES) {
			shoppingBasket[index++] = dish; // auch null erlaubt – Test prüft ja gerade diesen Fall
		}
	}


	public void deleteDish() {
		if (index > 0) {
			shoppingBasket[--index] = null;
		} else if(index == 0){
			shoppingBasket[0] = null;
		}
	}

	public DishVO getDish(int index) {
		if (index >= 0 && index < MAX_DISHES && shoppingBasket[index] != null) {
			return shoppingBasket[index];
		}
		return null;
	}

	public int getNumberOfDishes() {
		return index;
	}

	public String getState() {
		return state;
	}

//ToString

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
			text.append(String.format("OrderVO " + getOrderNo() + " from %1$tm/%1$td/%1$tY %1$tH:%1$tM With delivery at %1$tm/%1$td/%1$tY %2$tH:%2$tM\n", timestampStartedOrder, timestampDeliveredOrder));
			text.append("of customer: ");
			text.append(customer.getLastName()).append(" ");
			text.append(customer.getFirstName()).append(", ID of customer: ").append(customer.getId()).append("\n");


		if (shoppingBasket != null) {
			for (int i = 0; i < index; i++) {
				if (shoppingBasket[i] != null) {
					text.append(shoppingBasket[i].toString()).append("\n");
				}
			}
		}
		return text.toString();
	}

	// equals und hashCode basierend auf orderNo
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OrderVO)) return false;
		OrderVO other = (OrderVO) obj;
		return orderNo == other.orderNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNo);
	}

	// Getter & Setter
	public void setState(String state) {
			this.state = state;
	}
	// Setter für timestampDeliveredOrder
	public void setTimestampDeliveredOrder(LocalDateTime timestampDeliveredOrder) {
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}

	// Getter für timestampDeliveredOrder
	public LocalDateTime getTimestampDeliveredOrder() {
		return this.timestampDeliveredOrder;
	}

	// Setter für shoppingBasket
	public void setShoppingBasket(DishVO[] shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public DishVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	public static int getNextOrderNo() {
		return nextOrderNo;
	}

	public int getIndex() {
		return index;
	}

	public static int getMAX_DISHES() {
		return MAX_DISHES;
	}
}
