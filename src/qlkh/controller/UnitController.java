/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

    GiangTestFrame frame;
    IUnitDAO unitDao;
    Unit editUnit;

    public UnitController() {
        frame = new GiangTestFrame();
        unitDao = new UnitDaoImpl();
        frame.addBtnAddNewUnitActionListener(new BtnAddNewActionListener());
        frame.addBtnEditUnitActionListener(new BtnEditActionListener());
        frame.addBtnClearUnitActionListener(new BtnClearActionListener());
        frame.addTableUnitMouseListener(new TableUnitMouseListener());
        frame.addBtnDeleteUnitActionListener(new BtnDeleteActionListener());

    }

    public void showView() {
        List<Unit> units = new ArrayList<>();
        units = unitDao.getAllUnits();
        if (frame == null) {
            frame = new GiangTestFrame();
        }
        frame.showView(units);

    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String newUnitName = frame.getNewUnitText();
            if (newUnitName != null && newUnitName.equals("") == false) {
                // Khởi tạo 1 instance of Unit
                Unit newUnit = new Unit(newUnitName);
                // In sert data and get result check
                int result = unitDao.insert(newUnit);
                // if result check =0 is not error
                if (result == 0) {
                    List<Unit> units = new ArrayList<>();
                    units = unitDao.getAllUnits();
                    frame.loadAllUnit(units);
                    frame.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    frame.setNewUnitText("");
                } else {
                    // Had error show message
                    frame.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
                    frame.focusTxtUnitField();
                }
            } else {
                frame.showMessage(Constants.MSG_UNIT_NAME_CANT_BE_EMPTY, Constants.FLAG_ERROR);
                frame.focusTxtUnitField();
            }
        }
    }

    private class BtnEditActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = editUnit.getId();
            String newUnitName = frame.getNewUnitText();
            // if new unit name has changed 
            if (editUnit.getName().equals(newUnitName) == false) {
                // check new unit name not null
                if (frame.isNotNull(newUnitName) == true) {
                    int result = unitDao.update(new Unit(id, newUnitName));
                    if (result > 0) {
                        frame.showMessage(Constants.MSG_UPDATE_SUCCESS, Constants.FLAG_SUCCESS);
                        List<Unit> units = unitDao.getAllUnits();
                        frame.showView(units);
                        frame.setNewUnitText("");
                        frame.setEnableBtnAddNew(true);
                        frame.setEnableBtnEdit(false);
                    } else {
                        frame.showMessage(Constants.MSG_UPDATE_ERROR, Constants.FLAG_ERROR);
                    }
                } else {
                    frame.showMessage(Constants.MSG_UNIT_NAME_CANT_BE_EMPTY, Constants.FLAG_ERROR);
                }
            }

        }
    }

    private class BtnClearActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.clearView();

        }

    }

    private class BtnDeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String unitName = frame.getNewUnitText();
            int choose = frame.showDialogMesage(frame, Constants.MSG_DIALOG_DELETE, Constants.MSG_DIALOG_TITLE);
            if (choose == JOptionPane.YES_OPTION) {
                int result = unitDao.delete(editUnit);
                if (result > 0) {
                    frame.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
                    frame.clearView();
                    List<Unit> units = new ArrayList<>();
                    units = unitDao.getAllUnits();
                    frame.showView(units);
                } else {

                    frame.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);
                }

            }

        }

    }

    private class TableUnitMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            editUnit = frame.getEditUnit();
            if (frame.isNotNull(editUnit.getName()) == true) {
                frame.setNewUnitText(editUnit.getName());
                frame.setEnableBtnAddNew(false);
                frame.setEnableBtnEdit(true);
                frame.setEnableBtnDelete(true);
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
