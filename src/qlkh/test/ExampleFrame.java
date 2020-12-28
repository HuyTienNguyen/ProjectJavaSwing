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
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello Swing Validator");

        jButton1.setText("Validate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtPhone)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Object> getListElement() {
        List<Object> listObject = new ArrayList<>();
        txtEmail.setName("txtEmail");
        txtPhone.setName("txtPhone");
        textArea.setName("textArea");
        listObject.add(txtEmail);
        listObject.add(txtPhone);
        listObject.add(jTextField3);
        listObject.add(jTextField4);
        listObject.add(textArea);
        return listObject;
    }

    private void showErrors(Map<String, String> mapErrors,List<Object> listObject) {
        for (Map.Entry<String, String> entrySet : mapErrors.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            for (Object listObject1 : listObject) {
                if(key.equals(listObject1.getClass().getName())){
                    //@err("name")
                    // errName.setText(value)
                }
            }
            
        }
    }

    @Override
    public List<Object> getListElementToValidate() {
        List<Object> listObject = new ArrayList<>();
        txtEmail.setName("txtEmail");
        txtPhone.setName("txtPhone");
        textArea.setName("textArea");
        listObject.add(txtEmail);
        listObject.add(txtPhone);
        listObject.add(jTextField3);
        listObject.add(jTextField4);
        listObject.add(textArea);

        return listObject;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // login click
        //  if boolean == true 
        // guiwr du lieuj len server
        //  boolean check = server trar vee
        // true dang nhap thanh cong 
        // false sai
        
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
            // Map<String,String> key = name : value = name is required
            List<String> errors = validator.getErrors();
            for (String error : errors) {
                System.out.println(error);
            }
            System.out.println("------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    @Override
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private void save() {

    }

}
