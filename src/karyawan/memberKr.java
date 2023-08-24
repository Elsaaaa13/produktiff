/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawan;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import main.koneksi;

/**
 *
 * @author LENOVO
 */
public class memberKr extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsMember = null;

    /**
     * Creates new form memberKr
     */
    public memberKr() {
        initComponents();
        setTitle("Data Member");
        showTabel();
        HeaderColumn();
    }

    public void showTabel() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id Member");
        tbl.addColumn("Nama Member");
        tbl.addColumn("No. Telp");

        tbl_member.setModel(tbl);
        try {
            String sql = "SELECT * FROM member";
            Connection con = (Connection) koneksi.configDB();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_member"),
                    res.getString("nama_member"),
                    res.getString("no_telp")
                });
                tbl_member.setModel(tbl);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah" + e);
        }
    }

    private void showData(String idMember) {
        try {
            String query = "SELECT * FROM member WHERE id_member = '" + idMember + "'";
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(query);

            if (r.next()) {
                this.txt_id.setText(r.getString("id_member"));
                this.txt_nama.setText(r.getString("nama_member"));
                this.txt_notelp.setText(r.getString("no_telp"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    private void cariData(String key) {
        // mencari data 
        try {
            Object[] judul_kolom = {"Id Member", "Nama Member", "No. Telp"};
            tabModel = new DefaultTableModel(null, judul_kolom);
            tbl_member.setModel(tabModel);

            java.sql.Connection conn = (java.sql.Connection) koneksi.configDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            //query pilih data dari produk
            RsMember = stt.executeQuery("SELECT * FROM member WHERE id_member LIKE '%" + key + "%' OR nama_member LIKE '%" + key + "%' OR no_telp LIKE '%" + key + "%'");
            while (RsMember.next()) {
                Object[] data = {
                    //data yang dapat dicari 
                    RsMember.getString("id_member"),
                    RsMember.getString("nama_member"),
                    RsMember.getString("no_telp"),};
                tabModel.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void HeaderColumn() {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        ((DefaultTableCellRenderer) tbl_member.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    private void load() {
        this.txt_id.setText("");
        this.txt_nama.setText("");
        this.txt_notelp.setText("");
        this.showTabel();
//        id_member();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_member = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_notelp = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clean = new javax.swing.JButton();
        btn_beranda = new javax.swing.JButton();
        btn_produk = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_memberMouseClicked(evt);
            }
        });
        tbl_member.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_memberKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_member);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 1000, 170));

        txt_id.setBackground(new java.awt.Color(0,0,0,0));
        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setBorder(null);
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 136, 540, 40));

        txt_nama.setBackground(new java.awt.Color(0,0,0,0));
        txt_nama.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        txt_nama.setBorder(null);
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 198, 540, 40));

        txt_notelp.setBackground(new java.awt.Color(0,0,0,0));
        txt_notelp.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_notelp.setForeground(new java.awt.Color(255, 255, 255));
        txt_notelp.setBorder(null);
        getContentPane().add(txt_notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 258, 540, 40));

        btn_tambah.setBackground(new java.awt.Color(0,0,0,0));
        btn_tambah.setBorder(null);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 160, 40));

        btn_edit.setBackground(new java.awt.Color(0,0,0,0));
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 130, 40));

        btn_hapus.setBackground(new java.awt.Color(0,0,0,0));
        btn_hapus.setBorder(null);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 140, 40));

        btn_clean.setBackground(new java.awt.Color(0,0,0,0));
        btn_clean.setBorder(null);
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clean, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 190, 40));

        btn_beranda.setBackground(new java.awt.Color(0,0,0,0));
        btn_beranda.setBorder(null);
        btn_beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_berandaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 133, 150, 50));

        btn_produk.setBackground(new java.awt.Color(0,0,0,0));
        btn_produk.setBorder(null);
        btn_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produkActionPerformed(evt);
            }
        });
        getContentPane().add(btn_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 40));

        btn_supplier.setBackground(new java.awt.Color(0,0,0,0));
        btn_supplier.setBorder(null);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 50));

        btn_transaksi.setBackground(new java.awt.Color(0,0,0,0));
        btn_transaksi.setBorder(null);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 50));

        btn_keluar.setBackground(new java.awt.Color(0,0,0,0));
        btn_keluar.setBorder(null);
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 130, 40));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 459, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/memberKr.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String id_member = this.txt_id.getText(),
                nama_member = this.txt_nama.getText(),
                no_telp = this.txt_notelp.getText();
        if (this.txt_notelp.getText().length() > 13) {
            JOptionPane.showMessageDialog(this, "No telp tidak boleh lebih dari 13");
        } else if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Id member harus diisi!");
        } else if (this.txt_nama.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nama member harus diisi!");
        } else if (this.txt_notelp.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nomor telepon harus diisi!");
        } else {

            try {
                String sql = "INSERT INTO member VALUES (?, ?, ?)";
                Connection conn = (Connection) koneksi.configDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id_member);
                pst.setString(2, nama_member);
                pst.setString(3, no_telp);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "ID member sudah terdaftar" );
//                JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
            }
            this.load();
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            String id_member = this.txt_id.getText(),
                    nama_member = this.txt_nama.getText(),
                    no_telp = this.txt_notelp.getText();

            System.out.println("ID Produk : " + id_member);
            String sql = String.format("UPDATE member SET nama_member = '%s', no_telp = '%s' WHERE id_member = '%s'", nama_member, no_telp, id_member);

            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            this.showData(id_member);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.load();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int status;
        status = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data?",
                "Confirm", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (status) {
            case JOptionPane.YES_OPTION: 
            try {
                String id_member = this.txt_id.getText(),
                        sql = "DELETE FROM member WHERE id_member = '" + id_member + "'";

                Connection conn = (Connection) koneksi.configDB();
                Statement stat = conn.createStatement();
                if (stat.executeUpdate(sql) > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    //                this.showData(idK);
                    this.showTabel();
                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal dihapus!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        this.load();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        this.txt_id.setText("");
        this.txt_nama.setText("");
        this.txt_notelp.setText("");
//        id_member();
//        tbl_member();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void tbl_memberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_memberMouseClicked
        this.showData(this.tbl_member.getValueAt(this.tbl_member.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_memberMouseClicked

    private void btn_berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_berandaActionPerformed
        new dashboardKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_berandaActionPerformed

    private void btn_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produkActionPerformed
        new produkKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_produkActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        new supplierKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        new menu_transaksiKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "PERINGATAN",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
             new main.landing_page().setVisible(true);
                     this.dispose();
            } else {
        }
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // cari data
        String key = txt_cari.getText();
        System.out.println(key);
        if (key != "") {
            cariData(key);
        } else {
            load();
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        if ((txt_cari.getText() + evt.getKeyChar()).length() > 29) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_cariKeyTyped

    private void tbl_memberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_memberKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.showData(this.tbl_member.getValueAt(this.tbl_member.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tbl_memberKeyPressed

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
            java.util.logging.Logger.getLogger(memberKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memberKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memberKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memberKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memberKr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_beranda;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_produk;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_member;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}