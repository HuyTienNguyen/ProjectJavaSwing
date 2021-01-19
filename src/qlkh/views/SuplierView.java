/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import qlkh.entities.Supliers;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class SuplierView extends javax.swing.JPanel implements IView {

    /**
     * Creates new form SuplierView
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        errName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        errAddress = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        errPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        errMail = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        character = new javax.swing.JTextField();
        lblCharacterCode = new javax.swing.JLabel();
        errCharacter = new javax.swing.JLabel();
        messageSuplier = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuplier = new javax.swing.JTable();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();

        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAdd.setBackground(new java.awt.Color(0, 255, 204));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/add_text_32px.png"))); // NOI18N
        btnAdd.setText(bundle.getString("btnAdd"));
        btnAdd.setActionCommand("Add Unit");
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(204, 255, 204));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/edit_40.png"))); // NOI18N
        btnEdit.setText(bundle.getString("btnEdit")
        );
        btnEdit.setFocusPainted(false);
        btnEdit.setMaximumSize(new java.awt.Dimension(134, 40));
        btnEdit.setMinimumSize(new java.awt.Dimension(134, 40));

        btnClear.setBackground(new java.awt.Color(51, 153, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/clear_40.png"))); // NOI18N
        btnClear.setText(bundle.getString("btnClear")
        );
        btnClear.setFocusPainted(false);
        btnClear.setMaximumSize(new java.awt.Dimension(134, 40));
        btnClear.setMinimumSize(new java.awt.Dimension(134, 40));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/delete_50.png"))); // NOI18N
        btnDelete.setText(bundle.getString("btnDelete")
        );
        btnDelete.setFocusPainted(false);
        btnDelete.setMaximumSize(new java.awt.Dimension(134, 40));
        btnDelete.setMinimumSize(new java.awt.Dimension(134, 40));

        errName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText(bundle.getString("name")
        );

        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress.setText(bundle.getString("address")
        );

        phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhone.setText(bundle.getString("phone"));

        errPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText(bundle.getString("email"));

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errMail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInfo.setText(bundle.getString("info"));

        info.setColumns(20);
        info.setRows(5);
        jScrollPane2.setViewportView(info);

        character.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCharacterCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCharacterCode.setText(bundle.getString("characterSuplier"));

        errCharacter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        id.setForeground(new java.awt.Color(240, 240, 240));
        id.setText("jLabel1");
        id.setOpaque(true);
        id.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(errMail, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblName))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(id)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(errPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCharacterCode, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(errName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(character, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(messageSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errMail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(character, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCharacterCode)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(errCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 50, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jScrollPane1.setViewportView(tblSuplier);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        headerPanel.setBackground(new java.awt.Color(51, 0, 51));

        headerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Suplier");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JTextField character;
    private javax.swing.JTextField email;
    private javax.swing.JLabel errAddress;
    private javax.swing.JLabel errCharacter;
    private javax.swing.JLabel errMail;
    private javax.swing.JLabel errName;
    private javax.swing.JLabel errPhone;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel id;
    private javax.swing.JTextArea info;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCharacterCode;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel messageSuplier;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTable tblSuplier;
    // End of variables declaration//GEN-END:variables
  ResourceBundle bundle;

    public SuplierView() {
        //  Locale local = Utils.getLocale();
        Locale local = Locale.getDefault();
        setResourceBundle(local);
        initComponents();

    }
    // Show view with list Suplier on Suplier Table

    public void showView(List<Supliers> supliers) {
        this.setVisible(true);
        setEnableBtnEdit(true);
        setEnableBtnDelete(true);
        setEnableBtnEdit(false);
        if(supliers != null && supliers.size() > 0){
        loadAllSupliers(supliers);    
        }
        

    }

    public JPanel getContent() {
        return this;
    }

    // Set ResourceBundle to this view

    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);

    }

    @Override
    public List<Object> getElements(boolean isInsert) {
        List<Object> objects = new ArrayList<>();
        // set Name text field
        id.setName("id");
        name.setName("name");
        address.setName("address");
        phone.setName("phone");
        email.setName("mail");
        character.setName("character");

        // add object to map
        objects.add(id);
        objects.add(name);
        objects.add(address);
        objects.add(phone);
        objects.add(email);
        objects.add(character);

        return objects;
    }

    @Override
    public void showErrors(Map<String, String> errors) {
        //get error messages
        String errorNameMsg = ((errors.get("name") == null) ? "" : errors.get("name"));
        String errorMailMsg = ((errors.get("mail") == null) ? "" : errors.get("mail"));
        String errorAddressMsg = ((errors.get("address") == null) ? "" : errors.get("address"));
        String errorPhoneMsg = ((errors.get("phone") == null) ? "" : errors.get("phone"));
        String errorCharacterMsg = ((errors.get("character") == null) ? "" : errors.get("character"));
        //Show messages
        showErrorMessage(errName, errorNameMsg);
        showErrorMessage(errMail, errorMailMsg);
        showErrorMessage(errAddress, errorAddressMsg);
        showErrorMessage(errPhone, errorPhoneMsg);
        showErrorMessage(errCharacter, errorCharacterMsg);

    }

    public Supliers getSuplier() {
        int supId = 0;
        Supliers suplier = new Supliers();
        try {
            supId = Integer.parseInt(id.getText());
        } catch (Exception e) {
        }
        suplier.setId(supId);
        suplier.setName(name.getText());
        suplier.setPhone(phone.getText());
        suplier.setAddress(address.getText());
        suplier.setMoreInfo(info.getText());
        suplier.setContractDate(Utils.getTimestampNow());
        suplier.setEmail(email.getText());
        suplier.setCharacters(character.getText());
        // System.out.println("info: "+suplier.getMoreInfo());
        return suplier;
    }

    public void showErrorMessage(JLabel label, String err) {
        label.setText(err);
        label.setForeground(Color.red);
    }

    public int showDialog(JFrame frame, String message, String title, int typeIcon) {
        int iconNumber = (typeIcon == JOptionPane.QUESTION_MESSAGE) ? JOptionPane.QUESTION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        return JOptionPane.showConfirmDialog(frame, bundle.getString(message), bundle.getString(title), JOptionPane.OK_CANCEL_OPTION, iconNumber);
    }

  
    // Load list Unit on Unit Table

    public void loadAllSupliers(List<Supliers> supliers) {
        DefaultTableModel supModel = new DefaultTableModel();
        supModel.setColumnIdentifiers(Constants.HEADER_SUPLIER_TABLE);
        int startNumber = 1;
        for (Supliers sup : supliers) {
            Vector row = new Vector();
            row.add(sup.getId());
            row.add(sup);
            row.add(sup.getPhone());
            row.add(sup.getAddress());
            row.add(sup.getEmail());
            row.add(sup.getMoreInfo());
            String date = "";
            try {
                date = Utils.getSimpleDateFormatWithHours(sup.getContractDate());
            } catch (Exception e) {
            }
            row.add(date);
            row.add(Utils.getSimpleDateFormatWithHours(sup.getContractDate()));
            row.add(sup.getCharacters());
            row.add((sup.getStatus() > 0) ? bundle.getString(Constants.STATUS_SHOW) : bundle.getString(Constants.STATUS_HIDE));
            startNumber++;
            supModel.addRow(row);
        }
        tblSuplier.setModel(supModel);
        tblSuplier.setAutoCreateRowSorter(true);
    }

    // Add event to button addNewUnit
    public void addBtnAddAction(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addBtnEditAction(ActionListener listener) {
        btnEdit.addActionListener(listener);
    }

    public void addBtnClearAction(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    public void addBtnDeleteAction(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    public void addTableMouseListener(MouseListener listener) {
        tblSuplier.addMouseListener(listener);
    }

    // Get text from txtNewUnitField
    private void showErrMess(String message, int color) {
        errName.setText(bundle.getString(message));
        errName.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    public void showMessage(String message, int color) {
        messageSuplier.setText(bundle.getString(message));
        messageSuplier.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    public void focusTxtUnitField() {
        name.requestFocus();
    }

//    public Unit getEditUnit() {
//        int row = tblSuplier.getSelectedRow();
//        if (row < 0) {
//            return null;
//        }
//        return (Unit) tblSuplier.getModel().getValueAt(row, 1);
//    }
    public int getEditSuplierId() {
        int row = tblSuplier.getSelectedRow();
        if (row < 0) {
            return -1;
        }
        return (int) tblSuplier.getModel().getValueAt(row, 0);
    }

    private void setEnableBtnAddNew(boolean value) {
        btnAdd.setEnabled(value);
    }

    private void setEnableBtnEdit(boolean value) {
        btnEdit.setEnabled(value);
    }

    private void setEnableBtnDelete(boolean value) {
        btnDelete.setEnabled(value);
    }

//    public boolean checkUnitName(String unitName) {
//        return (unitName != null && unitName.equals("") == false);
//    }
    public void clearView(boolean clearAll) {
        setEnableBtnAddNew(true);
        setEnableBtnEdit(false);
        setEnableBtnDelete(false);
        if (clearAll == true) {
            messageSuplier.setText("");
            clearError();
        }
        id.setText("");
        name.setText("");
        phone.setText("");
        address.setText("");
        info.setText("");
        email.setText("");
        character.setText("");
    }

    public void clearError() {
        errName.setText("");
        errPhone.setText("");

        errAddress.setText("");

        errCharacter.setText("");
        errMail.setText("");

        messageSuplier.setText("");

    }

    public void showEditSuplier(Supliers suplier) {
        id.setText(String.valueOf(suplier.getId()));
        name.setText(suplier.getName());
        phone.setText(suplier.getPhone());
        address.setText(suplier.getAddress());
        info.setText(suplier.getMoreInfo());
        email.setText(suplier.getEmail());
        character.setText(suplier.getCharacters());
        setEnableBtnAddNew(false);

        setEnableBtnEdit(true);
        setEnableBtnDelete(true);
    }

    public String getEditId() {

        return id.getText();

    }
}
