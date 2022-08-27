/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Models;

/**
 *
 * @author tg
 */
public class SoldProduct extends Product {

    private int amountSold;

    public SoldProduct(Product product, int amount) {
        super(product.getId(), product.getName(), product.getPrice(), product.getImagePath());
        this.amountSold = amount;
    }

    /**
     * @return the amountSold
     */
    public int getAmountSold() {
        return amountSold;
    }

    /**
     * @param amountSold the amountSold to set
     */
    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }

    public double getTotalValue() {
        return this.getAmountSold() * this.getPrice();
    }

    @Override
    public String toString() {
        return this.getName() + " [Price: £" + this.getPrice() + ", Image path: " + this.getImagePath() + ", Amount: " + this.getAmountSold() + "]";
    }
}
