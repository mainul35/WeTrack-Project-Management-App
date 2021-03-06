/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Config.ConnectionManager;
import com.JDBC.JDBCManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author FURIOUS
 */
public class ShowSkills extends AbstractFrame {

    JPanel pnlCheckbox = new JPanel();
    static String[] users = null;
    static JLabel[] lblDependentPhases = null;
    static ArrayList<String> tempSelectedPhaseName = new ArrayList<>();
    static ArrayList<String> tempSelectedPhaseId = new ArrayList<>();
    private static JFrame frame;

    /**
     * Creates new form SelectGamePlayerRegistrationForm
     */
    public ShowSkills(long phaseId) {
        initComponents();
        frame = this;
        JDBCManager manager = ConnectionManager.getConnection();
        String sql = "select skill.skillName from skill, phase, skillsForPhase\n"
                + "where skill.skillId = skillsForPhase.skillId\n"
                + "and phase.phaseId = skillsForPhase.phaseId\n"
                + "and phase.phaseId = ?";

        //Copied code
        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, phaseId);
        int size = al.size();
        users = new String[size];
        pnlCheckbox.setLayout(new GridLayout(size, 1, 0, 2));
        lblDependentPhases = new JLabel[size];
        for (int i = 0; i < size; i++) {
            lblDependentPhases[i] = new JLabel();
            lblDependentPhases[i].setText(al.get(i).get("skillName"));
            pnlCheckbox.add(lblDependentPhases[i]);
        }

        frame.setDefaultCloseOperation(2);

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpn = new javax.swing.JScrollPane(pnlCheckbox);
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setText("Close");

        jLabel1.setText("Skills required for this phase");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpn)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(jLabel1))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scpn;
    // End of variables declaration//GEN-END:variables
}
