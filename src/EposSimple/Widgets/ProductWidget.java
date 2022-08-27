/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EposSimple.Widgets;

import EposSimple.EposSimpleApp;
import EposSimple.Models.Product;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author tg
 */
public class ProductWidget extends javax.swing.JPanel {

    private Product product;

    /**
     * Creates new form ProductWidgets
     */
    public ProductWidget(EposSimpleApp parentFrame, Product product) {
        initComponents();
        this.product = product;

        btnProduct.setIcon(product.getProductIcon(120, 120));

        btnProduct.setText(product.getName() + " - £" + product.getPrice());
        MouseAdapter redispatcher = new MouseAdapterImpl();
        btnProduct.addMouseListener(redispatcher);
        btnProduct.addMouseMotionListener(redispatcher);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProduct = new javax.swing.JPanel();
        btnProduct = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setRequestFocusEnabled(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnlProduct.setMaximumSize(new java.awt.Dimension(180, 180));
        pnlProduct.setMinimumSize(new java.awt.Dimension(180, 180));
        pnlProduct.setPreferredSize(new java.awt.Dimension(180, 180));
        pnlProduct.setLayout(new java.awt.BorderLayout());

        btnProduct.setBackground(new java.awt.Color(255, 255, 255));
        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/bread.png"))); // NOI18N
        btnProduct.setText("Product Name");
        btnProduct.setBorderPainted(false);
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductMouseClicked(evt);
            }
        });
        pnlProduct.add(btnProduct, java.awt.BorderLayout.CENTER);

        add(pnlProduct);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseClicked
        ((EposSimpleApp) SwingUtilities.getWindowAncestor(this)).askHowManyProductsToAdd(product);
    }//GEN-LAST:event_btnProductMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProduct;
    private javax.swing.JPanel pnlProduct;
    // End of variables declaration//GEN-END:variables

    private class MouseAdapterImpl extends MouseAdapter {

        public MouseAdapterImpl() {
        }

        @Override
        public void mouseEntered(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        @Override
        public void mouseExited(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        @Override
        public void mouseMoved(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        @Override
        public void mousePressed(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        @Override
        public void mouseDragged(MouseEvent evt) {
            dispatchMouseEvent(evt);
        }

        private void dispatchMouseEvent(MouseEvent evt) {
            Container parent = evt.getComponent().getParent().getParent().getParent();
            parent.dispatchEvent(SwingUtilities.convertMouseEvent(evt.getComponent(), evt, parent));
        }
    }
}