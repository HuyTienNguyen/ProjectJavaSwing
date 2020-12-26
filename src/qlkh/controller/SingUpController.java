/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qlkh.SignUp;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.utils.Constants;

/**
 *
 * @author user
 */
public class SingUpController {
    private static SignUp signUp; //view
    private static UserDaoImpl userModel; //model

    public SingUpController() {
        signUp.addBtnSignUpActionListener(new BtnSignUpActionListener());
    }
    
    private class BtnSignUpActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //lấy dữ liệu từ view
            Users dataSignUp = signUp.getData();
            //check dữ liệu trống  từ view
            if(signUp.checkDataField()){
                
            }
            else{
                signUp.showErrFullname((dataSignUp.getName().trim().equals("")) ? Constants.SIGN_UP_ERR_FULL_NAME_EMPTY : Constants.MSG_EMPTY, Color.red);
                signUp.showErrEmail((dataSignUp.getEmail().trim().equals("")) ? Constants.SIGN_UP_ERR_EMAIL_EMPTY : Constants.MSG_EMPTY, Color.red);
                signUp.showErrUsername((dataSignUp.getUserName().trim().equals("")) ? Constants.SIGN_UP_ERR_USERNAME_EMPTY : Constants.MSG_EMPTY, Color.red);
                signUp.showErrPassword((dataSignUp.getPassword().trim().equals("")) ? Constants.SIGN_UP_ERR_PASSWORD_EMPTY : Constants.MSG_EMPTY, Color.red);
                signUp.showErrRePassword((dataSignUp.getRePassword().trim().equals("")) ? Constants.SIGN_UP_ERR_RE_PASSWORD_EMPTY : Constants.MSG_EMPTY, Color.red);
            }
        }
        
    }
    
    
}
