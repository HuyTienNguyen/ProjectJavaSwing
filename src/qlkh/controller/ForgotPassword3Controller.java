/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qlkh.ForgotPassword3;
import qlkh.daoimpl.UserDaoImpl;

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
//        forgotPass3.addBtnVerifyCode();

    }

    public void showForgotPassword3() {
        forgotPass3.showView();
    }
    private class BtnChangePassActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("okekkkk");
        }
        
    }
}
