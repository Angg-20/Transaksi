package Form;

import Koneksi.Database;
import Model.MUser;
import Model.Mmeja;
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
    List<Mmeja> Lmeja = new ArrayList<>();
    List<MUser> Luser = new ArrayList<>();

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
        Tpetugas.setText("");
        Tnamapetugas.setText("");
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

        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TNmenu = new javax.swing.JTextField();
        Tnamapetugas = new javax.swing.JTextField();
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
        Tpetugas = new javax.swing.JTextField();
        Bsimpan = new javax.swing.JButton();
        Btambah = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Tmenu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Tnamapelanggan1 = new javax.swing.JTextField();
        Tpelanggan1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Tmeja = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Tharga = new javax.swing.JTextField();
        Tkapasitas = new javax.swing.JTextField();

        jLabel7.setText("Kode Petugas");

        jLabel10.setText("Harga");

        TNmenu.setEditable(false);

        Tnamapetugas.setEditable(false);

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

        jLabel8.setText("Nama Petugas");

        jLabel9.setText("Kode Menu");

        Tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidActionPerformed(evt);
            }
        });

        Tpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpetugasActionPerformed(evt);
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

        jLabel13.setText("Kode Pelanggan");

        jLabel14.setText("Nama pelanggan");

        Tnamapelanggan1.setEditable(false);

        Tpelanggan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tpelanggan1ActionPerformed(evt);
            }
        });

        jLabel15.setText("No Meja");

        Tmeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmejaActionPerformed(evt);
            }
        });

        jLabel16.setText("Kapasitas");

        Tharga.setEditable(false);

        Tkapasitas.setEditable(false);

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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(Tmeja, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(Tkapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(Tpelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tnamapelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(Tpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(Tnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(Tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel10)
                                                .addGap(171, 171, 171))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
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
                        .addComponent(Tpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tpelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tnamapelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tmeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tkapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
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
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpetugasActionPerformed
        String id_petugas = Tpetugas.getText();
        for (MUser petugas : Luser) {
            if (String.valueOf(petugas.getId_user()).equals(id_petugas)) {
                Tnamapetugas.setText(petugas.getUsername());
                break;
            }
        }
    }//GEN-LAST:event_TpetugasActionPerformed

    private void TmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmenuActionPerformed
        String id_menu = Tmenu.getText();
        for (Mmenu menu : Lmenu) {
            if (String.valueOf(menu.getId_menu()).equals(id_menu)) {
                TNmenu.setText(menu.getNama_menu());
                Tharga.setText(String.valueOf(menu.getHarga()));
                break;
            }
        }
    }//GEN-LAST:event_TmenuActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        if (row >= 0) {
            Tmenu.setText(Table.getValueAt(row, 0).toString());
            TNmenu.setText(Table.getValueAt(row, 1).toString());
            Tjumlah.setText(Table.getValueAt(row, 2).toString());
            Tharga.setText(Table.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_TableMouseClicked

    private void BtambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtambahMouseClicked
        String id_menu = Tmenu.getText();
        String nama_menu = TNmenu.getText();
        int jumlah = Integer.parseInt(Tjumlah.getText());
        int harga = Integer.parseInt(Tharga.getText());
        int subTotal = jumlah * harga;

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.addRow(new Object[]{id_menu, nama_menu, jumlah, harga, subTotal});

        Tmenu.setText("");
        TNmenu.setText("");
        Tjumlah.setText("");
        Tharga.setText("");
    }//GEN-LAST:event_BtambahMouseClicked

    private void BhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhapusMouseClicked
        int row = Table.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_BhapusMouseClicked

    private void BsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsimpanMouseClicked
        try (Connection DB = Database.KoneksiDB()) {
            String Query = "INSERT INTO pesanan (id_pesanan, id_pelanggan, id_user, id_meja) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement Saya = DB.prepareStatement(Query);
            Saya.setString(1, Tid.getText());
            Saya.setString(2, Tpelanggan1.getText());
            Saya.setString(3, Tpetugas.getText());
            Saya.setString(4, Tmeja.getText());

            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            double total = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                total += Double.parseDouble(model.getValueAt(i, 4).toString());
            }
            Saya.setDouble(5, total);
            Saya.executeUpdate();

            for (int i = 0; i < model.getRowCount(); i++) {
                String QueryDetail = "INSERT INTO detail_pesanan (id_pesanan, id_menu, jumlah) VALUES (?, ?, ?)";
                PreparedStatement SayaDetail = DB.prepareStatement(QueryDetail);
                SayaDetail.setString(1, Tid.getText());
                SayaDetail.setString(2, model.getValueAt(i, 0).toString());
                SayaDetail.setInt(3, Integer.parseInt(model.getValueAt(i, 2).toString()));
                SayaDetail.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
            model.setRowCount(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_BsimpanMouseClicked

    private void Tpelanggan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tpelanggan1ActionPerformed
        String id_pelanggan = Tpelanggan1.getText();
        for (Mpelanggan pelanggan : Lpelanggan) {
            if (String.valueOf(pelanggan.getId_pelanggan()).equals(id_pelanggan)) {
                Tnamapelanggan1.setText(pelanggan.getNama_pelanggan());
                break;
            }
        }
    }//GEN-LAST:event_Tpelanggan1ActionPerformed

    private void TmejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmejaActionPerformed
        String id_meja = Tmeja.getText();
        for (Mmeja meja : Lmeja) {
            if (String.valueOf(meja.getId_meja()).equals(id_meja)) {
                Tkapasitas.setText(String.valueOf(meja.getKapasitas()));
                break;
            }
        }
    }//GEN-LAST:event_TmejaActionPerformed

    private void TidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsimpan;
    private javax.swing.JButton Btambah;
    private javax.swing.JTextField TNmenu;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tharga;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tjumlah;
    private javax.swing.JTextField Tkapasitas;
    private javax.swing.JTextField Tmeja;
    private javax.swing.JTextField Tmenu;
    private javax.swing.JTextField Tnamapelanggan1;
    private javax.swing.JTextField Tnamapetugas;
    private javax.swing.JTextField Tpelanggan1;
    private javax.swing.JTextField Tpetugas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tanggal;
    // End of variables declaration//GEN-END:variables
}
