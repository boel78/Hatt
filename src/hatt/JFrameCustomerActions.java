/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import hatt.Database;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;

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
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnGet = new javax.swing.JButton();
        cbCustomers = new javax.swing.JComboBox<>();
        txtCustomer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        cbCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(getCBCustomers()));

        txtCustomer.setForeground(new java.awt.Color(0, 0, 0));
        txtCustomer.setText("Kund:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone)
                    .addComponent(lblEmail)
                    .addComponent(txtCustomer))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btnGet))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnAdd)
                        .addGap(78, 78, 78)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnRemove)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnGet)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomer))
                        .addGap(83, 83, 83)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblAddress)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addGap(13, 13, 13)
                .addComponent(btnRemove))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed

       
        String cbContent = cbCustomers.getSelectedItem().toString();
        String numbers = cbContent.replaceAll("^.*\\s(\\d+)$", "$1");
        
        String customerID = numbers;
        System.out.println(numbers);
        
        fetchedID = numbers;

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
        String customerID = fetchedID;
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        if (Validation.doesEmailExist(email) && Validation.txtHasValue(txtAddress) && Validation.validateAddress(address)) {
            if (Validation.txtHasValue(txtName) && (Validation.txtHasValue(txtEmail)) && (Validation.txtHasValue(txtPhone))) {
                actions = new CustomerActions(customerID, name, address, phone, email);

                actions.addCustomer(name, address, phone, email);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String customerID = fetchedID;

        actions = new CustomerActions(customerID);

        if ( Validation.existsCustomerID(customerID)) {
            if (actions.removeCustomer(customerID)) {

                
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

        String customerID = fetchedID;
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
    }

        public String[] getCBCustomers() {
        ArrayList<String> CBAL = new ArrayList<>();
        ArrayList<String> cid = new ArrayList<>();
        cid = Database.fetchColumn(false, "cid", "customer", "", "");

       
            for (String s : cid) {
                CBAL.add(Database.fetchSingle("name","customer","cid",s)+ " " + s);
                
            }
        System.out.println(CBAL);
        

        String[] CBCustomersx = new String[CBAL.size()];
        CBAL.toArray(CBCustomersx);

        return CBCustomersx;
    
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCustomers;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JLabel txtCustomer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
