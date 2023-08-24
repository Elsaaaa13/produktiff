/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import main.koneksi;
import javax.swing.JOptionPane;
import karyawan.dashboardKr;
import owner.dashboardO;
import owner.dashboardO;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class login extends javax.swing.JFrame {

    public static String getNama() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static String username = "";

    public static String namaUser;

    /**
     * Creates new form login_O
     */
    public login() {
        initComponents();
        setTitle("Login");
        this.icon_hidden.setVisible(false);
        icon_show.setVisible(true);
        showPassword();
        hiddenPassword();
    }
    
    public void showPassword() {
        this.icon_show.setVisible(false);
        this.icon_show.setEnabled(false);
        this.icon_hidden.setVisible(true);
        this.icon_hidden.setEnabled(true);
        this.txt_password.setEchoChar(((char)0));
    }
    
    public void hiddenPassword(){
       this.icon_hidden.setVisible(false);
       this.icon_hidden.setEnabled(false);
       this.icon_show.setVisible(true);
       this.icon_show.setEnabled(true);
       this.txt_password.setEchoChar('*');
    }
    
    public static String getUsernamee() {
       try {
           Connection conn = (Connection) koneksi.configDB();
           Statement st = conn.createStatement();
           ResultSet res = st.executeQuery("SELECT * FROM karyawan WHERE username = '"+username+"'");
           if (res.next()) {
               return res.getString("username");
           }
       } catch (SQLException ex){
           
       }
       return "null";
   }
    
    public static String getIdK() {
       try {
           Connection conn = (Connection) koneksi.configDB();
           Statement st = conn.createStatement();
           ResultSet res = st.executeQuery("SELECT * FROM karyawan WHERE username = '"+username+"'");
           if (res.next()) {
               return res.getString("id_karyawan");
           }
       } catch (SQLException ex){
           
       }
       return "null";
   }
    
   public static String getPassword() {
       try {
           Connection conn = (Connection) koneksi.configDB();
           Statement st = conn.createStatement();
           ResultSet res = st.executeQuery("SELECT * FROM karyawan WHERE username = '"+username+"'");
           if (res.next()) {
               return res.getString("password");
           }
       } catch (SQLException ex){
           
       }
       return "null";
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
        btn_lupapw = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        icon_show = new javax.swing.JLabel();
        icon_hidden = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBackground(new java.awt.Color(0,0,0,0));
        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 470, 70));

        btn_lupapw.setBackground(new java.awt.Color(0,0,0,0));
        btn_lupapw.setBorder(null);
        btn_lupapw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lupapwActionPerformed(evt);
            }
        });
        getContentPane().add(btn_lupapw, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 460, 180, 30));

        btn_login.setBackground(new java.awt.Color(0,0,0,0));
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 220, 60));

        txt_password.setBackground(new java.awt.Color(0,0,0,0)
        );
        txt_password.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 410, 70));

        icon_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon show.png"))); // NOI18N
        icon_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_showMouseClicked(evt);
            }
        });
        getContentPane().add(icon_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 400, 50, 30));

        icon_hidden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon hidden.png"))); // NOI18N
        icon_hidden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_hiddenMouseClicked(evt);
            }
        });
        getContentPane().add(icon_hidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Login (3).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String Username = txt_username.getText();
        String Password = txt_password.getText();
        username = Username;
        this.setVisible(true);
        
        try {
            String sql = "SELECT * FROM karyawan WHERE username="+"'"+Username+"'"+" AND password='"+Password+"'";
            Connection conn = (Connection) koneksi.configDB();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            System.out.println("Koneksi Berhasil!!");
            
            if (r.next()){
                namaUser = r.getString("username");
                JOptionPane.showMessageDialog(null, "Login berhasil");
                if (r.getString("level_user").equalsIgnoreCase("owner")) {
                  new dashboardO().setVisible(true);
                  this.dispose();
                } else{
                    new dashboardKr().setVisible(true);
                this.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(null, "Maaf, username atau password salah");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal login "+e);
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void icon_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_showMouseClicked
        this.showPassword();
    }//GEN-LAST:event_icon_showMouseClicked

    private void icon_hiddenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_hiddenMouseClicked
        this.hiddenPassword();
    }//GEN-LAST:event_icon_hiddenMouseClicked

    private void btn_lupapwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lupapwActionPerformed
        new lupa_password().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_lupapwActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_lupapw;
    private javax.swing.JLabel icon_hidden;
    private javax.swing.JLabel icon_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
