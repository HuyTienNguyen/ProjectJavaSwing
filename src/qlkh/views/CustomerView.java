/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import qlkh.entities.Customers;
import qlkh.utils.Constants;
import qlkh.utils.Utils;
import qlkh.utils.pagination.ObjectTableModel;
import qlkh.utils.pagination.PaginatedTableDecorator;
import qlkh.utils.pagination.PaginationDataProvider;

/**
 *
 * @author user
 */
public class CustomerView extends javax.swing.JPanel implements IView {

    /**
     * Creates new form CustomerView
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        headerLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
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
        errEmail = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        messageCustomer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        tablePanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 102, 255));
        setPreferredSize(new java.awt.Dimension(990, 620));

        headerPanel.setBackground(new java.awt.Color(51, 0, 102));

        headerLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerLabel1.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel1.setText("Customer");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(headerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(851, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(headerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

        errName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName.setText(bundle.getString("name")
        );

        lblAddress.setText(bundle.getString("address")
        );

        phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        errAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPhone.setText(bundle.getString("phone"));

        errPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmail.setText(bundle.getString("email"));

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfo.setText(bundle.getString("info"));

        info.setColumns(20);
        info.setRows(5);
        jScrollPane2.setViewportView(info);

        messageCustomer.setText("jLabel1");

        jLabel1.setText(bundle.getString("id"));

        id.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(errEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(642, 642, 642))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(597, 597, 597))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(errAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(errPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(371, 371, 371)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(messageCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(159, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addGap(24, 24, 24)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(233, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(errName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblInfo)
                                    .addComponent(jLabel1)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(errEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JTextField email;
    private javax.swing.JLabel errAddress;
    private javax.swing.JLabel errEmail;
    private javax.swing.JLabel errName;
    private javax.swing.JLabel errPhone;
    private javax.swing.JLabel headerLabel1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField id;
    private javax.swing.JTextArea info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel messageCustomer;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables

    private static int[] pageSizes = new int[]{10, 20, 50, 75, 100};
    private static final int defaultPageSize = 10;
    //button để hiện phân trang maximum 7
    private static final int maxPagingCompToShow = 7;
    private static List<Customers> customers = new ArrayList<>();

    JTable tblCustomers;
    PaginatedTableDecorator<Customers> paginatedDecorator;
    ResourceBundle bundle;

    public CustomerView() {
        Locale local = Utils.getLocale();
        setResourceBundle(local);
        initComponents();
    }

    public JPanel getContent() {
        return this;
    }

    // Set ResourceBundle to this view

    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);

    }

    // Show view with list Suplier on Suplier Table
    public void showView(List<Customers> customers) {
        this.setVisible(true);
        setEnableBtnEdit(true);
        setEnableBtnEdit(false);
        if(customers != null){
                    loadAllCustomers(customers);

        }

    }

    public String getEditCustomerId() {
        int row = tblCustomers.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return tblCustomers.getModel().getValueAt(row, 0).toString();
    }

    private void setEnableBtnEdit(boolean value) {
        btnEdit.setEnabled(value);
    }

    private void setEnableBtnAddNew(boolean value) {
        btnAdd.setEnabled(value);
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

    public void addTableMouseListener(MouseListener listener) {
        paginatedDecorator.addTableMouseListener(listener);
    }

    public int showDialog(JFrame frame, String message, String title, int typeIcon) {
        int iconNumber = (typeIcon == JOptionPane.QUESTION_MESSAGE) ? JOptionPane.QUESTION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        return JOptionPane.showConfirmDialog(frame, bundle.getString(message), bundle.getString(title), JOptionPane.OK_CANCEL_OPTION, iconNumber);
    }

    public void showMessage(String message, int color) {
        messageCustomer.setText(bundle.getString(message));
        messageCustomer.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    private boolean isNull(String text) {
        return text == null || text.equals("") == true;
    }

    //get data view

    public Customers getData() {
        Customers customer = new Customers();
        customer.setId((isNull(id.getText()) == false) ? Integer.valueOf(id.getText()) : 0);
        customer.setName(name.getText());
        customer.setAddress(address.getText());
        customer.setPhone(phone.getText());
        customer.setEmail(email.getText());
        customer.setMoreInfo(info.getText());
        customer.setContractDate(Utils.getTimestampNow());
        return customer;
    }

    //get id customer

    public String getIdCustomer() {
        String idCustomer = id.getText();
        return idCustomer;
    }

    // Load list Unit on Unit Table

    public void loadAllCustomers(List<Customers> customer) {
        // set data for List<Product> lists
        this.customers = customer;
        tblCustomers = new JTable(createObjectDataModel());
        tblCustomers.setAutoCreateRowSorter(true);
        PaginationDataProvider<Customers> dataProvider = createDataProvider();
        paginatedDecorator = PaginatedTableDecorator.decorate(tblCustomers,
                dataProvider, pageSizes, defaultPageSize, maxPagingCompToShow);
        tablePanel.removeAll();
        tablePanel.setLayout(new CardLayout());
        tablePanel.add(paginatedDecorator.getContentPanel());
    }

    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<Customers>() {
            @Override
            public Object getValueAt(Customers customer, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return customer.getId();
                    case 1:
                        return customer.getName();
                    case 2:
                        return customer.getAddress();
                    case 3:
                        return customer.getPhone();
                    case 4:
                        return customer.getEmail();
                    case 5:
                        return customer.getMoreInfo();
                    case 6:
                        return customer.getContractDate();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return Constants.HEADER_CUSTOMERS_TABLE.length;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return Constants.HEADER_CUSTOMERS_TABLE[0];
                    case 1:
                        return Constants.HEADER_CUSTOMERS_TABLE[1];
                    case 2:
                        return Constants.HEADER_CUSTOMERS_TABLE[2];
                    case 3:
                        return Constants.HEADER_CUSTOMERS_TABLE[3];
                    case 4:
                        return Constants.HEADER_CUSTOMERS_TABLE[4];
                    case 5:
                        return Constants.HEADER_CUSTOMERS_TABLE[5];
                    case 6:
                        return Constants.HEADER_CUSTOMERS_TABLE[6];

                }
                return null;
            }

        };
    }

    private static PaginationDataProvider<Customers> createDataProvider() {

        return new PaginationDataProvider<Customers>() {
            String searchText;

            @Override
            public String getSearchText() {
                return searchText;
            }

            @Override
            public void setSearchText(String searchText) {
                this.searchText = searchText;
            }

            @Override
            public int getTotalRowCount(boolean isSearch) {
                return (isSearch == false ? customers.size() : getListsSearchByText().size());
            }

            @Override
            public List<Customers> getRows(int startIndex, int endIndex, boolean isSearch) {

                if (startIndex < endIndex) {
                    if (isSearch == false) {
                        return customers.subList(startIndex, endIndex);
                    } else {
                        List<Customers> newLists = getListsSearchByText();
                        return newLists.subList(startIndex, endIndex);
                    }
                }
                return new ArrayList<>();
            }

            @Override
            public List<Customers> getListsSearchByText() {

                List<Customers> newLists = new ArrayList<>();
                for (Customers em : customers) {
                    if (String.valueOf(em.getId()).contains(searchText) || em.getName().contains(searchText)) {
                        newLists.add(em);
                    }
                }
                return newLists;
            }

            @Override
            public void setList(List<Customers> lists) {
                customers = lists;
            }

        };

    }

    public void clearView(boolean clearAll) {
        setEnableBtnAddNew(true);
        setEnableBtnEdit(false);
        if (clearAll == true) {
            messageCustomer.setText("");
            clearError();
        }
        id.setText("");
        name.setText("");
        address.setText("");
        phone.setText("");
        email.setText("");
        name.requestFocus();
        
    }

    public void clearError() {
        errName.setText("");
        errAddress.setText("");
        errPhone.setText("");
        errEmail.setText("");
        messageCustomer.setText("");
        name.requestFocus();
    }

    public void showErrorMessage(JLabel label, String err) {
        label.setText(err);
        label.setForeground(Color.red);
    }

    @Override
    public List<Object> getElements(boolean isInsert) {
        List<Object> objects = new ArrayList<>();
        if (isInsert == false) {
            id.setName("id");
            objects.add(id);

        }
        // set Name text field
        name.setName("name");
        address.setName("address");
        phone.setName("phone");
        email.setName("email");
        // add object to map
        objects.add(name);
        objects.add(address);
        objects.add(phone);
        objects.add(email);
        return objects;
    }

    @Override
    public void showErrors(Map<String, String> errors) {
        //get error messages
        String errorNameMsg = ((errors.get("name") == null) ? "" : errors.get("name"));
        String errAddressMsg = ((errors.get("address") == null) ? "" : errors.get("address"));
        String errPhoneMsg = ((errors.get("phone") == null) ? "" : errors.get("phone"));
        String errEmailMsg = ((errors.get("email") == null) ? "" : errors.get("email"));
        //Show messages
        showErrorMessage(errName, errorNameMsg);
        showErrorMessage(errAddress, errAddressMsg);
        showErrorMessage(errPhone, errPhoneMsg);
        showErrorMessage(errEmail, errEmailMsg);
    }

    public void showUpdateCustomer(Customers customer) {
        id.setText(String.valueOf(customer.getId()));
        name.setText(customer.getName());
        address.setText(customer.getAddress());
        phone.setText(customer.getPhone());
        email.setText(customer.getEmail());
        info.setText(customer.getMoreInfo());

        setEnableBtnAddNew(false);
        setEnableBtnEdit(true);
    }

    public String getEditId() {
        return id.getText();

    }

}
