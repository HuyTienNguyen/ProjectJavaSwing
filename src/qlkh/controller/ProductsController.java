/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.ICategoryDAO;
import qlkh.dao.ISuplierDAO;
import qlkh.dao.IUnitDAO;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.daoimpl.UnitDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.Products;
import qlkh.entities.Supliers;
import qlkh.entities.Unit;
import qlkh.entities.ValidatorItem;
import qlkh.request.IRequest;
import qlkh.request.ProductRequest;
import qlkh.request.ProductUpdateRequest;
import qlkh.testView.GiangTestFrameProducts;
import qlkh.utils.Constants;
import qlkh.utils.Validator;

/**
 *
 * @author user
 */
public class ProductsController {

    GiangTestFrameProducts view;
    ProductDaoImpl proDao;
    ICategoryDAO cateDao;
    IUnitDAO unitDao;
    ISuplierDAO suplierDao;
    private static final int MAX_LENGTH_ID = 6;

    public ProductsController() {
        view = new GiangTestFrameProducts();
        proDao = new ProductDaoImpl();
        cateDao = new CategoryDaoImpl();
        unitDao = new UnitDaoImpl();
        suplierDao = new SuplierDaoImpl1();

    }

    public void showView() {
        if (view == null) {
            view = new GiangTestFrameProducts();
        }

        List<Supliers> supliers = suplierDao.getAllSupliers();
        List<Unit> units = unitDao.getAllUnits();
        List<Category> categories = cateDao.getAllCategoies();
        List<Products> products = proDao.getAllProducts();

        view.loadAllUnits(units);
        view.loadAllSupliers(supliers);
        view.loadAllCategories(categories);
        view.showView(products);

        view.addBtnAddActionListener(new BtnAddNewActionListener());
        view.addBtnEditActionListener(new BtnEditActionListener());
        view.addBtnClearActionListener(new BtnClearActionListener());
        view.addTableMouseListener(new TableProductMouseListener());
    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                IRequest request = new ProductRequest();
                // get list rules from suplier request
                Map<String, String> rules = request.getRules();
                // get list element from view
                List<Object> objects = view.getListElements();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listVals = Validator.setRules(objects, rules);
                // Declare instance of Validator
                Validator validator = new Validator(listVals, null);
                // Declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                // Get A list error from request validator
                Map<String, String> errors = validator.getErrors();
                // show errors to the view
                view.showErrors(errors);
                int records = 0;
                if (isFormValid == true) {
                    int totalProducts = proDao.getCountProducts() + 1;
                    String productId = String.valueOf(totalProducts);
                    Products product = view.getProduct(true, productId);
                    records = proDao.insert(product);
                }
                if (records > 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    List<Products> products = new ArrayList<>();
                    products = proDao.getAllProducts();
                    view.showView(products);
                    view.addTableMouseListener(new TableProductMouseListener());
                } else {
                    view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);

                }
            } catch (Exception ex) {
                Logger.getLogger(SuplierController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class BtnEditActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                IRequest request = new ProductUpdateRequest();
                // get list rules from suplier request
                Map<String, String> rules = request.getRules();
                // get list element from view
                List<Object> objects = view.getListElements();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listItem = Validator.setRules(objects, rules);
                // Declare instance of Validator
                String id = view.getEditProductId();
                Validator validator = new Validator(listItem, id);
                // Declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                // Get A list error from request validator
                Map<String, String> errors = validator.getErrors();
                // show errors to the view
                view.showErrors(errors);

                int records = 0;
                if (isFormValid == true) {

                    Products product = view.getProduct(false, id);
                    records = proDao.update(product);
                    if (records > 0) {
                        view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                        view.clearView(false);
                        List<Products> products = new ArrayList<>();
                        products = proDao.getAllProducts();
                        view.showView(products);
                        view.addTableMouseListener(new TableProductMouseListener());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class BtnClearActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearView(true);

        }

    }

    private class TableProductMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            String productId = view.getEditProductId();

            view.clearError();
            Products product = null;
            if (productId.equals("") == false && productId != null) {
                product = proDao.getProductById(productId);
            }
            if (product != null) {
                view.showUpdateProduct(product);
            }
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
