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
 * @author Alex & Carl
 */
public class JFrameCustomerActions extends javax.swing.JFrame {

    private String fetchedID;
    private String fetchedOrgNr;
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
        lblKund = new javax.swing.JLabel();
        txtOrgNumber = new javax.swing.JTextField();
        txtComment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setText("Namn:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        lblAddress.setText("Adress:");
        getContentPane().add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lblPhone.setText("Tel. Nr:");
        getContentPane().add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblEmail.setText("Epost:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        txtName.setColumns(10);
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        txtAddress.setColumns(10);
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        txtPhone.setColumns(10);
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        txtEmail.setColumns(10);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        btnAdd.setText("Lägg Till");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        btnUpdate.setText("Uppdatera");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        btnRemove.setForeground(new java.awt.Color(255, 51, 51));
        btnRemove.setText("Ta Bort");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        btnGet.setText("Hämta");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });
        getContentPane().add(btnGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        cbCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(getCBCustomers()));
        getContentPane().add(cbCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        txtCustomer.setText("Organisations Nr:");
        getContentPane().add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblKund.setText("Kund:");
        getContentPane().add(lblKund, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtOrgNumber.setColumns(10);
        getContentPane().add(txtOrgNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 70, -1));
        getContentPane().add(txtComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 430, 130));

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
        String fetchedOrgNumber = actions.getOrgNumber(customerID);

        String name = ""; //Database: customer/name
        String address = ""; //Database: customer/address
        String phone = ""; //Database: customer/phone
        String email = ""; //Database: customer/email
        String orgNumber = ""; //Database: customer/orgNumber
        String commentField = "";

        if (customer != null && !customer.isEmpty()) {
            name = customer.get("name");
            address = customer.get("address");
            phone = customer.get("phone");
            email = customer.get("email");
            orgNumber = customer.get("otgNumber");
            commentField = customer.get("comment"); 

            txtName.setText(name != null ? name : "");
            txtAddress.setText(address != null ? address : "");
            txtPhone.setText(phone != null ? phone : "");
            txtEmail.setText(email != null ? email : "");
            txtOrgNumber.setText(fetchedOrgNumber);
            txtComment.setText(commentField);
            System.out.println("test lyckats " + name + " " + address + " " + phone + " " + email + " " + fetchedOrgNumber);

            fetchedOrgNr = txtOrgNumber.getText();
            System.out.println("fetchedOrgNr: " + fetchedOrgNr);
            System.out.println("fetchedID: " + fetchedID);
        } else {
            // Kund inte hittad, rensa textfälten eller visa ett felmeddelande
            txtName.setText("");
            txtAddress.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            txtOrgNumber.setText("");
            txtComment.setText("");

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
        String orgNumber = txtOrgNumber.getText();

            if ((Validation.validateOrgNumber(orgNumber) || orgNumber.equals("")) &&
                    Validation.txtHasValue(txtName) &&
                    Validation.txtHasValue(txtEmail) &&
                    Validation.txtHasValue(txtPhone) &&
                    Validation.doesEmailExist(email) &&
                    Validation.validateAddress(address)) {
                actions = new CustomerActions(customerID, name, address, phone, email, orgNumber);

                actions.addCustomer(name, address, phone, email, orgNumber);
                String fetchedOrgNumber = actions.getOrgNumber(customerID);
                txtOrgNumber.setText(fetchedOrgNumber);
                System.out.println("fetchedOrgNr: " + fetchedOrgNr);
                System.out.println("fetchedID: " + fetchedID);


                //Resettar combobox
                cbCustomers.removeAllItems();
                String[] customers = getCBCustomers();
                for (String customer : customers) {
                    cbCustomers.addItem(customer);
                }

                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtOrgNumber.setText("");
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String customerID = fetchedID;

        actions = new CustomerActions(customerID);

        if (Validation.existsCustomerID(customerID)) {
            if (actions.removeCustomer(customerID)) {

                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtOrgNumber.setText("");

                //Resettar combobox
                cbCustomers.removeAllItems();
                String[] customers = getCBCustomers();
                for (String customer : customers) {
                    cbCustomers.addItem(customer);
                }
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
        String orgNr = txtOrgNumber.getText();

        if (!fetchedID.isEmpty()) {
            if (Validation.existsCustomerID(fetchedID) && Validation.validateName(name) && Validation.validateAddress(address) && Validation.validateEmailTypo(email) && Validation.validatePhone(phone)) {
                actions = new CustomerActions(customerID);


                actions.updateCustomer(fetchedID, name, address, phone, email, orgNr, fetchedOrgNr);
                System.out.println("if i btnUpdate");
                //Resettar combobox
                cbCustomers.removeAllItems();
                String[] customers = getCBCustomers();
                for (String customer : customers) {
                    cbCustomers.addItem(customer);
                }
                fetchedOrgNr = txtOrgNumber.getText();
                txtName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtOrgNumber.setText("");
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
            CBAL.add(Database.fetchSingle("name", "customer", "cid", s) + " " + s);

        }
        System.out.println(CBAL);

        String[] CBCustomersx = new String[CBAL.size()];
        CBAL.toArray(CBCustomersx);

        return CBCustomersx;

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtOrgNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrgNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrgNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGet;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCustomers;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblKund;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtComment;
    private javax.swing.JLabel txtCustomer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrgNumber;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
