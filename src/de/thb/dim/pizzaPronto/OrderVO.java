package de.thb.dim.pizzaPronto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The class OrderVO contains the begin and the end, i.e. delivery, of order as a
 * date timestamp Furthermore the class provides an objectmamagement of the
 * ordered pizzas (later dishes). The order has an identifiers.
 * 
 * @author Gabriele Schmidt
 * @version 2.0
 *
 */

public class OrderVO {

	private static final int MAX_DISHES = 10;
	private static int nextOrderNo = 0;
	private int orderNo;
	private int index;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private PizzaVO[] shoppingBasket;
	private CustomerVO customer;

	public OrderVO(LocalDateTime timestampStartedOrder, CustomerVO customer) {
		if (nextOrderNo == 0 || (nextOrderNo / 100000 < LocalDate.now().getYear()))
			nextOrderNo = LocalDateTime.now().getYear() * 100000;
		this.orderNo = ++nextOrderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		index = 0;
		shoppingBasket = new PizzaVO[MAX_DISHES];
	}

	/**
	 * Methode for adding a dish to the shopping baskes of OrderVO. Object is
	 * inserted in the position index, if the maximum number yet was not reached.
	 * 
	 * @param dish - the to be added dish
	 * 
	 */
	public void addDish(PizzaVO dish) {
		if (index < MAX_DISHES) { // wenn maximale Anzahl noch nicht erreicht ...
			shoppingBasket[index] = dish; // f�ge Gericht and Position index ein ...
			index++; // inkrementiere den index
		}
	}

	/**
	 * Methode for deleting the last dish from the shopping baskes of OrderVO.
	 * 
	 */
	public void deleteDish() {
		if (index > 0) {
			shoppingBasket[index - 1] = null; // set object at position index - 1 null ...
			this.index--; // decrement index den index
		} else if (index == 0)
			shoppingBasket[0] = null;
	}

	/**
	 * Method returns the dish at the position of index.
	 * 
	 * @param index - Index
	 * @return - objects of PizzaVO later Dishes, is null if no object exists on
	 *         position index
	 * 
	 */
	public PizzaVO getDish(int index) {
		if (index < MAX_DISHES && shoppingBasket[index] != null)
			return shoppingBasket[index];
		else
			return null;
	}

	/**
	 * Method returns number of pizzas later dishes
	 * 
	 * @return - number of pizzas
	 * 
	 */
	public int getNumberOfDishes() {
		return index;
	}

	// Setter and Getter

	public PizzaVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(PizzaVO[] warenkorb) {
		this.shoppingBasket = warenkorb;
	}

	public int getIndex() {
		return index;
	}

	public static int getNextOrderNo() {
		return nextOrderNo;
	}

	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(LocalDateTime order) {
		this.timestampStartedOrder = order;
	}

	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	public void setTimestampDeliveredOrder(LocalDateTime delivery) {
		this.timestampDeliveredOrder = delivery;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public static int getMAX_DISHES() {
		return MAX_DISHES;
	}

	public int getOrderNo() {
		return orderNo;
	}

	// default management method of Java

	public String toString() {

		StringBuilder text = new StringBuilder(String.format(
				"OrderVO " + getOrderNo()
						+ " from %1$tm/%1$td/%1$tY %1$tH:%1$tM with delivery at  %1$tm/%1$td/%1$tY %2$tH:%2$tM\n",
				timestampStartedOrder, timestampDeliveredOrder));

		text.append("of customer: " + customer.getLastName() + " " + customer.getFirstName() + ", ID of customer: "
				+ customer.getId() + "\n");

		if (shoppingBasket != null) {
			for (int i = 0; i < index; i++) {
				if (shoppingBasket[i] != null) {
					text.append(shoppingBasket[i].toString());
					text.append("\n");
				}
			}
		}

		return text.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		return orderNo == other.orderNo;
	}

}
