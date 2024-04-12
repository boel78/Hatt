/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author joelnorling
 */
public class CreateOrderExistingCustomer extends javax.swing.JFrame {
    
    private String uid;

    public CreateOrderExistingCustomer(String uid) {
        this.uid = uid;
        initComponents();
        fillCobCustomers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblCustomerInfo = new javax.swing.JLabel();
        lblOrderInfo = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfFabric2 = new javax.swing.JTextField();
        tfFabric4 = new javax.swing.JTextField();
        tfFabric3 = new javax.swing.JTextField();
        tfFabric1 = new javax.swing.JTextField();
        lblMaterial = new javax.swing.JLabel();
        tfAccessories3 = new javax.swing.JTextField();
        tfAccessories1 = new javax.swing.JTextField();
        tfAccessories2 = new javax.swing.JTextField();
        tfAccessories4 = new javax.swing.JTextField();
        tfSize3 = new javax.swing.JTextField();
        tfSize1 = new javax.swing.JTextField();
        lblSize = new javax.swing.JLabel();
        tfAmount3 = new javax.swing.JTextField();
        tfAmount1 = new javax.swing.JTextField();
        tfAmount2 = new javax.swing.JTextField();
        tfAmount4 = new javax.swing.JTextField();
        tfSize2 = new javax.swing.JTextField();
        tfSize4 = new javax.swing.JTextField();
        tfEstimatedTime = new javax.swing.JTextField();
        lblEstimatedTime = new javax.swing.JLabel();
        lblAccessories = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        cobCustomers = new javax.swing.JComboBox<>();
        lblCustomers = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        lblStar = new javax.swing.JLabel();
        lblMandatory = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfName.setEditable(false);

        lblName.setText("Namn");

        lblAddress.setText("Adress");

        tfAddress.setEditable(false);

        lblEmail.setText("Epost");

        tfEmail.setEditable(false);

        tfPhone.setEditable(false);

        lblPhone.setText("Telefonnummer");

        lblCustomerInfo.setText("Kundinfo");

        lblOrderInfo.setText("Beställningsinfo");

        lblDescription.setText("Beskrivning*");

        lblMaterial.setText("Tyg");

        lblSize.setText("Storlek (cm2)");

        lblEstimatedTime.setText("Estimerad tid*");

        lblAccessories.setText("Accessoarer");

        lblAmount.setText("Antal (st)");

        cobCustomers.setEditable(true);
        cobCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobCustomersActionPerformed(evt);
            }
        });

        lblCustomers.setText("Befintlig kund");

        btnConfirm.setText("Bekräfta order");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblStar.setText("*");

        lblMandatory.setText("* är obligatoriska fält");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblCustomerInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblCustomers))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cobCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMandatory)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblPhone)
                                .addComponent(lblEmail)
                                .addComponent(lblAddress)
                                .addComponent(lblName)
                                .addComponent(tfAddress)
                                .addComponent(tfEmail)
                                .addComponent(tfName)
                                .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblOrderInfo)
                        .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEstimatedTime)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfAccessories1)
                                        .addComponent(tfAccessories2)
                                        .addComponent(tfAccessories3)
                                        .addComponent(tfAccessories4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAccessories)
                                    .addGap(60, 60, 60)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAmount)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfAmount3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(tfAmount2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(tfAmount1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(tfAmount4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblMaterial)
                                .addComponent(tfFabric1)
                                .addComponent(tfFabric2)
                                .addComponent(tfFabric3)
                                .addComponent(tfFabric4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSize)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfSize4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(tfSize3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(tfSize2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(tfSize1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblStar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(tfEstimatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnConfirm)
                            .addGap(42, 42, 42)))
                    .addComponent(lblDescription))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCustomerInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCustomers)
                        .addGap(5, 5, 5)
                        .addComponent(cobCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrderInfo)
                        .addGap(40, 40, 40)
                        .addComponent(lblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstimatedTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEstimatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAccessories)
                                    .addComponent(lblAmount))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(tfAmount4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfAccessories1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAccessories2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAccessories3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(tfAccessories4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblSize)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfSize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfSize2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfSize3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29))
                                .addComponent(tfSize4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblMaterial)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfFabric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfFabric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfFabric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29))
                                .addComponent(tfFabric4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirm)
                    .addComponent(lblMandatory))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Returns the value in the combobox and makes it into a string
    private String getCustomerEmail() {
        return cobCustomers.getSelectedItem().toString();
    }

    private void cobCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobCustomersActionPerformed

        //Fills the textfields with information about the chosen customer
        String customerEmail = getCustomerEmail();

        String name = Database.fetchSingle("name", "customer", "Email", customerEmail);
        String address = Database.fetchSingle("address", "customer", "Email", customerEmail);
        String phone = Database.fetchSingle("phone", "customer", "Email", customerEmail);

        tfName.setText(name);
        tfAddress.setText(address);
        tfPhone.setText(phone);
        tfEmail.setText(customerEmail);
    }//GEN-LAST:event_cobCustomersActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        ArrayList<String> fabrics = getFabricsTf();
        ArrayList<String> accessories = getAccessoriesTf();
        if (Validation.hasValueMandatory(tfName) && Validation.hasValueMandatory(tfDescription) && Validation.hasValueMandatory(tfEstimatedTime) && Validation.hasValueMandatory(tfFabric1) && Validation.hasValueTwoFields(tfAccessories1, tfAmount1) && Validation.hasValueTwoFields(tfAccessories2, tfAmount2) && Validation.hasValueTwoFields(tfAccessories3, tfAmount3) && Validation.hasValueTwoFields(tfAccessories4, tfAmount4) && Validation.hasValueTwoFields(tfFabric1, tfSize1) && Validation.hasValueTwoFields(tfFabric2, tfSize2) && Validation.hasValueTwoFields(tfFabric3, tfSize3) && Validation.hasValueTwoFields(tfFabric4, tfSize4)) {
            if (Validation.fabricValidation(fabrics) && Validation.accessoryValidation(accessories) && Validation.isDoubleErrorMessage(tfEstimatedTime) && Validation.validateDescription(tfDescription) && Validation.isDoubleIfNotEmpty(tfAmount1) && Validation.isDoubleIfNotEmpty(tfAmount2) && Validation.isDoubleIfNotEmpty(tfAmount3) && Validation.isDoubleIfNotEmpty(tfAmount4) && Validation.isDoubleIfNotEmpty(tfSize1) && Validation.isDoubleIfNotEmpty(tfSize2) && Validation.isDoubleIfNotEmpty(tfSize3) && Validation.isDoubleIfNotEmpty(tfSize4)) {

                //Fetches the customer info based on the choice in the combobox
                String customerEmail = getCustomerEmail();
                String customerID = Database.fetchSingle("cid", "customer", "Email", customerEmail);

                //Fetches the description and time for ordering a hat
                String description = tfDescription.getText();
                double estimatedTime = Double.parseDouble(tfEstimatedTime.getText());

                //Creates a new orderID
                String orderID = Database.getAutoIncrement("xOrder", "oid");

                //Creates the order
                String orderColumns = "(oid, description, estimated_time, created_by, customer)";
                String ordeValues = "(" + orderID + ",'" + description + "'," + estimatedTime + "," + uid + "," + customerID + ")";
                Database.insert("xorder", orderColumns, ordeValues);

                //Fetches the fabrics and accessories
                HashMap<String, String> accessoriesAmounts = getAccessoriesWithAmount();
                HashMap<String, String> fabricSizes = getFabricsWithSize();

                //Loops trough the fabrics
                for (String fabricMaterials : fabricSizes.keySet()) {
                    String fabricMid = Database.fetchSingle("mid", "materials", "name", fabricMaterials);
                    String fabricAmount = fabricSizes.get(fabricMaterials);

                    //Adds the orderID, materialID and the amount to "order_consists_of_materials"
                    String consistsOfColumns = "(oid, mid, amount)";
                    String cosistsOfValues = "(" + orderID + "," + fabricMid + "," + fabricAmount + ")";
                    Database.insert("order_consists_of_materials", consistsOfColumns, cosistsOfValues);
                }

                //Loops trough the accessories
                for (String accessoriesMaterials : accessoriesAmounts.keySet()) {
                    String accessoriesMid = Database.fetchSingle("mid", "materials", "name", accessoriesMaterials);
                    String accessoriesAmount = accessoriesAmounts.get(accessoriesMaterials);

                    //Adds the orderID, materialID and the amount to "order_consists_of_materials"
                    String consistsOfColumns = "(oid, mid, amount)";
                    String cosistsOfValues = "(" + orderID + "," + accessoriesMid + "," + accessoriesAmount + ")";
                    Database.insert("order_consists_of_materials", consistsOfColumns, cosistsOfValues);
                }
                JOptionPane.showMessageDialog(null, "Ny beställning skapad!");
            }
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    //Method that fetches the accessories fields and connects them with an amount in a hashMap
    private HashMap<String, String> getAccessoriesWithAmount() {
        ArrayList<JTextField> tfAccessories = new ArrayList<>();
        tfAccessories.add(tfAccessories1);
        tfAccessories.add(tfAccessories2);
        tfAccessories.add(tfAccessories3);
        tfAccessories.add(tfAccessories4);

        ArrayList<JTextField> tfAmounts = new ArrayList<>();
        tfAmounts.add(tfAmount1);
        tfAmounts.add(tfAmount2);
        tfAmounts.add(tfAmount3);
        tfAmounts.add(tfAmount4);

        HashMap<String, String> accessoriesWithAmount = new HashMap<>();

        for (int i = 0; i < tfAccessories.size(); i++) {

            String fabric = tfAccessories.get(i).getText();
            String size = tfAmounts.get(i).getText();

            if (!fabric.isEmpty() && !size.isEmpty()) {
                accessoriesWithAmount.put(fabric, size);
            }
        }
        return accessoriesWithAmount;
    }

    //Method that fetches the fabric fields and connects them with an amount in a hashMap
    private HashMap<String, String> getFabricsWithSize() {
        ArrayList<JTextField> tfFabrics = new ArrayList<>();
        tfFabrics.add(tfFabric1);
        tfFabrics.add(tfFabric2);
        tfFabrics.add(tfFabric3);
        tfFabrics.add(tfFabric4);

        ArrayList<JTextField> tfSizes = new ArrayList<>();
        tfSizes.add(tfSize1);
        tfSizes.add(tfSize2);
        tfSizes.add(tfSize3);
        tfSizes.add(tfSize4);

        HashMap<String, String> fabricsWithSize = new HashMap<>();

        for (int i = 0; i < tfFabrics.size(); i++) {

            String fabric = tfFabrics.get(i).getText();
            String size = tfSizes.get(i).getText();

            if (!fabric.isEmpty() && !size.isEmpty()) {
                fabricsWithSize.put(fabric, size);
            }
        }
        return fabricsWithSize;
    }

    //Fills the comboBox with the existing customers
    private void fillCobCustomers() {
        cobCustomers.addItem("");
        ArrayList<String> emails;
        emails = Database.fetchColumn(false, "email", "customer", "", "");
        for (String email : emails) {
            cobCustomers.addItem(email);
        }
    }

    private ArrayList<String> getFabricsTf() {
        ArrayList<String> allFabrics = new ArrayList<>();
        ArrayList<String> fabricsWithValue = new ArrayList<>();
        allFabrics.add(tfFabric1.getText());
        allFabrics.add(tfFabric2.getText());
        allFabrics.add(tfFabric3.getText());
        allFabrics.add(tfFabric4.getText());

        for (String fabric : allFabrics) {
            if (!fabric.isEmpty()) {
                fabricsWithValue.add(fabric);
            }
        }

        return fabricsWithValue;
    }

    private ArrayList<String> getAccessoriesTf() {
        ArrayList<String> accessories = new ArrayList<>();
        ArrayList<String> accessoriesWithValue = new ArrayList<>();
        accessories.add(tfAccessories1.getText());
        accessories.add(tfAccessories2.getText());
        accessories.add(tfAccessories3.getText());
        accessories.add(tfAccessories4.getText());

        for (String accessory : accessories) {
            if (!accessory.isEmpty()) {
                accessoriesWithValue.add(accessory);
            }
        }

        return accessoriesWithValue;
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateOrderExistingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateOrderExistingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateOrderExistingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateOrderExistingCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox<String> cobCustomers;
    private javax.swing.JLabel lblAccessories;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCustomerInfo;
    private javax.swing.JLabel lblCustomers;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstimatedTime;
    private javax.swing.JLabel lblMandatory;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrderInfo;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblStar;
    private javax.swing.JTextField tfAccessories1;
    private javax.swing.JTextField tfAccessories2;
    private javax.swing.JTextField tfAccessories3;
    private javax.swing.JTextField tfAccessories4;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfAmount1;
    private javax.swing.JTextField tfAmount2;
    private javax.swing.JTextField tfAmount3;
    private javax.swing.JTextField tfAmount4;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEstimatedTime;
    private javax.swing.JTextField tfFabric1;
    private javax.swing.JTextField tfFabric2;
    private javax.swing.JTextField tfFabric3;
    private javax.swing.JTextField tfFabric4;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfSize1;
    private javax.swing.JTextField tfSize2;
    private javax.swing.JTextField tfSize3;
    private javax.swing.JTextField tfSize4;
    // End of variables declaration//GEN-END:variables
}