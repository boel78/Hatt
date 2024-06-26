/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author joakimfockstedt
 */
public class Login extends javax.swing.JFrame {


    /**
     * Creates new form login
     */
    public Login() {
        new Database();
        new Validation();
        initComponents();
    }

    //Metod för att hämta id från namn
    private String getID(String name) {
        String userID = Database.fetchSingle("uid", "user", "name", name);
        return userID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOtto = new javax.swing.JButton();
        btnAccountant = new javax.swing.JButton();
        btnJudith = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOtto.setText("Otto");
        btnOtto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOttoActionPerformed(evt);
            }
        });

        btnAccountant.setText("Revisor");
        btnAccountant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountantActionPerformed(evt);
            }
        });

        btnJudith.setText("Judith");
        btnJudith.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJudithActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnJudith)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnOtto)
                .addGap(46, 46, 46)
                .addComponent(btnAccountant)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJudith)
                    .addComponent(btnOtto)
                    .addComponent(btnAccountant))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOttoActionPerformed
        this.hide();
        String name = btnOtto.getText();
        Navigation n = new Navigation(name, getID(name));
        n.setVisible(true);
    }//GEN-LAST:event_btnOttoActionPerformed

    private void btnJudithActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJudithActionPerformed
        this.hide();
        String name = btnJudith.getText();
        Navigation n = new Navigation(name, getID(name));
        n.setVisible(true);
    }//GEN-LAST:event_btnJudithActionPerformed

    private void btnAccountantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountantActionPerformed
        this.hide();
        //String name = btnAccountant.getText();
        Navigation n = new Navigation("Joakim", getID("Joakim"));
        n.setVisible(true);
    }//GEN-LAST:event_btnAccountantActionPerformed

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
                new Login().setVisible(true);

                try {
                    // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel(
                            UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException e) {
                    // handle exception
                } catch (ClassNotFoundException e) {
                    // handle exception
                } catch (InstantiationException e) {
                    // handle exception
                } catch (IllegalAccessException e) {
                    // handle exception
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountant;
    private javax.swing.JButton btnJudith;
    private javax.swing.JButton btnOtto;
    // End of variables declaration//GEN-END:variables
}
