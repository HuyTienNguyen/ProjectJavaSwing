/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceExportDaoImpl;
import qlkh.daoimpl.InvoiceExportDetailDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.InvoiceExportDetail;
import qlkh.entities.Products;
import qlkh.request.IRequest;
import qlkh.request.InvoiceExportDetailRequest;
import qlkh.request.InvoiceImportDetailRequest;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.views.InvoiceExportDetailView;

/**
 *
 * @author user
 */
public class InvoiceExportDetailController {

    InvoiceExportDetailView view;
    ProductDaoImpl proDao;
    InvoiceImportDetailDaoImpl invoiceImDetailDao;
    InvoiceExportDetailDaoImpl invoiceExDetailDao;
    InvoiceExportDaoImpl invoiceExDao;
    CategoryDaoImpl cateDao;

    public InvoiceExportDetailController() {
        view = new InvoiceExportDetailView();
        proDao = new ProductDaoImpl();
        invoiceImDetailDao = new InvoiceImportDetailDaoImpl();
        invoiceExDao = new InvoiceExportDaoImpl();
        invoiceExDetailDao = new InvoiceExportDetailDaoImpl();
        cateDao = new CategoryDaoImpl();

    }

    public void showView() {
        if (view == null) {
            view = new InvoiceExportDetailView();
        }
        List<Products> products = proDao.getAllProducts();
        view.loadAllCategories(cateDao.getCategoies(), products);
        view.loadProducts(products);

        view.addBtnAddAction(this::btnAddAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addCbbCateStateChanged(this::cateBoxStateChanged);

        view.showView(invoiceExDetailDao.getAllInvoiceExportDetail());

        view.addTableMouseListener(new TableInvoiceExportDetailMouseListener());

        view.clearView(true);

    }

    public JPanel getContentPage() {
        return view.getContent();
    }

    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new InvoiceExportDetailRequest();
            // Declare instance of Validator
            boolean isInsert = true;
            Validator validator = Validator.validate(view.getElements(isInsert), request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view

            view.showErrors(validator.getErrors());
            if (validator.isPasses() == true) {
                InvoiceExportDetail elements = view.getInvoiceExportDetail();
                if (!view.getValueNewBill()) {
                    elements.setIdInvoiceExport(invoiceExDao.getIdTheLast());
                }
                int errOutput = invoiceExDetailDao.insert(elements);
                if (errOutput == 1) {
                    view.showMessage(Constants.MSG_NO_QUALITY, Constants.FLAG_ERROR);
                } else if (errOutput == 2) {
                    view.showMessage(Constants.MSG_ERROR_LOGIC, Constants.FLAG_ERROR);
                } else {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.showView(invoiceExDetailDao.getAllInvoiceExportDetail());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(InvoiceExportDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cateBoxStateChanged(ItemEvent e) {
        Category cate = view.getCateSelected();
        if (cate != null) {
            view.loadProducts(view.getListProduct(cate), cate);
        }

    }

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    }

    private class TableInvoiceExportDetailMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on invoiceedportdetail table
            String invoiceExportId = view.getEditInvoiceExportId();
            String productName = view.getEditInvoiceExportProductName();
            InvoiceExportDetail invoiceExportDetail = null;
            if (invoiceExportId.equals("") == false && invoiceExportId != null) {
                try {
                    invoiceExportDetail = invoiceExDetailDao.getUpdateInvoiceExport(invoiceExportId,productName);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceExportDetailController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Products p = new Products();
            p = proDao.getProductById(invoiceExportDetail.getIdProduct());
            if(p != null && invoiceExportDetail != null){
                view.updateInvoiceExportDetail(invoiceExportDetail,p);
            }
            else{
                System.out.println("loi");
            }
//            if (customer != null) {
//                view.clearView(true);
//                view.showUpdateCustomer(customer);
//            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
