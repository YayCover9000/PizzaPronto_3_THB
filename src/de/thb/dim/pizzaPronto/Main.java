package de.thb.dim.pizzaPronto;

import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        testCustomerVO();
        testChefVO();
        testPizzaVO();
    }

    private static void testCustomerVO() {
        System.out.println("--- Testing CustomerVO ---");
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(1998, 5, 24);

        CustomerVO cust1 = new CustomerVO("Bauer", "Hans", "male", today);
        CustomerVO cust2 = new CustomerVO("Maier", "Lars", dob);
        CustomerVO cust3 = new CustomerVO("Bauer", "Hans", "male", today);

        System.out.println("cust1: " + cust1);
        System.out.println("cust2: " + cust2);
        System.out.println("cust3: " + cust3);

        System.out.println("cust1 equals cust2? Expected: false, Actual: " + cust1.equals(cust2));
        System.out.println("cust1 equals cust3? Expected: true, Actual: " + cust1.equals(cust3));

        System.out.println("Age of cust1? Expected: 0: " + cust1.calculateAge());
        System.out.println("Age of cust2? Expected: 26: " + cust2.calculateAge());
    }

    private static void testChefVO() {
        System.out.println("\n--- Testing ChefVO ---");

        ChefVO chef1 = new ChefVO("Haurein", "Degen", Color.WHITE);
        ChefVO chef2 = new ChefVO("Simson", "Markiese", Color.LIGHT_GRAY);
        ChefVO chef3 = new ChefVO("Haurein", "Degen", Color.WHITE);

        // Ausgabe der Objekte
        System.out.println("chef1: " + chef1);
        System.out.println("chef2: " + chef2);
        System.out.println("chef3: " + chef3);

        //Vergleiche
        System.out.println("chef1 equals chef2? Expected: false, Actual: " + chef1.equals(chef2));
        System.out.println("chef1 equals chef3? Expected: true, Actual: " + chef1.equals(chef3));

        // Test Apron Color
        System.out.println("\nChecking Apron Colors");
        printApronColorDetails(chef1);
        printApronColorDetails(chef2);
        printApronColorDetails(chef3);

    }

    private static void printApronColorDetails(ChefVO chefVO) {
        Color apronColor = chefVO.getColorApron();
        if(apronColor != null) {
            String colorName = getColorName(apronColor);
            System.out.println(chefVO.getFirstName() + " " + chefVO.getLastName() +
                    " has apron color: " + colorName);
        } else {
            System.out.println(chefVO.getFirstName() + " " + chefVO.getLastName() +
                    " has no apron color set.");
        }
    }

    private static String getColorName(Color color) {
        if (color.equals(Color.WHITE)) {
            return "Weiß";
        } else if (color.equals(Color.LIGHT_GRAY)) {
            return "Hellgrau";
        } else if (color.equals(Color.GRAY)) {
            return "Grau";
        } else if (color.equals(Color.DARK_GRAY)) {
            return "Dunkelgrau";
        } else if (color.equals(Color.BLACK)) {
            return "Schwarz";
        } else if (color.equals(Color.RED)) {
            return "Rot";
        } else if (color.equals(Color.PINK)) {
            return "Pink";
        } else if (color.equals(Color.ORANGE)) {
            return "Orange";
        } else if (color.equals(Color.YELLOW)) {
            return "Gelb";
        } else if (color.equals(Color.GREEN)) {
            return "Grün";
        } else if (color.equals(Color.MAGENTA)) {
            return "Magenta";
        } else if (color.equals(Color.CYAN)) {
            return "Cyan";
        } else if (color.equals(Color.BLUE)) {
            return "Blau";
        } else {
            // Falls unbekannte Farbe
            return "Unbekannte Farbe (" +
                    color.getRed() + "," +
                    color.getGreen() + "," +
                    color.getBlue() + ")";
        }
    }


    private static void testPizzaVO() {
        System.out.println("\n--- Testing PizzaVO ---");

        String[] zutaten1 = {"Tomaten", "Eier"};
        String[] zutaten2 = {"Apfel", "Banane"};

        PizzaVO pizza1 = new PizzaVO("Margherita", zutaten1, 10.0f);
        PizzaVO pizza2 = new PizzaVO("Baumpizza", zutaten2, 5.0f);
        PizzaVO pizza3 = new PizzaVO("Margherita", zutaten1, 10.0f);

        System.out.println("pizza1: " + pizza1);
        System.out.println("pizza2: " + pizza2);
        System.out.println("pizza3: " + pizza3);

        System.out.println("pizza1 equals pizza2? Expected: false, Actual: " + pizza1.equals(pizza2));
        System.out.println("pizza1 equals pizza3? Expected: true, Actual: " + pizza1.equals(pizza3));
    }
}
