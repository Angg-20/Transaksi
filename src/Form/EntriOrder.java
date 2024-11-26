/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.Database;
import Model.Mpelanggan;
import Model.Mmenu;
import Model.Morder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Client
 */
public class EntriOrder extends javax.swing.JInternalFrame {

    List<Mpelanggan> Lpelanggan = new ArrayList<>();
    List<Mmenu> Lmenu = new ArrayList<>();
    List<Morder> Lorder = new ArrayList<>();
    
    public EntriOrder() {
        initComponents();
        AmbilDataPelanggan();
        AmbilDataMenu();
        AmbilDataOrder();
        TampilkanData();
        kosong();
    }
    
    private void kosong() {
        Tid.setText("");
        Tpelanggan.setText("");
        Tnamapelanggan.setText("");
        Tmenu.setText("");
        TNmenu.setText("");
        Tjumlah.setText("");
        Tharga.setText("");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal.setText(sdf.format(new Date()));
    }
    
    private void AmbilDataPelanggan() {
        try (Connection DB = Database.KoneksiDB()) {
            PreparedStatement Query = DB.prepareStatement("SELECT * FROM pelanggan");
            ResultSet Hasil = Query.executeQuery();
            Lpelanggan.clear();
            while (Hasil.next()) {
                Lpelanggan.add(new Mpelanggan(
                        Hasil.getInt("id_pelanggan"),
                        Hasil.getString("nama_pelanggan"),
                        Hasil.getString("jenis_kelamin"),
                        Hasil.getString("alamat"),
                        Hasil.getString("nohp")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void AmbilDataMenu() {
        try (Connection DB = Database.KoneksiDB()) {
            PreparedStatement Query = DB.prepareStatement("SELECT * FROM menu");
            ResultSet Hasil = Query.executeQuery();
            Lmenu.clear();
            while (Hasil.next()) {
                Lmenu.add(new Mmenu(
                        Hasil.getInt("id_menu"),
                        Hasil.getInt("harga"),
                        Hasil.getString("nama_menu")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void AmbilDataOrder() {
        try (Connection DB = Database.KoneksiDB()) {
            PreparedStatement Query = DB.prepareStatement("SELECT * FROM pesanan");
            ResultSet Hasil = Query.executeQuery();
            Lorder.clear();
            while (Hasil.next()) {
                Lorder.add(new Morder(
                        Hasil.getInt("id_pesanan"),
                        Hasil.getInt("id_pelanggan"),
                        Hasil.getInt("id_menu"),
                        Hasil.getInt("jumlah"),
                        Hasil.getInt("total"),
                        Hasil.getString("tanggal")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void TampilkanData() {
        DefaultTableModel TB = (DefaultTableModel) Table.getModel();
        TB.setRowCount(0);
        for (Morder M : Lorder) {
            Object[] isi = new Object[5];
            isi[0] = M.getId_menu();
            for (Mmenu menu : Lmenu) {
                if (menu.getId_menu() == M.getId_menu()) {
                    isi[1] = menu.getNama_menu();
                    isi[3] = menu.getHarga();
                }
            }
            isi[2] = M.getJumlah();
            isi[4] = M.getTotal_bayar();
            TB.addRow(isi);
        }
        Table.setModel(TB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tharga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TNmenu = new javax.swing.JTextField();
        Tnamapelanggan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Tjumlah = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tid = new javax.swing.JTextField();
        Tpelanggan = new javax.swing.JTextField();
        Bsimpan = new javax.swing.JButton();
        Btambah = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Tmenu = new javax.swing.JTextField();

        Tharga.setEditable(false);
        Tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThargaActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode Pelanggan");

        jLabel10.setText("Harga");

        TNmenu.setEditable(false);

        Tnamapelanggan.setEditable(false);

        jLabel11.setText("Nama Menu");

        jLabel12.setText("Jumlah");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Menu", "Nama Menu", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jLabel5.setText("Kode Pesan");

        tanggal.setEditable(false);

        jLabel6.setText("Tanggal");

        jLabel8.setText("Nama pelanggan");

        jLabel9.setText("Kode Menu");

        Tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidActionPerformed(evt);
            }
        });

        Tpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpelangganActionPerformed(evt);
            }
        });

        Bsimpan.setText("simpan");
        Bsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BsimpanMouseClicked(evt);
            }
        });

        Btambah.setText("Tambah");
        Btambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtambahMouseClicked(evt);
            }
        });

        Bhapus.setText("Hapus");
        Bhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BhapusMouseClicked(evt);
            }
        });

        Tmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(Tmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(TNmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(Tnamapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(Tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tnamapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TNmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(26, 26, 26)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bsimpan)
                    .addComponent(Btambah)
                    .addComponent(Bhapus))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThargaActionPerformed
    }//GEN-LAST:event_ThargaActionPerformed

    private void TidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidActionPerformed
    }//GEN-LAST:event_TidActionPerformed

    private void TpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpelangganActionPerformed
        String id_pelanggan = Tpelanggan.getText();
        for(Mpelanggan pelanggan : Lpelanggan) {
            if(String.valueOf(pelanggan.getId_pelanggan()).equals(id_pelanggan)) {
                Tnamapelanggan.setText(pelanggan.getNama_pelanggan());
                break;
            }
        }
    }//GEN-LAST:event_TpelangganActionPerformed

    private void TmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmenuActionPerformed
        String id_menu = Tmenu.getText();
        for(Mmenu menu : Lmenu) {
            if(String.valueOf(menu.getId_menu()).equals(id_menu)) {
                TNmenu.setText(menu.getNama_menu());
                Tharga.setText(String.valueOf(menu.getHarga()));
                break;
            }
        }
    }//GEN-LAST:event_TmenuActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        if(row >= 0) {
            Tmenu.setText(Table.getValueAt(row, 0).toString());
            TNmenu.setText(Table.getValueAt(row, 1).toString());
            Tjumlah.setText(Table.getValueAt(row, 2).toString());
            Tharga.setText(Table.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_TableMouseClicked

    private void BtambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtambahMouseClicked
        kosong();
    }//GEN-LAST:event_BtambahMouseClicked

    private void BhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhapusMouseClicked
        int row = Table.getSelectedRow();
        if(row >= 0) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_BhapusMouseClicked

    private void BsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsimpanMouseClicked
        try {
            Connection DB = Database.KoneksiDB();
            String sql = "INSERT INTO pesanan (id_pelanggan, id_menu, jumlah, total, tanggal) VALUES (?,?,?,?,?)";
            PreparedStatement ps = DB.prepareStatement(sql);
            
            ps.setInt(1, Integer.parseInt(Tpelanggan.getText()));
            ps.setInt(2, Integer.parseInt(Tmenu.getText()));
            ps.setInt(3, Integer.parseInt(Tjumlah.getText()));
            ps.setInt(4, Integer.parseInt(Tjumlah.getText()) * Integer.parseInt(Tharga.getText()));
            ps.setString(5, tanggal.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            
            AmbilDataOrder();
            TampilkanData();
            kosong();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BsimpanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsimpan;
    private javax.swing.JButton Btambah;
    private javax.swing.JTextField TNmenu;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tjumlah;
    private javax.swing.JTextField Tmenu;
    private javax.swing.JTextField Tnamapelanggan;
    private javax.swing.JTextField Tpelanggan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tanggal;
    // End of variables declaration//GEN-END:variables
}
