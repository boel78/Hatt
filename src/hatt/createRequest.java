package hatt;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class createRequest extends javax.swing.JFrame {

    private int i = 0;
    private int j = 0;
    private String[] cbHatModels;
    private String description;
    private String hatModel;
    private String ID;
    private boolean createOrder;
    private InfDB idb;
    private String uid;

    public createRequest(String uid) {
        this.uid = uid;
        try {
            idb = new InfDB("hattmakardb", "3306", "hattmakare", "Hattsweatshop");
        } catch (InfException ex) {
            ex.printStackTrace();
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbHatModel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox<>();
        txtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Skapa orderförfrågan");

        jLabel2.setText("Baserad på redan lagerförd modell?");

        cbHatModel.setModel(new javax.swing.DefaultComboBoxModel<>(getCBHatModels()));

        jLabel3.setText("Beskrivning:");

        jLabel4.setText("Skapa förfrågan");

        btnSend.setText("Skapa");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel5.setText("Vilken kund?");

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(getCBCustomer()));

        txtDescription.setText("Tryck här för att skriva");
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(cbHatModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnSend))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHatModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(btnSend))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (Validation.txtHasValue(txtDescription)) {
            description = txtDescription.getText();
            hatModel = cbHatModel.getSelectedItem().toString();

            ID = Database.fetchSingle("cid", "customer", "name", cbCustomer.getSelectedItem().toString());
            String nextID = Database.getAutoIncrement("requests", "rid");
            int workerID = 1;

            if (description.length() <= 100) {
                String stocked = cbHatModel.getSelectedItem().toString();
                if (stocked.isEmpty()) {
                    Database.insert("requests", "(rid, description, reviewed_by, reviewed, review_status, customer)", "(" + nextID + ", '" + description + "', " + workerID + ",  'N', 'N'," + ID + ")");
                    JOptionPane.showMessageDialog(null, "Förfrågningen är inlagd i systemet.");
                } else {
                    String sid = Database.fetchSingle("sid", "stocked_product", "name", stocked);
                    Database.insert("requests", "(rid, description, reviewed_by, reviewed, review_status, customer, stocked_product)", "(" + nextID + ", '" + description + "', " + workerID + ",  'N', 'N'," + ID + "," + sid + ")");
                    JOptionPane.showMessageDialog(null, "Förfrågningen är inlagd i systemet.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Var god och fyll i en beskrivning som är kortare än 100 bokstäver.");
            }
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusGained
        if (j == 0) {
            txtDescription.setText("");
        }
        j++;
    }//GEN-LAST:event_txtDescriptionFocusGained

    public String[] getCBHatModels() {
        ArrayList<String> CBAL = new ArrayList<>();
        CBAL = Database.fetchColumn(false, "Name", "stocked_product", "", "");
        CBAL.add("Nej");

        String[] CBHatModelsx = new String[CBAL.size()];
        CBAL.toArray(CBHatModelsx);

        return CBHatModelsx;
    }

    public String[] getCBCustomer() {
        ArrayList<String> CBAL = new ArrayList<>();

        CBAL = Database.fetchColumn(false, "name", "customer", "", "");

        String[] CBCustomer = new String[CBAL.size()];
        CBAL.toArray(CBCustomer);

        return CBCustomer;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JComboBox<String> cbHatModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
