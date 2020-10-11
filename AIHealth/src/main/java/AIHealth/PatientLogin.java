package AIHealth;
import javax.swing.JOptionPane;

public class PatientLogin extends javax.swing.JFrame {

    public PatientLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        LogBut = new javax.swing.JButton();
        PwdLogFld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UsrLogFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        jLabel3.setText("Doctor's Login");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        UsrLogFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrLogFldActionPerformed(evt);
            }
        });

        jLabel4.setText("Patient's Login");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
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
                            .addComponent(jLabel4)
                            .addComponent(UsrLogFld, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton)
                .addGap(59, 59, 59)
                .addComponent(jLabel4)
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
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PwdLogFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdLogFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PwdLogFldActionPerformed

    private void UsrLogFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrLogFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsrLogFldActionPerformed

    private void LogButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogButActionPerformed
        String UsrName = UsrLogFld.getText();
        String Pwd = PwdLogFld.getText();
        JDBC t1 = new JDBC();
        if (UsrName.isEmpty() == true || Pwd.isEmpty() == true){
            JOptionPane.showMessageDialog(this, "No Data Entered");
            System.out.println("No Data Entered");
        }
        else{
            if (t1.PatientDBConnect(UsrName, Pwd) == 1) {
                System.out.println("Correct");
                Patient p = new Patient(UsrName);
                PatientPortal dp1 = new PatientPortal(p);
                dp1.PatientPortalMain(p);
                this.setVisible(false);
            }
            else if (t1.PatientDBConnect(UsrName, Pwd) == 0){
                JOptionPane.showMessageDialog(this, "Incorrect credentials");
                System.out.println("Incorrect");
            }
            else 
                System.out.println("ERROR");
        }
        //System.out.println(UsrName);
    }//GEN-LAST:event_LogButActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.setVisible(false);
        InitialFrame if2 = new InitialFrame();
        if2.selectLogin();
    }//GEN-LAST:event_BackButtonActionPerformed
    
    public void login() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientLogin().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
