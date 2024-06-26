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
public class Comment extends javax.swing.JFrame {

    private InfDB idb;

    public Comment() {
        new Database();
        new Validation();
        initComponents();
        fillCustomers();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSaveComment = new javax.swing.JButton();
        CommentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSaveComment.setText("Spara kommentar");
        btnSaveComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCommentActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 323, -1, -1));
        getContentPane().add(CommentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 79, 346, 164));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Lämna kommentar nedan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 11, -1, -1));

        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(cbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, -1, -1));

        jLabel2.setText("Kund");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCommentActionPerformed
        String cid = Database.fetchSingle("cid", "customer", "name", cbCustomer.getSelectedItem().toString());

        String comment = CommentField.getText();
        if (Validation.txtHasValue(CommentField) && Validation.validateDescription200(CommentField)) {
            updateComment(comment, cid);
            JOptionPane.showMessageDialog(null, "Kommentaren har sparats.");

        }
        CommentField.setText("");


    }//GEN-LAST:event_btnSaveCommentActionPerformed

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCustomerActionPerformed

    public void updateComment(String comment, String cid) {
        Database.updatePreparedQuery("UPDATE customer SET comment = '" + comment + "' WHERE cid = " + cid);
    }

    private void fillCustomers() {
        ArrayList<HashMap<String, String>> list = Database.fetchRows(false, "customer", "", "");
        for (HashMap<String, String> row : list) {
            for (String key : row.keySet()) {
                if (key.equals("name")) {
                    cbCustomer.addItem(row.get(key));
                }
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CommentField;
    private javax.swing.JButton btnSaveComment;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
