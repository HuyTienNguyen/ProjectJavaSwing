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
import javax.swing.JOptionPane;
import qlkh.dao.ISuplierDAO;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.entities.Supliers;
import qlkh.entities.Unit;
import qlkh.testView.GiangTestFrameSupplier;
import qlkh.utils.Constants;

/**
 *
 * @author user
 */
public class SuplierController {

    GiangTestFrameSupplier frame;
    ISuplierDAO suplierDao;
    Supliers editSuplier;

    public SuplierController() {
        frame = new GiangTestFrameSupplier();
        suplierDao = new SuplierDaoImpl1();
        frame.addBtnAddNewUnitActionListener(new BtnAddNewActionListener());
        frame.addBtnEditUnitActionListener(new BtnEditActionListener());
        frame.addBtnClearUnitActionListener(new BtnClearActionListener());
        frame.addTableUnitMouseListener(new TableSuplierMouseListener());
        frame.addBtnDeleteUnitActionListener(new BtnDeleteActionListener());
    }

    public void showView() {
        if (frame == null) {
            frame = new GiangTestFrameSupplier();
        }
        List<Supliers> listSup = suplierDao.getAllSupliers();
        frame.showView();

    }

    private class BtnAddNewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

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
            frame.clearView();

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
