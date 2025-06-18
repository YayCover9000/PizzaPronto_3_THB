package de.thb.dim.pizzaPronto.valueObjects;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MenuVO {
    //private DishVO[] dishes;
    private List<DishVO> dishes;
    // Constructor to ensure dishes are initialized
    public MenuVO() {
        initMenu();
    }

    private void initMenu() {
        dishes = new ArrayList<>();  // Liste initialisieren

        dishes.add(new PizzaVO(30, "Popeye", new String[]{"Schinken", "Spinat", "Champignon", "Ei"}, 7.00f, 1));
        dishes.add(new PizzaVO(30, "Popeye", new String[]{"Schinken", "Spinat", "Champignon", "Ei"}, 8.90f, 2));
        dishes.add(new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 5.80f, 1));
        dishes.add(new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 7.40f, 2));
        dishes.add(new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 7.00f, 1));
        dishes.add(new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 8.90f, 2));

        dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4));
        dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 5));
        dishes.add(new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 6));
        dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 4));
        dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 5));
        dishes.add(new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 6));
        dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 4));
        dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 5));
        dishes.add(new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 6));

        dishes.add(new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
        dishes.add(new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
        dishes.add(new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        DecimalFormat dFormat = new DecimalFormat(".00");

        sb.append("MENU PIZZA PRONTO\n\n");

        sb.append("Prima special pizzas:\n   1 normal (Diameter approx. 26 cm) and\n   2 grande (Diameter approx. 32 cm)\n");

        int i = 0;
        while (i < dishes.size() && dishes.get(i) instanceof PizzaVO) {
            sb.append(dishes.get(i).getNumber()).append("\t");
            sb.append(dishes.get(i).getName()).append("\t");
            sb.append(dishes.get(i).ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes.get(i).getPrice())).append(" Euro");

            if (i + 1 < dishes.lastIndexOf(dishes) && dishes.get(i).getNumber() == dishes.get(i + 1).getNumber()) {
                sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes.get(i + 1).getPrice())).append(" Euro\n");
                i += 2;
            } else {
                sb.append("\n");
                i++;
            }
        }

        sb.append("\nPrima special pastas:\n4  Spaghetti\n5  Tortellini\n6  Gnocchi\n");

        while (i < dishes.size() && dishes.get(i) instanceof PastaVO) {
            sb.append(" ").append(dishes.get(i).getNumber()).append("\t");
            sb.append(dishes.get(i).getName()).append("\t");
            sb.append(dishes.get(i).ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes.get(i).getPrice())).append(" Euro\n");

            // Skip duplicates
            int currentNum = dishes.get(i).getNumber();
            while (i < dishes.size() && dishes.get(i).getNumber() == currentNum) {
                i++;
            }
        }

        sb.append("\nPrima desserts\n");

        while (i < dishes.size() && dishes.get(i) instanceof DessertVO) {
            sb.append(dishes.get(i).getNumber()).append("\t");
            sb.append(dishes.get(i).getName()).append("\t");
            sb.append(dishes.get(i).ingredientsToString());
            sb.append("\n\tPrice:\t\t\t").append(dFormat.format(dishes.get(i).getPrice())).append(" Euro\n");
            i++;
        }

        return sb.toString();
    }
    public DishVO getDish(int i) {
        return dishes.get(i);
    }
    public int getNumberOfDishes() {
        return dishes.size();
    }
}
