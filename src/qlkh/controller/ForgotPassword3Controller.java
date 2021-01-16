/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.ForgotPassword3;
import qlkh.SignIn;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class ForgotPassword3Controller {

    private static ForgotPassword3 forgotPass3; //view
    private static UserDaoImpl userModel; //model

    public ForgotPassword3Controller() {
    }

    public ForgotPassword3Controller(ForgotPassword3 view) {
        forgotPass3 = view;
        forgotPass3.addBtnVerify(new BtnChangePassActionListener());

    }

    public void showForgotPassword3() {
        forgotPass3.showView();
    }

    private class BtnChangePassActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (forgotPass3.validateData()) {
                try {
                    Users users = forgotPass3.getUsernameAndEmail();
                    UserDaoImpl userModel = new UserDaoImpl();
                    if (userModel.checkUsernameAndEmail(users)) {
                        forgotPass3.showMessageUsername("MSG_EMPTY");
                        String password = forgotPass3.getPassword();
                        if (userModel.updatePasswordByEmail(password, users.getEmail()) > 0) {
                            forgotPass3.showMessageRePassword("MSG_EMPTY");
                            userModel.UpdateVerifyCode("", users.getEmail());
                            forgotPass3.showMessageVerify("Đổi mật khẩu thành công!");
                            forgotPass3.hideView();
                            Locale myLocale = Utils.getLocale();
                            SignIn signIn = new SignIn(myLocale);
                            SignInController mainController = new SignInController(signIn);
                            mainController.showSignIn();
                        } else {
                            forgotPass3.showMessageRePassword("MSG_EDIT_ERROR");
                        }
                    } else {
                        forgotPass3.showMessageUsername("FORGOT_PASSWORD_3_ERR_USERNAME_NOT_EXISTS");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ForgotPassword3Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
