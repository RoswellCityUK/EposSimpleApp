/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Models;

import java.util.ArrayList;

/**
 *
 * @author tg
 */

public class Report {
    
    private ArrayList<Sale> sales;
    private User user;
    
    private String reportName;
    private int totalCustomers = 0;
    private double totalSalesValue = 0;
    private double avgSaleValue = 0;
    private double minSaleValue = 0;
    private double maxSaleValue = 0;
    
    private User emptyUser = new User("empty", 0, 1);
    
    public Report(ArrayList<Sale> sales){
        this.sales = sales;
        this.user = null;
        
        if(!this.sales.isEmpty()){
            updateTotalCustomerCount();
            updateTotalSalesValue();
            updateAvgSaleValue();
            updateMinMaxSaleValue();
        }
    }
    
    public Report(ArrayList<Sale> sales, User user){
        this.sales = filterSalesByUser(sales, user);
        this.user = user;
        
        if(!this.sales.isEmpty()){
            updateTotalCustomerCount();
            updateTotalSalesValue();
            updateAvgSaleValue();
            updateMinMaxSaleValue();
        }
    }
    
    private ArrayList<Sale> filterSalesByUser(ArrayList<Sale> sales, User user){
        ArrayList<Sale> updatedSales = new ArrayList<>();
        
        for(Sale sale : sales){
            if(sale.getSoldBy() == user){
                updatedSales.add(sale);
            }
        }
        
        return updatedSales;
    }

    private void updateTotalCustomerCount() {
        this.totalCustomers = sales.size();
    }

    private void updateTotalSalesValue() {
        this.totalSalesValue = 0;
        for (Sale sale : sales){
            totalSalesValue += sale.getTotalValue();
        }
    }

    private void updateAvgSaleValue() {
        this.avgSaleValue = this.totalSalesValue/this.totalCustomers;
        
    }

    private void updateMinMaxSaleValue() {
        this.minSaleValue = this.sales.get(0).getTotalValue();
        this.maxSaleValue = this.sales.get(0).getTotalValue();
        for (Sale sale : this.sales){
            if(this.minSaleValue>sale.getTotalValue()){
                this.minSaleValue = sale.getTotalValue();
            }
            if(this.maxSaleValue<sale.getTotalValue()){
                this.maxSaleValue = sale.getTotalValue();
            }
        }
    }  
    
    public String getReportName(){
        if(this.user == null){
            return "Report on totals";
        }else{
            return "Report for user: " + this.user.getLogin();
        }
    }
    
    public int getTotalCustomerServed(){
        return this.totalCustomers;
    }
    
    public double getTotalSalesValue(){
        return this.totalSalesValue;
    }
    
    public double getAvgSaleValue(){
        return this.avgSaleValue;
    }   
    
    public double getMinSaleValue(){
        return this.minSaleValue;
    }
    
    public double getMaxSaleValue(){
        return this.maxSaleValue;
    }
    
    public User getUser(){
        return this.user;
    }
    
    @Override
    public String toString(){
        return getReportName();
    }
}
