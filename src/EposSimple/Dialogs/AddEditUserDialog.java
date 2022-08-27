/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EposSimple.Dialogs;

import EposSimple.EposSimpleApp;
import EposSimple.Models.Product;
import EposSimple.Models.User;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

/**
 *
 * @author tg
 */
public class AddEditUserDialog extends JDialog {

    private final EposSimpleApp parentFrame;
    private User user;
    private String editMode; // = "edit" OR "add"

    /**
     * Creates new form ProductAmount
     *
     * @param parentFrame
     * @param product
     */
    public AddEditUserDialog(EposSimpleApp parentFrame){
        this.parentFrame = parentFrame;;
        
        initComponents();
        
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        lblDialogTitle.setText("Add New User");
        this.editMode = "add";
    }
    
    public AddEditUserDialog(EposSimpleApp parentFrame, User user) {
        this.user = user;
        this.parentFrame = parentFrame;;
        
        initComponents();
        
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        
        txtUsername.setText(user.getLogin());
        if(user.getRole() == 1){
            togRole.setSelected(false);
        }else{
            togRole.setSelected(true);            
        }            
        this.editMode = "edit";
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(720, 278);
    }

    private boolean tryParseInt(String string){
        try{
            Integer.parseInt(string);
            return true;
        }catch(NumberFormatException en){
            return false;
        }
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

        jPanel1 = new javax.swing.JPanel();
        lblDialogTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblNewPin = new javax.swing.JLabel();
        txtNewPin = new javax.swing.JTextField();
        lblConfirmPin = new javax.swing.JLabel();
        txtConfirmPin = new javax.swing.JTextField();
        lblUserRole = new javax.swing.JLabel();
        togRole = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(720, 278));
        setMinimumSize(new java.awt.Dimension(720, 278));
        setModal(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(720, 278));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDialogTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDialogTitle.setText("Edit user");
        jPanel1.add(lblDialogTitle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("Username:");
        lblUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        jPanel2.add(lblUsername, gridBagConstraints);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txtUsername, gridBagConstraints);

        lblNewPin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNewPin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNewPin.setText("New PIN (leave empty if not changing):");
        lblNewPin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        jPanel2.add(lblNewPin, gridBagConstraints);

        txtNewPin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNewPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNewPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNewPin.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txtNewPin, gridBagConstraints);

        lblConfirmPin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblConfirmPin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConfirmPin.setText("Confirm PIN:");
        lblConfirmPin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        jPanel2.add(lblConfirmPin, gridBagConstraints);

        txtConfirmPin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtConfirmPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtConfirmPin.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txtConfirmPin, gridBagConstraints);

        lblUserRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUserRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserRole.setText("User role:");
        lblUserRole.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        jPanel2.add(lblUserRole, gridBagConstraints);

        togRole.setBackground(new java.awt.Color(255, 255, 255));
        togRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        togRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cancel-20.png"))); // NOI18N
        togRole.setText("Is not a Manager");
        togRole.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        togRole.setBorderPainted(false);
        togRole.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-ok-20.png"))); // NOI18N
        togRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togRoleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(togRole, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 1, 1, 1));

        btnCancel.setBackground(new java.awt.Color(250, 250, 250));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel);

        btnConfirm.setBackground(new java.awt.Color(250, 250, 250));
        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConfirm.setText("CONFIRM");
        btnConfirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnConfirm.setBorderPainted(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jPanel3.add(btnConfirm);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        txtNewPin.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        if(editMode.equals("edit")){
            boolean validationOk = true;
            if(!user.getLogin().equals(txtUsername.getText()) && !txtUsername.getText().isBlank()){
                user.setLogin(txtUsername.getText());
            }else if(txtUsername.getText().isBlank()){
                txtUsername.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                validationOk = false;
            }
            
            if(txtNewPin.getText().equals(txtConfirmPin.getText()) && !txtNewPin.getText().isBlank() && tryParseInt(txtNewPin.getText())){
                user.setPin(Integer.parseInt(txtNewPin.getText()));
            }else if(!txtNewPin.getText().equals(txtConfirmPin.getText()) || tryParseInt(txtNewPin.getText())){
                txtNewPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                validationOk = false;
            }
            
            if(togRole.isSelected()){
                user.setRole(0);
            }else{
                user.setRole(1);
            }            
            if(validationOk){
                parentFrame.editUser(user);
                this.dispose();
            }
        }else if(editMode.equals("add")){
            boolean validationOk = true;
            if(txtUsername.getText().isBlank()){
                validationOk = false;
            }
            if(txtNewPin.getText().equals(txtConfirmPin.getText())){
                validationOk = false;
            }
            if(tryParseInt(txtNewPin.getText())){
                validationOk = false;
            }
            if(validationOk){
                user = new User(txtUsername.getText(), Integer.parseInt(txtNewPin.getText()), (togRole.isSelected())? 0 : 1); 
                parentFrame.addUser(user);
                this.dispose();
            }
            
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void togRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togRoleActionPerformed
        if(togRole.isSelected()){
            togRole.setText("Is a Manager");
        }else{
            togRole.setText("Is not a Manager");
        }
    }//GEN-LAST:event_togRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblConfirmPin;
    private javax.swing.JLabel lblDialogTitle;
    private javax.swing.JLabel lblNewPin;
    private javax.swing.JLabel lblUserRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JToggleButton togRole;
    private javax.swing.JTextField txtConfirmPin;
    private javax.swing.JTextField txtNewPin;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}