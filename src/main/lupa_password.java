/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class lupa_password extends javax.swing.JFrame {
    String username = "root";
    String password = "";
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form lupa_password
     */
    public lupa_password() {
        initComponents();
        setTitle("Lupa Password");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        txt_notelp = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_konfirpw = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBackground(new java.awt.Color(0,0,0,0));
        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_username.setForeground(new java.awt.Color(84, 153, 58));
        txt_username.setBorder(null);
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 500, 50));

        txt_notelp.setBackground(new java.awt.Color(0,0,0,0));
        txt_notelp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_notelp.setForeground(new java.awt.Color(84, 153, 58));
        txt_notelp.setBorder(null);
        getContentPane().add(txt_notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 419, 500, 50));

        txt_password.setBackground(new java.awt.Color(0,0,0,0));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_password.setForeground(new java.awt.Color(84, 153, 58));
        txt_password.setBorder(null);
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 310, 500, 50));

        txt_konfirpw.setBackground(new java.awt.Color(0,0,0,0));
        txt_konfirpw.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_konfirpw.setForeground(new java.awt.Color(84, 153, 58));
        txt_konfirpw.setBorder(null);
        getContentPane().add(txt_konfirpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 419, 500, 50));

        btn_simpan.setBackground(new java.awt.Color(0,0,0,0));
        btn_simpan.setBorder(null);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 210, 50));

        btn_kembali.setBackground(new java.awt.Color(0,0,0,0));
        btn_kembali.setBorder(null);
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Lupa password.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String Username = txt_username.getText();
        String No_telp = txt_notelp.getText();
        String Password = String.valueOf(txt_password.getText());
        String confirmPassword = String.valueOf(txt_konfirpw.getText());
        new login().setVisible(true);
        
        try {
            // Mengecek apakah username dan nomor telepon sesuai
            String sql = "SELECT * FROM karyawan WHERE username="+"'"+Username+"'"+" AND no_telp='"+No_telp+"'";
            Connection conn = (Connection) koneksi.configDB();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            System.out.println("Koneksi Berhasil!!");
            
            if (r.next()) {
                // Mengecek apakah password dan konfirmasi password sama
                if (Password.equals(confirmPassword)) {
                    // Mengubah password pada database
                    String sql2 = "UPDATE karyawan SET password='"+Password+"' WHERE username='"+Username+"'";
                    PreparedStatement pst = conn.prepareStatement(sql2);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password berhasil diubah, silahkan login kembali!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password dan konfirmasi password tidak sesuai");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau nomor telepon tidak ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengatur ulang password: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lupa_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lupa_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lupa_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lupa_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lupa_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_konfirpw;
    private javax.swing.JTextField txt_notelp;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
