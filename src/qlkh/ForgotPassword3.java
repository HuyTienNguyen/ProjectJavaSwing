/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import qlkh.entities.Users;

/**
 *
 * @author user
 */
public class ForgotPassword3 extends javax.swing.JFrame {

    /**
     * Creates new form FotgotPassword3
     */
    private static Locale locale;
    private static ResourceBundle bundle;
    private static String addressEmail;
    public ForgotPassword3(Locale local,String addEmail) {
        this.locale = local;
        this.addressEmail = addEmail;
        setResourceBundle(local);
        initComponents();
        setLocationRelativeTo(null);
    }
    //hàm set bundle khi truyền vào
    public void setResourceBundle(Locale local) {
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", local);
    }
    //hàm show view
    public void showView() {
        this.setVisible(true);
    }
    
    public void hideView(){
        this.dispose();
    }
    //hàm lấy về email mà khách hàng xác thực mã
    public String getAddressEmail(){
        return this.addressEmail;
    }
    //hàm trả về username và email để xác thực
    public Users getUsernameAndEmail(){
        Users users = new Users();
        users.setUserName(username.getText());
        users.setEmail(this.addressEmail);
        return users;
    }
    //hàm validate data
    public boolean validateData(){
        boolean check = false;
        if(username.getText().trim().equals("") && username.getText() == null){
            showMessageUsername("FORGOT_PASSWORD_3_ERR_USERNAME_REQUIRED");
            check = false;
        }
        else{
            Pattern p;
            Matcher m;
            
            p= Pattern.compile("^[a-zA-Z0-9]{8,30}$");
            m = p.matcher(username.getText());
            if(m.matches()){
                showMessageUsername("EMPTY");
                check = true;
            }
            else{
                showMessageUsername("FORGOT_PASSWORD_3_ERR_USERNAME_REGEX");
                check = false;
            }
        }
        
        if(String.valueOf(password.getPassword()).trim().equals("") && String.valueOf(password.getPassword()) == null){
            showMessagePassword("FORGOT_PASSWORD_3_ERR_PASSWORD_REQUIRED");
            check = false;
        }
        else{
            Pattern p;
            Matcher m;
            
            p= Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
            m = p.matcher(String.valueOf(password.getPassword()));
            if(m.matches()){
                showMessagePassword("EMPTY");
                check = true;
            }
            else{
                showMessagePassword("FORGOT_PASSWORD_3_ERR_PASSWORD_REGEX");
                check = false;
            }
        }
        
        if(String.valueOf(repassword.getPassword()).trim().equals("") && String.valueOf(repassword.getPassword()) == null){
            showMessageRePassword("FORGOT_PASSWORD_3_ERR_RE_PASSWORD_REQUIRED");
            check = false;
        }
        else{
            if(String.valueOf(repassword.getPassword()).equals(String.valueOf(password.getPassword()))){
                showMessageRePassword("EMPTY");
                check = true;
            }
            else{
                showMessageRePassword("FORGOT_PASSWORD_3_ERR_RE_PASSWORD_CONFIRM");
                check = false;
            }
        }
        return check;
    }
    //hàm button xác thực mã đổi mật khẩu
    public void addBtnVerify(ActionListener listener){
        btnVerify.addActionListener(listener);
    }
    
    //hàm show message username
    public void showMessageUsername(String message){
        errUsername.setText(bundle.getString(message));
        errUsername.setForeground(Color.RED);
    }
    //hàm show message password
    public void showMessagePassword(String message){
        errPassword.setText(bundle.getString(message));
        errPassword.setForeground(Color.RED);
    }
    //hàm show message repassword
    public void showMessageRePassword(String message){
        errPasswordConfirm.setText(bundle.getString(message));
        errPasswordConfirm.setForeground(Color.RED);
    }
    //hàm show thông báo gửi verifycode
    public void showMessageVerify(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnVerify = new keeptoo.KButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        errUsername = new javax.swing.JLabel();
        errPassword = new javax.swing.JLabel();
        errPasswordConfirm = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        repassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setGradientFocus(600);
        kGradientPanel1.setStartColor(new java.awt.Color(153, 0, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(bundle.getString("FORGOT_PASSWORD3_LBL_REPASSWORD"));
        jLabel5.setToolTipText("");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(bundle.getString("FORGOT_PASSWORD3_LBL_SETUP_EMAIL"));
        jLabel6.setToolTipText("");
        jLabel6.setAlignmentY(0.0F);

        btnVerify.setForeground(new java.awt.Color(204, 204, 204));
        btnVerify.setText("Continue");
        btnVerify.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVerify.setkBorderRadius(40);
        btnVerify.setkEndColor(new java.awt.Color(0, 204, 204));
        btnVerify.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btnVerify.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnVerify.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btnVerify.setkStartColor(new java.awt.Color(204, 0, 204));
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(bundle.getString("FORGOT_PASSWORD3_LBL_NEW_PASSWORD_NOTE"));
        jLabel7.setToolTipText("");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(bundle.getString("FORGOT_PASSWORD3_LBL_USERNAME"));
        jLabel8.setToolTipText("");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(bundle.getString("FORGOT_PASSWORD3_LBL_PASSWORD"));
        jLabel9.setToolTipText("");

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(102, 102, 102));
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        repassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        repassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(username)
                    .addComponent(errUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password)
                    .addComponent(repassword, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(errUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(errPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(errPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel1.add(jPanel1);
        jPanel1.setBounds(500, 30, 410, 570);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(bundle.getString("signUpTitle3"));
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(50, 220, 370, 60);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(bundle.getString("signUpTitle1"));
        kGradientPanel1.add(jLabel4);
        jLabel4.setBounds(50, 60, 230, 40);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 153, 255));
        jLabel10.setText(bundle.getString("signUpTitle2"));
        kGradientPanel1.add(jLabel10);
        jLabel10.setBounds(50, 190, 230, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/grap.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(30, 340, 390, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerifyActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnVerify;
    private javax.swing.JLabel errPassword;
    private javax.swing.JLabel errPasswordConfirm;
    private javax.swing.JLabel errUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField repassword;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
