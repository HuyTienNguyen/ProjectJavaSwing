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
import javax.swing.JOptionPane;
import qlkh.dao.IUnitDAO;
import qlkh.daoimpl.UnitDaoImpl;
import qlkh.entities.Unit;
import qlkh.testView.GiangTestFrame;
import qlkh.utils.Constants;

/**
 *
 * @author user
 */
public class UnitController {

    GiangTestFrame view;
    IUnitDAO unitDao;
    Unit editUnit;

    public UnitController() {
        view = new GiangTestFrame();
        unitDao = new UnitDaoImpl();
        initListeners();

    }

    private void initListeners() {
        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addBtnDeleteAction(this::btnDeleteAction);
        view.addTableUnitMouseListener(new TableUnitMouseListener());
    }

    public void showView() {
        List<Unit> units = new ArrayList<>();
        units = unitDao.getAllUnits();
        if (view == null) {
            view = new GiangTestFrame();
        }
        view.showView(units);

    }

    private void btnAddAction(ActionEvent e) {
        String newUnitName = view.getNewUnitText();
        if (newUnitName != null && newUnitName.equals("") == false) {
            // Khởi tạo 1 instance of Unit
            Unit newUnit = new Unit(newUnitName);
            // In sert data and get result check
            int result = unitDao.insert(newUnit);
            // if result check =0 is not error
            if (result == 0) {
                List<Unit> units = new ArrayList<>();
                units = unitDao.getAllUnits();
                view.loadAllUnit(units);
                view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                view.setNewUnitText("");
            } else {
                // Had error show message
                view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
                view.focusTxtUnitField();
            }
        } else {
            view.showMessage(Constants.MSG_UNIT_NAME_CANT_BE_EMPTY, Constants.FLAG_ERROR);
            view.focusTxtUnitField();
        }

    }

    private void btnEditAction(ActionEvent e) {

        int id = editUnit.getId();
        String newUnitName = view.getNewUnitText();
        // if new unit name has changed 
        if (editUnit.getName().equals(newUnitName) == false) {
            // check new unit name not null
            if (view.isNotNull(newUnitName) == true) {
                int result = unitDao.update(new Unit(id, newUnitName));
                if (result > 0) {
                    view.showMessage(Constants.MSG_UPDATE_SUCCESS, Constants.FLAG_SUCCESS);
                    List<Unit> units = unitDao.getAllUnits();
                    view.showView(units);
                    view.setNewUnitText("");
                    view.setEnableBtnAddNew(true);
                    view.setEnableBtnEdit(false);
                } else {
                    view.showMessage(Constants.MSG_UPDATE_ERROR, Constants.FLAG_ERROR);
                }
            } else {
                view.showMessage(Constants.MSG_UNIT_NAME_CANT_BE_EMPTY, Constants.FLAG_ERROR);
            }
        }
    }

    private void btnClearAction(ActionEvent a) {
        view.clearView();

    }

    private void btnDeleteAction(ActionEvent a) {
        String unitName = view.getNewUnitText();
        int status = editUnit.getStatus();
        int typeIcon = (status == 1) ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
        String message = (status == 1) ? Constants.MSG_DIALOG_DELETE : Constants.MSG_DIALOG_SHOW;
        String title = (status == 1) ? Constants.MSG_DIALOG_TITLE : Constants.MSG_DIALOG_TITLE_SHOW;
        int choose = view.showDialog(view, message, title, typeIcon);
        if (editUnit != null) {
            if (choose == JOptionPane.YES_OPTION) {
                int result = unitDao.delete(editUnit);
                if (result > 0) {
                    view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView();
                    List<Unit> units = new ArrayList<>();
                    units = unitDao.getAllUnits();
                    view.showView(units);
                } else {
                    view.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);
                }
            }
        }
    }

    private class TableUnitMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            editUnit = view.getEditUnit();
            if (view.isNotNull(editUnit.getName()) == true) {
                view.setNewUnitText(editUnit.getName());
                view.setEnableBtnAddNew(false);
                view.setEnableBtnEdit(true);
                view.setEnableBtnDelete(true);
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
