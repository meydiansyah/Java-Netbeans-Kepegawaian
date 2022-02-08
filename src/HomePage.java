
import config.Koneksi;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Connection conn;
    Koneksi koneksi = new Koneksi();
    Statement st;
    ResultSet rs;
    
    String indexUser;
    String indexAdmin;
    String indexPegawai;
    
    public HomePage(String idAdmin) {
        initComponents();
        
        indexAdmin = idAdmin;
        
        button_detail.setVisible(false);
        button_hapus.setVisible(false);
        img_user.setVisible(false);
        button_tambah.setVisible(false);
        
        getIcon();
        
        setTable();
        
        
    }

    private HomePage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getIcon() {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/admin.png")));
        Image img = icon.getImage();
        Image imgIcon = img.getScaledInstance(icon_img.getWidth(), icon_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imgIcon);
        icon_img.setIcon(i);
    }
    
    private void getImageUser(String url) {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(url)));
        Image img = icon.getImage();
        Image imgIcon = img.getScaledInstance(icon_img.getWidth(), icon_img.getHeight(), Image.SCALE_SMOOTH);
        
        ImageIcon i = new ImageIcon(imgIcon);
        img_user.setIcon(i);
    }
    
    private void setTable() {
        DefaultTableModel tblPegawai = new DefaultTableModel();
        tblPegawai.addColumn("Id");
        tblPegawai.addColumn("Nama");
        tblPegawai.addColumn("NIP");
        tblPegawai.addColumn("Jabatan");
        tblPegawai.addColumn("Telepon");
        
        table_pegawai.setModel(tblPegawai);
        table_pegawai.getColumnModel().getColumn(0).setPreferredWidth(5);

        getTable("Pegawai", tblPegawai);
        
        DefaultTableModel tblPelamar = new DefaultTableModel();

        tblPelamar.addColumn("Id");
        tblPelamar.addColumn("Nama");
        tblPelamar.addColumn("NIK");
        tblPelamar.addColumn("Telepon");
        tblPelamar.addColumn("Status");
        
        table_pelamar.setModel(tblPelamar);
        table_pelamar.getColumnModel().getColumn(0).setPreferredWidth(5);
        table_pelamar.getColumnModel().getColumn(1).setPreferredWidth(50);
        table_pelamar.getColumnModel().getColumn(2).setPreferredWidth(150);
        getTable("Pelamar", tblPelamar);
        
    }
    
    private void getTable(String data, DefaultTableModel tbl) {
        conn = koneksi.getConnection();
        try {
           st = conn.createStatement();
           if(data.equals("Pegawai")) {
               rs = st.executeQuery("select pegawai.id, user.nama, pegawai.nip, jabatan.nama_jabatan, user.telepon from pegawai inner join jabatan on pegawai.jabatan_id = jabatan.id inner join user on user.id = pegawai.user_id");
           
                while(rs.next()) {
                  tbl.addRow(new Object[]{
                     rs.getString("id"),
                     rs.getString("nama"),
                     rs.getString("nip"),
                     rs.getString("nama_jabatan"),
                     rs.getString("telepon")
                 });      
                }
                table_pegawai.setModel(tbl);
           } else {
               rs = st.executeQuery("select user.id, user.nama, user.nik, user.telepon, pelamar.status from pelamar inner join user on user.id = pelamar.user_id where pelamar.status = 'Proses' or pelamar.status = 'Ditolak'");
           
                while(rs.next()) {
                  tbl.addRow(new Object[]{
                     rs.getString("id"),
                     rs.getString("nama"),
                     rs.getString("nik"),
                     rs.getString("telepon"),
                     rs.getString("status")
                 });      
                }
                table_pelamar.setModel(tbl);
           }
           
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        icon_img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pegawai = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pelamar = new javax.swing.JTable();
        button_tambah = new javax.swing.JButton();
        button_hapus = new javax.swing.JButton();
        button_detail = new javax.swing.JButton();
        img_user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("DIN Alternate", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 62, 138));
        jLabel1.setText("Sistem Informasi");

        jLabel4.setFont(new java.awt.Font("DIN Alternate", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 62, 138));
        jLabel4.setText("Kepegawaian");

        tabPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPaneMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(209, 224, 255));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(242, 246, 255));

        table_pegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        table_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_pegawai);

        jPanel3.add(jScrollPane1);

        tabPane.addTab("Pegawai", jPanel3);

        jPanel2.setBackground(new java.awt.Color(209, 224, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        table_pelamar.setModel(new javax.swing.table.DefaultTableModel(
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
        table_pelamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pelamarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_pelamar);

        jPanel2.add(jScrollPane2);

        tabPane.addTab("Data Pelamar", jPanel2);

        button_tambah.setText("Tambah");
        button_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tambahActionPerformed(evt);
            }
        });

        button_hapus.setText("Hapus");
        button_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hapusActionPerformed(evt);
            }
        });

        button_detail.setText("Detail");
        button_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_detailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon_img, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(button_detail, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(img_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(icon_img, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(img_user, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(button_detail)
                        .addGap(18, 18, 18)
                        .addComponent(button_hapus)
                        .addGap(18, 18, 18)
                        .addComponent(button_tambah))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getGambar(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            rs.next();
            getImageUser(rs.getString("image"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void checkAdmin(String id) {
        conn = koneksi.getConnection();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select pegawai_id from admin where pegawai_id = " + id );
            
            if(rs.next()) {
                button_hapus.setVisible(false);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void onTapTable(String type, int index) {
        button_detail.setVisible(true);
        button_hapus.setVisible(true);
        img_user.setVisible(true);
        
        String id;
        
        if(type.equals("Pegawai")) {
            id = (String) table_pegawai.getValueAt(index, 0);
            indexPegawai = id;
            getGambar("select user.image from pegawai inner join user on pegawai.user_id = user.id where pegawai.id = " + indexPegawai);
            checkAdmin(id);
            
            conn = koneksi.getConnection();
            try {
                st = conn.createStatement();
                rs = st.executeQuery("select user_id from pegawai where id = " + indexPegawai);
                rs.next();
                indexUser = rs.getString("user_id");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
        } else {
            id = (String) table_pelamar.getValueAt(index, 0);
            indexUser = id;
            getGambar("select image from user where id = " + indexUser);
        }
    }
    
    private void table_pelamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pelamarMouseClicked
        // TODO add your handling code here:
        int index = table_pelamar.rowAtPoint(evt.getPoint());
        onTapTable("Pelamar", index);
    }//GEN-LAST:event_table_pelamarMouseClicked

    private void table_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pegawaiMouseClicked
        // TODO add your handling code here:
        int index = table_pegawai.rowAtPoint(evt.getPoint());
        onTapTable("Pegawai", index);
    }//GEN-LAST:event_table_pegawaiMouseClicked

    private void button_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_detailActionPerformed
        // TODO add your handling code here:
        DetailPegawai dp = new DetailPegawai(indexUser, indexAdmin, indexPegawai);
        UserPage du = new UserPage("Detail", indexUser, indexAdmin);
        
        if(tabPane.getSelectedIndex() == 0) {
            dp.setVisible(true);
        } else {
            du.setVisible(true);
        }
        
        
    }//GEN-LAST:event_button_detailActionPerformed
    
    private void tabPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPaneMouseClicked
        // TODO add your handling code here:
        if(tabPane.getSelectedIndex() == 0) 
            button_tambah.setVisible(false);
        else 
            button_tambah.setVisible(true);
    }//GEN-LAST:event_tabPaneMouseClicked

    private void button_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tambahActionPerformed
        // TODO add your handling code here:
        UserPage up = new UserPage("Tambah", "0", indexAdmin);
        up.setVisible(true);
    }//GEN-LAST:event_button_tambahActionPerformed

    private void button_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hapusActionPerformed
        // TODO add your handling code here:
        conn = koneksi.getConnection();
        
         int opt = JOptionPane.showConfirmDialog(null, "Simpan Perubahan ?");
            
        if(opt == JOptionPane.YES_OPTION) {
            try {
                st = conn.createStatement();
                st.execute("delete from user where id = " + indexUser);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus !");
            dispose();
            HomePage hp = new HomePage(indexAdmin);
            hp.setVisible(true);

        }
        
    }//GEN-LAST:event_button_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_detail;
    private javax.swing.JButton button_hapus;
    private javax.swing.JButton button_tambah;
    private javax.swing.JLabel icon_img;
    private javax.swing.JLabel img_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable table_pegawai;
    private javax.swing.JTable table_pelamar;
    // End of variables declaration//GEN-END:variables
}
