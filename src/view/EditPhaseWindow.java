/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Mainul35
 */
public class EditPhaseWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditPhaseWindow
     */
    static Long currentPhase;
    public EditPhaseWindow(Long phaseId) {
        currentPhase = phaseId;
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

        lblSelectDependencyPhases = new javax.swing.JLabel();
        lblShowDependencyPhases = new javax.swing.JLabel();
        lblShowSkills = new javax.swing.JLabel();
        lblShowAssignedUsers = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelectDependencyPhases.setText("Select dependency phase...");
        lblSelectDependencyPhases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectDependencyPhasesMouseClicked(evt);
            }
        });

        lblShowDependencyPhases.setText("Show dependency phases...");
        lblShowDependencyPhases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowDependencyPhasesMouseClicked(evt);
            }
        });

        lblShowSkills.setText("Show skills...");
        lblShowSkills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowSkillsMouseClicked(evt);
            }
        });

        lblShowAssignedUsers.setText("Show assigned users...");
        lblShowAssignedUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowAssignedUsersMouseClicked(evt);
            }
        });

        btnSave.setText("Save and close");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowAssignedUsers)
                    .addComponent(lblShowSkills)
                    .addComponent(lblShowDependencyPhases)
                    .addComponent(lblSelectDependencyPhases))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblSelectDependencyPhases)
                .addGap(18, 18, 18)
                .addComponent(lblShowDependencyPhases)
                .addGap(18, 18, 18)
                .addComponent(lblShowSkills)
                .addGap(18, 18, 18)
                .addComponent(lblShowAssignedUsers)
                .addGap(101, 101, 101)
                .addComponent(btnSave)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSelectDependencyPhasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectDependencyPhasesMouseClicked
        // TODO add your handling code here:
        SelectDependencyPhases sdp = new SelectDependencyPhases(currentPhase);
        sdp.setVisible(true);
    }//GEN-LAST:event_lblSelectDependencyPhasesMouseClicked

    private void lblShowDependencyPhasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowDependencyPhasesMouseClicked
        // TODO add your handling code here:
        ShowDependencyPhases sdp = new ShowDependencyPhases(currentPhase);
        sdp.setVisible(true);
    }//GEN-LAST:event_lblShowDependencyPhasesMouseClicked

    private void lblShowSkillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowSkillsMouseClicked
        // TODO add your handling code here:
        ShowSkills ss = new ShowSkills(currentPhase);
        ss.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblShowSkillsMouseClicked

    private void lblShowAssignedUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowAssignedUsersMouseClicked
        // TODO add your handling code here:
        ShowAssignedUsers sau = new ShowAssignedUsers(currentPhase);
        sau.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblShowAssignedUsersMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblSelectDependencyPhases;
    private javax.swing.JLabel lblShowAssignedUsers;
    private javax.swing.JLabel lblShowDependencyPhases;
    private javax.swing.JLabel lblShowSkills;
    // End of variables declaration//GEN-END:variables
}