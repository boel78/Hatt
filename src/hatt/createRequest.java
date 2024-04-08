package hatt;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;



public class createRequest extends javax.swing.JFrame {
    
    private String[] cbHatModels;
    private String description;
    private String hatModel;
    private String ID;
    private boolean createOrder;
    private static InfDB idb;
    
    public createRequest() {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        lblAlreadyAModel = new javax.swing.JLabel();
        cbHatModel = new javax.swing.JComboBox<>();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblRequest = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        lblCustomer = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAlreadyAModel.setText("Baserad på redan lagerförd modell?");

        cbHatModel.setModel(new javax.swing.DefaultComboBoxModel<>(getCBHatModels()));

        lblDescription.setText("Beskrivning:");

        txtDescription.setText("Klicka, sen skriv här....");
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
            }
        });

        lblRequest.setText("Skapa orderförfrågan");

        jLabel4.setText("Skapa förfrågan");

        btnSend.setText("Skapa");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblCustomer.setText("Vilken kund?");

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(getCBCustomer()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription)
                    .addComponent(lblRequest)
                    .addComponent(jLabel4)
                    .addComponent(btnSend)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlreadyAModel)
                            .addComponent(cbHatModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomer)
                            .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlreadyAModel)
                    .addComponent(lblCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHatModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        
        description = txtDescription.getText();
        hatModel = cbHatModel.getSelectedItem().toString();
        System.out.print(description);
        
        try
        {
            int workerID = 1;
            String nextID = idb.getAutoIncrement("requests", "rid");
            ID = idb.fetchSingle("SELECT cid FROM customer WHERE name LIKE '" + cbCustomer.getSelectedItem().toString() + "'");
            idb.insert("INSERT INTO requests VALUES (" + nextID + ", '" + description + "', "+ workerID + ",  'N', 'N'," + ID + ")");
        } 
        catch (InfException ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSendActionPerformed
    
    public static String[] getCBHatModels(){
        ArrayList<String> CBAL = new ArrayList<>();
        
        try{
            CBAL = idb.fetchColumn("SELECT name FROM stocked_product");
            CBAL.add("Nej");
            System.out.println();
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        
        String[] CBHatModelsx = new String[CBAL.size()];
        CBAL.toArray(CBHatModelsx);
        
        
        return CBHatModelsx;
    }
    
    public static String[] getCBCustomer(){
        ArrayList<String> CBAL = new ArrayList<>();
        
        try{
            CBAL = idb.fetchColumn("SELECT name FROM customer");
            System.out.println();
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        
        String[] CBCustomer = new String[CBAL.size()];
        CBAL.toArray(CBCustomer);
        
        
        return CBCustomer;
    }
    
    private void txtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusGained
        // TODO add your handling code here:
        txtDescription.setText("");
    }//GEN-LAST:event_txtDescriptionFocusGained

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        // TODO add your handling code here
        txtDescription.setText("Klicka, sen skriv här....");
    }//GEN-LAST:event_txtDescriptionFocusLost

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
            java.util.logging.Logger.getLogger(createRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        }
        catch(InfException ex){
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JComboBox<String> cbHatModel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAlreadyAModel;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
