
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qlkh.dao.ISuplierDAO;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.entities.Supliers;
import qlkh.request.IRequest;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.request.SuplierRequest;
import qlkh.request.SuplierUpdateRequest;
import qlkh.views.SuplierView;

/**
 *
 * @author user
 */
public class SuplierController {

    SuplierView view;
    ISuplierDAO suplierDao;
    Supliers editSuplier;

    public SuplierController() {
        view = new SuplierView();
        suplierDao = new SuplierDaoImpl1();
        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addBtnDeleteAction(this::btnDelAction);
        view.addTableMouseListener(new TableSuplierMouseListener());

    }

    public void showView() {
        if (view == null) {
            view = new SuplierView();
        }
        view.showView(suplierDao.getAllSupliers());
        view.clearView(true);

    }
  public JPanel getContentPage() {
        return view.getContent();
    }
    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new SuplierRequest();
            // Set return messages
            boolean isInSert = false;

            // Declare List Item to Validate
            Validator validator = Validator.validate(view.getElements(isInSert), request.getRules(), null);
            // Declare instance of Validator
            validator.setErrorMessages(request.getMessages());

            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = suplierDao.insert(view.getSuplier());
            }
            if (records > 0) {
                view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);          
                view.showView(suplierDao.getAllSupliers());
            } else {
                view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);

            }
        } catch (Exception ex) {
            Logger.getLogger(SuplierController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnEditAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new SuplierUpdateRequest();
            // Declare instance of Validator
            String id = view.getEditId();
            boolean isInSert = false;
            Validator validator = Validator.validate(view.getElements(isInSert), request.getRules(), id);
            // Declare instance of Validator
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = suplierDao.update(view.getSuplier());
                if (records > 0) {
                    view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.showView(suplierDao.getAllSupliers());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    }

    private void btnDelAction(ActionEvent e) {
        Supliers suplier = view.getSuplier();
        if (suplier != null) {
            String suplierName = suplier.getName();

            int status = suplier.getStatus();
            int typeIcon = (status == 1) ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
            String message = (status == 1) ? Constants.MSG_DIALOG_DELETE : Constants.MSG_DIALOG_SHOW;
            String title = (status == 1) ? Constants.MSG_DIALOG_TITLE : Constants.MSG_DIALOG_TITLE_SHOW;

            int records = 0;
                records = suplierDao.delete(suplier);
                if (records > 0) {
                    view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);                
                    view.showView(suplierDao.getAllSupliers());
                } else {
                    view.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);

                }
        }

    }

    private class TableSuplierMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            int suplierId = view.getEditSuplierId();
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
}
