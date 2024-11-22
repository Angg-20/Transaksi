package Form;

import Koneksi.Database;
import Model.Mmenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JInternalFrame {

    List<Mmenu> LMenu = new ArrayList<>();

    public Menu() {
        initComponents();
        AmbilData();
        TampilkanData();
    }

    private void AmbilData() {
        try (Connection DB = Database.KoneksiDB()) {
            PreparedStatement Query = DB.prepareStatement("SELECT * FROM menu");
            ResultSet Hasil = Query.executeQuery();
            LMenu.clear();
            while (Hasil.next()) {
                LMenu.add(new Mmenu(
                        Hasil.getInt("id_menu"),
                        Hasil.getInt("harga"),
                        Hasil.getString("nama_menu")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void TampilkanData() {
        DefaultTableModel TB = (DefaultTableModel) Table.getModel();
        TB.setRowCount(0);
        for (Mmenu M : LMenu) {
            Object[] isi = new Object[4];
            isi[0] = M.getId_menu();
            isi[1] = M.getNama_menu();
            isi[2] = M.getHarga();
            TB.addRow(isi);
        }
        Table.setModel(TB);
    }

    public void KMenuOtomatis(){
        try (Connection DB = Database.KoneksiDB()) {
            String query = "SELECT MAX(CAST(SUBSTRING(id_menu, 3) AS UNSIGNED)) AS max_id FROM menu";
            PreparedStatement stmt = DB.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }

            String Id = String.format("M-%03d", maxId + 1);
            Tid.setText(Id);
            Tid.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Tmenu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tharga = new javax.swing.JTextField();
        Bsimpan = new javax.swing.JButton();
        Bbatal = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Menu ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Menu");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Harga");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tid)
                    .addComponent(Tmenu)
                    .addComponent(Tharga)
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
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(Tmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                "Kode Menu", "Nama Menu", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jLabel4.setText("Menu");

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
        String Kmenu = Tid.getText();
        String Nmenu = Tmenu.getText();
        String Harga = Tharga.getText();

        Connection db = Database.KoneksiDB();
        String Query = "INSERT INTO menu(id_menu,nama_menu,harga)values(?, ?, ?)";
        try {
            PreparedStatement PS = db.prepareStatement(Query);
            PS.setString(1, Kmenu);
            PS.setString(2, Nmenu);
            PS.setString(3, Harga);
            PS.executeUpdate();
            AmbilData();
            TampilkanData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        Tid.setText("");
        Tmenu.setText("");
        Tharga.setText("");
    }//GEN-LAST:event_BsimpanMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        TampilkanData();
    }//GEN-LAST:event_formInternalFrameOpened

    private void BbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbatalMouseClicked
        Tid.setText("");
        Tmenu.setText("");
        Tharga.setText("");
    }//GEN-LAST:event_BbatalMouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int sr = Table.getSelectedRow();
        String NS = Table.getValueAt(sr, 0).toString();
        for (Mmenu m : LMenu) {
            if (m.getId_menu() == Integer.parseInt(NS)) {
                Tid.setText(String.valueOf(m.getId_menu()));
                Tmenu.setText(m.getNama_menu());
                Tharga.setText(String.valueOf(m.getHarga()));
            }
        }
    }//GEN-LAST:event_TableMouseClicked

    private void BeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeditMouseClicked
        String Kmenu = Tid.getText();
        String Nmenu = Tmenu.getText();
        String Harga = Tharga.getText();

        Connection db = Database.KoneksiDB();
        String Query = "UPDATE menu SET nama_menu=?, harga=? WHERE id_menu=?";
        try {
            PreparedStatement PS = db.prepareStatement(Query);
            PS.setString(1, Nmenu);
            PS.setString(2, Harga);
            PS.setString(3, Kmenu);
            PS.executeUpdate();
            AmbilData();
            TampilkanData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        Tid.setText("");
        Tmenu.setText("");
        Tharga.setText("");
    }//GEN-LAST:event_BeditMouseClicked

    private void BhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhapusMouseClicked
        Connection con = Database.KoneksiDB();
        String query = "DELETE FROM menu WHERE id_menu = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            int selectedRow = Table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus");
                return;
            }
            String NS = Table.getValueAt(selectedRow, 0).toString();
            pst.setString(1, NS);
            pst.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Berhasil Delete Data Pada Tabel");
            AmbilData();
            TampilkanData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        Tid.setText("");
        Tmenu.setText("");
        Tharga.setText("");
    }//GEN-LAST:event_BhapusMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bbatal;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsimpan;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
