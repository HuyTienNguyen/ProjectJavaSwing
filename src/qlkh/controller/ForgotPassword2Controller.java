/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import qlkh.ForgotPassword2;
import qlkh.ForgotPassword3;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class ForgotPassword2Controller {

    private static ForgotPassword2 forgotPass2; //view
    private static UserDaoImpl userModel; //model

    public ForgotPassword2Controller() {
    }

    public ForgotPassword2Controller(ForgotPassword2 view) {
        forgotPass2 = view;
        forgotPass2.addBtnVerifyCode(new BtnSendMailActionListener());

    }

    public void showForgotPassword2() {
        forgotPass2.showView();
    }

    private class BtnSendMailActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String numberCode = forgotPass2.getVerifyCode();
            String email = forgotPass2.getAddressEmail();
            if (!numberCode.trim().equals("")) {
                forgotPass2.showMessage(Constants.MSG_EMPTY);
                Users users = new Users();
                UserDaoImpl userModel = new UserDaoImpl();
                if (userModel.getRecordThroughVerifyCode(numberCode, email) > 0) {
                    forgotPass2.showMessageVerify("Xác thực mã nhập thành công!");
                    forgotPass2.hideView();
                    Locale myLocale = Utils.getLocale();
                    ForgotPassword3 forgotPass3 = new ForgotPassword3(myLocale, email);
                    ForgotPassword3Controller forgotPass3Controller = new ForgotPassword3Controller(forgotPass3);
                    forgotPass3Controller.showForgotPassword3();
                } else {
                    forgotPass2.showMessage("FORGOT_PASSWORD2_ERR_NOT_EXISTS");
                }
            } else {
                forgotPass2.showMessage("FORGOT_PASSWORD2_ERR_REQUIRED");
            }
        }

    }
}
