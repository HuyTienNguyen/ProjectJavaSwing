
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.views;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import qlkh.entities.Category;
import qlkh.entities.InvoiceExport;
import qlkh.entities.InvoiceExportDetail;
import qlkh.entities.InvoiceImport;
import qlkh.entities.InvoiceImportDetail;
import qlkh.entities.Products;
import qlkh.utils.Constants;
import qlkh.utils.Utils;
import qlkh.utils.pagination.ObjectTableModel;
import qlkh.utils.pagination.PaginatedTableDecorator;
import qlkh.utils.pagination.PaginationDataProvider;

/**
 *
 * @author user
 */
public class InvoiceExportDetailView extends javax.swing.JPanel implements IView {

    /**
     * Creates new form OutputInfoView
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
        headerLabel = new javax.swing.JLabel();
        tableInvoiceExDetail = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        counts = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        errCounts = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        messageInvoiceExportDetail = new javax.swing.JLabel();
        lblCate1 = new javax.swing.JLabel();
        cbbCategory = new javax.swing.JComboBox<Category>();
        errCate = new javax.swing.JLabel();
        lblCate2 = new javax.swing.JLabel();
        cbbProducts = new javax.swing.JComboBox<Products>();
        errProduct = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        idCustomer = new javax.swing.JTextField();
        errIdCustomer = new javax.swing.JLabel();
        chkNewBill = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        IdExport = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        headerPanel.setBackground(new java.awt.Color(51, 0, 51));

        headerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Invoice Export Detail");

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

        javax.swing.GroupLayout tableInvoiceExDetailLayout = new javax.swing.GroupLayout(tableInvoiceExDetail);
        tableInvoiceExDetail.setLayout(tableInvoiceExDetailLayout);
        tableInvoiceExDetailLayout.setHorizontalGroup(
            tableInvoiceExDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableInvoiceExDetailLayout.setVerticalGroup(
            tableInvoiceExDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        counts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        btnClear.setBackground(new java.awt.Color(51, 153, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/clear_40.png"))); // NOI18N
        btnClear.setText(bundle.getString("btnClear")
        );
        btnClear.setFocusPainted(false);
        btnClear.setMaximumSize(new java.awt.Dimension(134, 40));
        btnClear.setMinimumSize(new java.awt.Dimension(134, 40));

        errCounts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText(bundle.getString("counts")
        );

        lblCate1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCate1.setText(bundle.getString("cbbCategory"));

        errCate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCate2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCate2.setText(bundle.getString("cbbProduct"));

        cbbProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbProductsActionPerformed(evt);
            }
        });

        errProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName1.setText(bundle.getString("idCustomer")
        );

        idCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errIdCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        chkNewBill.setText(bundle.getString("newbill"));

        jLabel1.setText("Id");

        IdExport.setEditable(false);

        btnUpdate.setBackground(new java.awt.Color(204, 255, 204));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlkh/images/edit_40.png"))); // NOI18N
        btnUpdate.setText(bundle.getString("btnEdit"));
        btnUpdate.setPreferredSize(new java.awt.Dimension(151, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(errCate, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCate1)
                            .addComponent(chkNewBill))
                        .addGap(241, 241, 241)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(messageInvoiceExportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(counts, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(errCounts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errIdCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(159, 159, 159))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(283, 283, 283))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCate2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IdExport)
                            .addComponent(cbbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageInvoiceExportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(counts, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lblCate1)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errCate, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(errCounts, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCate2))
                        .addGap(5, 5, 5)
                        .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(chkNewBill)
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableInvoiceExDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tableInvoiceExDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void cbbProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbProductsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdExport;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Category> cbbCategory;
    private javax.swing.JComboBox<Products> cbbProducts;
    private javax.swing.JCheckBox chkNewBill;
    private javax.swing.JTextField counts;
    private javax.swing.JLabel errCate;
    private javax.swing.JLabel errCounts;
    private javax.swing.JLabel errIdCustomer;
    private javax.swing.JLabel errProduct;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField idCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCate1;
    private javax.swing.JLabel lblCate2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel messageInvoiceExportDetail;
    private javax.swing.JPanel tableInvoiceExDetail;
    // End of variables declaration//GEN-END:variables
    ResourceBundle bundle;
    private static Map<String, Products> productMap = new HashMap<>();
    private static Map<String, String> exportMap = new HashMap<>();
    private static Map<Category, List<Products>> cateMap = new HashMap<>();
    private static int[] pageSizes = new int[]{10, 25, 50, 100, 1000, 10000};
    private static final int defaultPageSize = pageSizes[0];
    private static final int maxPagingCompToShow = 7;
    private static List<Products> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<InvoiceExportDetail> details = new ArrayList<>();
    private static List<InvoiceExport> export = new ArrayList<>();

    JTable tblDetails;
    PaginatedTableDecorator<InvoiceExportDetail> paginatedDecorator;

    public InvoiceExportDetailView() {
        //  Locale local = Utils.getLocale();
        Locale local = Utils.getLocale();
        setResourceBundle(local);
        initComponents();
    }

    /**
     * Add Event Action to button add new
     *
     * @param listener
     */
    public void addBtnAddAction(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    /**
     * Add Event Action to button clear
     *
     * @param listener
     */
    public void addBtnClearAction(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    /**
     * Add Event Action to Table
     *
     * @param listener
     */
    public void addTableMouseListener(MouseListener listener) {
        paginatedDecorator.addTableMouseListener(listener);
    }

    /**
     * Add Item Event to Category combobox
     *
     * @param listener
     */
    public void addCbbCateStateChanged(ItemListener listener) {
        cbbCategory.addItemListener(listener);
    }

 

    public void addBtnUpdateAction(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    /**
     * Return an instance of Category from category combobox
     *
     * @return
     */
    public Category getCateSelected() {
        return (Category) cbbCategory.getSelectedItem();
    }

    /**
     * Return a list of products from memory of form
     *
     * @param cate an instance of Category
     * @return
     */
    public List<Products> getListProduct(Category cate) {
        List<Products> listProducts = cateMap.get(cate);
        return listProducts;
    }

    /**
     * Display the products in the view search by an instance of Category
     *
     * @param listProduct List of elements Products
     * @param cate
     */
    public void loadProducts(List<Products> listProduct, Category cate) {
        clearCbbProducts();
        if (cate != null) {
            List<Products> listAddToCbb = new ArrayList<>();
            listAddToCbb = cateMap.get(cate);
            if (listAddToCbb != null) {
                for (Products pro : listAddToCbb) {
                    cbbProducts.addItem(pro);
                }
            }
        }
    }

    /**
     * Clear combobox Product
     */
    public void clearCbbProducts() {
        cbbProducts.removeAllItems();
    }

    /**
     * Display a view of InvoiceImportDetail elements
     *
     * @param details a list of InvoiceImportDetail elements
     */
    public void showView(List<InvoiceExportDetail> details) {
        this.setVisible(true);
        if (details != null) {
            loadAllDetails(details);
        }
    }

    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);
    }

    public JPanel getContent() {
        return this;
    }

    /**
     * Return an instance of ObjectDataModel
     *
     * @return
     *
     */
    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<InvoiceExportDetail>() {
            @Override
            public Object getValueAt(InvoiceExportDetail ied, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return ied.getIdInvoiceExport();
                    case 1:
                        return ied.getNameCustomer();
                    case 2:
                        return ied.getNameProduct();
                    case 3:
                        return ied.getCounts();
                    case 4:
                        return ied.getMoney();
                    case 5:
                        return ied.getUserName();
                    case 6:
                        return ied.getDateOutput();

                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return Constants.HEADER_EXPORT_DETAIL_TABLE.length;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[0];
                    case 1:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[1];
                    case 2:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[2];
                    case 3:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[3];
                    case 4:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[4];
                    case 5:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[5];
                    case 6:
                        return Constants.HEADER_EXPORT_DETAIL_TABLE[6];
                }
                return null;
            }

        };
    }

    private static PaginationDataProvider<InvoiceExportDetail> createDataProvider() {

        return new PaginationDataProvider<InvoiceExportDetail>() {
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
                return (isSearch == false ? details.size() : getListsSearchByText().size());
            }

            @Override
            public List<InvoiceExportDetail> getRows(int startIndex, int endIndex, boolean isSearch) {

                if (startIndex < endIndex) {
                    if (isSearch == false) {
                        return details.subList(startIndex, endIndex);
                    } else {
                        List<InvoiceExportDetail> newLists = getListsSearchByText();
                        return newLists.subList(startIndex, endIndex);
                    }
                }
                return new ArrayList<>();
            }

            @Override
            public List<InvoiceExportDetail> getListsSearchByText() {

                List<InvoiceExportDetail> newLists = new ArrayList<>();
                for (InvoiceExportDetail em : details) {
                    if (String.valueOf(em.getIdInvoiceExport()).contains(searchText)
                            || em.getNameCustomer().contains(searchText)
                            || em.getNameProduct().contains(searchText)
                            || String.valueOf(em.getCounts()).contains(searchText)
                            || String.valueOf(em.getMoney()).contains(searchText)
                            || em.getUserName().contains(searchText)
                            || String.valueOf(em.getDateOutput()).contains(searchText)) {
                        newLists.add(em);
                    }
                }
                return newLists;
            }

            @Override
            public void setList(List<InvoiceExportDetail> lists) {
                details = lists;
            }

        };

    }

    public void showMessage(String message, int color) {
        messageInvoiceExportDetail.setText(bundle.getString(message));
        messageInvoiceExportDetail.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    public String getEditInvoiceExportId() {
        int row = tblDetails.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return tblDetails.getModel().getValueAt(row, 0).toString();
    }

    public String getEditInvoiceExportProductName() {
        int row = tblDetails.getSelectedRow();
        if (row < 0) {
            return null;
        }
        return tblDetails.getModel().getValueAt(row, 2).toString();
    }

    /**
     * @return a instance of InvoiceImportDetail
     *
     */
    public InvoiceExportDetail getInvoiceExportDetail() {
        Products product = (Products) cbbProducts.getSelectedItem();
        InvoiceExportDetail invoiceDetail = new InvoiceExportDetail();
        invoiceDetail.setNameProduct(product.getName());
        invoiceDetail.setCounts(Integer.parseInt(counts.getText()));
        invoiceDetail.setIdUser(Utils.getIdUser());
        invoiceDetail.setIdCustomer(idCustomer.getText());
        invoiceDetail.setIdInvoiceExport("");
        return invoiceDetail;
    }

    /**
     * @return a instance of InvoiceImportDetail when update
     *
     */
    public InvoiceExportDetail getInvoiceExportDetailWhenUpdate() {
        Products product = (Products) cbbProducts.getSelectedItem();
        InvoiceExportDetail invoiceDetail = new InvoiceExportDetail();
        invoiceDetail.setNameProduct(product.getName());
        invoiceDetail.setCounts(Integer.parseInt(counts.getText()));
        invoiceDetail.setIdInvoiceExport(IdExport.getText());
        return invoiceDetail;
    }

    public void updateInvoiceExportDetail(InvoiceExportDetail invoiceExportDetail, Products p) {
        IdExport.setText(invoiceExportDetail.getIdInvoiceExport());
        counts.setText(String.valueOf(invoiceExportDetail.getCounts()));
        idCustomer.setText(invoiceExportDetail.getIdCustomer());
        idCustomer.setEnabled(false);
        int cateId = p.getIdCate();
        for (Category c : categories) {
            if (c.getId() == cateId) {
                cbbCategory.setSelectedItem(c);
                break;
            }
        }

        for (Products p1 : products) {

            if (p1.getId().equals(p.getId())) {
                cbbProducts.setSelectedItem(p1);
                break;
            }
        }
    }

    public void loadAllCategories(List<Category> listCate, List<Products> listProducts) {
        cbbCategory.removeAllItems();
        if (categories.isEmpty() == true) {
            categories = listCate;
        }
        Category numberOneCate = new Category(0, "");
        cbbCategory.addItem(numberOneCate);
        for (Category cate : categories) {
            if (cate.getStatus() > 0) {
                cbbCategory.addItem(cate);
                List<Products> childList = new ArrayList<>();
                for (Products listProduct : listProducts) {
                    if (cate.getId() == listProduct.getIdCate()) {
                        childList.add(listProduct);
                    }
                }
                cateMap.put(cate, childList);
            }
        }

    }

    /**
     * Display the products in the view
     *
     * @param listProduct
     */
    public void loadProducts(List<Products> listProduct) {
        // set data for List<Product> lists
        if (products.isEmpty() == true) {
            products = listProduct;
        }
        cbbProducts.addItem(new Products("0", ""));
        for (Products pro : products) {
            productMap.put(pro.getId(), pro);
        }
    }

    public void loadAllDetails(List<InvoiceExportDetail> listDetails) {
        if (listDetails != null) {
            this.details = listDetails;
            tblDetails = new JTable(createObjectDataModel());
            tblDetails.setAutoCreateRowSorter(true);
            PaginationDataProvider<InvoiceExportDetail> dataProvider = createDataProvider();
            paginatedDecorator = PaginatedTableDecorator.decorate(tblDetails,
                    dataProvider, pageSizes, defaultPageSize, maxPagingCompToShow);
            tableInvoiceExDetail.removeAll();
            tableInvoiceExDetail.setLayout(new CardLayout());
            tableInvoiceExDetail.add(paginatedDecorator.getContentPanel());
        }
    }

    private void setEnableBtnAddNew(boolean value) {
        btnAdd.setEnabled(value);
    }

    /**
     * Display text on labels
     *
     * @param label
     * @param err
     */
    public void showErrorMessage(JLabel label, String err) {
        label.setText(err);
        label.setForeground(Color.red);
    }

    /**
     * Clear the view
     *
     * @param clearAll true : clear all the view ; false: clear all except the
     * notification of the view
     */
    public void clearView(boolean clearAll) {
        setEnableBtnAddNew(true);
        if (clearAll == true) {
            messageInvoiceExportDetail.setText("");
            clearError();
        }
        IdExport.setText("");
        idCustomer.setEnabled(true);
        counts.setText("");
        cbbCategory.setSelectedIndex(0);
        counts.requestFocus();
        idCustomer.setText("");
        
    }

    /**
     * Clear all error on the form
     */
    public void clearError() {
        errCounts.setText("");
        errCate.setText("");
        errProduct.setText("");
        errIdCustomer.setText("");
    }

    /**
     * get value new bill
     */
    public boolean getValueNewBill() {
        return chkNewBill.isSelected();
    }

    @Override
    public List<Object> getElements(boolean isInsert) {
        List<Object> objects = new ArrayList<>();
        cbbCategory.setName("cate");
        counts.setName("counts");
        idCustomer.setName("idCustomer");

        // add object to map
        objects.add(cbbCategory);
        objects.add(counts);
        objects.add(idCustomer);

        return objects;
    }

    /**
     * Display errors on view
     *
     * @param errors
     */
    @Override
    public void showErrors(Map<String, String> errors) {
        //get error messages
        String errorCate = ((errors.get("cate") == null) ? "" : errors.get("cate"));
        String errorCounts = ((errors.get("counts") == null) ? "" : errors.get("counts"));
        String errorIdCustomer = ((errors.get("idCustomer") == null) ? "" : errors.get("idCustomer"));

        //Show messages
        showErrorMessage(errCate, errorCate);
        showErrorMessage(errCounts, errorCounts);
        showErrorMessage(errIdCustomer, errorIdCustomer);
    }

}
