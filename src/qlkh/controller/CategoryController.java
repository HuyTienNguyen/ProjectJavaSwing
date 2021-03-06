/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qlkh.dao.ICategoryDAO;
import qlkh.daoimpl.CategoryDaoImpl;
import qlkh.entities.Category;
import qlkh.request.CategoryRequest;
import qlkh.request.CategoryUpdateRequest;
import qlkh.request.IRequest;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.views.CategoryView;

/**
 *
 * @author user
 */
public class CategoryController {

    CategoryView view;
    ICategoryDAO cateDao;
    Category editCate;

    public CategoryController() {
        view = new CategoryView();
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
            view = new CategoryView();
        }
        view.showView( cateDao.getCategoies());
        view.clearView(true);
    }
      public JPanel getContentPage() {
        return view.getContent();
    }
    private void btnAddAction(ActionEvent e) {

        try {
            // Declare suplier request
            IRequest request = new CategoryRequest();

            // Declare instance of Validator
            boolean isInsert = true;
            Validator validator = Validator.validate(view.getElements(isInsert), request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());

            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = cateDao.insert(view.getCategory());
            }
            if (records > 0) {
                view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);          
                view.showView(cateDao.getCategoies());
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
            Validator validator = Validator.validate(view.getElements(isInsert), request.getRules(), id);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = cateDao.update(view.getCategory());
                if (records > 0) {
                    view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
;
                    view.showView(cateDao.getCategoies());
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


        int records = 0;
        if (cate != null) {
            records = cateDao.delete(cate);
            if (records > 0) {
                view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                view.clearView(false);

                view.showView(cateDao.getCategoies());

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
