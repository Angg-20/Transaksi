package Form;

import Koneksi.Database;
import Model.Mmeja;
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

public class EntriMeja extends javax.swing.JInternalFrame {

    List<Mmeja> Lmeja = new ArrayList<>();

    public EntriMeja() {
        initComponents();
        AmbilData();
        TampilkanData();
    }

    public void kosong() {
        Tid.setText("");
        Tmeja.setText("");
    }

    public void AmbilData() {
        try {
            Connection db = Database.KoneksiDB();
            PreparedStatement ps = db.prepareStatement("Select * from meja");
            ResultSet hasil = ps.executeQuery();
            Lmeja.clear();
            while (hasil.next()) {
                Lmeja.add(new Mmeja(hasil.getInt("id_meja"), hasil.getInt("no_meja")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void TampilkanData() {
        DefaultTableModel TB = (DefaultTableModel) Table.getModel();
        TB.setRowCount(0);
        for (Mmeja M : Lmeja) {
            Object[] isi = new Object[2];
            isi[0] = M.getId_meja();
            isi[1] = M.getNo_meja();
            TB.addRow(isi);
        }
        Table.setModel(TB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Tid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Tmeja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Bsimpan = new javax.swing.JButton();
        Bbatal = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();

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

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Menu", "Nama Menu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jLabel4.setText("Meja");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Meja");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No Meja");

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
                    .addComponent(Tmeja)
                    .addComponent(Bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
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
                .addComponent(Tmeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(Bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int sr = Table.getSelectedRow();
        String NS = Table.getValueAt(sr, 0).toString();
        for (Mmeja m : Lmeja) {
            if (m.getId_meja() == Integer.parseInt(NS)) {
                Tid.setText(String.valueOf(m.getId_meja()));
                Tmeja.setText(String.valueOf(m.getNo_meja()));
            }
        }
    }//GEN-LAST:event_TableMouseClicked

    private void BsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsimpanMouseClicked
        String Kmeja = Tid.getText();
        String Nmeja = Tmeja.getText();

        Connection db = Database.KoneksiDB();
        String Query = "INSERT INTO meja(id_meja, no_meja)values (?, ?)";
        try {
            PreparedStatement ps = db.prepareStatement(Query);
            ps.setString(1, Kmeja);
            ps.setString(2, Nmeja);
            ps.execute();
            AmbilData();
            TampilkanData();
            kosong();
        } catch (SQLException ex) {
            Logger.getLogger(EntriMeja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BsimpanMouseClicked

    private void BbatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BbatalMouseClicked
        kosong();
    }//GEN-LAST:event_BbatalMouseClicked

    private void BhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhapusMouseClicked
        Connection con = Database.KoneksiDB();
        String query = "DELETE FROM meja WHERE id_meja = ?";
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
            kosong();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BhapusMouseClicked

    private void BeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeditMouseClicked
        String Kmeja = Tid.getText();
        String Nmeja = Tmeja.getText();

        Connection db = Database.KoneksiDB();
        String Query = "Update meja set no_meja = ? where id_meja = ?";
        try {
            PreparedStatement ps = db.prepareStatement(Query);
            ps.setString(1, Nmeja);
            ps.setString(2, Kmeja);
            ps.executeUpdate();
            AmbilData();
            TampilkanData();
        } catch (SQLException ex) {
            Logger.getLogger(EntriMeja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        kosong();
    }//GEN-LAST:event_BeditMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        TampilkanData();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bbatal;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bsimpan;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tid;
    private javax.swing.JTextField Tmeja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
