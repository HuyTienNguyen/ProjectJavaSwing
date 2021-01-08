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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
import qlkh.request.SuplierRequest;
import qlkh.request.UpdateSuplierRequest;
import qlkh.testView.GiangTestFrameProducts;
import qlkh.testView.GiangTestFrameSupplier;
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

    Object obj;

    public ProductsController() {
        view = new GiangTestFrameProducts();
        proDao = new ProductDaoImpl();
        cateDao = new CategoryDaoImpl();
        unitDao = new UnitDaoImpl();
        suplierDao = new SuplierDaoImpl1();
        view.addBtnAddActionListener(new BtnAddNewActionListener());
        view.addBtnEditActionListener(new BtnEditActionListener());
        view.addBtnClearActionListener(new BtnClearActionListener());
        view.addBtnDeleteActionListener(new BtnDeleteActionListener());
        view.addTableMouseListener(new TableSuplierMouseListener());
        view.addComboboxStateChangedListener(new CBBUnitItemListener());

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
    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                SuplierRequest request = new SuplierRequest();
                // get list rules from suplier request
                Map<String, String> rules = request.getRules();
                // get list element from view
                List<Object> listValueOfForm = view.getListElements();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listVals = Validator.setRules(listValueOfForm, rules);
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
                    Supliers suplier = view.getNewSuplier();
                    records = suplierDao.insert(suplier);
                }
                if (records > 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    List<Products> objects = new ArrayList<>();
                    objects = proDao.getAllProducts();
                    view.showView(objects);
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
                UpdateSuplierRequest request = new UpdateSuplierRequest();
                // get list rules from suplier request
                Map<String, String> rules = request.getRules();
                // get list element from view
                List<Object> listElements = view.getListElements();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listItem = Validator.setRules(listElements, rules);
                // Declare instance of Validator
                String id = view.getEditId();
                Validator validator = new Validator(listItem, id);
                // Declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                // Get A list error from request validator
                Map<String, String> errors = validator.getErrors();
                // show errors to the view
                view.showErrors(errors);
                int records = 0;
                if (isFormValid == true) {
                    Supliers suplier = view.getEditSuplier();
                    records = suplierDao.update(suplier);
                    if (records > 0) {
                        view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                        view.clearView(false);
                        List<Products> products = new ArrayList<>();
                        products = proDao.getAllProducts();
                        view.showView(products);
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

    private class BtnDeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Supliers suplier = view.getEditSuplier();
            if (suplier != null) {
                String suplierName = suplier.getName();

                int status = suplier.getStatus();
                int typeIcon = (status == 1) ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
                String message = (status == 1) ? Constants.MSG_DIALOG_DELETE : Constants.MSG_DIALOG_SHOW;
                String title = (status == 1) ? Constants.MSG_DIALOG_TITLE : Constants.MSG_DIALOG_TITLE_SHOW;

                int yourChoose = view.showDialog(view, message, title, typeIcon);
                int records = 0;
                if (yourChoose == JOptionPane.YES_OPTION) {
                    records = suplierDao.delete(suplier);
                    if (records > 0) {
                        view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                        view.clearView(false);
                        List<Products> products = new ArrayList<>();
                        products = proDao.getAllProducts();
                        view.showView(products);
                    } else {
                        view.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);

                    }
                }
            }
        }
    }

    private class TableSuplierMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            int suplierId = 1;
            view.clearError();
            Supliers suplier = null;
            if (suplierId > 0) {
                suplier = suplierDao.getSuplierById(suplierId);
            }
            if (suplier != null) {
                view.showEditSuplier(suplier);
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
    private  class CBBUnitItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(view.getUnitID());
        }
    }


    

}
