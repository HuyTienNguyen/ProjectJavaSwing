/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.testView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import qlkh.entities.Category;
import qlkh.entities.InvoiceImport;
import qlkh.entities.InvoiceImportDetail;
import qlkh.entities.Products;
import qlkh.entities.Supliers;
import qlkh.entities.Unit;
import qlkh.test.IView;
import qlkh.utils.Constants;
import qlkh.utils.Utils;
import qlkh.utils.pagination.ObjectTableModel;
import qlkh.utils.pagination.PaginatedTableDecorator;
import qlkh.utils.pagination.PaginationDataProvider;

/**
 *
 * @author GIANG
 */
public class GiangTestFrameInvoiceImportDetail extends javax.swing.JFrame implements IView {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userRoleMainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        tableInvoiceImDetail = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        inputPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        errInputPrice = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        messageInvoiceImportDetail = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        lblCate1 = new javax.swing.JLabel();
        cbbCategory = new javax.swing.JComboBox<Category>();
        errCate = new javax.swing.JLabel();
        lblCate2 = new javax.swing.JLabel();
        cbbProducts = new javax.swing.JComboBox<Products>();
        errProduct = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        outputPrice = new javax.swing.JTextField();
        errOuputPrice = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        errNumber = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        idInVoiceImport = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userRoleMainPanel.setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(51, 0, 51));

        headerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Invoice Import Detail");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tableInvoiceImDetailLayout = new javax.swing.GroupLayout(tableInvoiceImDetail);
        tableInvoiceImDetail.setLayout(tableInvoiceImDetailLayout);
        tableInvoiceImDetailLayout.setHorizontalGroup(
            tableInvoiceImDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableInvoiceImDetailLayout.setVerticalGroup(
            tableInvoiceImDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        inputPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        errInputPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText(bundle.getString("inputPrice")
        );

        id.setForeground(new java.awt.Color(240, 240, 240));
        id.setOpaque(true);
        id.setRequestFocusEnabled(false);

        lblCate1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCate1.setText(bundle.getString("cbbCategory"));

        errCate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCate2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCate2.setText(bundle.getString("cbbProduct"));

        errProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName1.setText(bundle.getString("outputPrice")
        );

        outputPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errOuputPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName2.setText(bundle.getString("outputPrice")
        );

        idInVoiceImport.setForeground(new java.awt.Color(240, 240, 240));
        idInVoiceImport.setOpaque(true);
        idInVoiceImport.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCate2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCate1)
                                .addGap(13, 13, 13)
                                .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(errCate, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(messageInvoiceImportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(outputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(errInputPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errOuputPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(idInVoiceImport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageInvoiceImportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idInVoiceImport, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)
                            .addComponent(lblCate1)
                            .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errCate, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(errInputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCate2)
                            .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errOuputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout userRoleMainPanelLayout = new javax.swing.GroupLayout(userRoleMainPanel);
        userRoleMainPanel.setLayout(userRoleMainPanelLayout);
        userRoleMainPanelLayout.setHorizontalGroup(
            userRoleMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableInvoiceImDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userRoleMainPanelLayout.setVerticalGroup(
            userRoleMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userRoleMainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tableInvoiceImDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userRoleMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userRoleMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<Category> cbbCategory;
    private javax.swing.JComboBox<Products> cbbProducts;
    private javax.swing.JLabel errCate;
    private javax.swing.JLabel errInputPrice;
    private javax.swing.JLabel errNumber;
    private javax.swing.JLabel errOuputPrice;
    private javax.swing.JLabel errProduct;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idInVoiceImport;
    private javax.swing.JTextField inputPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCate1;
    private javax.swing.JLabel lblCate2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel messageInvoiceImportDetail;
    private javax.swing.JTextField number;
    private javax.swing.JTextField outputPrice;
    private javax.swing.JPanel tableInvoiceImDetail;
    private javax.swing.JPanel userRoleMainPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form GiangTestFrame
     */
    ResourceBundle bundle;
    private static Map<String, String> productMap = new HashMap<>();
    private static int[] pageSizes = new int[]{10, 20, 50, 75, 100};
    private static final int defaultPageSize = 10;
    private static final int maxPagingCompToShow = 7;
    private static List<Products> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<InvoiceImportDetail> details = new ArrayList<>();

    JTable tblDetails;
    PaginatedTableDecorator<InvoiceImportDetail> paginatedDecorator;

    public GiangTestFrameInvoiceImportDetail() {
        //  Locale local = Utils.getLocale();
        Locale local = Utils.getLocale();
        setResourceBundle(local);
        initComponents();

    }

    // Show view with list Suplier on Suplier Table
    public void showView(List<InvoiceImportDetail> details) {
        this.setVisible(true);
        setEnableBtnEdit(true);
        setEnableBtnEdit(false);
        loadAllDetails(details);

    }

    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<Products>() {
            @Override
            public Object getValueAt(Products product, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return product.getId();
                    case 1:
                        return product.getName();

                    case 3:
                        return productMap.get(product.getId());

                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return Constants.HEADER_PRODUCT_TABLE.length;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return Constants.HEADER_PRODUCT_TABLE[0];
                    case 1:
                        return Constants.HEADER_PRODUCT_TABLE[1];
                    case 2:
                        return Constants.HEADER_PRODUCT_TABLE[2];
                    case 3:
                        return Constants.HEADER_PRODUCT_TABLE[3];
                    case 4:
                        return Constants.HEADER_PRODUCT_TABLE[4];
                }
                return null;
            }

        };
    }

    private static PaginationDataProvider<InvoiceImportDetail> createDataProvider() {

        return new PaginationDataProvider<InvoiceImportDetail>() {
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
                return (isSearch == false ? products.size() : getListsSearchByText().size());
            }

            @Override
            public List<InvoiceImportDetail> getRows(int startIndex, int endIndex, boolean isSearch) {

                if (startIndex < endIndex) {
                    if (isSearch == false) {
                        return details.subList(startIndex, endIndex);
                    } else {
                        List<InvoiceImportDetail> newLists = getListsSearchByText();
                        return newLists.subList(startIndex, endIndex);
                    }
                }
                return new ArrayList<>();
            }

            @Override
            public List<InvoiceImportDetail> getListsSearchByText() {

                List<InvoiceImportDetail> newLists = new ArrayList<>();
                for (InvoiceImportDetail em : details) {
                    if (String.valueOf(em.getId()).contains(searchText)) {
                        newLists.add(em);
                    }
                }
                return newLists;
            }

            @Override
            public void setList(List<InvoiceImportDetail> lists) {
                details = lists;
            }

        };

    }

    public void loadAllCategories(List<Category> listCate) {
        if (categories.isEmpty() == true) {
            categories = listCate;
        }
        Category numberOneCate = new Category(0, "");
        cbbCategory.addItem(numberOneCate);
        for (Category cate : categories) {
            if (cate.getStatus() > 0) {
                cbbCategory.addItem(cate);
            }
        }
    }

    // Load list Unit on Unit Table
    public void loadAllProducts(List<Products> listProduct, boolean isFirstLoad, Category cate) {
        clearCbbProducts();
        Products newPro = new Products();
        newPro.setId("0");
        newPro.setName("");
        if (isFirstLoad == true) {
            cbbProducts.addItem(newPro);

        } else {
            // set data for List<Product> lists
            if (products.isEmpty() == true) {
                products = listProduct;
            }

            cbbProducts.addItem(newPro);
            for (Products pro : products) {
                if (pro.getIdCate() == cate.getId()) {
                    cbbProducts.addItem(pro);
                }
                productMap.put(pro.getId(), pro.getName());
            }
        }
    }

    public void clearCbbProducts() {
        cbbProducts.removeAllItems();
    }

    // Set ResourceBundle to this view
    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);

    }

    @Override
    public List<Object> getListElements(boolean isInsert) {
        List<Object> objects = new ArrayList<>();
        // set Name text field
        id.setName("id");
        cbbCategory.setName("category");
        cbbProducts.setName("product");
        inputPrice.setName("inputPrice");
        outputPrice.setName("outputPrice");
        number.setName("number");

        // add object to map
        objects.add(id);
        objects.add(cbbCategory);
        objects.add(cbbProducts);
        objects.add(inputPrice);
        objects.add(outputPrice);
        objects.add(number);

        return objects;
    }

    @Override
    public void showErrors(Map<String, String> errors) {
        //get error messages
        String errorCate = ((errors.get("category") == null) ? "" : errors.get("category"));
        String errorPro = ((errors.get("product") == null) ? "" : errors.get("product"));
        String errorInput = ((errors.get("inputPrice") == null) ? "" : errors.get("inputPrice"));
        String errorOutput = ((errors.get("outputPrice") == null) ? "" : errors.get("outputPrice"));
        String errorNumber = ((errors.get("number") == null) ? "" : errors.get("number"));

        //Show messages
        showErrorMessage(errCate, errorCate);
        showErrorMessage(errProduct, errorPro);
        showErrorMessage(errInputPrice, errorInput);
        showErrorMessage(errOuputPrice, errorOutput);
        showErrorMessage(errNumber, errorNumber);
    }

    public InvoiceImportDetail getInVoiceDetail(boolean isInsert, String productId) {
        Products product = (Products) cbbProducts.getSelectedItem();

        InvoiceImportDetail invoiceDetail = new InvoiceImportDetail();

        invoiceDetail.setId((isInsert == true) ? "" : id.getText());
        invoiceDetail.setIdInvoiceImport(idInVoiceImport.getText());
        invoiceDetail.setIdProduct(product.getName());
        invoiceDetail.setInputPrice(Float.parseFloat(inputPrice.getText()));
        invoiceDetail.setOutputPrice(Float.parseFloat(outputPrice.getText()));
        invoiceDetail.setNumber(Integer.parseInt(number.getText()));
        return invoiceDetail;
    }

    public void showErrorMessage(JLabel label, String err) {
        label.setText(err);
        label.setForeground(Color.red);
    }

    public void loadAllDetails(List<InvoiceImportDetail> listDetails) {
        this.details = listDetails;
        tblDetails = new JTable(createObjectDataModel());
        tblDetails.setAutoCreateRowSorter(true);
        PaginationDataProvider<InvoiceImportDetail> dataProvider = createDataProvider();
        paginatedDecorator = PaginatedTableDecorator.decorate(tblDetails,
                dataProvider, pageSizes, defaultPageSize, maxPagingCompToShow);
        tableInvoiceImDetail.removeAll();
        tableInvoiceImDetail.setLayout(new CardLayout());
        tableInvoiceImDetail.add(paginatedDecorator.getContentPanel());

    }

    // Add event to button addNewUnit
    public void addBtnAddActionListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addBtnEditActionListener(ActionListener listener) {
        btnEdit.addActionListener(listener);
    }

    public void addBtnClearActionListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    public void addTableMouseListener(MouseListener listener) {
        paginatedDecorator.addTableMouseListener(listener);
    }

    // Get text from txtNewUnitField
    private void showErrMess(String message, int color) {
        errInputPrice.setText(bundle.getString(message));
        errInputPrice.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    public void showMessage(String message, int color) {
        messageInvoiceImportDetail.setText(bundle.getString(message));
        messageInvoiceImportDetail.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    public void focusTxtUnitField() {
        inputPrice.requestFocus();
    }

//    public Unit getEditUnit() {
//        int row = tblSuplier.getSelectedRow();
//        if (row < 0) {
//            return null;
//        }
//        return (Unit) tblSuplier.getModel().getValueAt(row, 1);
//    }
//    public String getEditProductId() {
//        int row = tblProducts.getSelectedRow();
//        if (row < 0) {
//            return null;
//        }
//        return tblProducts.getModel().getValueAt(row, 0).toString();
//    }
    private void setEnableBtnAddNew(boolean value) {
        btnAdd.setEnabled(value);
    }

    private void setEnableBtnEdit(boolean value) {
        btnEdit.setEnabled(value);
    }

    public int showDialog(JFrame frame, String message, String title, int typeIcon) {
        int iconNumber = (typeIcon == JOptionPane.QUESTION_MESSAGE) ? JOptionPane.QUESTION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        return JOptionPane.showConfirmDialog(frame, bundle.getString(message), bundle.getString(title), JOptionPane.OK_CANCEL_OPTION, iconNumber);
    }

    public void clearView(boolean clearAll) {
        setEnableBtnAddNew(true);
        setEnableBtnEdit(false);
        if (clearAll == true) {
            messageInvoiceImportDetail.setText("");
        }
        id.setText("");
        idInVoiceImport.setText("");
        inputPrice.setText("");
        outputPrice.setText("");
        number.setText("");
        cbbCategory.setSelectedIndex(0);
        inputPrice.requestFocus();
    }

    public void clearError() {
        errInputPrice.setText("");
        errOuputPrice.setText("");
        errNumber.setText("");
        errCate.setText("");
        errProduct.setText("");
        messageInvoiceImportDetail.setText("");
        inputPrice.requestFocus();
    }

    public void showUpdateDetail(InvoiceImportDetail invoiceDetail) {
        id.setText(invoiceDetail.getId());
        inputPrice.setText(Float.toString(invoiceDetail.getInputPrice()));
        outputPrice.setText(Float.toString(invoiceDetail.getOutputPrice()));
        number.setText(Integer.toString(invoiceDetail.getNumber()));
        String proId = invoiceDetail.getIdProduct();
        Products product = null;
        for (Products pro : products) {
            if (pro.getId().compareTo(proId) == 0) {
                product = pro;
                break;
            }
        }
        Category cate = null;
        if (product != null) {
            for (Category cat : categories) {
                if (cat.getId() == product.getIdCate()) {
                    cate = cat;
                    break;

                }

            }
            if (cate != null) {
                cbbCategory.setSelectedItem(cate);
               // loadAllProducts(products, cate);
                cbbProducts.setSelectedItem(product);
            }
        }
        setEnableBtnAddNew(false);
        setEnableBtnEdit(true);
    }

    public String getEditId() {
        return id.getText();

    }
}
