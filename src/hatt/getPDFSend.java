/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Erik
 */
public class getPDFSend extends javax.swing.JFrame {

    InfDB idb;
    private String oid;
    private String customerName;

    /**
     * Creates new form getPDFSend
     */
    public getPDFSend() {
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        new Database();

        initComponents();
        fillCB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOrder = new javax.swing.JComboBox<>();
        btnCreateWaybill = new javax.swing.JButton();
        lblOrder = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtVolume = new javax.swing.JTextField();
        txtAmountPackages = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbOrder.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrderItemStateChanged(evt);
            }
        });

        btnCreateWaybill.setText("Skapa och skriv ut fraktsedel");
        btnCreateWaybill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateWaybillActionPerformed(evt);
            }
        });

        lblOrder.setText("Ordrar");

        txtWeight.setColumns(5);

        txtVolume.setColumns(5);

        txtAmountPackages.setColumns(5);

        jLabel1.setText("Vikt (kg)");

        jLabel2.setText("Volym");

        jLabel3.setText("Mängd paket");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnCreateWaybill))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrder)
                            .addComponent(cbOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmountPackages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(txtAmountPackages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnCreateWaybill, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateWaybillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateWaybillActionPerformed
        String weight = txtWeight.getText();
        String volume = txtVolume.getText();
        String amountPackages = txtAmountPackages.getText();

        if (Validation.isDouble(weight) && Validation.validateInt(amountPackages) && Validation.isDouble(volume)) {

        } else {
            JOptionPane.showMessageDialog(null, "Var vänlig och fyll i giltiga siffor");
        }
        
        
        createPDF(volume, weight, amountPackages);
    }//GEN-LAST:event_btnCreateWaybillActionPerformed

    private void cbOrderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrderItemStateChanged
        String[] x = cbOrder.getSelectedItem().toString().split(" ");
        oid = x[0];
        customerName = x[2];
    }//GEN-LAST:event_cbOrderItemStateChanged

    private void fillCB() {
        HashMap<String, String> list = new HashMap<>();
        ArrayList<HashMap<String, String>> response = Database.fetchRows(true, "xOrder", "ordertype", "'J'");
        for (HashMap<String, String> row : response) {
            String column = "";
            String desc = "";
            String customer = "";
            for (String key : row.keySet()) {
                switch (key) {
                    case "oid":
                        column = row.get(key);
                        break;
                    case "description":
                        desc = row.get(key);
                        break;
                    case "customer":
                        customer = Database.fetchSingle("name", "customer", "cid", row.get(key));
                        break;
                }
            }

            list.put(column, desc + " " + customer);
        }
        for (String key : list.keySet()) {
            cbOrder.addItem(key + " " + list.get(key));
        }
    }

    public void createPDF(String volume, String weight, String package_count) {
        String wid = Database.getAutoIncrement("waybill", "wid");
        
        String cid  = Database.fetchSingle("customer", "xOrder", "oid", oid);

        String fileName = "Fraktsedel_" + wid + ".pdf";

        Database.insert("waybill", "(wid, oid, volume, weight, content, package_count)", "(" + wid + "," + oid + "," + volume + "," + weight + ", 'En handgjord hatt.'," + package_count + ")");
        
        LocalDate localdate = LocalDate.now();
        
        try {
            PDDocument document = new PDDocument();

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);

            contentStream.beginText();

            contentStream.newLineAtOffset(100, 700);

            contentStream.showText("FraktID: " + wid);
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Datum: " + localdate.toString());
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Avsändare: Ottos Hattmakeri, Örebro, Hattmakarvgen 1, 019-303 878");
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Mottagare: " + customerName + ", " + Database.fetchSingle("address", "customer", "cid", cid) + ", " + Database.fetchSingle("phone", "customer", "cid", cid));

            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Varuvärde: " + Database.fetchSingle("price", "xOrder", "oid", oid) + "kr inkl. Moms");
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Vikt: " + weight);
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Volym: " + volume);
            
            contentStream.newLineAtOffset(0, -50);
            
            contentStream.showText("Antal paket: " + package_count);
            
            contentStream.endText();

            contentStream.close();

            document.save(fileName);

            document.close();

        } catch (Exception ex) {
            System.out.println("");
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
            java.util.logging.Logger.getLogger(getPDFSend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(getPDFSend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(getPDFSend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(getPDFSend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new getPDFSend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateWaybill;
    private javax.swing.JComboBox<String> cbOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JTextField txtAmountPackages;
    private javax.swing.JTextField txtVolume;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
