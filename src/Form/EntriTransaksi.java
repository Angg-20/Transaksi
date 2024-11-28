package Form;

import Koneksi.Database;
import Model.MUser;
import Model.Mmeja;
import Model.Mmenu;
import Model.Morder;
import Model.Mpelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntriTransaksi extends javax.swing.JInternalFrame {

    List<Mpelanggan> Lpelanggan = new ArrayList<>();
    List<Mmenu> Lmenu = new ArrayList<>();
    List<Morder> Lorder = new ArrayList<>();
    List<Mmeja> Lmeja = new ArrayList<>();
    List<MUser> Luser = new ArrayList<>();

    public EntriTransaksi() {
        initComponents();
        AmbilDataMeja();
        AmbilDataMenu();
        AmbilDataOrder();
        AmbilDataPelanggan();
        AmbilDataUser();
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

    private void AmbilDataUser() {
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

    private void AmbilDataMeja() {
        try {
            Connection db = Database.KoneksiDB();
            PreparedStatement ps = db.prepareStatement("Select * from meja");
            ResultSet hasil = ps.executeQuery();
            Lmeja.clear();
            while (hasil.next()) {
                Lmeja.add(new Mmeja(hasil.getInt("id_meja"), hasil.getInt("no_meja"), hasil.getInt("kapasitas")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        Ttransaksi = new javax.swing.JTextField();
        Ttanggal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Tpesanan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Tpelanggan = new javax.swing.JTextField();
        Tmeja = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jLabel8.setText("Nama pelanggan");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama barang", "Jumlah", "Harga", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel13.setText("Total");

        jLabel14.setText("Bayar");

        jLabel5.setText("Kode Transaksi");

        jLabel15.setText("Kembalian");

        jLabel6.setText("Tanggal");

        jButton2.setText("Simpan");

        Tpesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpesananActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode pesanan");

        jLabel16.setText("No Meja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(Ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Tpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(Ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(Tpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(Tmeja, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tmeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TpesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpesananActionPerformed
        String id_pesanan = Tpesanan.getText();
        for (Morder m : Lorder) {
            if (String.valueOf(m.getId_order()).equals(id_pesanan)) {
                int id_pelanggan = m.getId_pelanggan();
                int id_meja = m.getId_meja();
                break;
            }
        }
        for (Mpelanggan mp : Lpelanggan) {
            String kodep = String.valueOf(id_pesanan);
            if (String.valueOf(mp.getId_pelanggan()).equals(kodep)) {
                Tpelanggan.setText(mp.getNama_pelanggan());
            }
        }
        for (Mmeja mm : Lmeja) {
            if (String.valueOf(mm.getId_meja()).equals(id_pesanan)) {
                Tmeja.setText(String.valueOf(mm.getNo_meja()));
            }
        }
    }//GEN-LAST:event_TpesananActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tmeja;
    private javax.swing.JTextField Tpelanggan;
    private javax.swing.JTextField Tpesanan;
    private javax.swing.JTextField Ttanggal;
    private javax.swing.JTextField Ttransaksi;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    // End of variables declaration//GEN-END:variables
}
