/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import hatt.Database;
import hatt.Validation;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import oru.inf.InfException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joakimfockstedt
 */
public class Feedback1 extends javax.swing.JFrame {

    private InfDB idb;
    private String rid;

    /**
     * Creates new form reviewREquestt
     */
    public Feedback1() {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        new Database();
        new Validation();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        cbDenyAccept = new javax.swing.JComboBox<>();
        btnCompleteDenyAccept = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        KommenterarOmKund = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnShowRequest = new javax.swing.JButton();
        cbReviews = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TFFeedb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtDescription = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        cbDenyAccept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neka", "Godkänn", "Återkoppla", " " }));
        cbDenyAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDenyAcceptActionPerformed(evt);
            }
        });

        btnCompleteDenyAccept.setText("Fullfölj");
        btnCompleteDenyAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteDenyAcceptActionPerformed(evt);
            }
        });

        jLabel3.setText("Godkänn/Neka/Återkoppla förfrågan");

        KommenterarOmKund.setText("Kommentera kund");
        KommenterarOmKund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KommenterarOmKundActionPerformed(evt);
            }
        });

        jLabel2.setText("Beskrivning");

        btnShowRequest.setText("Visa");
        btnShowRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRequestActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbReviews.setModel(new javax.swing.DefaultComboBoxModel<>(getCBReviews()));
        cbReviews.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbReviewsItemStateChanged(evt);
            }
        });
        cbReviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReviewsActionPerformed(evt);
            }
        });
        getContentPane().add(cbReviews, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 86, 183, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Lämna återkoppling nedan ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 22, -1, -1));

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 306, -1, -1));
        getContentPane().add(TFFeedb, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 152, 285, 128));

        jLabel4.setText("Välj förfrågning:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 56, -1, -1));

        jButton2.setText("Visa ev tidigare feedback");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 119, -1, -1));

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setText(Database.fetchSingle("description", "requests", "rid", "1"));
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 86, 237, -1));

        jLabel5.setText("Feedback");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 129, -1, -1));

        jLabel6.setText("Beskrivning");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 63, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRequestActionPerformed

    }//GEN-LAST:event_btnShowRequestActionPerformed

    private void btnCompleteDenyAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteDenyAcceptActionPerformed

    }//GEN-LAST:event_btnCompleteDenyAcceptActionPerformed

    private void KommenterarOmKundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KommenterarOmKundActionPerformed


    }//GEN-LAST:event_KommenterarOmKundActionPerformed

    private void cbDenyAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDenyAcceptActionPerformed

    }//GEN-LAST:event_cbDenyAcceptActionPerformed

    private void cbReviewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReviewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbReviewsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String feedback = TFFeedb.getText();
        String rid = cbReviews.getSelectedItem().toString();

        if (!feedback.isEmpty()) {
            if (Validation.validateDescription200(TFFeedb)) {
                Database.updatePreparedQuery("UPDATE requests SET feedback = '" + feedback + "' WHERE rid = " + rid);
                JOptionPane.showMessageDialog(null, "Feedback skickat!");
                TFFeedb.setText(" ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vänligen skriv något");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String feedback = TFFeedb.getText();
        String rid = cbReviews.getSelectedItem().toString();
        String query1 = "SELECT feedback FROM requests, customer WHERE customer.cid = requests.rid AND rid = '" + rid + "'";

        try {
            String oldFeed = idb.fetchSingle(query1);
            TFFeedb.setText(oldFeed);
        } catch (InfException ex) {
            Logger.getLogger(Feedback1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void cbReviewsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbReviewsItemStateChanged
        rid = cbReviews.getSelectedItem().toString();

        txtDescription.setText(Database.fetchSingle("description", "requests", "rid", rid));
    }//GEN-LAST:event_cbReviewsItemStateChanged

    public String[] getCBReviews() {
        ArrayList<String> CBAL = new ArrayList<>();
        ArrayList<String> rid = new ArrayList<>();
        rid = Database.fetchColumn(false, "rid", "requests", "", "");

        try {
            for (String s : rid) {
                String query = "SELECT rid FROM requests, customer WHERE customer.cid = requests.rid AND rid = '" + s + "'";
                CBAL.add(idb.fetchSingle(query));
            }
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        String[] CBReviewsx = new String[CBAL.size()];
        CBAL.toArray(CBReviewsx);

        return CBReviewsx;
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KommenterarOmKund;
    private javax.swing.JTextField TFFeedb;
    private javax.swing.JButton btnCompleteDenyAccept;
    private javax.swing.JButton btnShowRequest;
    private javax.swing.JComboBox<String> cbDenyAccept;
    private javax.swing.JComboBox<String> cbReviews;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
