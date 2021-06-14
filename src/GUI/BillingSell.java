/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Trade_Program.Program;
import User.Admin;
import User.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author AH
 */
public class BillingSell extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public int row_counter=0;
    public int selected_row=999;
    Object data_row[]=new Object[5];

    /**
     * Creates new form Users
     */
    public BillingSell() {

        initComponents();
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jTable1.getSelectedRow();
                usernametb.setText(model.getValueAt(i, 1).toString());
                passtb.setText(model.getValueAt(i, 2).toString());
                accounttypetb.setText(model.getValueAt(i, 3).toString());
                OrganisationalTb.setText(model.getValueAt(i, 4).toString());
                selected_row=Integer.parseInt(model.getValueAt(i, 0).toString());

            }
        });
        try{
            int index = 1;
            ArrayList<String[]> dbData=Program.client.sendData(Admin.viewCurrentSellOffers());
            for (String i[] : dbData) {
                data_row[0] = index++;
                data_row[1] = i[2];
                data_row[2] = i[3];
                data_row[3] = i[4];
                data_row[4] = i[1];
                row_counter= index;
                model.addRow(data_row);
            }
        }catch (Exception e){
            System.out.println("User init Error: "+e);

        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createadminlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LogoutLbl = new javax.swing.JLabel();
        AssetsLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usernametb = new javax.swing.JTextField();
        passtb = new javax.swing.JTextField();
        accounttypetb = new javax.swing.JTextField();
        OrganisationalTb = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        orglbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        createuserlbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/exit.png"))); // NOI18N
        jLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Trading Software");

        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/stock(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(235, 235, 235)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel5)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        createadminlbl.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        createadminlbl.setText("Create Sell Offer");
        createadminlbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                createadminlblMouseClicked(evt);
            }
        });

        //jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/cashback.png"))); // NOI18N

        LogoutLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/undo.png"))); // NOI18N
        LogoutLbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                LogoutLblMouseClicked(evt);
            }
        });



        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(60, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setText("Sell Offer:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Price");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Organisational Unit");

        usernametb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        passtb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        passtb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtbActionPerformed(evt);
            }
        });

        accounttypetb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        OrganisationalTb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        SaveBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        SaveBtn.setText("Save");
        SaveBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SaveBtnMouseClicked(evt);
            }
        });
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        EditBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        clearbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        Object[] columns = {"row_id","Asset Name", "Quantity", "Price", "Organisational Unit"};
        model.setColumnIdentifiers(columns);
        jTable1.setModel(model);
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Asset Name");



        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user.png"))); // NOI18N

        createuserlbl.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        createuserlbl.setText("Create Buy Offer");
        createuserlbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                createuserlblMouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(LogoutLbl))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(usernametb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(passtb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel14)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8))
                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel11))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(accounttypetb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(OrganisationalTb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(257, 257, 257)
                                                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createuserlbl)))
                                .addGap(57, 57, 57)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createadminlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AssetsLbl)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orglbl)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 200, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel15)
                                                .addComponent(createadminlbl))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(AssetsLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(orglbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(createuserlbl)
                                                        .addComponent(jLabel16))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernametb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passtb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accounttypetb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OrganisationalTb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearbtn))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SaveBtn)
                                        .addComponent(EditBtn)
                                        .addComponent(DeleteBtn))
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(LogoutLbl)
                                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        if(true){
            if(!(usernametb.getText().isEmpty() || passtb.getText().isEmpty() || accounttypetb.getText().isEmpty() || OrganisationalTb.getText().isEmpty())) {
                // TODO add your handling code here:
                String[][] databaseData;
                try{
                    Program.client.sendData(Member.buyOffer(usernametb.getText(), passtb.getText(), OrganisationalTb.getText()));

                    row_counter++;
                    data_row[0] = row_counter;

                    data_row[1] = usernametb.getText();
                    data_row[2] = passtb.getText();
                    data_row[3] = accounttypetb.getText();
                    data_row[4] = OrganisationalTb.getText();

                    model.addRow(data_row);

                }catch (Exception e){
                    System.out.println("Error: "+e);

                }



            }else{
                JOptionPane.showMessageDialog(this,"Please Enter Missing Information");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Account Type is not Valid");
        }




    }//GEN-LAST:event_SaveBtnActionPerformed

    private void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();
        model.setValueAt(usernametb.getText(), i, 1);
        model.setValueAt(passtb.getText(), i, 2);
        model.setValueAt(accounttypetb.getText(), i, 3);
        model.setValueAt(OrganisationalTb.getText(), i, 4);

        try{
            Program.client.sendData(Admin.editUser(usernametb.getText(), passtb.getText(), selected_row));
        }catch (Exception e){

        }

        usernametb.setText("");
        passtb.setText("");
        accounttypetb.setText("");
        OrganisationalTb.setText("");
        JOptionPane.showMessageDialog(this,"Information Updated");

    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if(i >=0){
            model.removeRow(i);
            try{
                Program.client.sendData(Admin.deleteUser(selected_row));
            }catch (Exception e){

            }

        }
        usernametb.setText("");
        passtb.setText("");
        accounttypetb.setText("");
        OrganisationalTb.setText("");
        JOptionPane.showMessageDialog(this,"User Deleted");
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        usernametb.setText("");
        passtb.setText("");
        accounttypetb.setText("");
        OrganisationalTb.setText(" ");
    }//GEN-LAST:event_clearbtnActionPerformed

    private void jLabel1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void SaveBtnMouseClicked(MouseEvent evt) {//GEN-FIRST:event_SaveBtnMouseClicked
        if(usernametb.getText().isEmpty() || passtb.getText().isEmpty() || accounttypetb.getText().isEmpty() || OrganisationalTb.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Missing Information");
        }
    }//GEN-LAST:event_SaveBtnMouseClicked

    private void EditBtnMouseClicked(MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked

    }//GEN-LAST:event_EditBtnMouseClicked

    private void LogoutLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_LogoutLblMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutLblMouseClicked

    private void createadminlblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_createadminlblMouseClicked
        new BillingSell().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createadminlblMouseClicked

    private void AssetsLblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_AssetsLblMouseClicked
        new BillingBuy().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AssetsLblMouseClicked

    private void passtbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtbActionPerformed

    private void orglblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_orglblMouseClicked
        new create_org().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orglblMouseClicked

    private void createuserlblMouseClicked(MouseEvent evt) {//GEN-FIRST:event_createuserlblMouseClicked
        new BillingBuy().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createuserlblMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssetsLbl;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel LogoutLbl;
    private javax.swing.JTextField OrganisationalTb;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField accounttypetb;
    private javax.swing.JButton clearbtn;
    private javax.swing.JLabel createadminlbl;
    private javax.swing.JLabel createuserlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel orglbl;
    private javax.swing.JTextField passtb;
    private javax.swing.JTextField usernametb;
    // End of variables declaration//GEN-END:variables
}
