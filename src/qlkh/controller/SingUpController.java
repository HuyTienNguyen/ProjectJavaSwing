/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.SignIn;
import qlkh.SignUp;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.entities.ValidatorItem;
import qlkh.request.SignUpRequest;
import qlkh.utils.Constants;
import qlkh.utils.Utils;
import qlkh.utils.Validator;

/**
 *
 * @author user
 */
public class SingUpController {

    private static SignUp signUp; //view
    private static UserDaoImpl userModel; //model

    public SingUpController() {
    }

    public SingUpController(SignUp view) {
        signUp = view;
        signUp.addBtnSignUpActionListener(new BtnSignUpActionListener());
    }

    public void showSignIn() {

        signUp.showView();

    }

    private class BtnSignUpActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //declare signup request
                SignUpRequest request = new SignUpRequest();
                   boolean isInSert =false;
                Validator validator = Validator.validate(signUp.getListElements(isInSert), request.getRules(), null);
                // Declare instance of Validator
                validator.setErrorMessages(request.getMessages());

                // show errors to the view
                //show errors to the view

                signUp.showErrors(validator.getErrors());


                int records = 0;
                if ( validator.isPasses() == true) {
                    Users users = signUp.getNewUsers();
                    UserDaoImpl userModel = new UserDaoImpl();
                    records = userModel.insert(users);
                    if (records > 0) {
                        signUp.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                        signUp.hideView();
                        Locale myLocale = Utils.getLocale();
                        SignIn signIn = new SignIn(myLocale);
                        SignInController mainController = new SignInController(signIn);
                        mainController.showSignIn();
                    } else {
                        signUp.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(SingUpController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
