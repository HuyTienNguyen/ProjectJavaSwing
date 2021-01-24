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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceImportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.InvoiceImport;
import qlkh.entities.InvoiceImportDetail;
import qlkh.entities.Products;
import qlkh.request.IRequest;
import qlkh.request.InvoiceImportDetailRequest;
import qlkh.testView.GiangTestFrameInvoiceImportDetail;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.views.CategoryView;
import qlkh.views.InvoiceImportDetail2View;

/**
 *
 * @author user
 */
public class InvoiceImportDetailController {

    InvoiceImportDetail2View view;
    ProductDaoImpl proDao;
    InvoiceImportDetailDaoImpl invoiceImDetailDao;
    InvoiceImportDaoImpl invoiceImDao;
    CategoryDaoImpl cateDao;

    public InvoiceImportDetailController() {
        view = new InvoiceImportDetail2View();
        proDao = new ProductDaoImpl();
        invoiceImDetailDao = new InvoiceImportDetailDaoImpl();
        invoiceImDao = new InvoiceImportDaoImpl();
        cateDao = new CategoryDaoImpl();

        List<Products> products = proDao.getAllProducts();
        view.loadAllCategories(cateDao.getCategoies(), products);
        view.loadImports(invoiceImDao.getImports());
        view.loadProducts(products);
        view.showView(invoiceImDetailDao.getAllDetails());

        view.addBtnAddAction(this::btnAddAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addCbbCateStateChanged(this::cateBoxStateChanged);
        view.addTableMouseListener(new TableMouseListener());
    }

    public void showView() {
        if (view == null) {
            view = new InvoiceImportDetail2View();
        }
        view.showView(invoiceImDetailDao.getAllDetails());
        view.clearView(true);
    }

    public JPanel getContentPage() {
        return view.getContent();
    }

    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new InvoiceImportDetailRequest();
            // Declare instance of Validator
            boolean isInsert = true;

            Validator validator = Validator.validate(view.getElements(isInsert), request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            if (validator.isPasses() == true) {

                int records = invoiceImDetailDao.insert(view.getInVoiceDetail());
                if (records == 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.loadImports(invoiceImDao.getImports());
                    view.showView(invoiceImDetailDao.getAllDetails());
                } else {
                    view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(InvoiceImportDetailController.class.getName()).log(Level.SEVERE, null, ex);
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

    private class TableMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            //   String productId = view.getEditProductId();

//            view.clearError();
//            Products product = null;
//            if (productId.equals("") == false && productId != null) {
//                product = proDao.getProductById(productId);
//            }
//            if (product != null) {
//                view.showUpdateProduct(product);
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
