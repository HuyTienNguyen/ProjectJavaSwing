/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.InvoiceImportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.InvoiceImportDetail;
import qlkh.entities.Products;
import qlkh.request.IRequest;
import qlkh.request.ProductRequest;
import qlkh.request.ProductUpdateRequest;
import qlkh.testView.GiangTestFrameInvoiceImportDetail;
import qlkh.utils.Constants;
import qlkh.utils.Validator;

/**
 *
 * @author user
 */
public class InvoiceImportDetailController {

    GiangTestFrameInvoiceImportDetail view;
    ProductDaoImpl proDao;
    InvoiceImportDetailDaoImpl invoiceImDetailDao;
    InvoiceImportDaoImpl invoiceImDao;
    CategoryDaoImpl cateDao;

    public InvoiceImportDetailController() {
        view = new GiangTestFrameInvoiceImportDetail();
        proDao = new ProductDaoImpl();
        invoiceImDetailDao = new InvoiceImportDetailDaoImpl();
        invoiceImDao = new InvoiceImportDaoImpl();
        cateDao = new CategoryDaoImpl();
    }

    public void showView() {
        if (view == null) {
            view = new GiangTestFrameInvoiceImportDetail();
        }
        view.loadAllCategories(cateDao.getCategoies());
        view.loadAllImport(invoiceImDao.getImports());
        view.loadAllProducts(proDao.getAllProducts(), null);
        view.showView(invoiceImDetailDao.getAllDetails());

        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addCbbCateStateChanged(this::cateBoxStateChanged);
        view.addTableMouseListener(new TableProductMouseListener());
    }

    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new ProductRequest();
            // Declare instance of Validator
            boolean isInsert = true;

            Validator validator = Validator.validate(view.getListElements(isInsert), request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                int totalProducts = proDao.getCountProducts() + 1;
                String productId = String.valueOf(totalProducts);
                //    Products product = view.getProduct(true, productId);
                // records = proDao.insert(product);
            }
            if (records > 0) {
                view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                List<Products> products = new ArrayList<>();
                products = proDao.getAllProducts();
                //view.showView(products);
            } else {
                view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);

            }
        } catch (Exception ex) {
            Logger.getLogger(SuplierController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cateBoxStateChanged(ItemEvent e) {
       Category cate = view.getCateSelected();
               System.out.println(cate.getName());
                      Category cate1 = view.getCateSelected();
               System.out.println(cate1.getName());

    }

    private void btnEditAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new ProductUpdateRequest();
            String id = view.getEditId();
            // Declare instance of Validator
            boolean isInsert = false;

            Validator validator = Validator.validate(view.getListElements(isInsert), request.getRules(), id);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());

            int records = 0;
            if (validator.isPasses() == true) {

                 //   Products product = view.getProduct(false, id);
                //   records = proDao.update(product);
                if (records > 0) {
                    view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    List<Products> products = new ArrayList<>();
                    products = proDao.getAllProducts();
                    //   view.showView(products);
                    view.addTableMouseListener(new TableProductMouseListener());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    

}

private class TableProductMouseListener implements MouseListener {

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
