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
import qlkh.dao.ISuplierDAO;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.entities.Supliers;
import qlkh.entities.Unit;
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
        view.showView();

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
                List<Object> listObject = view.getListElementToValidate();
                // Set return messages
                Validator.setErrorMessages(request.getMessages());

                // Declare List Item to Validate
                List<ValidatorItem> listVals = Validator.setRules(listObject, mapRules);
                // Declare instance of Validator
                Validator validator = new Validator(listVals);
                boolean isFormValid = validator.isPasses();
              
                    Map<String, String> errors = validator.getErrors();
                    view.showErrors(errors);
               
                    for (Object obj : listObject) {
                        System.out.println(Validator.getValue(obj));
                    }
               

            } catch (Exception ex) {
                Logger.getLogger(SuplierController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class BtnEditActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class BtnClearActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearView();

        }

    }

    private class BtnDeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class TableSuplierMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("a");
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
