/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import qlkh.SignIn;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;

/**
 *
 * @author user
 */
public class SignInController {

    private static SignIn signIn; // view
    private static UserDaoImpl userModel; //model

    public SignInController() {
    }

    public SignInController(SignIn view) {
        //Khởi tạo thực thể SignIn khi LoginController được khởi tạo
        signIn = view;
        signIn.addBtnSignInActionListener(new BtnSignInActionListener());

    }


    public void showSignIn() {
        signIn.showView();
    }

    private class BtnSignInActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //check dữ liệu trống từ view
            if (signIn.checkDataField()) {
                signIn.showErrUserName("", Color.red);
                //lấy dữ liệu từ bên  view về
                Users userLogin = signIn.getUserLogin();
                UserDaoImpl userModel = new UserDaoImpl();
                //nếu tài khoản hợp lệ thì cho đi tiếp còn thì thông báo lỗi sai
                if (userModel.checkUser(userLogin) == true) {
                    JOptionPane.showMessageDialog(signIn,"Dang nhap thanh cong");
                } else {
                    signIn.showErrPassword("Ten dang nhap hoac tai khoan khong chinh xac", Color.RED);
                }
            } else {
                if(signIn.getUserLogin().getUserName().trim().equals("")){
                    signIn.showErrUserName("Username không được để trống", Color.red);
                }else{
                    signIn.showErrUserName("", Color.red);
                }
                
                if(signIn.getUserLogin().getPassword().trim().equals("")){
                    signIn.showErrPassword("Password không được để trống", Color.red);
                }
                else{
                    signIn.showErrPassword("", Color.red);
                }
                
            }
        }

    }
}
