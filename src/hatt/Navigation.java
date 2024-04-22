/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatt;

/**
 *
 * @author joakimfockstedt
 */
public class Navigation extends javax.swing.JFrame {

    private String user;
    private String uid;
    private String cid;
    private boolean isStaff;

    /**
     * Creates new form navigation
     */
    public Navigation(String user, String uid, String cid, boolean isStaff) {
        this.user = user;
        this.uid = uid;
        this.cid = cid;
        this.isStaff = isStaff;
        initComponents();
        lblUser.setText(user);
        loadPane();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        tbdPane = new javax.swing.JTabbedPane();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));

        lblUser.setText("jLabel1");

        tbdPane.setFocusTraversalKeysEnabled(false);
        tbdPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbdPaneStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbdPane, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbdPane, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbdPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbdPaneStateChanged
        String tab = tbdPane.getTitleAt(tbdPane.getSelectedIndex());
        int tabindex = tbdPane.getSelectedIndex();

        if (isStaff) {
            //Otto och Judith
            if (uid.equals("1") || uid.equals("2")) {
                switch (tab) {
                    case "Granska förfrågning":
                        reviewRequest rr = new reviewRequest();
                        tbdPane.setComponentAt(tabindex, rr.getContentPane());
                        break;
                    case "Lagerför en modell":
                        RegisterStockedProduct rsp = new RegisterStockedProduct();
                        tbdPane.setComponentAt(tabindex, rsp.getContentPane());
                        break;
                    case "Visa material info":
                        showMaterialInfo smi = new showMaterialInfo();
                        tbdPane.setComponentAt(tabindex, smi.getContentPane());
                        break;
                    case "Skapa förfrågning":
                        createRequest cr = new createRequest(uid, "");
                        tbdPane.setComponentAt(tabindex, cr.getContentPane());
                        break;
                    case "Skapa order för existerande kund":
                        CreateOrderExistingCustomer coec = new CreateOrderExistingCustomer(uid);
                        tbdPane.setComponentAt(tabindex, coec.getContentPane());
                        break;
                    case "Hantera kunder":
                        JFrameCustomerActions ca = new JFrameCustomerActions();
                        tbdPane.setComponentAt(tabindex, ca.getContentPane());
                        break;
                    case "Lämna återkoppling på förfrågning":
                        Feedback1 fb = new Feedback1();
                        tbdPane.setComponentAt(tabindex, fb.getContentPane());
                        break;
                    case "Lämna kommentar på kund":
                        Comment cm = new Comment();
                        tbdPane.setComponentAt(tabindex, cm.getContentPane());
                        break;
                    case "Leverantörsida":
                        Supplier spl = new Supplier();
                        tbdPane.setComponentAt(tabindex, spl.getContentPane());
                        break;
                    case "Visa ordrar":
                        showOrders so = new showOrders();
                        tbdPane.setComponentAt(tabindex, so.getContentPane());
                        break;
                    case "Registrera material":
                        RegisterMaterial rm = new RegisterMaterial();
                        tbdPane.setComponentAt(tabindex, rm.getContentPane());
                        break;
                        case "Skapa Kund":
                        CreateCustomer cc = new CreateCustomer(true);
                        tbdPane.setComponentAt(tabindex, cc.getContentPane());
                        break;
                }
                //Revisorn
            } else if (uid.equals("3")) {
                switch (tab) {
                    case "Granska förfrågning":
                        reviewRequest rr = new reviewRequest();
                        tbdPane.setComponentAt(tabindex, rr.getContentPane());
                        break;
                    case "Lagerför en modell":
                        RegisterStockedProduct rsp = new RegisterStockedProduct();
                        tbdPane.setComponentAt(tabindex, rsp.getContentPane());
                        break;
                    case "Visa material info":
                        showMaterialInfo smi = new showMaterialInfo();
                        tbdPane.setComponentAt(tabindex, smi.getContentPane());
                        break;
                    case "Skapa förfrågning":
                        createRequest cr = new createRequest(uid, "");
                        tbdPane.setComponentAt(tabindex, cr.getContentPane());
                        break;
                    case "Skapa order för existerande kund":
                        CreateOrderExistingCustomer coec = new CreateOrderExistingCustomer(uid);
                        tbdPane.setComponentAt(tabindex, coec.getContentPane());
                        break;
                    case "Hantera kunder":
                        JFrameCustomerActions ca = new JFrameCustomerActions();
                        tbdPane.setComponentAt(tabindex, ca.getContentPane());
                        break;
                    case "Lämna återkoppling på förfrågning":
                        Feedback1 fb = new Feedback1();
                        tbdPane.setComponentAt(tabindex, fb.getContentPane());
                        break;
                    case "Lämna kommentar på kund":
                        Comment cm = new Comment();
                        tbdPane.setComponentAt(tabindex, cm.getContentPane());
                        break;
                    case "Leverantörsida":
                        Supplier spl = new Supplier();
                        tbdPane.setComponentAt(tabindex, spl.getContentPane());
                        break;
                    case "Visa ordrar":
                        showOrders so = new showOrders();
                        tbdPane.setComponentAt(tabindex, so.getContentPane());
                        break;
                    case "Registrera material":
                        RegisterMaterial rm = new RegisterMaterial();
                        tbdPane.setComponentAt(tabindex, rm.getContentPane());
                        break;
                }
            }
        } else {
            switch (tab) {
                case "Skapa förfrågning":
                    createRequest cr = new createRequest("", cid);
                    tbdPane.setComponentAt(tabindex, cr.getContentPane());
                    break;
            }
        }

    }//GEN-LAST:event_tbdPaneStateChanged

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Navigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navigation().setVisible(true);
            }
        });
    }
     */
    //Fyller tabbedPane med alla JFrames
    private void loadPane() {

        if (isStaff) {
            //Om det är Judith eller Otto
            if (uid.equals("1") || uid.equals("2")) {
                JFrameCustomerActions ca = new JFrameCustomerActions();
                tbdPane.addTab("Hantera kunder", ca.getContentPane());
                CreateOrderExistingCustomer coec = new CreateOrderExistingCustomer(uid);
                tbdPane.addTab("Skapa order för existerande kund", coec.getContentPane());
                createRequest cr = new createRequest(uid, "");
                tbdPane.addTab("Skapa förfrågning", cr.getContentPane());
                showMaterialInfo smi = new showMaterialInfo();
                tbdPane.addTab("Visa material info", smi.getContentPane());
                RegisterStockedProduct rsp = new RegisterStockedProduct();
                tbdPane.addTab("Lagerför en modell", rsp.getContentPane());
                reviewRequest rr = new reviewRequest();
                tbdPane.addTab("Granska förfrågning", rr.getContentPane());

                Feedback1 fb = new Feedback1();
                tbdPane.addTab("Lämna återkoppling på förfrågning", fb.getContentPane());

                Comment cm = new Comment();
                tbdPane.addTab("Lämna kommentar på kund", cm.getContentPane());

                Supplier spl = new Supplier();
                tbdPane.addTab("Leverantörsida", spl.getContentPane());

                showOrders so = new showOrders();
                tbdPane.addTab("Visa ordrar", so.getContentPane());

                RegisterMaterial rm = new RegisterMaterial();
                tbdPane.addTab("Registrera material", rm.getContentPane());

                CreateCustomer cc = new CreateCustomer(true);
                tbdPane.addTab("Skapa kund", cc.getContentPane());

            } //Revisorn
            else if (uid.equals("3")) {
                RegisterStockedProduct rsp = new RegisterStockedProduct();
                tbdPane.addTab("Lagerför en modell", rsp.getContentPane());

                showMaterialInfo smi = new showMaterialInfo();
                tbdPane.addTab("Visa material info", smi.getContentPane());

                reviewRequest rr = new reviewRequest();
                tbdPane.addTab("Granska förfrågning", rr.getContentPane());

                createRequest cr = new createRequest(uid, "");
                tbdPane.addTab("Skapa förfrågning", cr.getContentPane());

                CreateOrderExistingCustomer coec = new CreateOrderExistingCustomer(uid);
                tbdPane.addTab("Skapa order för existerande kund", coec.getContentPane());

                JFrameCustomerActions ca = new JFrameCustomerActions();
                tbdPane.addTab("Hantera kunder", ca.getContentPane());

            }
        } else {
            createRequest cr = new createRequest("", cid);
            tbdPane.addTab("Skapa förfrågning", cr.getContentPane());
        }


        /*CreateOrderNewCustomer conc = new CreateOrderNewCustomer();
        tbdPane.addTab("Skapa order för ny kund", conc.getContentPane());
           
         */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTabbedPane tbdPane;
    // End of variables declaration//GEN-END:variables
}
