/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qlkh.dao.ISuplierDAO;
import qlkh.dao.IUserDAO;
import qlkh.daoimpl.SuplierDaoImpl1;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Supliers;
import qlkh.entities.Users;
import qlkh.request.IRequest;
import qlkh.request.UsersRequest;
import qlkh.views.UsersView;
import qlkh.utils.Constants;
import qlkh.utils.Validator;

/**
 *
 * @author user
 */
public class UsersController {

    UsersView view;
    IUserDAO userDao;
    Supliers editSuplier;

    public UsersController() {
        view = new UsersView();
        userDao = new UserDaoImpl();
        view.addBtnAddAction(this::btnAddAction);
        view.addBtnEditAction(this::btnEditAction);
        view.addBtnClearAction(this::btnClearAction);
      //  view.addBtnDelAction(this::btnDeleteAction);

    }

    public void showView() {
        if (view == null) {
            view = new UsersView();
        }
        view.showView(userDao.getUsers());
        view.addTableMouseListener(new TableMouseListener());
                view.clearView(true);

    }
  public JPanel getContentPage() {
        return view.getContent();
    }
    private void btnAddAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new UsersRequest();
            // Set return messages
            boolean isInSert = true;

            // Declare List Item to Validate
            Validator validator = Validator.validate(view.getElements(isInSert), request.getRules(), null);
            // Declare instance of Validator
            validator.setErrorMessages(request.getMessages());

            // show errors to the view
            view.showErrors(validator.getErrors());
            int records = 0;
            if (validator.isPasses() == true) {
                records = userDao.insert(view.getUsers(isInSert));
            }
            if (records > 0) {
                view.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                view.showView(userDao.getUsers());
                view.clearView(false);
                 view.addTableMouseListener(new TableMouseListener());
            } else {
                view.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnEditAction(ActionEvent e) {
        try {
            // Declare suplier request
            IRequest request = new UsersRequest();
            // Declare instance of Validator
            String id = view.getEditId();
            boolean isInSert = false;
            Validator validator = Validator.validate(view.getElements(isInSert), request.getRules(), id);
            // Declare instance of Validator
            validator.setErrorMessages(request.getMessages());
            // show errors to the view
            view.showErrors(validator.getErrors());
            Map<String,String>error = validator.getErrors();           
            int records = 0;
            if (validator.isPasses() == true) {
                records = userDao.update(view.getUsers(isInSert));
                if (records > 0) {
                    view.showMessage(Constants.MSG_EDIT_SUCCESS, Constants.FLAG_SUCCESS);
                    view.clearView(false);
                    view.showView(userDao.getUsers());
                     view.addTableMouseListener(new TableMouseListener());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void btnClearAction(ActionEvent e) {
        view.clearView(true);

    }

//    private void btnDeleteAction(ActionEvent e) {
//        Users user = view.getUsers(false);
//        if (user != null) {
//            String userName = user.getName();
//
//            int status = suplier.getStatus();
//            int typeIcon = (status == 1) ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
//            String message = (status == 1) ? Constants.MSG_DIALOG_DELETE : Constants.MSG_DIALOG_SHOW;
//            String title = (status == 1) ? Constants.MSG_DIALOG_TITLE : Constants.MSG_DIALOG_TITLE_SHOW;
//
//            int yourChoose = view.showDialog(view, message, title, typeIcon);
//            int records = 0;
//            if (yourChoose == JOptionPane.YES_OPTION) {
//                records = userDao.delete(suplier);
//                if (records > 0) {
//                    view.showMessage(Constants.MSG_DELETE_SUCCESS, Constants.FLAG_SUCCESS);
//                    view.clearView(false);                
//                    view.showView(userDao.getAllSupliers());
//                } else {
//                    view.showMessage(Constants.MSG_DELETE_ERROR, Constants.FLAG_ERROR);
//
//                }
//            }
//        }
//
//    }
    private class TableMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // get Id by row selected on suplier table
            String userId = view.getEditUsersId();
            int id = 0;
            try {
              id=  Integer.parseInt(userId);
            } catch (Exception ex) {
            }
            view.clearError();
            Users user = null;
            if (id >0) {
                user = userDao.getUserById(id);
            }
            if (user != null) {
                view.showUpdateUser(user);
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
