/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.daoimpl.CustomerDaoImpl;
import qlkh.test.HuyTestFrameCustomer;
import qlkh.entities.Customers;
import qlkh.entities.Products;
import qlkh.request.CustomersRequest;
import qlkh.request.IRequest;
import qlkh.utils.Constants;
import qlkh.utils.Validator;

/**
 *
 * @author user
 */
public class CustomerController {

    HuyTestFrameCustomer view;
    CustomerDaoImpl cusDao;

    public CustomerController() {
        view = new HuyTestFrameCustomer();
        cusDao = new CustomerDaoImpl();
    }

    public void showView() {
        if (view == null) {
            view = new HuyTestFrameCustomer();
        }

        List<Customers> customer = cusDao.getAllCustomers();

        view.showView(customer);
        // gọi lên đây
        // đấy có thế thôi, oke anh, vậy để e đọc qua
        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnDeleteAction(this::btnDeleteAction);
        view.addBtnClearAction(this::btnClearAction);
        view.addTableMouseListener(new TableProductMouseListener());
    }

    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new CustomersRequest();
            boolean isInsert = true;
            // Declare instance of Validator

            Validator validator = Validator.validate(
                    view.getListElements(isInsert),
                    request.getRules(), null);
            // Set Error 
            validator.setErrorMessages(request.getMessages());

            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = cusDao.insert(view.getData());
                if (records > 0) {
                    view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.showView(cusDao.getAllCustomers());
                    view.addTableMouseListener(new TableProductMouseListener());
                } else {
                    view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void btnEditAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new CustomersRequest();
            
            // Declare instance of Validator
            String id = view.getEditCustomerId();
            boolean isInsert = false;
            // Declare instance of Validator
            Validator validator = Validator.validate(view.getListElements(isInsert), request.getRules(), id);
            // Set Error 
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());

            int records = 0;
            if (validator.isPasses() == true) {

                Customers customer = view.getData();
               
                records = cusDao.update(customer);
                if (records > 0) {
                    view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.showView(cusDao.getAllCustomers());
                    view.addTableMouseListener(new TableProductMouseListener());
                } else {
                    view.showMessage(Constants.MSG_EDIT_ERROR, Constants.FLAG_ERROR);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void btnDeleteAction(ActionEvent e) {
        int idCustomer = Integer.parseInt(view.getIdCustomer());
        int records = 0;
        records = cusDao.delete(idCustomer);
        if (records > 0) {
            view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
            view.clearView(false);
            view.showView(cusDao.getAllCustomers());
            view.addTableMouseListener(new TableProductMouseListener());
        } else {
            view.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);

        }
    }

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    }

    private class TableProductMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            String customerId = view.getEditCustomerId();

            Customers customer = null;
            if (customerId.equals("") == false && customerId != null) {
                customer = cusDao.getCustomerById(customerId);
            }
            if (customer != null) {
                view.clearView(true);
                view.showUpdateCustomer(customer);
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
