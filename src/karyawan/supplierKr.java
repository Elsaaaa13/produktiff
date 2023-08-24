/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawan;

import java.awt.event.KeyEvent;
import java.sql.Connection;
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
public class supplierKr extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    ResultSet RsSupplier = null;

    /**
     * Creates new form karyawanKr
     */
    public supplierKr() {
        initComponents();
        setTitle("Data Supplier");
        showTabel();
        HeaderColumn();
    }

    public void showTabel() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id Supplier");
        tbl.addColumn("Nama Supplier");
        tbl.addColumn("Alamat");
        tbl.addColumn("No Telp");

        tbl_supplier.setModel(tbl);
        try {
            String sql = "SELECT * FROM supplier";
            Connection con = (Connection) koneksi.configDB();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_supplier"),
                    res.getString("nama_supplier"),
                    res.getString("alamat"),
                    res.getString("no_telp")
                });
                tbl_supplier.setModel(tbl);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah" + e);
        }
    }

    private void showData(String idSupplier) {
        try {
            String query = "SELECT * FROM supplier WHERE id_supplier = '" + idSupplier + "'";
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(query);

            if (r.next()) {
                this.txt_id.setText(r.getString("id_supplier"));
                this.txt_nama.setText(r.getString("nama_supplier"));
                this.txt_alamat.setText(r.getString("alamat"));
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
            Object[] judul_kolom = {"Id Supplier", "Nama Supplier", "Alamat", "No. Telp"};
            tabModel = new DefaultTableModel(null, judul_kolom);
            tbl_supplier.setModel(tabModel);

            java.sql.Connection conn = (java.sql.Connection) koneksi.configDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            //query pilih data dari produk
            RsSupplier = stt.executeQuery("SELECT * FROM supplier WHERE id_supplier LIKE '%" + key + "%' OR nama_supplier LIKE '%" + key + "%' OR alamat LIKE '%" + key + "%' OR no_telp LIKE '%" + key + "%'");
            while (RsSupplier.next()) {
                Object[] data = {
                    //data yang dapat dicari 
                    RsSupplier.getString("id_supplier"),
                    RsSupplier.getString("nama_supplier"),
                    RsSupplier.getString("alamat"),
                    RsSupplier.getString("no_telp")
                };
                tabModel.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void HeaderColumn() {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        ((DefaultTableCellRenderer) tbl_supplier.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    private void load() {
        this.txt_id.setText("");
        this.txt_nama.setText("");
        this.txt_alamat.setText("");
        this.txt_notelp.setText("");
        this.showTabel();
//        id_supplier();
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
        tbl_supplier = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_notelp = new javax.swing.JTextField();
        btn_clean = new javax.swing.JButton();
        btn_beranda = new javax.swing.JButton();
        btn_produk = new javax.swing.JButton();
        btn_member = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_supplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_supplierMouseClicked(evt);
            }
        });
        tbl_supplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_supplierKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_supplier);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 980, 210));

        txt_id.setBackground(new java.awt.Color(0,0,0,0));
        txt_id.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setBorder(null);
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 154, 270, 40));

        txt_nama.setBackground(new java.awt.Color(0,0,0,0));
        txt_nama.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        txt_nama.setBorder(null);
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 212, 270, 40));

        txt_alamat.setBackground(new java.awt.Color(0,0,0,0));
        txt_alamat.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_alamat.setForeground(new java.awt.Color(255, 255, 255));
        txt_alamat.setBorder(null);
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 154, 260, 40));

        txt_notelp.setBackground(new java.awt.Color(0,0,0,0));
        txt_notelp.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_notelp.setForeground(new java.awt.Color(255, 255, 255));
        txt_notelp.setBorder(null);
        getContentPane().add(txt_notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 211, 260, 40));

        btn_clean.setBackground(new java.awt.Color(0,0,0,0));
        btn_clean.setBorder(null);
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clean, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 283, 190, 50));

        btn_beranda.setBackground(new java.awt.Color(0,0,0,0));
        btn_beranda.setBorder(null);
        btn_beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_berandaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 50));

        btn_produk.setBackground(new java.awt.Color(0,0,0,0));
        btn_produk.setBorder(null);
        btn_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produkActionPerformed(evt);
            }
        });
        getContentPane().add(btn_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 40));

        btn_member.setBackground(new java.awt.Color(0,0,0,0));
        btn_member.setBorder(null);
        btn_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_memberActionPerformed(evt);
            }
        });
        getContentPane().add(btn_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 150, 40));

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
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 130, 50));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/supplierKr.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_supplierMouseClicked
        this.showData(this.tbl_supplier.getValueAt(this.tbl_supplier.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_supplierMouseClicked

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        this.txt_id.setText("");
        this.txt_nama.setText("");
        this.txt_alamat.setText("");
        this.txt_notelp.setText("");
//        id_supplier();
//        tbl_supplier();
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_berandaActionPerformed
        new dashboardKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_berandaActionPerformed

    private void btn_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produkActionPerformed
        new produkKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_produkActionPerformed

    private void btn_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_memberActionPerformed
        new memberKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_memberActionPerformed

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

    private void tbl_supplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_supplierKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.showData(this.tbl_supplier.getValueAt(this.tbl_supplier.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tbl_supplierKeyPressed

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
            java.util.logging.Logger.getLogger(supplierKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierKr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_beranda;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_member;
    private javax.swing.JButton btn_produk;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_supplier;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}
