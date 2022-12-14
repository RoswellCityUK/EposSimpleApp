/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EposSimple.Panels;

import EposSimple.Widgets.ProductWidget;
import EposSimple.Widgets.ProductBillWidget;
import EposSimple.EposSimpleApp;
import EposSimple.Helpers.*;
import EposSimple.Models.*;
import EposSimple.Widgets.NotificationWidget;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tg
 */
public class SalesDashboard extends javax.swing.JPanel {

    User loggedUser;
    EposSimpleApp parentFrame;
    NotificationWidget notification;
    ExecutorService sTE = Executors.newSingleThreadExecutor();
    ArrayList<Product> offer;

    /**
     * Creates new form SalesDashboard
     *
     * @param parentFrame
     * @param loggedUser
     * @param offer
     */
    public SalesDashboard(EposSimpleApp parentFrame, User loggedUser, ArrayList<Product> offer) {
        this.loggedUser = loggedUser;
        this.parentFrame = parentFrame;
        this.offer = offer;
        initComponents();
        for (Product product : offer) {
            pnlProducts.add(new ProductWidget(parentFrame, product));
        }
        pnlConfirmation.setSize(pnlButtons.getSize());

        DragScrollListener listener = new DragScrollListener(pnlProducts);
        pnlProducts.addMouseListener(listener);
        pnlProducts.addMouseMotionListener(listener);

        DragScrollListener listener2 = new DragScrollListener(pnlBill);
        pnlBill.addMouseListener(listener2);
        pnlBill.addMouseMotionListener(listener2);

        notification = new NotificationWidget(parentFrame, 0.00);
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

        pnlConfirmation = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        sclProducts = new CustomScrollPane();
        pnlProducts = new javax.swing.JPanel();
        sclBill = new CustomScrollPane();
        pnlBill = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        btnCharge = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        pnlConfirmation.setBackground(new java.awt.Color(255, 255, 255));
        pnlConfirmation.setMaximumSize(new java.awt.Dimension(227, 29));
        pnlConfirmation.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-20.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlConfirmation.add(btnCancel);

        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-ok-20.png"))); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.setBorderPainted(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlConfirmation.add(btnConfirm);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        setMaximumSize(new java.awt.Dimension(1260, 626));
        setMinimumSize(new java.awt.Dimension(1260, 626));
        setPreferredSize(new java.awt.Dimension(1260, 626));
        setLayout(new java.awt.GridBagLayout());

        sclProducts.setBackground(new java.awt.Color(255, 255, 255));
        sclProducts.setBorder(null);
        sclProducts.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sclProducts.setMaximumSize(new java.awt.Dimension(940, 604));
        sclProducts.setMinimumSize(new java.awt.Dimension(940, 604));
        sclProducts.setPreferredSize(new java.awt.Dimension(940, 604));

        pnlProducts.setBackground(new java.awt.Color(255, 255, 255));
        pnlProducts.setLayout(new java.awt.GridLayout(0, 3, 15, 30));
        pnlProducts.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EmptyBorder(0, 0, 0, 0)));
        sclProducts.setViewportView(pnlProducts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 5, 0);
        add(sclProducts, gridBagConstraints);

        sclBill.setBackground(new java.awt.Color(255, 255, 255));
        sclBill.setBorder(null);
        sclBill.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sclBill.setMaximumSize(new java.awt.Dimension(294, 513));
        sclBill.setMinimumSize(new java.awt.Dimension(294, 513));
        sclBill.setName(""); // NOI18N
        sclBill.setPreferredSize(new java.awt.Dimension(294, 513));

        pnlBill.setBackground(new java.awt.Color(255, 255, 255));
        pnlBill.setMaximumSize(new java.awt.Dimension(294, 3965555));
        pnlBill.setMinimumSize(new java.awt.Dimension(294, 0));
        pnlBill.setLayout(new javax.swing.BoxLayout(pnlBill, javax.swing.BoxLayout.Y_AXIS));
        sclBill.setViewportView(pnlBill);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 10);
        add(sclBill, gridBagConstraints);

        pnlActions.setBackground(new java.awt.Color(255, 255, 255));
        pnlActions.setInheritsPopupMenu(true);
        pnlActions.setMaximumSize(new java.awt.Dimension(294, 91));
        pnlActions.setMinimumSize(new java.awt.Dimension(294, 91));
        pnlActions.setPreferredSize(new java.awt.Dimension(294, 91));
        pnlActions.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        btnCharge.setBackground(java.awt.SystemColor.textHighlight);
        btnCharge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCharge.setForeground(new java.awt.Color(255, 255, 255));
        btnCharge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-credit-card-cash-withdrawal-28.png"))); // NOI18N
        btnCharge.setText("Charge");
        btnCharge.setBorderPainted(false);
        btnCharge.setEnabled(false);
        btnCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeActionPerformed(evt);
            }
        });
        pnlActions.add(btnCharge);

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));
        pnlButtons.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlButtons.add(btnEdit);

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setText("CLEAR BILL");
        btnReset.setBorderPainted(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlButtons.add(btnReset);

        pnlActions.add(pnlButtons);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 5, 10);
        add(pnlActions, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeActionPerformed

        double total = ((EposSimpleApp) SwingUtilities.getWindowAncestor(this)).printBill();
        Runnable fetchFromDatabase;
        fetchFromDatabase = () -> {
            try {
                notification.updateTotal(total);
                pnlBill.revalidate();
                pnlBill.repaint();
                pnlBill.add(notification, 0);
                Thread.sleep(1000);
                pnlBill.remove(notification);
                pnlBill.revalidate();
                pnlBill.repaint();
            } catch (InterruptedException en) {

            }
        };
        sTE.execute(fetchFromDatabase);

    }//GEN-LAST:event_btnChargeActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ((EposSimpleApp) SwingUtilities.getWindowAncestor(this)).toggleEditMode();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        pnlActions.add(pnlConfirmation);
        pnlActions.remove(pnlButtons);
        pnlActions.validate();
        pnlActions.repaint();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        pnlActions.add(pnlButtons);
        pnlActions.remove(pnlConfirmation);
        pnlActions.validate();
        pnlActions.repaint();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        ((EposSimpleApp) SwingUtilities.getWindowAncestor(this)).resetBill();
        pnlActions.remove(pnlConfirmation);
        pnlActions.add(pnlButtons);
        pnlActions.validate();
        pnlActions.repaint();
    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCharge;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlBill;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlConfirmation;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JScrollPane sclBill;
    private javax.swing.JScrollPane sclProducts;
    // End of variables declaration//GEN-END:variables

    public void addBillPanel(ProductBillWidget widget) {
        pnlBill.add(widget);
    }

    public void removeBillWidget(ProductBillWidget widget) {
        pnlBill.remove(widget);
        pnlBill.validate();
        pnlBill.repaint();
        parentFrame.pack();
    }

    public void refreshBillTotal(ArrayList<SoldProduct> bill) {

        if (bill.isEmpty()) {
            btnCharge.setText("Charge");
            btnCharge.setEnabled(false);
        } else {
            double billTotal = 0;
            for (SoldProduct product : bill) {
                billTotal += product.getPrice() * product.getAmountSold();
            }
            NumberFormat formatter = new DecimalFormat("#0.00");
            btnCharge.setText("Charge ??" + formatter.format(billTotal));
            btnCharge.setEnabled(true);
        }
    }
    
    public void refreshProducts(){
        pnlProducts.removeAll();
        for (Product product : this.offer) {
            pnlProducts.add(new ProductWidget(parentFrame, product));
        }
    }

    public void resetBill() {
        pnlBill.removeAll();
        pnlBill.validate();
        pnlBill.repaint();
        parentFrame.pack();
    }
}
