/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Models;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tg
 */
public class Product implements Comparable<Product> {

    private static int counter = 0;
    private int id;
    private String name;
    private String image;
    private double price;
    private int order;

    public Product(int id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.order = this.id;
    }

    public Product(String name, double price, String image) {
        this.id = counter++;
        this.name = name;
        this.price = price;
        this.image = image;
        this.order = this.id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the image
     */
    public String getImagePath() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImagePath(String image) {
        this.image = image;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    public ImageIcon getProductIcon(int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/ProductImages/" + this.getImagePath()));
        Image oldimg = icon.getImage();
        Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        return icon;
    }

    @Override
    public String toString() {
        return this.getName() + " [Price: £" + this.getPrice() + ", Image path: " + this.getImagePath() + "]";
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(getOrder(), o.getOrder());
    }
    
    public boolean isProductLastinOrder(){
        if(this.getId() == counter-1){
            return true;
        }else{
            return false;
        }
    }

}
