package org.example.restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private final File menuFile = new File("menu.txt");

    private final Map<String, Meal> menu = new HashMap<>();
    public Restaurant() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(menuFile));
            br.lines().forEach(line -> {
                String[] tokens = line.split(",");
                menu.put(
                        tokens[0],
                        new Meal(
                                tokens[1],
                                Integer.parseInt(tokens[2]),
                                Integer.parseInt(tokens[3])
                        )
                );
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMenu() {
        menu.forEach((id, meal) -> {
            System.out.printf("%4s: %s\n", id, meal);
        });
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.printMenu();
    }
}

class Meal {
    String name;
    /**
     * Like calories but for mental healthy (?).
     */
    int mentalPower;
    int price;

    public Meal(String name, int mentalPower, int price) {
        this.name = name;
        this.mentalPower = mentalPower;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%20s (provides %4d mental power), $%5d", name, mentalPower, price);
    }
}
