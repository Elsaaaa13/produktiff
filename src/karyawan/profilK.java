/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import main.koneksi;
import main.login;
import owner.dashboardO;

/**
 *
 * @author LENOVO
 */
public class profilK extends javax.swing.JFrame {

    /**
     * Creates new form profilK
     */
    public profilK() {
        initComponents();
        setTitle("Profil Karyawan");
         showData(login.namaUser);
    }

    private void showData(String username){
        try{
            String query = "SELECT * FROM karyawan WHERE username = '"+username+"'";
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(query);
            
            if(r.next()){
                this.lbl_id.setText(r.getString("id_karyawan"));
                this.txt_nama.setText(r.getString("nama_karyawan"));
                lbl_username.setText(login.namaUser);
                this.lbl_password.setText(r.getString("password"));
                this.txt_notelp.setText(r.getString("no_telp"));
                this.txt_alamat.setText(r.getString("alamat"));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
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

        btn_kembali = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        lbl_username = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_notelp = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        btn_edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_kembali.setBackground(new java.awt.Color(0,0,0,0));
        btn_kembali.setBorder(null);
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 50));

        lbl_id.setBackground(new java.awt.Color(255, 255, 255));
        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(84, 153, 58));
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id.setOpaque(true);
        getContentPane().add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 150, 30));

        txt_nama.setBackground(new java.awt.Color(0,0,0,0));
        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(84, 153, 58));
        txt_nama.setBorder(null);
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 198, 490, 40));

        lbl_username.setBackground(new java.awt.Color(0,0,0,0));
        lbl_username.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(84, 153, 58));
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 293, 365, 38));

        lbl_password.setBackground(new java.awt.Color(0,0,0,0));
        lbl_password.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(84, 153, 58));
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 293, 360, 38));

        txt_notelp.setBackground(new java.awt.Color(0,0,0,0));
        txt_notelp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_notelp.setForeground(new java.awt.Color(84, 153, 58));
        txt_notelp.setBorder(null);
        getContentPane().add(txt_notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 383, 400, 40));

        txt_alamat.setBackground(new java.awt.Color(0,0,0,0));
        txt_alamat.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_alamat.setForeground(new java.awt.Color(84, 153, 58));
        txt_alamat.setBorder(null);
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 480, 740, 60));

        btn_edit.setBackground(new java.awt.Color(0,0,0,0));
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, 200, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Profile_karyawan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        new dashboardKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            String namaK = this.txt_nama.getText(),
            notelpK = this.txt_notelp.getText(),
            alamatK = this.txt_alamat.getText(),
            usernameK = this.lbl_username.getText(),
            passwordK = this.lbl_password.getText(),
            idK = this.lbl_id.getText(),
            sql;
            sql = String.format("UPDATE karyawan SET nama_karyawan= '%s', no_telp= '%s', alamat = '%s' WHERE username = '%s'",  namaK, notelpK, alamatK, usernameK, passwordK, idK);

            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            this.showData(login.getNama());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        showData(login.namaUser);
    }//GEN-LAST:event_btn_editActionPerformed

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
            java.util.logging.Logger.getLogger(profilK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profilK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profilK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profilK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profilK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}