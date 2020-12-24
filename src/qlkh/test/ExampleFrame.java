package qlkh.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qlkh.entities.ValidatorItem;
import qlkh.utils.Validator;
import request.LoginRequest;

/*
 * @author Sahan Dissanayake (Disapamok)
 * www.sahan.xyz
 * https://github.com/disapamok
 * https://twitter.com/disapamok
 */
public class ExampleFrame extends javax.swing.JFrame implements IView {

    public ExampleFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello Swing Validator");

        jButton1.setText("Validate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtPhone)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Object> getListElement() {
        List<Object> listObject = new ArrayList<>();
        txtEmail.setName("txtEmail");
        txtPhone.setName("txtPhone");
        listObject.add(txtEmail);
        listObject.add(txtPhone);
        listObject.add(jTextField3);
        listObject.add(jTextField4);
        return listObject;
    }

    @Override
    public List<Object> getListElementValidate() {
        List<Object> listObject = new ArrayList<>();
        txtEmail.setName("txtEmail");
        txtPhone.setName("txtPhone");
        listObject.add(txtEmail);
        listObject.add(txtPhone);
        listObject.add(jTextField3);
        listObject.add(jTextField4);
        return listObject;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Khởi tạo FormRequest
            LoginRequest loginRequest = new LoginRequest();
            // Khởi tạo List Rules
            Map<String, String> msgs = loginRequest.getRules();
            //Khởi tạo List elêmnent cần validate
            List<Object> listObject = getListElement();
            // Set Error Message
            Validator.setErrorMessages(loginRequest.getMessages());
            //List Item (Rules,ObjectName,)
            List<ValidatorItem> vals = Validator.setRules(listObject, msgs);
            // Khởi tạo đối tượng validator
            // Validator::make == laravel
            Validator validator = new Validator(vals);
            // Form validate ok or not ok
            boolean isFormValid = validator.isPasses();

            System.out.println("Passes : " + isFormValid);

            List<String> errors = validator.getErrors();
            for (String error : errors) {
                System.out.println(error);
            }
            System.out.println("------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void showErrors(List<String> list) {

    }

    public Map<String, String> getErrors() {
        // txtEmail  error adâf
        return null;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExampleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private void save() {

    }

}
