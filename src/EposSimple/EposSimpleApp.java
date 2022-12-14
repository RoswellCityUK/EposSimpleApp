package EposSimple;

import EposSimple.Dialogs.*;
import EposSimple.Widgets.ProductBillWidget;
import EposSimple.Helpers.*;
import EposSimple.Models.*;
import EposSimple.Panels.*;
import EposSimple.Widgets.ProductListWidget;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.JComponent;
import javax.swing.JDialog;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author tg
 */
public class EposSimpleApp extends javax.swing.JFrame {

    private final Login loginPanel;
    private TopMenu topMenu;
    private SalesDashboard salesDashboard;
    private Reports reports;
    private ProductManagement productManagement;
    private UserManagement userManagement;

    ArrayList<User> users;
    ArrayList<Sale> sales;
    ArrayList<Product> offer;
    ArrayList<SoldProduct> bill;

    ArrayList<ProductBillWidget> billWidgets;

    private User loggedUser;
    private static EposSimpleApp frame;

    public boolean editMode;

    /**
     * Creates new form EposSimpleApp
     */
    public EposSimpleApp() {
        users = new ArrayList<>();
        sales = new ArrayList<>();
        offer = new ArrayList<>();
        bill = new ArrayList<>();
        billWidgets = new ArrayList<>();

        editMode = false;

        initComponents();

        DbSeeding.process(users, offer);
        setLocationRelativeTo(null);

        loginPanel = new Login(users);
        pnlBody.add(loginPanel);
        pnlBody.revalidate();
        pnlBody.repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        pnlBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ePOS Simple App");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("ePOS App"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pnlHeader.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        pnlHeader.setMaximumSize(new java.awt.Dimension(1280, 55));
        pnlHeader.setMinimumSize(new java.awt.Dimension(1280, 55));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1280, 55));
        pnlHeader.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pnlBody.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        pnlBody.setMaximumSize(new java.awt.Dimension(1280, 665));
        pnlBody.setMinimumSize(new java.awt.Dimension(1280, 665));
        pnlBody.setPreferredSize(new java.awt.Dimension(1280, 665));
        pnlBody.setLayout(new javax.swing.BoxLayout(pnlBody, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(pnlBody, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EposSimpleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EposSimpleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EposSimpleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EposSimpleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            frame = new EposSimpleApp();
            frame.setVisible(true);
        });
    }

    public void askHowManyProductsToAdd(Product product) {
        java.awt.EventQueue.invokeLater(() -> {
            JDialog d = new ProductAmountDialog(frame, product);
            d.setVisible(true);
        });
        disableEditMode();
    }

    public void addProductToBill(Product product, int amount) {
        SoldProduct billProduct = new SoldProduct(product, amount);
        int i = 0;
        int index = bill.size();
        boolean productExistedOnBill = false;
        for (SoldProduct productOnBill : bill) {
            if (productOnBill.getId() == billProduct.getId()) {
                billProduct.setAmountSold(billProduct.getAmountSold() + productOnBill.getAmountSold());
                index = i;
                productExistedOnBill = true;
                break;
            }
            i++;
        }
        if (!productExistedOnBill) {
            bill.add(billProduct);
            billWidgets.add(index, new ProductBillWidget(frame, billProduct));
            salesDashboard.addBillPanel(billWidgets.get(index));
        } else {
            bill.set(index, billProduct);
            billWidgets.get(index).changeBillWidgetContent(billProduct);
        }
        salesDashboard.refreshBillTotal(bill);
    }

    public void deleteProductFromBill(SoldProduct product, ProductBillWidget widget) {
        bill.remove(product);
        salesDashboard.removeBillWidget(widget);
        billWidgets.remove(widget);
    }

    public void editProductFromBill(SoldProduct product, ProductBillWidget widget) {
        java.awt.EventQueue.invokeLater(() -> {
            JDialog d = new ProductEditDialog(frame, product);
            d.setVisible(true);
        });
    }
    
    public void editAmountOnBill(SoldProduct product) {
        disableEditMode();
        int i = 0;
        int index = -1;
        for(SoldProduct productOnBill : bill){
            if(productOnBill.getId() == product.getId()){
                index = i;
                bill.set(index, product);
                billWidgets.get(index).changeBillWidgetContent(product);
                break;
            }
            i++;
        }
        salesDashboard.refreshBillTotal(bill);
    }

    public double printBill() {
        double billTotalValue = 0;
        for (SoldProduct product : bill) {
            billTotalValue += product.getTotalValue();
        }
        Sale newSale = new Sale(bill, billTotalValue, loggedUser);
        sales.add(newSale);
        resetBill();
        return billTotalValue;
    }
    
    public void editUser(User userToEdit){
        if(loggedUser.getRole() == 0){
            int i = 0;
            for(User user : this.users){
                if(userToEdit.getId() == user.getId()){
                    users.set(i, user);
                    break;
                }
                i++;
            }
            showUserManagement();
        }else{
            System.out.println("No Access");
        }
    }
    
    public void addUser(User userToAdd){
        if(loggedUser.getRole() == 0){
            users.add(userToAdd);
        }else{
            System.out.println("No Access");
        }
    }
    
    public void deleteUser(User userToDelete){
        if(loggedUser.getRole() == 0){
            int i = 0;
            for(User user : this.users){
                if(userToDelete.getId() == user.getId()){
                    users.remove(i);
                    break;
                }
                i++;
            }
            showUserManagement();
        }else{
            System.out.println("No Access");
        }
    }
    
    public void deleteProductFromOffer(Product productToDelete){
        if(loggedUser.getRole() == 0){
            int i = 0;
            for(Product product : this.offer){
                if(productToDelete.getId() == product.getId()){
                    offer.remove(i);
                    break;
                }
                i++;
            }
            showProductManagement();
        }else{
            System.out.println("No Access");
        }
    }
    
    public void editProduct(Product productToEdit, ProductListWidget selectedWidget){
        if(loggedUser.getRole() == 0){
            int i = 0;
            for(Product product : this.offer){
                if(productToEdit.getId() == product.getId()){
                    offer.set(i, product);
                    break;
                }
                i++;
            }
            showProductManagement();
            productManagement.selectProduct(selectedWidget, productToEdit);
        }else{
            System.out.println("No Access");
        }
    }
    
    public void moveProductOrder(String direction, int productId){
        switch(direction){
            case "up" -> {
                int i = 0;
                for(Product product : this.offer){
                    if(productId == product.getId()){
                        int thisProductOrder = offer.get(i).getOrder();
                        int nextProductOrder = offer.get(i-1).getOrder();
                        offer.get(i).setOrder(nextProductOrder);
                        offer.get(i-1).setOrder(thisProductOrder);
                        System.out.println(thisProductOrder + " <-> " + nextProductOrder);
                        break;
                    }
                    i++;
                }
            }
            case "down" -> {
                int i = 0;
                for(Product product : this.offer){
                    if(productId == product.getId()){
                        int thisProductOrder = offer.get(i).getOrder();
                        int previousProductOrder = offer.get(i+1).getOrder();
                        offer.get(i).setOrder(previousProductOrder);
                        offer.get(i+1).setOrder(thisProductOrder);
                        System.out.println(thisProductOrder + " <-> " + previousProductOrder);
                        break;
                    }
                    i++;
                }
            }
        }
        Collections.sort(offer);
        showProductManagement();
        salesDashboard.refreshProducts();
    }
    
    public void resetAllSales(){
        if(loggedUser.getRole() == 0){
            this.sales.clear();
            showReports();
        }else{
            System.out.println("Access Denied");
        }
    }

    public void loginUser(User user) {
        this.loggedUser = user;

        pnlBody.remove(loginPanel);
        pnlBody.validate();
        pnlBody.repaint();

        topMenu = new TopMenu(frame, loggedUser);
        showTopMenu();

        salesDashboard = new SalesDashboard(frame, loggedUser, offer);
        showDashboard();
    }

    public void showDashboard() {
        pnlBody.removeAll();
        pnlBody.add(salesDashboard);
        pnlBody.validate();
        pnlBody.repaint();
    }

    public void showReports() {
        pnlBody.removeAll();
        reports = new Reports(frame, loggedUser, sales, users);
        pnlBody.add(reports);
        pnlBody.validate();
        pnlBody.repaint();
    }

    public void showUserManagement() {
        pnlBody.removeAll();
        userManagement = new UserManagement(frame, loggedUser, sales, users);
        pnlBody.add(userManagement);
        pnlBody.validate();
        pnlBody.repaint();
    }

    public void showProductManagement() {
        pnlBody.removeAll();
        productManagement = new ProductManagement(frame, loggedUser, offer);
        pnlBody.add(productManagement);
        pnlBody.validate();
        pnlBody.repaint();
    }

    public void showTopMenu() {
        topMenu.setSize(1280, 55);
        pnlHeader.add(topMenu);
        
        pnlHeader.validate();
        pnlHeader.repaint();
    }

    public void logoutUser() {

        pnlHeader.removeAll();

        pnlBody.removeAll();
        pnlBody.add(loginPanel);

        this.loggedUser = null;
        this.topMenu = null;
        this.salesDashboard = null;
        this.bill = new ArrayList<>();
        this.billWidgets = new ArrayList<>();

        pnlHeader.validate();
        pnlHeader.repaint();
        pnlBody.validate();
        pnlBody.repaint();
    }

    public void toggleEditMode() {
        if (editMode) {
            disableEditMode();
        } else {
            enableEditMode();
        }
    }

    public void disableEditMode() {
        for (ProductBillWidget widget : billWidgets) {
            widget.setNormalMode();
        }
        editMode = false;
    }

    public void enableEditMode() {
        for (ProductBillWidget widget : billWidgets) {
            widget.setEditMode();
        }
        editMode = true;
    }

    public void resetBill() {
        bill.clear();
        salesDashboard.resetBill();
        billWidgets.clear();
        salesDashboard.refreshBillTotal(bill);
    }

    public void exit() {
        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables

    

}
