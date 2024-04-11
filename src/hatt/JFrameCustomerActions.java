/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author calletegerup
 */
public class JFrameCustomerActions extends javax.swing.JFrame {

    private String fetchedID;
    private CustomerActions actions;

    public JFrameCustomerActions() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        lblCustomerID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnGet = new javax.swing.JButton();
        txtOrgNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        lblCustomerID.setForeground(new java.awt.Color(0, 0, 0));
        lblCustomerID.setText("Kund ID:");

        lblName.setForeground(new java.awt.Color(0, 0, 0));
        lblName.setText("Namn:");

        lblAddress.setForeground(new java.awt.Color(0, 0, 0));
        lblAddress.setText("Adress:");

        lblPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblPhone.setText("Tel. Nr:");

        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Epost:");

        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setText("Lägg Till");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Uppdatera");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setForeground(new java.awt.Color(255, 51, 51));
        btnRemove.setText("Ta Bort");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnGet.setForeground(new java.awt.Color(0, 0, 0));
        btnGet.setText("Hämta");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });

        txtOrgNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrgNumberActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Organisations Nr:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblPhone)
                        .addGap(28, 28, 28)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnAdd)
                        .addGap(78, 78, 78)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress)
                                .addGap(25, 25, 25)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblEmail)
                        .addGap(32, 32, 32)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCustomerID)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(btnGet))
                            .addComponent(txtOrgNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerID)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOrgNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addGap(13, 13, 13)
                .addComponent(btnRemove))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed

        String customerID = txtCustomerID.getText();
        fetchedID = txtCustomerID.getText();

        actions = new CustomerActions(customerID);

        HashMap<String, String> customer = actions.getCustomer(customerID);

        String name = ""; //Database: customer/name
        String address = ""; //Database: customer/address
        String phone = ""; //Database: customer/phone
        String email = ""; //Database: customer/email

        if (customer != null && !customer.isEmpty()) {
            name = customer.get("name");
            address = customer.get("address");
            phone = customer.get("phone");
            email = customer.get("email");

            txtName.setText(name != null ? name : "");
            txtAddress.setText(address != null ? address : "");
            txtPhone.setText(phone != null ? phone : "");
            txtEmail.setText(email != null ? email : "");
            System.out.println("test lyckats " + name + " " + address + " " + phone + " " + email);
        } else {
            // Kund inte hittad, rensa textfälten eller visa ett felmeddelande
            txtName.setText("");
            txtAddress.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            System.out.println("test lyckades inte " + name + " " + address + " " + phone + " " + email);
            JOptionPane.showMessageDialog(null, "Det gick inte att hitta kunden. Kontrollera uppgifterna.");
        }
    }//GEN-LAST:event_btnGetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String customerID = txtCustomerID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String orgNumber = txtOrgNumber.getText();

        if (Validation.txtHasValue(txtAddress) && Validation.validateAddress(address)) {
            if (Validation.txtHasValue(txtName) && (Validation.txtHasValue(txtEmail)) && (Validation.txtHasValue(txtPhone))) {
                actions = new CustomerActions(customerID, name, address, phone, email);

                actions.addCustomer(name, address, phone, email);
                
                if(txtOrgNumber.getText() != null) {
                    if(Validation.validateOrgNumber(orgNumber)){
                        
                    }   else {
                        JOptionPane.showMessageDialog(null, "Fel format på organisationsnummer.\nRegistrera kund som privatperson eller se över det inskrivna organisationsnummer.\n(XXXXXX-XXXX)");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String customerID = txtCustomerID.getText();

        actions = new CustomerActions(customerID);

        if (Validation.txtHasValue(txtCustomerID) && Validation.existsCustomerID(customerID)) {
            if (actions.removeCustomer(customerID)) {

                txtCustomerID.setText("");
                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Kunde inte ta bort kunden.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kunde inte ta bort kunden.");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String customerID = txtCustomerID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();

        if (!fetchedID.isEmpty()) {
            if (Validation.existsCustomerID(fetchedID) && Validation.validateName(name) && Validation.validateAddress(address) && Validation.validateEmailTypo(email) && Validation.validatePhone(phone)) {
                actions = new CustomerActions(customerID);

                actions.updateCustomer(fetchedID, name, address, phone, email);
                System.out.println("if i btnUpdate");
            } else {

                System.out.println("else i btnUpdate");
                JOptionPane.showMessageDialog(null, "Något gick fel.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hämta kunden du vill ändra först.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtOrgNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrgNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrgNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrgNumber;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
