/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.util.HashMap;

/**
 *
 * @author lukasdenfete
 */
public class showMaterialInfo extends javax.swing.JFrame {

    private Database db;

    /**
     * Creates new form showMaterialInfo
     */
    public showMaterialInfo() {
        db = new Database();
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

        lblChooseMaterial = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        btnShowInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaShowInfo = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblChooseMaterial.setText("Sök material");

        txtMaterial.setColumns(10);

        btnShowInfo.setText("Visa info");
        btnShowInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowInfoMouseClicked(evt);
            }
        });

        txtAreaShowInfo.setColumns(20);
        txtAreaShowInfo.setRows(5);
        jScrollPane1.setViewportView(txtAreaShowInfo);

        btnBack.setText("Tillbaka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addComponent(btnShowInfo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lblChooseMaterial)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblChooseMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowInfo)
                .addGap(35, 35, 35)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowInfoMouseClicked
        // TODO add your handling code here:
        String name = txtMaterial.getText();
        txtAreaShowInfo.setText("");
        String id = db.fetchSingle("mid", "materials", "name", name);
        if (id != null) {
            String supplierID = db.fetchSingle("sid", "ordering_materials", "mid", id);
            HashMap<String, String> supplierInfo = new HashMap<>();
            supplierInfo = db.fetchRow("supplier", "sid", supplierID);
            for (String key : supplierInfo.keySet()) {
                if (!key.equals("sid")) {
                    txtAreaShowInfo.append(key + " = " + supplierInfo.get(key) + "\n");
                }
            }
            HashMap<String, String> fabrics = db.fetchRow("fabric", "mid", id);
            if (fabrics.isEmpty()) {
                HashMap<String, String> accessories = db.fetchRow("accessories", "mid", id);
                txtAreaShowInfo.append("Type = Accessories\n");
                txtAreaShowInfo.append("Amount = " + accessories.get("amount") + "\n");
            } else {
                txtAreaShowInfo.append("Type = Fabric\n");
                txtAreaShowInfo.append("Size = " + fabrics.get("size") + "\n");
            }
            txtAreaShowInfo.append("Price = " + db.fetchSingle("price", "materials", "mid", id));

        } else {
            System.out.println("Materialet finns inte. Kolla efter stavfel.");
        }
    }//GEN-LAST:event_btnShowInfoMouseClicked

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
            java.util.logging.Logger.getLogger(showMaterialInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showMaterialInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showMaterialInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showMaterialInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showMaterialInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnShowInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChooseMaterial;
    private javax.swing.JTextArea txtAreaShowInfo;
    private javax.swing.JTextField txtMaterial;
    // End of variables declaration//GEN-END:variables
}
