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
import javax.swing.JOptionPane;
import qlkh.dao.ICategoryDAO;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.entities.Category;
import qlkh.entities.Supliers;
import qlkh.entities.ValidatorItem;
import qlkh.request.CategoryRequest;
import qlkh.request.CategoryUpdateRequest;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.testView.GiangTestFrameCategory;

/**
 *
 * @author user
 */
public class CategoryController {

    GiangTestFrameCategory view;
    ICategoryDAO cateDao;
    Category editCate;

    public CategoryController() {
        view = new GiangTestFrameCategory();
        cateDao = new CategoryDaoImpl();
        view.addBtnAddActionListener(new BtnAddNewActionListener());
        view.addBtnEditActionListener(new BtnEditActionListener());
        view.addBtnClearActionListener(new BtnClearActionListener());
        view.addBtnDeleteActionListener(new BtnDeleteActionListener());
        view.addTableMouseListener(new TableSuplierMouseListener());

    }

    public void showView() {
        if (view == null) {
            view = new GiangTestFrameCategory();
        }
        List<Category> categories = cateDao.getAllCategoies();
        view.showView(categories);

    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                CategoryRequest request = new CategoryRequest();
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
                    Category cate = view.getNewCategory();
                    records = cateDao.insert(cate);
                }
                if (records > 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    List<Category> cates = new ArrayList<>();
                    cates = cateDao.getAllCategoies();
                    view.showView(cates);
                } else {
                    view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);

                }
            } catch (Exception ex) {
                Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class BtnEditActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                CategoryUpdateRequest request = new CategoryUpdateRequest();
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
                    Category cate = view.getEditCategory();
                    records = cateDao.update(cate);
                    if (records > 0) {
                        view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                        view.clearView(false);
                        List<Category> cates = new ArrayList<>();
                        cates = cateDao.getAllCategoies();
                        view.showView(cates);
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
            Category cate = view.getEditCategory();
        

            int status = cate.getStatus();
            int typeIcon = (status == 1) ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
            String message = (status == 1) ? Constants.MSG_DIALOG_DELETE : Constants.MSG_DIALOG_SHOW;
            String title = (status == 1) ? Constants.MSG_DIALOG_TITLE : Constants.MSG_DIALOG_TITLE_SHOW;

            int yourChoose = view.showDialog(view, message, title, typeIcon);
            int records = 0;
            if (cate != null) {               
                records = cateDao.delete(cate);
                if (records > 0) {
                    view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    List<Category> cates = new ArrayList<>();
                    cates = cateDao.getAllCategoies();
                    view.showView(cates);
                }
            }
        }
    }

    private class TableSuplierMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            int suplierId = view.getEditCategoryId();
            view.clearError();
            Category cate = null;
            if (suplierId > 0) {
                cate = cateDao.getCateById(suplierId);
            }
            if (cate != null) {
                view.showEditCategory(cate);
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
