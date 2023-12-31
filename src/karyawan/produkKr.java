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
import main.Rupiah;
import main.koneksi;

/**
 *
 * @author LENOVO
 */
public class produkKr extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;

    /** Creates new form produkKr */
    public produkKr() {
        initComponents();
        setTitle("Data Produk");
        showTabel();
        HeaderColumn();
    }

    public void showTabel () {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id Produk");
        tbl.addColumn("Nama Produk");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        
        tbl_produk.setModel(tbl);
        try {
            String sql = "SELECT * FROM produk";
            Connection con = (Connection) koneksi.configDB();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_produk"),
                    res.getString("nama_produk"),
                    Rupiah.convertToRupiah(Integer.parseInt(res.getString("harga"))),
                    res.getString("stok")
                });
                tbl_produk.setModel(tbl);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah" + e);
        }
    }
    
    private void showData(String idProduk){
        try{
            String query = "SELECT * FROM produk WHERE id_produk = '"+idProduk+"'";
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(query);
            
            if(r.next()){
                this.lbl_id.setText(r.getString("id_produk"));
                this.lbl_nama.setText(r.getString("nama_produk"));
                this.lbl_harga.setText(r.getString("harga"));
                this.txt_stok.setText(r.getString("stok"));
       
           }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } 
    }
    
    private void cariData(String key){
       // mencari data 
        try{
            Object[] judul_kolom = {"Id Produk", "Nama Produk", "Harga", "Stok"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tbl_produk.setModel(tabModel);
            
            java.sql.Connection conn=(java.sql.Connection)koneksi.configDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            //query pilih data dari produk
            RsProduk=stt.executeQuery("SELECT * FROM produk WHERE id_produk LIKE '%"+key+"%' OR nama_produk LIKE '%"+key+"%' OR harga LIKE '%"+key+"%'"
                    + "OR stok LIKE '%"+key+"%'");  
            while(RsProduk.next()){
                Object[] data={
                    //data yang dapat dicari 
                    RsProduk.getString("id_produk"),
                    RsProduk.getString("nama_produk"),
                    RsProduk.getString("harga"),
                    RsProduk.getString("stok"),
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void HeaderColumn() {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl_produk.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tbl_produk.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
//        tbl_produk.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        
        ((DefaultTableCellRenderer) tbl_produk.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void load() {
        this.lbl_id.setText("");
        this.lbl_nama.setText("");
        this.lbl_harga.setText("");
        this.txt_stok.setText("");
        this.showTabel();
//        id_produk();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produk = new javax.swing.JTable();
        txt_stok = new javax.swing.JTextField();
        lbl_rp = new javax.swing.JLabel();
        btn_clean = new javax.swing.JButton();
        btn_beranda = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_member = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();
        lbl_nama = new javax.swing.JLabel();
        lbl_harga = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_produk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produkMouseClicked(evt);
            }
        });
        tbl_produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_produkKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_produk);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 990, 230));

        txt_stok.setBackground(new java.awt.Color(0,0,0,0));
        txt_stok.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        txt_stok.setForeground(new java.awt.Color(255, 255, 255));
        txt_stok.setBorder(null);
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 205, 250, 40));

        lbl_rp.setBackground(new java.awt.Color(0,0,0,0));
        lbl_rp.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lbl_rp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rp.setText("Rp");
        getContentPane().add(lbl_rp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 146, -1, -1));

        btn_clean.setBackground(new java.awt.Color(0,0,0,0));
        btn_clean.setBorder(null);
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clean, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 190, 40));

        btn_beranda.setBackground(new java.awt.Color(0,0,0,0));
        btn_beranda.setBorder(null);
        btn_beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_berandaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 50));

        btn_supplier.setBackground(new java.awt.Color(0,0,0,0));
        btn_supplier.setBorder(null);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 273, 150, 50));

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
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 140, 50));

        lbl_id.setBackground(new java.awt.Color(0,0,0,0)
        );
        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 147, 260, 30));

        lbl_nama.setBackground(new java.awt.Color(0,0,0,0)
        );
        lbl_nama.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lbl_nama.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 206, 250, 30));

        lbl_harga.setBackground(new java.awt.Color(0,0,0,0)
        );
        lbl_harga.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lbl_harga.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbl_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 147, 190, 30));

        btn_edit.setBackground(new java.awt.Color(0,0,0,0)
        );
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 120, 40));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 402, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/produkKr.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produkMouseClicked
        this.showData(this.tbl_produk.getValueAt(this.tbl_produk.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_produkMouseClicked

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        this.lbl_id.setText("");
        this.lbl_nama.setText("");
        this.lbl_harga.setText("");
        this.txt_stok.setText("");
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_berandaActionPerformed
        new dashboardKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_berandaActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        new supplierKr().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_supplierActionPerformed

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

    private void tbl_produkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_produkKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.showData(this.tbl_produk.getValueAt(this.tbl_produk.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tbl_produkKeyPressed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            String id_produk = this.lbl_id.getText(),
                    nama_produk = this.lbl_nama.getText(),
                    harga = this.lbl_harga.getText(),
                    stok = this.txt_stok.getText();

            System.out.println("ID Produk : " + id_produk);
            String sql = String.format("UPDATE produk SET nama_produk = '%s', harga = '%s', stok = '%s' WHERE id_produk = '%s'", nama_produk, harga, stok, id_produk);

            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            this.showData(id_produk);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.load();
    }//GEN-LAST:event_btn_editActionPerformed

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
            java.util.logging.Logger.getLogger(produkKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produkKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produkKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produkKr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produkKr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_beranda;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_member;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_harga;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_rp;
    private javax.swing.JTable tbl_produk;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables

}
