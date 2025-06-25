package de.thb.dim.pizzaPronto.valueObjects;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class OrderVO {

	private int orderNo;
	private StateOfOrderVO state;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private CustomerVO customer;

	//Vom Typ DishVO
	private List<DishVO> shoppingBasket = new LinkedList<DishVO>();


	public OrderVO(int orderNo, StateOfOrderVO state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		this.timestampStartedOrder = LocalDateTime.now();
		this.customer = customer;
		this.state = state;
		this.orderNo = orderNo;
	}

	// Berechnet den Gesamtpreis aller Gerichte im Warenkorb
	public float calculatePriceDishes() {
		float total = 0;
		for (int i = 0; i < shoppingBasket.size(); i++) {
			if (shoppingBasket.get(i) != null) {
				total += shoppingBasket.get(i).getPrice();
			}
		}
		return total;
	}

	// Verwaltungsmethoden für shoppingBasket
	public void addDish(DishVO dish) {
		shoppingBasket.add(dish);
	}

	public void deleteDish(DishVO dish) {
		shoppingBasket.remove(shoppingBasket.size() - 1);
	}
	public void deleteDish(int index) {
		shoppingBasket.remove(index);
	}

	public DishVO getDish(int index) {
		return shoppingBasket.get(index);
	}

	public int getNumberOfDishes() {
		return shoppingBasket.size();
	}

	public StateOfOrderVO getState() {
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
			text.append("Order state: ").append(state).append("\n");



		if (shoppingBasket != null) {
			for (int i = 0; i < shoppingBasket.size(); i++) {
				if (shoppingBasket.get(i) != null) {
					text.append(shoppingBasket.get(i).toString()).append("\n");
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
	public void setState(StateOfOrderVO state) {
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

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public void setState(String state) {
		this.state = StateOfOrderVO.valueOf(state);
	}

	public List<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(List<DishVO> shoppingBasket) {
		if (shoppingBasket == null) {
			this.shoppingBasket = new LinkedList<>();
		} else {
			this.shoppingBasket = shoppingBasket;
		}
	}
}
