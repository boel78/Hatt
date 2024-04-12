/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import hatt.Database;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author joakimfockstedt
 */
public class reviewRequest extends javax.swing.JFrame {

    private InfDB idb;
    private String rID;

    /**
     * Creates new form reviewREquestt
     */
    public reviewRequest() {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }
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

        cbReviews = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnShowRequest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        cbDenyAccept = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnCompleteDenyAccept = new javax.swing.JButton();
        KommenterarOmKund = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));

        cbReviews.setModel(new javax.swing.DefaultComboBoxModel<>(getCBReviews()));

        jLabel1.setText("Välj förfrågan");

        btnShowRequest.setText("Visa");
        btnShowRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRequestActionPerformed(evt);
            }
        });

        jLabel2.setText("Beskrivning");

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        cbDenyAccept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neka", "Godkänn" }));

        jLabel3.setText("Godkänn/Neka förfrågan");

        btnCompleteDenyAccept.setText("Fullfölj");
        btnCompleteDenyAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteDenyAcceptActionPerformed(evt);
            }
        });

        KommenterarOmKund.setText("Kommentera kund");
        KommenterarOmKund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KommenterarOmKundActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbReviews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnShowRequest))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDenyAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCompleteDenyAccept)
                        .addGap(18, 18, 18)
                        .addComponent(KommenterarOmKund)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReviews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowRequest))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDenyAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompleteDenyAccept)
                    .addComponent(KommenterarOmKund))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRequestActionPerformed
        String txt = "";
        String cbContent = cbReviews.getSelectedItem().toString();
        String numbers = cbContent.replaceAll("^.*\\s(\\d+)$", "$1");
        rID = numbers;
        txt = Database.fetchSingle("description", "requests", "rid", numbers);

        txtAreaDescription.setText("");
        txtAreaDescription.append(txt);
    }//GEN-LAST:event_btnShowRequestActionPerformed

    private void btnCompleteDenyAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteDenyAcceptActionPerformed
        String cbContent = cbDenyAccept.getSelectedItem().toString();
        if (cbContent == "Neka") {
            try {
                idb.update("UPDATE requests SET reviewed = 'J' WHERE rid = " + rID);
                idb.update("UPDATE requests SET review_status = 'N' WHERE rid = " + rID);
                JOptionPane.showMessageDialog(null, "Förfågan har nekats.");
            } catch (InfException ex) {
                ex.printStackTrace();
            }
        } else if (cbContent == "Godkänn") {
            try {
                idb.update("UPDATE requests SET reviewed = 'J' WHERE rid = " + rID);
                idb.update("UPDATE requests SET review_status = 'J' WHERE rid = " + rID);
                JOptionPane.showMessageDialog(null, "Förfågan har godkänts");
            } catch (InfException ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnCompleteDenyAcceptActionPerformed

    private void KommenterarOmKundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KommenterarOmKundActionPerformed
     new Comment().setVisible(true);
     
    }//GEN-LAST:event_KommenterarOmKundActionPerformed

    public String[] getCBReviews() {
        ArrayList<String> CBAL = new ArrayList<>();
        ArrayList<String> rid = new ArrayList<>();
        rid = Database.fetchColumn(false, "rid", "requests", "", "");

        try {
            for (String s : rid) {
                CBAL.add(idb.fetchSingle("SELECT name FROM customer WHERE cid IN (SELECT customer FROM requests WHERE rid = '" + s + "')") + " " + s);
            }
        } catch (InfException ex) {
            ex.printStackTrace();
        }

        String[] CBReviewsx = new String[CBAL.size()];
        CBAL.toArray(CBReviewsx);

        return CBReviewsx;
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
            java.util.logging.Logger.getLogger(reviewRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reviewRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reviewRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reviewRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reviewRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KommenterarOmKund;
    private javax.swing.JButton btnCompleteDenyAccept;
    private javax.swing.JButton btnShowRequest;
    private javax.swing.JComboBox<String> cbDenyAccept;
    private javax.swing.JComboBox<String> cbReviews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDescription;
    // End of variables declaration//GEN-END:variables
}
