package AIHealth;

public class InitialFrame extends javax.swing.JFrame {

    public InitialFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogLab = new javax.swing.JLabel();
        DBut = new javax.swing.JButton();
        PBut = new javax.swing.JButton();
        LogLab1 = new javax.swing.JLabel();
        DBut1 = new javax.swing.JButton();
        PBut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LogLab.setText("Select Login Type");

        DBut.setText("Doctor");
        DBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DButActionPerformed(evt);
            }
        });

        PBut.setText("Patient");
        PBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PButActionPerformed(evt);
            }
        });

        LogLab1.setText("Select Sign Up Type");

        DBut1.setText("Doctor");
        DBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBut1ActionPerformed(evt);
            }
        });

        PBut1.setText("Patient");
        PBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PBut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LogLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LogLab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DBut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PBut1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogLab1)
                        .addGap(42, 42, 42)
                        .addComponent(DBut1)
                        .addGap(42, 42, 42)
                        .addComponent(PBut1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogLab)
                        .addGap(42, 42, 42)
                        .addComponent(DBut)
                        .addGap(42, 42, 42)
                        .addComponent(PBut)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DButActionPerformed
        DoctorLogin dl1 = new DoctorLogin();
        dl1.login();
        this.setVisible(false);
    }//GEN-LAST:event_DButActionPerformed

    private void PButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PButActionPerformed
        PatientLogin pl1 = new PatientLogin();
        pl1.login();
        this.setVisible(false);
    }//GEN-LAST:event_PButActionPerformed

    private void DBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBut1ActionPerformed
        DoctorSignUp dsu = new DoctorSignUp();
        dsu.signup();
        this.setVisible(false);
    }//GEN-LAST:event_DBut1ActionPerformed

    private void PBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PBut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PBut1ActionPerformed
    
    public void selectLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitialFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DBut;
    private javax.swing.JButton DBut1;
    private javax.swing.JLabel LogLab;
    private javax.swing.JLabel LogLab1;
    private javax.swing.JButton PBut;
    private javax.swing.JButton PBut1;
    // End of variables declaration//GEN-END:variables
}
