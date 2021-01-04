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
import qlkh.dao.ISuplierDAO;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.entities.Supliers;
import qlkh.entities.ValidatorItem;
import qlkh.testView.GiangTestFrameSupplier;
import qlkh.utils.Constants;
import qlkh.utils.Validator;
import qlkh.request.SuplierRequest;

/**
 *
 * @author user
 */
public class SuplierController {

    GiangTestFrameSupplier view;
    ISuplierDAO suplierDao;
    Supliers editSuplier;

    public SuplierController() {
        view = new GiangTestFrameSupplier();
        suplierDao = new SuplierDaoImpl1();
        view.addBtnAddActionListener(new BtnAddNewActionListener());
        view.addBtnEditActionListener(new BtnEditActionListener());
        view.addBtnClearActionListener(new BtnClearActionListener());
        view.addBtnDeleteActionListener(new BtnDeleteActionListener());
        view.addTableMouseListener(new TableSuplierMouseListener());

    }

    public void showView() {
        if (view == null) {
            view = new GiangTestFrameSupplier();
        }
        List<Supliers> listSup = suplierDao.getAllSupliers();
        view.showView(listSup);

    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Declare suplier request
                SuplierRequest request = new SuplierRequest();
                // get list rules from suplier request
                Map<String, String> mapRules = request.getRules();
                // get list element from view
                List<Object> listValueOfForm = view.getListElementToValidate();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listVals = Validator.setRules(listValueOfForm, mapRules);
                // Declare instance of Validator
                Validator validator = new Validator(listVals);
                // Declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                // Get A list error from request validator
                Map<String, String> errors = validator.getErrors();
                // show errors to the view
                view.showErrors(errors);
                int recordNumber = 0;
                if (isFormValid == true) {
                    Supliers suplier = view.getNewSuplier();
                    recordNumber = suplierDao.insert(suplier);
                }
                if (recordNumber > 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    List<Supliers> list = new ArrayList<>();
                    list = suplierDao.getAllSupliers();
                    view.showView(list);
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
                SuplierRequest request = new SuplierRequest();
                // get list rules from suplier request
                Map<String, String> mapRules = request.getRules();
                // get list element from view
                List<Object> listValueOfForm = view.getListElementToValidate();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());
                
                // Declare List Item to Validate
                List<ValidatorItem> listVals = Validator.setRules(listValueOfForm, mapRules);
                // Declare instance of Validator
                Validator validator = new Validator(listVals);
                // Declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                // Get A list error from request validator
                Map<String, String> errors = validator.getErrors();
                // show errors to the view
                view.showErrors(errors);
                int recordNumber = 0;
                if (isFormValid == true) {
                    Supliers suplier = view.getEditSuplier();                 
                    recordNumber = suplierDao.update(suplier);
                    if (recordNumber > 0) {
                        view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                        view.clearView(false);
                        List<Supliers> list = new ArrayList<>();
                        list = suplierDao.getAllSupliers();
                        view.showView(list);
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
            int recordNumber = 0;
            recordNumber = suplierDao.delete(suplier);
            if (recordNumber > 0) {
                view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                view.clearView(false);
                List<Supliers> list = new ArrayList<>();
                list = suplierDao.getAllSupliers();
                view.showView(list);
            }
        }
    }

    private class TableSuplierMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            int suplierId = view.getEditSuplierId();

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
