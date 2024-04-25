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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOtto.setText("Otto");
        btnOtto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOttoActionPerformed(evt);
            }
        });
        getContentPane().add(btnOtto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        btnAccountant.setText("Revisor");
        btnAccountant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountantActionPerformed(evt);
            }
        });
        getContentPane().add(btnAccountant, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        btnJudith.setText("Judith");
        btnJudith.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJudithActionPerformed(evt);
            }
        });
        getContentPane().add(btnJudith, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hatt/FriendlyKate-sjkLLyy3RLw7dMG-removebg-preview.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(300, 300));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 310, 605));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Ottos hattmakeri");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 330, 90));

        jLabel3.setText("Logga in");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOttoActionPerformed
        this.hide();
        String name = btnOtto.getText();
        Navigation n = new Navigation(name, getID(name),"", true);
        n.setVisible(true);
    }//GEN-LAST:event_btnOttoActionPerformed

    private void btnJudithActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJudithActionPerformed
        this.hide();
        String name = btnJudith.getText();
        Navigation n = new Navigation(name, getID(name),"", true);
        n.setVisible(true);
    }//GEN-LAST:event_btnJudithActionPerformed

    private void btnAccountantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountantActionPerformed
        this.hide();
        //String name = btnAccountant.getText();
        Navigation n = new Navigation("Joakim", getID("Joakim"),"", true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
