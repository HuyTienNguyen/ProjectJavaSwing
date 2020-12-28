/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;


import qlkh.ForgotPassword1;
import qlkh.FotgotPassword3;
import qlkh.daoimpl.UserDaoImpl;

/**
 *
 * @author user
 */
public class ForgotPassword1Controller {
    private static ForgotPassword1 forgotPass; //view
    private static UserDaoImpl userModel; //model
    public ForgotPassword1Controller() {
    }
    public ForgotPassword1Controller(ForgotPassword1 view) {
        forgotPass = view;
        
    }
    public void showSignIn() {
        forgotPass.showView();
    }
    
}
