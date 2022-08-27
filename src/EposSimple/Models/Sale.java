/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tg
 */
public class Sale {
    private static int counter = 0;
    private int id;
    private Date date;
    private ArrayList<SoldProduct> products;
    private double totalValue;
    private User soldBy;

    public Sale(ArrayList<SoldProduct> products, double totalValue, User soldBy){
        this.id = counter++;
        this.date = new Date();
        this.products = products;
        this.totalValue = totalValue;
        this.soldBy = soldBy;
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the products
     */
    public ArrayList<SoldProduct> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<SoldProduct> products) {
        this.products = products;
    }

    /**
     * @return the totalValue
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return the soldBy
     */
    public User getSoldBy() {
        return soldBy;
    }

    /**
     * @param soldBy the soldBy to set
     */
    public void setSoldBy(User soldBy) {
        this.soldBy = soldBy;
    }
    
}

