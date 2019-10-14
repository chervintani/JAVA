/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_package;

import compositions.Database;
import compositions.Validation;
import javax.swing.JOptionPane;

/**
 *
 * @author 2ndyrGroupC
 */
public class SearchChoice extends javax.swing.JFrame {

    /**
     * Creates new form SearchChoice
     */
    Validation validate = new Validation();
    RetrieveChoice retrieve = new RetrieveChoice();
    Database db = new Database();

    public SearchChoice() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_searchinfo = new javax.swing.JButton();
        jButton_searchlsched = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jButton_searchacc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton_searchinfo.setBackground(new java.awt.Color(255, 102, 0));
        jButton_searchinfo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton_searchinfo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_searchinfo.setText("Personal Information");
        jButton_searchinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_searchinfoMouseClicked(evt);
            }
        });
        jButton_searchinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchinfoActionPerformed(evt);
            }
        });

        jButton_searchlsched.setBackground(new java.awt.Color(255, 102, 0));
        jButton_searchlsched.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton_searchlsched.setForeground(new java.awt.Color(255, 255, 255));
        jButton_searchlsched.setText("Schedule");
        jButton_searchlsched.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_searchlschedMouseClicked(evt);
            }
        });

        jButton_cancel.setBackground(new java.awt.Color(255, 102, 0));
        jButton_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton_cancel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cancel.setText("Cancel");
        jButton_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_cancelMouseClicked(evt);
            }
        });

        jButton_searchacc.setBackground(new java.awt.Color(255, 102, 0));
        jButton_searchacc.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton_searchacc.setForeground(new java.awt.Color(255, 255, 255));
        jButton_searchacc.setText("Account");
        jButton_searchacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_searchaccMouseClicked(evt);
            }
        });
        jButton_searchacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchaccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_searchacc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_searchlsched, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_searchinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton_searchacc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_searchinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_searchlsched, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_searchinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_searchinfoMouseClicked
        //CANNOT RETRIEVE PERSONAL INFOMATION
        
        String accId = JOptionPane.showInputDialog("Enter Account Id:");
        if (accId == null) {
            this.setVisible(true);
        } else {
            if (validate.checkInt(accId)) {
                retrieve = new RetrieveChoice();
                retrieve.renderInfoTable(db.infoSearch(Integer.valueOf(accId)));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Account ID !", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton_searchinfoMouseClicked

    private void jButton_searchinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchinfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_searchinfoActionPerformed

    private void jButton_searchlschedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_searchlschedMouseClicked
        String accId = JOptionPane.showInputDialog("Enter Account Id:");
        if (accId == null) {
            this.setVisible(true);
        } else {
            if (validate.checkInt(accId)) {
                retrieve = new RetrieveChoice();
                retrieve.renderScheduleTable(db.schedSearch(Integer.valueOf(accId)));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Account ID !", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            }
        }

    }//GEN-LAST:event_jButton_searchlschedMouseClicked

    private void jButton_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_cancelMouseClicked
        this.setVisible(false);
        new ChoiceEnrollment().setVisible(true);
    }//GEN-LAST:event_jButton_cancelMouseClicked

    private void jButton_searchaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_searchaccMouseClicked
        String accId = JOptionPane.showInputDialog("Enter Account Id:");
        if (accId == null) {
            this.setVisible(true);
        } else {
            if (validate.checkInt(accId)) {
                retrieve = new RetrieveChoice();
                retrieve.renderAccountTable(db.accSearch(Integer.valueOf(accId)));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Account ID !", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton_searchaccMouseClicked

    private void jButton_searchaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_searchaccActionPerformed

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
            java.util.logging.Logger.getLogger(SearchChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchChoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_searchacc;
    private javax.swing.JButton jButton_searchinfo;
    private javax.swing.JButton jButton_searchlsched;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}