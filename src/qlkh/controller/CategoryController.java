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
import qlkh.entities.ValidatorItem;
import qlkh.request.CategoryRequest;
import qlkh.request.CategoryUpdateRequest;
import qlkh.request.IRequest;
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

        initListeners();
    }

    private void initListeners() {
        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addBtnDeleteAction(this::btnDelteAction);
        view.addTableMouseListener(new TableCategoryMouseListener());
    }

    public void showView() {
        if (view == null) {
            view = new GiangTestFrameCategory();
        }
        List<Category> categories = cateDao.getAllCategoies();
        view.showView(categories);

    }

    private void btnAddAction(ActionEvent e) {

        try {
            // Declare suplier request
            IRequest request = new CategoryRequest();

            // Declare instance of Validator
            boolean isInsert = true;
            Validator validator = Validator.validate(view.getListElements(isInsert), request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());

            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                Category cate = view.getCategory();
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

    private void btnEditAction(ActionEvent e) {

        try {
            // Declare suplier request
            IRequest request = new CategoryUpdateRequest();

            String id = view.getEditId();
            boolean isInsert = false;
            // Declare instance of Validator
            Validator validator = Validator.validate(view.getListElements(isInsert), request.getRules(), id);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                Category cate = view.getCategory();
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

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    }

    private void btnDelteAction(ActionEvent e) {
        Category cate = view.getCategory();
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

    private class TableCategoryMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            int cateId = view.getEditCategoryId();
            view.clearError();
            Category cate = null;
            if (cateId > 0) {
                cate = cateDao.getCateById(cateId);
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
