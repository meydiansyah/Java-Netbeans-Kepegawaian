
import config.Koneksi;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    
    Connection conn;
    Statement st;
    ResultSet rs;
    Koneksi koneksi = new Koneksi();
    String pw = "";
    String indexAdmin;
    
    public LoginPage() {
        initComponents();
        
        lanjut_button.setVisible(false);
        label_checkLengthNip.setVisible(true);
        label_checkNip.setVisible(true);
        label_checkPassword.setVisible(false);
        
        getIcon();
        listener();
        pwd(false);
    }
    
    private void pwd(Boolean bl) {
        label_password.setVisible(bl);
        password_textField.setVisible(bl);
        login_button.setVisible(bl);
    }
    
    private void listener() {
        nip_textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verified();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verified();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verified();
                
            }
            
            public void verified() {
                if(nip_textField.getText().length() >= 12) {
                    label_checkLengthNip.setVisible(false);
                    
                    if(!checkUserNip()) {
                        label_checkNip.setVisible(true);
                        lanjut_button.setVisible(false);
                    } else {
                        lanjut_button.setVisible(true);
                        label_checkNip.setVisible(false);
                    }
                    
                } else {
                    label_checkLengthNip.setVisible(true);
                    label_checkNip.setVisible(true);
                    lanjut_button.setVisible(false);
                }
            }
            
            
        });
    }
    
    private Boolean checkUserNip() {
        conn = koneksi.getConnection();
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select admin.id, pegawai.nip, password from admin inner join pegawai on pegawai.id = admin.pegawai_id WHERE pegawai.nip = '"+ nip_textField.getText() +"'");
            
            if(rs.next()) {
                pw = rs.getString("password");
                indexAdmin = rs.getString("id");
                return true;
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    private void getIcon() {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/admin.png")));
        Image img = icon.getImage();
        Image imgIcon = img.getScaledInstance(icon_img.getWidth(), icon_img.getHeight(), Image.SCALE_SMOOTH);
        
        ImageIcon i = new ImageIcon(imgIcon);
        icon_img.setIcon(i);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        icon_img = new javax.swing.JLabel();
        nip_textField = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        login_button = new javax.swing.JButton();
        lanjut_button = new javax.swing.JButton();
        password_textField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        label_checkLengthNip = new javax.swing.JLabel();
        label_checkPassword = new javax.swing.JLabel();
        label_checkNip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("DIN Alternate", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 62, 138));
        jLabel1.setText("Sistem Informasi");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 62, 138));
        jLabel2.setText("Masukkan NIP :");

        nip_textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nip_textFieldKeyTyped(evt);
            }
        });

        label_password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_password.setForeground(new java.awt.Color(25, 62, 138));
        label_password.setText("Masukkan Password :");

        login_button.setText("Masuk");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        lanjut_button.setText("Lanjut");
        lanjut_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lanjut_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DIN Alternate", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 62, 138));
        jLabel4.setText("Kepegawaian");

        label_checkLengthNip.setForeground(new java.awt.Color(255, 102, 102));
        label_checkLengthNip.setText("*nip berisi 11 angka");

        label_checkPassword.setForeground(new java.awt.Color(255, 102, 102));
        label_checkPassword.setText("*password tidak cocok");

        label_checkNip.setForeground(new java.awt.Color(255, 102, 102));
        label_checkNip.setText("*masukkan nip yang terdaftar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(284, 284, 284)
                            .addComponent(icon_img, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(password_textField)
                                    .addGap(68, 68, 68))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_password)
                                    .addGap(135, 135, 135))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_checkPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lanjut_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(label_checkLengthNip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_checkNip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(nip_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon_img, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nip_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(label_password)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lanjut_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_checkPassword)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_checkLengthNip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_checkNip)
                        .addGap(90, 90, 90))))
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

    private void lanjut_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lanjut_buttonActionPerformed
        // TODO add your handling code here:
        pwd(true);
        password_textField.requestFocusInWindow();
        lanjut_button.setVisible(false);
    }//GEN-LAST:event_lanjut_buttonActionPerformed

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        // TODO add your handling code here:
        if(password_textField.getText().equals(pw)) {
            JOptionPane.showMessageDialog(null, "berhasil login");
            setVisible(false);
            HomePage hm = new HomePage(indexAdmin);
            hm.setVisible(true);
        } else {
            label_checkPassword.setVisible(true);
        }
    }//GEN-LAST:event_login_buttonActionPerformed

    private void nip_textFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nip_textFieldKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_nip_textFieldKeyTyped

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon_img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_checkLengthNip;
    private javax.swing.JLabel label_checkNip;
    private javax.swing.JLabel label_checkPassword;
    private javax.swing.JLabel label_password;
    private javax.swing.JButton lanjut_button;
    private javax.swing.JButton login_button;
    private javax.swing.JTextField nip_textField;
    private javax.swing.JPasswordField password_textField;
    // End of variables declaration//GEN-END:variables
}
