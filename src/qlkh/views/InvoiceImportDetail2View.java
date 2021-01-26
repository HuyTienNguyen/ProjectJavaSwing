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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import qlkh.entities.Category;
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
public class InvoiceImportDetail2View extends javax.swing.JPanel implements IView {

    /**
     * Creates new form InvoiceImportDetail2View
     */
    ResourceBundle bundle;
    private static Map<String, Products> productMap = new HashMap<>();
    private static Map<String, String> importMap = new HashMap<>();
    private static Map<Category, List<Products>> cateMap = new HashMap<>();
    private static int[] pageSizes = new int[]{100, 1000, 10000};
    private static final int defaultPageSize = pageSizes[0];
    private static final int maxPagingCompToShow = 7;
    private static List<Products> products = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<InvoiceImportDetail> details = new ArrayList<>();
    private static List<InvoiceImport> imports = new ArrayList<>();

    JTable tblDetails;
    PaginatedTableDecorator<InvoiceImportDetail> paginatedDecorator;

    public InvoiceImportDetail2View() {
        //  Locale local = Utils.getLocale();
        Locale local = Utils.getLocale();
        setResourceBundle(local);
        initComponents();
    }

    /**
     * Display a view of InvoiceImportDetail elements
     *
     * @param details a list of InvoiceImportDetail elements
     */
    public void showView(List<InvoiceImportDetail> details) {
        this.setVisible(true);
        if (details != null) {
            loadAllDetails(details);
        }
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
        return new ObjectTableModel<InvoiceImportDetail>() {
            @Override
            public Object getValueAt(InvoiceImportDetail iid, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return iid.getId();
                    case 1:
                        return ((Products) productMap.get(iid.getIdProduct())).getName();
                    case 2:
                        return iid.getNumber();
                    case 3:
                        return iid.getInputPrice();
                    case 4:
                        return ((Products) productMap.get(iid.getIdProduct())).getPrice();
                    case 5:
                        return importMap.get(iid.getIdInvoiceImport());

                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return Constants.HEADER_IMPORT_DETAIL_TABLE.length;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[0];
                    case 1:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[1];
                    case 2:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[2];
                    case 3:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[3];
                    case 4:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[4];
                    case 5:
                        return Constants.HEADER_IMPORT_DETAIL_TABLE[5];
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
                return (isSearch == false ? details.size() : getListsSearchByText().size());
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

    /**
     * Put imports to memory of form
     *
     * @param imports
     */
    public void loadImports(List<InvoiceImport> imports) {

        this.imports = imports;
        int counts = 1;
        InvoiceImport newInvoiceImport = new InvoiceImport("0", Utils.getTimestampNow());
        cbbInvoiceImport.addItem(newInvoiceImport);

        for (InvoiceImport ip : imports) {
            if (counts < 10) {
                cbbInvoiceImport.addItem(ip);
            }
            importMap.put(ip.getId(), ip.getDateInput().toString());
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

    /**
     * Clear combobox Product
     */
    public void clearCbbProducts() {
        cbbProducts.removeAllItems();
    }

    /**
     * Set ResourceBundle to this view
     *
     * @param locale
     */
    private void setResourceBundle(Locale locale) {
        //Set Resources Bundle theo local 
        bundle = ResourceBundle.getBundle("qlkh/utils/languages", locale);

    }

    /**
     * @Return listElements can use for validate Request by class Validator
     * @param isInsert
     * @return
     */
    @Override
    public List<Object> getElements(boolean isInsert) {
        List<Object> objects = new ArrayList<>();
        cbbProducts.setName("product");
        inputPrice.setName("inputPrice");
        number.setName("number");

        // add object to map
        objects.add(cbbProducts);
        objects.add(inputPrice);
        objects.add(number);

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
        String errorProduct = ((errors.get("product") == null) ? "" : errors.get("product"));
        String errorInputPrice = ((errors.get("inputPrice") == null) ? "" : errors.get("inputPrice"));
        String errorNumber = ((errors.get("number") == null) ? "" : errors.get("number"));

        //Show messages
        showErrorMessage(errProduct, errorProduct);
        showErrorMessage(errInputPrice, errorInputPrice);
        showErrorMessage(errNumber, errorNumber);
    }

    /**
     * @return a instance of InvoiceImportDetail
     *
     */
    public InvoiceImportDetail getInVoiceDetail() {
        Products product = (Products) cbbProducts.getSelectedItem();
        InvoiceImportDetail invoiceDetail = new InvoiceImportDetail();
        invoiceDetail.setIdInvoiceImport(((InvoiceImport) cbbInvoiceImport.getSelectedItem()).getId());
        invoiceDetail.setIdProduct(product.getId());
        invoiceDetail.setInputPrice(Float.parseFloat(inputPrice.getText()));
        invoiceDetail.setNumber(Integer.parseInt(number.getText()));
        return invoiceDetail;
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
     * Display the elements of InvoiceImportDetail on the table of view
     *
     * @param listDetails List elements of InvoiceImportDetail
     */
    public void loadAllDetails(List<InvoiceImportDetail> listDetails) {
        if (listDetails != null) {
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

    /**
     * Return an instance of Category from category combobox
     *
     * @return
     */
    public Category getCateSelected() {
        return (Category) cbbCategory.getSelectedItem();
    }

    /**
     * Display message to the user
     *
     * @param message
     * @param color
     */
    public void showMessage(String message, int color) {
        messageInvoiceImportDetail.setText(bundle.getString(message));
        messageInvoiceImportDetail.setForeground((color == Constants.FLAG_SUCCESS) ? Constants.COLOR_SUCCESS : Constants.COLOR_ERROR);
    }

    /**
     * Focus to the first file of the form
     */
    public void focusTxtUnitField() {
        inputPrice.requestFocus();
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
     * Set Enable for Add New button
     *
     * @param value new value of the Add button
     */
    private void setEnableBtnAddNew(boolean value) {
        btnAdd.setEnabled(value);
    }

    /**
     * Returns a dialog box for the user to choose from
     *
     * @param parentFrame parent frame of the dialog box
     * @param message messages sent to users
     * @param title title of the dialog box
     * @param typeIcon type Icon of dialog box
     * @return
     */
    public int showDialog(JFrame parentFrame, String message, String title, int typeIcon) {
        int iconNumber = (typeIcon == JOptionPane.QUESTION_MESSAGE) ? JOptionPane.QUESTION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        return JOptionPane.showConfirmDialog(parentFrame, bundle.getString(message), bundle.getString(title), JOptionPane.OK_CANCEL_OPTION, iconNumber);
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
            messageInvoiceImportDetail.setText("");
        }
        id.setText("");
        idInVoiceImport.setText("");
        inputPrice.setText("");
        number.setText("");
        cbbCategory.setSelectedIndex(0);
        cbbInvoiceImport.setSelectedIndex(0);
        inputPrice.requestFocus();
        clearError();
    }

    /**
     * Clear all error on the form
     */
    public void clearError() {
        errInputPrice.setText("");
        errNumber.setText("");
        errCate.setText("");
        errProduct.setText("");
        messageInvoiceImportDetail.setText("");
        inputPrice.requestFocus();
    }

    /**
     * Return id of Edit InvoiceImportDetail
     *
     * @return
     */
    public String getEditId() {
        return id.getText();

    }

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
        tableInvoiceImDetail = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        inputPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
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
        number = new javax.swing.JTextField();
        errNumber = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        idInVoiceImport = new javax.swing.JLabel();
        lblCate3 = new javax.swing.JLabel();
        cbbInvoiceImport = new javax.swing.JComboBox<InvoiceImport>();
        errProduct1 = new javax.swing.JLabel();

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
                .addContainerGap(759, Short.MAX_VALUE))
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

        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        errNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName2.setText(bundle.getString("iidNumber")
        );

        idInVoiceImport.setForeground(new java.awt.Color(240, 240, 240));
        idInVoiceImport.setOpaque(true);
        idInVoiceImport.setRequestFocusEnabled(false);

        lblCate3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCate3.setText(bundle.getString("cbbIdInvoice"));

        cbbInvoiceImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbInvoiceImportActionPerformed(evt);
            }
        });

        errProduct1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCate1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCate3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbInvoiceImport, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(errCate, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(messageInvoiceImportDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(inputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(errInputPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(idInVoiceImport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCate2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(errInputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCate2))
                        .addGap(5, 5, 5)
                        .addComponent(errProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCate3)
                            .addComponent(cbbInvoiceImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblName2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(errNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(tableInvoiceImDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tableInvoiceImDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void cbbProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbProductsActionPerformed

    private void cbbInvoiceImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbInvoiceImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbInvoiceImportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JComboBox<Category> cbbCategory;
    private javax.swing.JComboBox<InvoiceImport> cbbInvoiceImport;
    private javax.swing.JComboBox<Products> cbbProducts;
    private javax.swing.JLabel errCate;
    private javax.swing.JLabel errInputPrice;
    private javax.swing.JLabel errNumber;
    private javax.swing.JLabel errProduct;
    private javax.swing.JLabel errProduct1;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idInVoiceImport;
    private javax.swing.JTextField inputPrice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCate1;
    private javax.swing.JLabel lblCate2;
    private javax.swing.JLabel lblCate3;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel messageInvoiceImportDetail;
    private javax.swing.JTextField number;
    private javax.swing.JPanel tableInvoiceImDetail;
    // End of variables declaration//GEN-END:variables
}
