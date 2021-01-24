/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.ForgotPassword1;
import qlkh.ForgotPassword2;
import qlkh.ForgotPassword3;
import qlkh.SignIn;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class ForgotPassword1Controller {
    private static ForgotPassword1 forgotPass1; //view
    private static UserDaoImpl userModel; //model
    public ForgotPassword1Controller() {
    }
    public ForgotPassword1Controller(ForgotPassword1 view) {
        forgotPass1 = view;
        view.addBtnSendMailActionListener(new BtnSendMailActionListener());
        view.addGoToBackPage(this::clickBackHome);
        
    }
    public void showSignIn() {
        forgotPass1.showView();
    }
    
    private class BtnSendMailActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String addressEmail = forgotPass1.getAddressEmail();
            if(!addressEmail.trim().equals("")){
                forgotPass1.showMessage(Constants.MSG_EMPTY);
                Users users = new Users();
                users.setEmail(addressEmail);
                UserDaoImpl userModel = new UserDaoImpl();
                if(userModel.checkExistsUserByEmail(addressEmail)){
                    try {
                        String verifyCode = Utils.randomNumber();
                        if(userModel.UpdateVerifyCode(verifyCode, addressEmail) > 0){
                            Utils.sendMail(addressEmail, verifyCode);
                            forgotPass1.showMessageVerify("Chúng tôi đã gửi cho bạn 1 mã xác thực tới địa chỉ Email: " + addressEmail);
                            forgotPass1.hideView();
                            Locale myLocale = Utils.getLocale();
                            ForgotPassword2 forgotPass2 = new ForgotPassword2(myLocale,addressEmail);
                            ForgotPassword2Controller forgotPass2Controller = new ForgotPassword2Controller(forgotPass2);
                            forgotPass2Controller.showForgotPassword2();
                        }
                        else{
                            forgotPass1.showMessageVerify("Hiện tại gửi mã xác nhận bị lôi!");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ForgotPassword1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else{
                    forgotPass1.showMessage("FORGOT_PASSWORD1_ERR_NOT_EXISTS");
                }
            }
            else{
                forgotPass1.showMessage("FORGOT_PASSWORD1_ERR_REQUIRED");
            }
        }
        
    }
    
    private void clickBackHome(ActionEvent e) {
        forgotPass1.hideView();
        SignIn signIn = new SignIn(Utils.getLocale());
        SignInController mainController = new SignInController(signIn);
        mainController.showSignIn();
    }
    
}
