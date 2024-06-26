/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author lukasdenfete
 */
public class Supplier extends javax.swing.JFrame {

    private String sid;
    private String selectedMaterial;

    /**
     * Creates new form Supplier
     */
    public Supplier() {
        initComponents();
        new Database();
        fillSupplier();
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

        lblHeader = new javax.swing.JLabel();
        cbSuppliers = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbMaterial = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnRemoveSupplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setText("Leverantörssida");
        getContentPane().add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 6, -1, -1));

        cbSuppliers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ny leverantör" }));
        cbSuppliers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSuppliersItemStateChanged(evt);
            }
        });
        getContentPane().add(cbSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        jLabel1.setText("Välj leverantör");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 14, -1, -1));

        txtName.setColumns(7);
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 105, -1, -1));

        txtEmail.setColumns(7);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 167, -1, -1));

        txtPhone.setColumns(7);
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 221, -1, -1));

        lblName.setText("Namn:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 82, -1, -1));

        lblEmail.setText("Email:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 144, -1, -1));

        lblPhone.setText("Telefon:");
        getContentPane().add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 198, -1, -1));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 92, 176, 91));

        jLabel2.setText("Leverantörens material:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 57, -1, -1));

        cbMaterial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaterialItemStateChanged(evt);
            }
        });
        getContentPane().add(cbMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 212, -1, -1));

        jLabel3.setText("Lägg till material:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 189, -1, -1));

        btnAdd.setText("Lägg till");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 251, -1, -1));

        btnCreate.setText("Skapa");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 266, -1, -1));

        btnRemoveSupplier.setForeground(new java.awt.Color(255, 0, 0));
        btnRemoveSupplier.setText("Ta bort");
        btnRemoveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 266, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (!cbSuppliers.getSelectedItem().toString().equals("Ny leverantör")) {
        String mid = Database.fetchSingle("mid", "materials", "name", selectedMaterial);
        if (btnAdd.getText().equals("Lägg till")) {
            Database.insert("supplier_has_material", "(sid, mid)", "(" + sid + "," + mid + ")");
            fillMaterialBox(sid);
            JOptionPane.showMessageDialog(null, "Material tilldelat.");
            btnAdd.setText("Ta bort");
            btnAdd.setForeground(Color.red);

        } else {
            if (btnAdd.getText().equals("Ta bort")) {
                Database.deleteRow("supplier_has_material", "mid", mid);
                JOptionPane.showMessageDialog(null, "Material har tagits bort från leverantören.");
                btnAdd.setText("Lägg till");
                btnAdd.setForeground(Color.black);
                fillMaterialBox(sid);
            }
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbSuppliersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSuppliersItemStateChanged
        // TODO add your handling code here:
        if (cbSuppliers.getSelectedItem().toString().equals("Ny leverantör")) {
            btnCreate.setText("Skapa");
            txtName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtArea.setText("");

        } else {
            btnCreate.setText("Uppdatera");
            sid = Database.fetchSingle("sid", "supplier", "name", cbSuppliers.getSelectedItem().toString());
            txtName.setText(cbSuppliers.getSelectedItem().toString());
            txtEmail.setText(Database.fetchSingle("email", "supplier", "sid", sid));
            txtPhone.setText(Database.fetchSingle("phone", "supplier", "sid", sid));
            fillMaterialBox(sid);
        }
    }//GEN-LAST:event_cbSuppliersItemStateChanged

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (Validation.validateName(txtName.getText())) {
            if (Validation.validateEmailTypo(txtEmail.getText())) {
                if (Validation.validatePhone(txtPhone.getText())) {
                    if (btnCreate.getText().equals("Skapa")) {
                        String newSid = Database.getAutoIncrement("supplier", "sid");
                        if(newSid == null){
                            newSid = "1";
                        }
                        Database.insert("supplier", "(sid, name, email, phone)", "(" + newSid + ",'" + txtName.getText() + "','" + txtEmail.getText() + "','" + txtPhone.getText() + "')");
                        JOptionPane.showMessageDialog(null, "Leverantören är nu tillagd");
                        fillSupplier();
                    } else {
                        Database.updatePreparedQuery("UPDATE supplier SET name = '" + txtName.getText() + "', email = '" + txtEmail.getText() + "', phone = '" + txtPhone.getText() + "' WHERE sid = " + sid);
                        JOptionPane.showMessageDialog(null, "Leverantören är nu uppdaterad");
                        fillSupplier();
                        
                    }                  
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fyll i ett giltigt namn");

        }

        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbMaterialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaterialItemStateChanged
        // TODO add your handling code here:
        selectedMaterial = cbMaterial.getSelectedItem().toString();
        String mid = Database.fetchSingle("mid", "materials", "name", selectedMaterial);
        if (!Validation.checkSupplierMaterial(sid, mid)) {
            btnAdd.setText("Lägg till");
            btnAdd.setForeground(Color.black);
        } else {
            btnAdd.setText("Ta bort");
            btnAdd.setForeground(Color.red);
        }
    }//GEN-LAST:event_cbMaterialItemStateChanged

    private void btnRemoveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSupplierActionPerformed
        if (!cbSuppliers.getSelectedItem().toString().equals("Ny leverantör")) {
        int input = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort leverantören?");
        // 0=yes, 1=no, 2=cancel
        if (input == 0) {

            boolean hasMaterialEmpty = false;
            while (!hasMaterialEmpty) {
                if (Validation.checkExistingCell("supplier_has_material", "sid", sid)) {
                    Database.deleteRow("supplier_has_material", "sid", sid);
                }
                else{
                    hasMaterialEmpty = true;
                }
            }
            
            boolean orderingEmpty = false;
            while (!orderingEmpty) {
                if (Validation.checkExistingCell("ordering_materials", "sid", sid)) {
                    Database.deleteRow("ordering_materials", "sid", sid);
                }
                else{
                    orderingEmpty = true;
                }
            } 
            if(orderingEmpty && hasMaterialEmpty){
                Database.deleteRow("supplier", "sid", sid);
                JOptionPane.showMessageDialog(null, "Leverantören är nu bortagen ur systemet.");
                fillSupplier();
            }
        }
        }
    }//GEN-LAST:event_btnRemoveSupplierActionPerformed

    private void fillSupplier() {
        int amount = cbSuppliers.getItemCount();
        System.out.println(amount);
        if (cbSuppliers.getItemCount() > 1) {
            for (int i = amount - 1; i >= 1; i--) {
                System.out.println("AMOUBNT:" + amount);
                System.out.println(i);
                cbSuppliers.removeItemAt(i);
            }
        }
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");

        ArrayList<HashMap<String, String>> list = Database.fetchRows(false, "supplier", "", "");
        for (HashMap<String, String> row : list) {
            for (String key : row.keySet()) {
                if (key.equals("name")) {
                    cbSuppliers.addItem(row.get(key));
                }
            }
        }
    }

    private void fillMaterialBox(String sid) {
        txtArea.setText("");
        ArrayList<HashMap<String, String>> list = Database.fetchRows(true, "supplier_has_material", "sid", sid);

        for (HashMap<String, String> row : list) {
            for (String key : row.keySet()) {
                if (key.equals("mid")) {
                    txtArea.append(Database.fetchSingle("name", "materials", "mid", row.get(key)) + "\n");
                }
            }
        }

    }

    private void fillMaterials() {

        ArrayList<HashMap<String, String>> list = Database.fetchRows(false, "materials", "", "");

        for (HashMap<String, String> row : list) {
            for (String key : row.keySet()) {
                if (key.equals("name")) {
                    cbMaterial.addItem(row.get(key));
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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemoveSupplier;
    private javax.swing.JComboBox<String> cbMaterial;
    private javax.swing.JComboBox<String> cbSuppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
