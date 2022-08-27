/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Helpers;

import EposSimple.Models.Product;
import EposSimple.Models.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author tg
 */
public class DbSeeding {

    public static void process(ArrayList<User> users, ArrayList<Product> offer) {
        users.add(new User("Mr. Bezos", 12345, 0));
        users.add(new User("Mr. Anderson", 12345, 1));
        users.add(new User("Mr. Bloob", 12345, 1));
        users.add(new User("Mrs. Renata", 12345, 1));
        users.add(new User("Mr. Rasputin", 12345, 0));
        users.add(new User("Mr. Zero", 12345, 1));

        offer.add(new Product("Lettuce", getRandomPrice(), "lettuce.png"));
        offer.add(new Product("Loaf", getRandomPrice(), "loaf.png"));
        offer.add(new Product("Pickles", getRandomPrice(), "pickles.png"));
        offer.add(new Product("Fries", getRandomPrice(), "fries.png"));
        offer.add(new Product("Cupcake", getRandomPrice(), "cupcake.png"));
        offer.add(new Product("Carrot", getRandomPrice(), "carrot.png"));
        offer.add(new Product("Burger", getRandomPrice(), "burger.png"));
        offer.add(new Product("Bread", getRandomPrice(), "bread.png"));
        offer.add(new Product("Cake", getRandomPrice(), "birthday-cake.png"));
        offer.add(new Product("Beer", getRandomPrice(), "beer.png"));
        offer.add(new Product("Cheese", getRandomPrice(), "cheese.png"));
        offer.add(new Product("Chocolate", getRandomPrice(), "chocolate.png"));
        offer.add(new Product("Croissant", getRandomPrice(), "croissant.png"));
        offer.add(new Product("Donut", getRandomPrice(), "donut.png"));
        offer.add(new Product("Honey", getRandomPrice(), "honey.png"));
        offer.add(new Product("Hot-Dog", getRandomPrice(), "hot-dog.png"));
        offer.add(new Product("Milk", getRandomPrice(), "milk.png"));
        offer.add(new Product("Noodles", getRandomPrice(), "noodles.png"));
        offer.add(new Product("Tea", getRandomPrice(), "tea.png"));

        Collections.sort(offer);
    }

    private static double getRandomPrice() {
        Random r = new Random();
        int temp;
        double randomPrice = 0.1 + (20 - 0.1) * r.nextDouble();
        temp = (int) (randomPrice * 100);
        randomPrice = (double) temp / 100;
        return randomPrice;
    }
}
