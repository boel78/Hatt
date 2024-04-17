/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author danagliana
 */
public class RegisterMaterial extends javax.swing.JFrame {

    private InfDB idb;
    private String userID;
    private Validation validation;
    private Database db;

    /**
     * Creates new form RegisterProduct
     */
    public RegisterMaterial() {
        userID = "1";
        new Validation();
        new Database();
        initComponents();
        fillMaterials();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        txtNewPrice = new javax.swing.JTextField();
        txtExistingName = new javax.swing.JTextField();
        txtNewName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtExistingPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbExistingMaterials = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbNewMaterialType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtExistingMaterial = new javax.swing.JTextField();
        lblExistingMaterial = new javax.swing.JLabel();
        lblNewMaterial = new javax.swing.JLabel();
        txtNewMaterial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegister.setText("Registrera");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtNewPrice.setColumns(10);

        txtExistingName.setColumns(10);

        txtNewName.setColumns(10);

        jLabel1.setText("Namn");

        jLabel2.setText("Pris");

        jLabel3.setText("Namn");

        txtExistingPrice.setColumns(10);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Registrera Material");

        jLabel5.setText("Pris");

        cbExistingMaterials.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbExistingMaterialsItemStateChanged(evt);
            }
        });

        jLabel7.setText("Uppdatera Material");

        cbNewMaterialType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accesoar", "Tyg" }));

        jLabel8.setText("Material typ:");

        btnUpdate.setText("Uppdatera");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtExistingMaterial.setColumns(9);

        lblExistingMaterial.setText("Mängd");

        lblNewMaterial.setText("Mängd");

        txtNewMaterial.setColumns(9);

        jLabel6.setText("Nytt Material");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbExistingMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblExistingMaterial)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExistingMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtExistingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtExistingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNewMaterial)
                        .addGap(23, 23, 23)
                        .addComponent(txtNewMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNewMaterialType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbExistingMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtExistingMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblExistingMaterial)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtExistingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtExistingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(btnUpdate))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNewMaterialType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewMaterial))
                        .addGap(51, 51, 51)
                        .addComponent(btnRegister)))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        String name = txtNewName.getText();
        String price = txtNewPrice.getText();
        String materialText = txtNewMaterial.getText();
        String materialType = cbNewMaterialType.getSelectedItem().toString();
        createMaterial(name, price, materialText, materialType);

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cbExistingMaterialsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbExistingMaterialsItemStateChanged
        String mid = Database.fetchSingle("mid", "materials", "name", cbExistingMaterials.getSelectedItem().toString());
        txtExistingName.setText(cbExistingMaterials.getSelectedItem().toString());
        txtExistingPrice.setText(Database.fetchSingle("price", "materials", "name", cbExistingMaterials.getSelectedItem().toString()));
        if (Validation.checkExistingCell("fabric", "mid", mid)) {
            String materialInfo = Database.fetchSingle("size", "fabric", "mid", mid);
            txtExistingMaterial.setText(materialInfo);
        } else {
            String materialInfo = Database.fetchSingle("amount", "accessories", "mid", mid);
            txtExistingMaterial.setText(materialInfo);
        }


    }//GEN-LAST:event_cbExistingMaterialsItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String mid = Database.fetchSingle("mid", "materials", "name", cbExistingMaterials.getSelectedItem().toString());
        String price = txtExistingPrice.getText();
        String name = txtExistingName.getText();
        String materialText = txtExistingMaterial.getText();

        updateMaterial(mid, price, name, materialText);

    }//GEN-LAST:event_btnUpdateActionPerformed

    public void createMaterial(String name, String price, String materialText, String materialType) {

        boolean materialTextValid = false;
        String mid = Database.getAutoIncrement("materials", "mid");

        double konverteratPrice = 0;

        //validering ska ske här innan datan införs i databasen.
        //konvertering 
        if (Validation.isDouble(price)) {
            konverteratPrice = Double.parseDouble(price);
        } else {
            JOptionPane.showMessageDialog(null, "Var god och skriv in ett giltigt pris.");
        }

        if (materialType.equals("Tyg")) {
            if (materialText != null) {
                if (Validation.isDouble(materialText)) {
                    double materialDouble = Double.parseDouble(materialText);
                    materialTextValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Var god skriv in en siffra/decimaltal");
                }

            }
        } else {
            if (materialText != null) {
                if (validateInt(materialText)) {
                    int materialInt = Integer.parseInt(materialText);
                    materialTextValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Var god skriv in en siffra");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Var god skriv in en siffra/decimaltal");
            }
        }

        if ((name != null) && (name.length() <= 25)
                && (konverteratPrice > 0)
                && (materialText != null)
                && (materialText.length() <= 25)
                && materialTextValid) {
            if (materialType.equals("Tyg")) {
                Database.insert("materials", "(mid, name, price, handled_by)", "(" + mid + ",'" + name + "'," + konverteratPrice + "," + userID + ")");
                Database.insert("fabric", "(mid, size)", "(" + mid + "," + materialText + ")");
            } else {
                Database.insert("materials", "(mid, name, price, handled_by)", "(" + mid + ",'" + name + "'," + konverteratPrice + "," + userID + ")");
                Database.insert("accessories", "(mid, amount)", "(" + mid + "," + materialText + ")");
            }
            JOptionPane.showMessageDialog(null, "Registrering slutförd!");
        } else {
            JOptionPane.showMessageDialog(null, "Kontrollera inmatade uppgifter.");
        }
    }

    public void updateMaterial(String mid, String price, String name, String materialText) {
        //ÄR ETT FABRIC
        if (Validation.checkExistingCell("fabric", "mid", mid)) {
            if (Validation.isDouble(price)) {
                if (Validation.validateName(name)) {
                    if (Validation.isDouble(materialText)) {
                        Database.updatePreparedQuery("UPDATE fabric SET size= " + materialText + " WHERE mid= " + mid);
                        Database.updatePreparedQuery("UPDATE materials SET name = '" + name + "', price = " + price + ", handled_by= " + userID + " WHERE mid = " + mid);
                        JOptionPane.showMessageDialog(null, "Uppdatering lyckades.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Var god och fyll i en giltig mängd");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Var god och fyll i ett giltigt namn.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Var god och fyll i ett giltigt pris.");
            }
            //ÄR EN ACCESSOAR
        } else {
            if (Validation.isDouble(price)) {
                if (Validation.validateName(name)) {
                    if (validateInt(materialText)) {
                        Database.updatePreparedQuery("UPDATE accessories SET amount= " + materialText + " WHERE mid= " + mid);
                        Database.updatePreparedQuery("UPDATE materials SET name = '" + name + "', price = " + price + ", handled_by= " + userID + " WHERE mid = " + mid);
                        JOptionPane.showMessageDialog(null, "Uppdatering lyckades.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Var god och fyll i en giltig mängd");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Var god och fyll i ett giltigt namn.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Var god och fyll i ett giltigt pris.");
            }
        }
    }

    private void fillMaterials() {
        ArrayList<String> cbValues = new ArrayList<>();
        ArrayList<HashMap<String, String>> list = Database.fetchRows(false, "materials", "", "");
        for (HashMap<String, String> row : list) {
            for (String key : row.keySet()) {
                if (key.equals("name")) {
                    cbExistingMaterials.addItem(row.get(key));
                }
            }
        }

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
            java.util.logging.Logger.getLogger(RegisterMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterMaterial().setVisible(true);
            }
        });
    }

    private boolean validateInt(String input) {
        boolean valid = false;

        try {
            Integer.parseInt(input);
            valid = true;
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return valid;
    }

    private boolean validateSupplier(String supplier) {
        boolean exists = false;
        if (supplier.length() <= 25) {
            ArrayList<HashMap<String, String>> suppliers = db.fetchRows(false, "supplier", "", "");
            for (HashMap<String, String> column : suppliers) {
                if (column.get("name").equals(supplier)) {
                    System.out.println("Hittade kolumnen name");
                    exists = true;
                } else {

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Var vänlig och fyll i ett namn som är mindre än 25 bokstäver långt");
        }
        return exists;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbExistingMaterials;
    private javax.swing.JComboBox<String> cbNewMaterialType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblExistingMaterial;
    private javax.swing.JLabel lblNewMaterial;
    private javax.swing.JTextField txtExistingMaterial;
    private javax.swing.JTextField txtExistingName;
    private javax.swing.JTextField txtExistingPrice;
    private javax.swing.JTextField txtNewMaterial;
    private javax.swing.JTextField txtNewName;
    private javax.swing.JTextField txtNewPrice;
    // End of variables declaration//GEN-END:variables
}
