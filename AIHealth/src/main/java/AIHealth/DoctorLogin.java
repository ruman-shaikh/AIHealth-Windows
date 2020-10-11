package AIHealth;
import javax.swing.JOptionPane;

public class DoctorLogin extends javax.swing.JFrame {

    public DoctorLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UsrLogFld = new javax.swing.JTextField();
        LogBut = new javax.swing.JButton();
        PwdLogFld = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        UsrLogFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrLogFldActionPerformed(evt);
            }
        });

        LogBut.setText("Login");
        LogBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogButActionPerformed(evt);
            }
        });

        PwdLogFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdLogFldActionPerformed(evt);
            }
        });

        jLabel3.setText("Doctor's Login");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LogBut)
                                    .addComponent(PwdLogFld)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(UsrLogFld, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UsrLogFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PwdLogFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LogBut)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsrLogFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrLogFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsrLogFldActionPerformed

    private void PwdLogFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdLogFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PwdLogFldActionPerformed

    private void LogButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogButActionPerformed
        String UsrName = UsrLogFld.getText();
        String Pwd = PwdLogFld.getText();
        JDBC t1 = new JDBC();
        if (UsrName.isEmpty() == true || Pwd.isEmpty() == true){
            JOptionPane.showMessageDialog(this, "No Data Entered");
            System.out.println("No Data Entered");
        }
        else {
            if (t1.DoctorDBConnect(UsrName, Pwd) == 1) {
                System.out.println("Correct");
                Doctor d = new Doctor(UsrName);
                DoctorPortal dp1 = new DoctorPortal(d);
                dp1.DoctorPortalMain(d);
                this.setVisible(false);
            }
            else if (t1.DoctorDBConnect(UsrName, Pwd) == 0){
                JOptionPane.showMessageDialog(this, "Incorrect credentials");
                System.out.println("Incorrect");
            
            }
            else 
                System.out.println("ERROR");
        //System.out.println(UsrName);
        }
    }//GEN-LAST:event_LogButActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.setVisible(false);
        InitialFrame if3 = new InitialFrame();
        if3.selectLogin();
    }//GEN-LAST:event_BackButtonActionPerformed
    
    public void login() {
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
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton LogBut;
    private javax.swing.JPasswordField PwdLogFld;
    private javax.swing.JTextField UsrLogFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
