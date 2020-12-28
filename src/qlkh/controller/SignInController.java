/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import qlkh.App;
import qlkh.ForgotPassword1;
import qlkh.SignIn;
import qlkh.SignUp;
import qlkh.daoimpl.UserDaoImpl;
import qlkh.entities.Users;
import qlkh.utils.Constants;
import qlkh.utils.Utils;

/**
 *
 * @author user
 */
public class SignInController {

    private static SignIn signIn; // view
    private static UserDaoImpl userModel; //model
    //This will be the file where the username and password will be saved
    File file = new File(System.getProperty("user.home") + "/Desktop/save.txt");

    public SignInController() {
    }

    public SignInController(SignIn view) {
        //Khởi tạo thực thể SignIn khi LoginController được khởi tạo
        signIn = view;
        signIn.addBtnSignInActionListener(new BtnSignInActionListener());
        signIn.addBtnSignUpActionListener(new BtnSignUpActionListener());
        signIn.addCheckBoxRemeberPassword(new CheckBoxRemeberPassword());
        signIn.addMyLocaleStateChanged(new MyLocaleStateChanged());
        signIn.addBtnForgotPassActionListener(new BtnForgotPasswordActionListener());
        UPDATE();

    }

    public void showSignIn() {
        signIn.showView();
    }

    public void SAVE(Boolean check) {      //Save the UserName and Password (for one user)
        try {
            if (check) {
                if (!file.exists()) {
                    file.createNewFile();  //if the file !exist create a new one
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                Users users = signIn.getUserLogin();
                bw.write(users.getUserName()); //write the name
                bw.newLine(); //leave a new Line
                bw.write(users.getPassword()); //write the password
                bw.close(); //close the BufferdWriter
            } else {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void UPDATE() { //UPDATE ON OPENING THE APPLICATION

        try {
            if (file.exists()) {    //if this file exists

                Scanner scan = new Scanner(file);   //Use Scanner to read the File
                signIn.setValueCheckboxRememberPassword(Boolean.TRUE);
                signIn.setValueUsernameAndPass(scan.nextLine(), scan.nextLine());//set text cho username password
                scan.close();
            } else {
                signIn.setValueCheckboxRememberPassword(Boolean.FALSE);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }//End OF UPDATE

    /*
     --hàm sự kiện signIn để đăng nhập
     */
    private class BtnSignInActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //lấy dữ liệu từ view về
            Users dataSignIn = signIn.getUserLogin();
            //check dữ liệu trống từ view
            if (signIn.checkDataField()) {
                signIn.showErrUserName(Constants.MSG_EMPTY, Color.red);
                //tạo model để lấy dữ liệu từ db
                UserDaoImpl userModel = new UserDaoImpl();
                //nếu tài khoản hợp lệ thì cho đi tiếp còn thì thông báo lỗi sai
                if (userModel.checkUser(dataSignIn) == true) {
                    JOptionPane.showMessageDialog(signIn, "Dang nhap thanh cong");
                } else {
                    signIn.showErrPassword(Constants.MSG_FAIL_CONNECT_SIGNIN, Color.RED);
                }
            } else {

                if (dataSignIn.getUserName().trim().equals("")) {
                    signIn.showErrUserName(Constants.MSG_ERROR_USERNAME_CANT_BE_EMPTY_SIGNIN, Color.red);
                } else {
                    signIn.showErrUserName(Constants.MSG_EMPTY, Color.red);
                }

                if (dataSignIn.getPassword().trim().equals("")) {
                    signIn.showErrPassword(Constants.MSG_ERROR_PASSWORD_CANT_BE_EMPTY_SIGNIN, Color.red);
                } else {
                    signIn.showErrPassword(Constants.MSG_EMPTY, Color.red);
                }

            }
        }
    }
    /*
     --hàm chuyển view sang signUp
     */

    private class BtnSignUpActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Locale newLocale = Utils.getLocale();
            SignUp singUp = new SignUp(newLocale);
            SingUpController signUpController = new SingUpController(singUp);
            signUpController.showSignIn();
            signIn.setVisible(false);
        }

    }

    /*
     --hàm sự kiện để lấy value trong combox để thay đổi ngôn ngữ
     */
    private class MyLocaleStateChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String y = signIn.getMyLocaleInCombobox();
            //setLocale theo combobox
            Utils.setLocale(y);

            // getLocale
            Locale newLocale = Utils.getLocale();
            signIn.dispose();
            SignIn newSignIn = new SignIn(newLocale);
            SignInController newSignInController = new SignInController(newSignIn);
            newSignInController.showSignIn();

        }
    }

    /*
     -- hàm sự kiện nhớ mật khẩu
     */
    private class CheckBoxRemeberPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (signIn.getValueCheckBoxRememberPassword()) {
                SAVE(Boolean.TRUE);
            } else {
                SAVE(Boolean.FALSE);
            }
        }

    }
    /*
     --hàm thêm sự kiện button quên mật khẩu
     */

    private class BtnForgotPasswordActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Locale newLocale = Utils.getLocale();
            ForgotPassword1 forgotPass = new ForgotPassword1(newLocale);
            ForgotPassword1Controller forgotPass1Controller = new ForgotPassword1Controller(forgotPass);
            forgotPass1Controller.showSignIn();
            signIn.setVisible(false);
        }

    }

}
