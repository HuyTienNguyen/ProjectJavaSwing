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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.SignUp;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.entities.ValidatorItem;
import qlkh.request.SignUpRequest;
import qlkh.utils.Constants;
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
    
    private class BtnSignUpActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //declare signup request
                SignUpRequest request = new SignUpRequest();
                //get list rules from signup request
                Map<String,String> rules = request.getRules();
                //get list element from view
                List<Object> listValueOfForm = signUp.getListElements();
                //set return messages
                Validator.setErrorMessages(request.getMessages());
                
                //declare list item to validate
                List<ValidatorItem> listVals = Validator.setRules(listValueOfForm, rules);
                //declare instance of validator
                Validator validator = new Validator(listVals,null);
                //declare a boolean validate form
                boolean isFormValid = validator.isPasses();
                //Get a list error from request validator
                Map<String,String> errors = validator.getErrors();
                //show errors to the view
                signUp.showErrors(errors);
                int records = 0;
                if(isFormValid == true){
                    Users users = signUp.getNewUsers();
                    records = userModel.insert(users);
                    
                    if(records > 0){
                        signUp.showMessage(Constants.MSG_ADD_SUCCESS, Constants.FLAG_SUCCESS);
                        
                    }
                    else{
                        signUp.showMessage(Constants.MSG_ADD_ERROR, Constants.FLAG_ERROR);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(SingUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
}
