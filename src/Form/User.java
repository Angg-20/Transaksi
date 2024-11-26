/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.Database;
import Model.MUser;
import Model.Mmenu;
import Model.Mpelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braga
 */
public class User extends javax.swing.JInternalFrame {

    List<MUser> Luser = new ArrayList<>();
    
    public User() {
        initComponents();
        AmbilData();
        TampilkanData();
    }

    private void kosong() {
        Tid.setText("");
        Tusername.setText("");
        Tpassword.setText("");
        Role.setSelectedIndex(0);
    }

    private void AmbilData() {
        try (Connection DB = Database.KoneksiDB()) {
            PreparedStatement Query = DB.prepareStatement("SELECT * FROM user");
            ResultSet Hasil = Query.executeQuery();
            Luser.clear();
            while (Hasil.next()) {
                Luser.add(new MUser(
                        Hasil.getInt("id_user"),
                        Hasil.getString("username"),
                        Hasil.getString("password"),
                        Hasil.getString("role")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void TampilkanData() {
        DefaultTableModel TB = (DefaultTableModel) Table.getModel();
        TB.setRowCount(0);
        for (MUser M : Luser) {
            Object[] isi = new Object[4];
            isi[0] = M.getId_user();
            isi[1] = M.getUsername();
            isi[2] = M.getPassword(); 
            isi[3] = M.getRole();
            TB.addRow(isi);
        }
        Table.setModel(TB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Tusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tpassword = new javax.swing.JTextField();
        Bsimpan = new javax.swing.JButton();
        Bbatal = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Role = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode user");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("username");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("password");

        Bsimpan.setText("Simpan");
        Bsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BsimpanMouseClicked(evt);
            }
        });

        Bbatal.setText("Batal");
        Bbatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BbatalMouseClicked(evt);
            }
        });

        Bhapus.setText("Hapus");
        Bhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BhapusMouseClicked(evt);
            }
        });

        Bedit.setText("Edit");
        Bedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeditMouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("role");

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrator", "waiter", "kasir", "owner" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tid)
                    .addComponent(Tusername)
                    .addComponent(Tpassword)
                    .addComponent(Bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(Bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode user", "username", "password", "role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsimpanMouseClicked
        try {
            String sql = "INSERT INTO user(id_user, username, password, role) VALUES (?,?,?,?)";
            Connection conn = Database.KoneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Tid.getText());
            pst.setString(2, Tusername.getText());
            pst.setString(3, Tpassword.getText());
            pst.setString(4, Role.getSelectedItem().toString());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
            AmbilData();
            TampilkanData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_BsimpanMouseClicked

    private void BbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbatalMouseClicked
        kosong();
    }//GEN-LAST:event_BbatalMouseClicked

    private void BhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhapusMouseClicked
        try {
            String sql = "DELETE FROM user WHERE id_user=?";
            Connection conn = Database.KoneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Tid.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            kosong();
            AmbilData();
            TampilkanData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_BhapusMouseClicked

    private void BeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeditMouseClicked
        try {
            String sql = "UPDATE user SET username=?, password=?, role=? WHERE id_user=?";
            Connection conn = Database.KoneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Tusername.getText());
            pst.setString(2, Tpassword.getText());
            pst.setString(3, Role.getSelectedItem().toString());
            pst.setString(4, Tid.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            kosong();
            AmbilData();
            TampilkanData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_BeditMouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int sr = Table.getSelectedRow();
        String NS = Table.getValueAt(sr, 0).toString();
        for (MUser m : Luser) {
            if (m.getId_user() == Integer.parseInt(NS)) {
                Tid.setText(String.valueOf(m.getId_user()));
                Tusername.setText(m.getUsername());
                Tpassword.setText(m.getPassword());
                Role.setSelectedItem(m.getRole());
            }
        }
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bbatal;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsimpan;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tpassword;
    private javax.swing.JTextField Tusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
