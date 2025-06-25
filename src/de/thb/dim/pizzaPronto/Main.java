package de.thb.dim.pizzaPronto;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Dummy-Daten erstellen
        String[] arra = {"hallo"};
        CustomerVO customer = new CustomerVO("Max", "Mustermann", LocalDate.of(1900,4,5));  // ggf. Konstruktor anpassen
        DishVO pizza = new PizzaVO(12,"Pizza Margheri", arra, 8.50f,2);  // ggf. Konstruktor anpassen

        // Ordering testen
        Ordering ordering = new Ordering();

        // Neue Bestellung starten
        OrderVO order = ordering.startNewOrder(customer);
        if (order != null) {
            System.out.println("Bestellung gestartet: ");
        }

        // Gericht hinzufügen
        ordering.addDish(pizza);
        System.out.println("Preis nach Hinzufügen: " + ordering.calculateTotalPrice());

        // Gericht löschen
        ordering.deleteDish();
        System.out.println("Preis nach Löschen: " + ordering.calculateTotalPrice());

        // Bestellung bestätigen
        ordering.confirmOrder();
        System.out.println("Bestellung bestätigt.");
    }
}
