package de.thb.dim.pizzaPronto;

import java.text.DecimalFormat;

public class MenuVO {
    private static final int NUMBER_OF_DISHES = 18;
    private DishVO[] dishes;

    // Constructor to ensure dishes are initialized
    public MenuVO() {
        initMenu();
    }

    private void initMenu() {
        int i = 0;
        this.dishes = new DishVO[NUMBER_OF_DISHES];

        dishes[i++] = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 7.00f, 1);
        dishes[i++] = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 8.90f, 2);
        dishes[i++] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 5.80f, 1);
        dishes[i++] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 7.40f, 2);
        dishes[i++] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 7.00f, 1);
        dishes[i++] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 8.90f, 2);

        dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4);
        dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 5);
        dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 6);
        dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 4);
        dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 5);
        dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 6);
        dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 4);
        dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 5);
        dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 6);

        dishes[i++] = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
        dishes[i++] = new DessertVO(22, "Hausgemachte Pannacotta", 2.60f);
        dishes[i++] = new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        DecimalFormat dFormat = new DecimalFormat(".00");

        sb.append("MENU PIZZA PRONTO\n\n");

        sb.append("Prima special pizzas:\n   1 normal (Diameter approx. 26 cm) and\n   2 grande (Diameter approx. 32 cm)\n");

        int i = 0;
        while (i < dishes.length && dishes[i] instanceof PizzaVO) {
            sb.append(dishes[i].getNumber()).append("\t");
            sb.append(dishes[i].getName()).append("\t");
            sb.append(dishes[i].ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes[i].getPrice())).append(" Euro");

            if (i + 1 < dishes.length && dishes[i].getNumber() == dishes[i + 1].getNumber()) {
                sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes[i + 1].getPrice())).append(" Euro\n");
                i += 2;
            } else {
                sb.append("\n");
                i++;
            }
        }

        sb.append("\nPrima special pastas:\n4  Spaghetti\n5  Tortellini\n6  Gnocchi\n");

        while (i < dishes.length && dishes[i] instanceof PastaVO) {
            sb.append(" ").append(dishes[i].getNumber()).append("\t");
            sb.append(dishes[i].getName()).append("\t");
            sb.append(dishes[i].ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes[i].getPrice())).append(" Euro\n");

            // Skip duplicates
            int currentNum = dishes[i].getNumber();
            while (i < dishes.length && dishes[i].getNumber() == currentNum) {
                i++;
            }
        }

        sb.append("\nPrima desserts\n");

        while (i < dishes.length && dishes[i] instanceof DessertVO) {
            sb.append(dishes[i].getNumber()).append("\t");
            sb.append(dishes[i].getName()).append("\t");
            sb.append(dishes[i].ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes[i].getPrice())).append(" Euro\n");
            i++;
        }

        return sb.toString();
    }

    public int getNumberOfDishes() {
        return NUMBER_OF_DISHES;
    }

    public DishVO getDish(int index) {
        if (dishes != null && index >= 0 && index < dishes.length) {
            return dishes[index];
        }
        return null;
    }

    public void setDishes(DishVO[] dishes) {
        this.dishes = dishes;
    }
}
