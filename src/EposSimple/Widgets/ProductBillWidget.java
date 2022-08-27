/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EposSimple.Widgets;

import EposSimple.EposSimpleApp;
import EposSimple.Models.SoldProduct;

/**
 *
 * @author tg
 */
public class ProductBillWidget extends javax.swing.JPanel {

    private EposSimpleApp parentFrame;
    private SoldProduct product;

    /**
     * Creates new form BillPanel
     */
    public ProductBillWidget(EposSimpleApp parentFrame, SoldProduct product) {
        this.parentFrame = parentFrame;
        this.product = product;
        initComponents();
        lblProductName.setIcon(product.getProductIcon(42, 42));
        lblProductName.setText(product.getName());
        setPriceAmount(product.getPrice(), product.getAmountSold());
        pnlEditMode.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblProductName = new javax.swing.JLabel();
        pnlNormalMode = new javax.swing.JPanel();
        lblProductPrice = new javax.swing.JLabel();
        lblProductAmount = new javax.swing.JLabel();
        pnlEditMode = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(275, 53));
        setMinimumSize(new java.awt.Dimension(275, 53));
        setPreferredSize(new java.awt.Dimension(275, 53));
        java.awt.GridBagLayout layout1 = new java.awt.GridBagLayout();
        layout1.columnWeights = new double[] {1.0, 1.0};
        setLayout(layout1);

        lblProductName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProductName.setText("Product Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lblProductName, gridBagConstraints);

        pnlNormalMode.setBackground(new java.awt.Color(255, 255, 255));
        pnlNormalMode.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        pnlNormalMode.setLayout(new java.awt.GridLayout(2, 1));

        lblProductPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProductPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductPrice.setText("Product Price");
        pnlNormalMode.add(lblProductPrice);

        lblProductAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProductAmount.setText("Product Amount");
        lblProductAmount.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        pnlNormalMode.add(lblProductAmount);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(pnlNormalMode, gridBagConstraints);

        pnlEditMode.setBackground(new java.awt.Color(255, 255, 255));
        pnlEditMode.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));
        pnlEditMode.setLayout(new java.awt.GridLayout(1, 2));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-remove-24.png"))); // NOI18N
        btnDelete.setToolTipText("");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlEditMode.add(btnDelete);

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-settings-24.png"))); // NOI18N
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlEditMode.add(btnEdit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(pnlEditMode, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        parentFrame.deleteProductFromBill(this.product, this);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        parentFrame.editProductFromBill(this.product, this);
    }//GEN-LAST:event_btnEditActionPerformed

    public void changeBillWidgetContent(SoldProduct product) {
        this.product = product;
        setPriceAmount(product.getPrice(), product.getAmountSold());
    }

    private void setPriceAmount(double price, int amount) {
        lblProductPrice.setText("£" + price);
        lblProductAmount.setText("x" + amount);
    }

    public void setEditMode() {
        pnlNormalMode.setVisible(false);
        pnlEditMode.setVisible(true);
    }

    public void setNormalMode() {
        pnlEditMode.setVisible(false);
        pnlNormalMode.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel lblProductAmount;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JPanel pnlEditMode;
    private javax.swing.JPanel pnlNormalMode;
    // End of variables declaration//GEN-END:variables
}
