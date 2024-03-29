/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_package;

import compositions.Account;
import compositions.Database;
import compositions.PersonalInfo;
import compositions.Schedule;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupC
 */
public class RetrieveChoice extends javax.swing.JFrame {
    
    Database db = new Database();

    /**
     * Creates new form RetrieveChoice
     */
    public RetrieveChoice() {
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_retAcc = new javax.swing.JButton();
        jButton_retPerInfo = new javax.swing.JButton();
        jButton_retSched = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Retrieve Information");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButton_retAcc.setBackground(new java.awt.Color(255, 102, 0));
        jButton_retAcc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_retAcc.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retAcc.setText("Accounts");
        jButton_retAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_retAccMouseClicked(evt);
            }
        });
        jButton_retAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retAccActionPerformed(evt);
            }
        });

        jButton_retPerInfo.setBackground(new java.awt.Color(255, 102, 0));
        jButton_retPerInfo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_retPerInfo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retPerInfo.setText("Personal Information");
        jButton_retPerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retPerInfoActionPerformed(evt);
            }
        });

        jButton_retSched.setBackground(new java.awt.Color(255, 102, 0));
        jButton_retSched.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_retSched.setForeground(new java.awt.Color(255, 255, 255));
        jButton_retSched.setText("Schedule");
        jButton_retSched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retSchedActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 102, 0));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_retAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_retSched, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_retPerInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_retAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_retPerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_retSched, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_retPerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retPerInfoActionPerformed
        this.renderInfoTable(db.retrieveInfo());
    }//GEN-LAST:event_jButton_retPerInfoActionPerformed

    private void jButton_retAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_retAccMouseClicked

    }//GEN-LAST:event_jButton_retAccMouseClicked

    private void jButton_retAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retAccActionPerformed
        this.renderAccountTable(db.retrieveAccount());
    }//GEN-LAST:event_jButton_retAccActionPerformed

    private void jButton_retSchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retSchedActionPerformed
        this.renderScheduleTable(db.retrieveSched());
    }//GEN-LAST:event_jButton_retSchedActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        this.setVisible(false);
        new ChoiceEnrollment().setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked
    
    public void renderInfoTable(ArrayList<PersonalInfo> info) {
        ArrayList<PersonalInfo> data = info;
        Object[][] rows = new Object[data.size()][5];
        for (int index = 0; index < data.size(); index++) {
            rows[index][0] = data.get(index).getId();
            rows[index][1] = data.get(index).getAccId();
            rows[index][2] = data.get(index).getfName();
            rows[index][3] = data.get(index).getlName();
            rows[index][4] = data.get(index).getAge();
        }
        Object[] cols = {
            "ID", "Account ID", "Firstname", "Lastname", "Age"
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, cols) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.getTableHeader().setFont(font);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "All Personal Information", JOptionPane.PLAIN_MESSAGE
        );
        
    }
    
    public void renderAccountTable(ArrayList<Account> account) {
        ArrayList<Account> data = account;
        
        Object[][] rows = new Object[data.size()][3];
        for (int index = 0; index < data.size(); index++) {
            rows[index][0] = data.get(index).getId();
            rows[index][1] = data.get(index).getUsername();
            rows[index][2] = data.get(index).getPassword();
        }
        Object[] cols = {
            "ID", "Username", "Password"
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, cols) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 16);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(40);
        table.getTableHeader().setPreferredSize(new Dimension(40, 40));
        table.getTableHeader().setFont(font);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "All Accounts", JOptionPane.PLAIN_MESSAGE
        );
        
    }
    
    public void renderScheduleTable(ArrayList<Schedule> sched) {
        ArrayList<Schedule> data = sched;
        Object[][] rows = new Object[data.size()][6];
        for (int index = 0; index < data.size(); index++) {
            rows[index][0] = data.get(index).getId();
            rows[index][1] = data.get(index).getAccId();
            rows[index][2] = data.get(index).getSubject();
            rows[index][3] = data.get(index).getUnits();
            rows[index][4] = data.get(index).getSchedule();
        }
        Object[] cols = {
            "ID", "Account ID", "Subject", "Units", "Schedule"
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, cols) {
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.getTableHeader().setFont(font);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "All Schedules", JOptionPane.PLAIN_MESSAGE
        );
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
            java.util.logging.Logger.getLogger(RetrieveChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetrieveChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetrieveChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetrieveChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetrieveChoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_retAcc;
    private javax.swing.JButton jButton_retPerInfo;
    private javax.swing.JButton jButton_retSched;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
