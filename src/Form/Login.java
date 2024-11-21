package Form;

import Koneksi.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Tusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Lerror = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        Tpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        Lerror.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        Lerror.setForeground(new java.awt.Color(255, 51, 51));
        Lerror.setText("Error");

        Login.setText("Login");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });

        Tpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(Tusername)
                        .addComponent(Lerror, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Login)
                            .addGap(72, 72, 72))
                        .addComponent(Tpassword)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lerror)
                .addGap(24, 24, 24)
                .addComponent(Login)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        String username = Tusername.getText();
        String password = new String(Tpassword.getPassword());
        if (username.isEmpty()) {
            Lerror.setText("Username harus di isi");
        } else if (password.isEmpty()) {
            Lerror.setText("Password harus di isi");
        } else {
            try {
                Connection db = Database.KoneksiDB();
                String Query = "SELECT * FROM user WHERE username = ? && password = ?";
                PreparedStatement ps = db.prepareStatement(Query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet hasil = ps.executeQuery();
                if (hasil.next()) {
                    String role = hasil.getString("role");
                    if ("administrator".equalsIgnoreCase(role)) {
                        new DashBoardUtama().setVisible(true);
                        setVisible(false);
                    } else if ("waiter".equalsIgnoreCase(role)) {
                        new DashBoardUtama().setVisible(true);
                        setVisible(false);
                    } else if ("kasir".equalsIgnoreCase(role)) {
                        new DashBoardUtama().setVisible(true);
                        setVisible(false);
                    } else if ("owner".equalsIgnoreCase(role)) {
                        new DashBoardUtama().setVisible(true);
                        setVisible(false);
                    }
                } else {
                    Lerror.setText("username / password Salah");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_LoginMouseClicked

    private void TpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpasswordActionPerformed
    }//GEN-LAST:event_TpasswordActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lerror;
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Tpassword;
    private javax.swing.JTextField Tusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
