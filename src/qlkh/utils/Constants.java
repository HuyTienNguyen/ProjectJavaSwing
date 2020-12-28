/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils;

import java.awt.Color;

/**
 *
 * @author GIANG
 */
public class Constants {
    
    // Hằng số cho Color message thông báo
    public static final int FLAG_ERROR = 1;
    public static final int FLAG_SUCCESS = 2;
    // Hằng số màu thông báo
    public static final Color COLOR_SUCCESS = new Color(3, 148, 252);
    public static final Color COLOR_ERROR = new Color(237, 56, 28);
    
    // Hằng số cho các trường hợp INSERT, UPDATE, DELETE
    public static final int ACTION_INSERT = 1;
    public static final int ACTION_UPDATE = 2;
    public static final int ACTION_DELETE = 3;
    public static final int ACTION_INSERT_BY_PROC = 4;
    public static final int ACTION_UPDATE_BY_PROC = 5;
    public static final int ACTION_DELETE_BY_PROC = 6;
    // Hằng số thông báo thành công
    public static final String MSG_ADD_SUCCESS = "MSG_ADD_SUCCESS";
    public static final String MSG_ADD_ERROR = "MSG_ADD_ERROR";
    public static final String MSG_UPDATE_SUCCESS = "MSG_UPDATE_SUCCESS";
    public static final String MSG_UPDATE_ERROR = "MSG_UPDATE_ERROR";
    public static final String MSG_DELETE_SUCCESS = "MSG_DELETE_SUCCESS";
    public static final String MSG_DELETE_ERROR = "MSG_DELETE_ERROR";
    //Hằng số title and message dialog
    public static final String MSG_DIALOG_DELETE = "MSG_DIALOG_DELETE";
    public static final String MSG_DIALOG_TITLE = "MSG_DIALOG_TITLE";
    // Hằng số show hide status
    public static final String STATUS_HIDE = "HIDE";
    public static final String STATUS_SHOW = "SHOW";

    // Hằng số cho Class UserDaoImpl

     public static final int ACTION_GET_USER_BY_CODE = 4;
     public static final int ACTION_GET_USER_BY_USERNAME_PASS = 5;

    // SImple format date
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*
     *   Unit Table
     */
    // Header Unit Table
    public static final String[] HEADER_UNIT_TABLE = {"STT", "Unit Name", "Status"};
    public static final String MSG_UNIT_NAME_CANT_BE_EMPTY = "MSG_UNIT_NAME_CANT_BE_EMPTY";

    /*
     *   END Unit Table
     */
    
    /*
     *   SignIn view
     */
    
    public static final String SIGN_IN_ERR_PASS_FIELD = "errPassword";
    public static final String MSG_ERROR_USERNAME_CANT_BE_EMPTY_SIGNIN = "MSG_ERROR_USERNAME_CANT_BE_EMPTY_SIGNIN";
    public static final String MSG_ERROR_PASSWORD_CANT_BE_EMPTY_SIGNIN = "MSG_ERROR_PASSWORD_CANT_BE_EMPTY_SIGNIN";
    public static final String MSG_FAIL_CONNECT_SIGNIN = "MSG_FAIL_CONNECT_SIGNIN";
    public static final String MSG_EMPTY = "MSG_EMPTY";
    /*
     *   SignIn view
     */
    /*
     *   SignUp view
     */
    public static final String SIGN_UP_ERR_FULL_NAME = "SIGN_UP_ERR_FULL_NAME";
    public static final String SIGN_UP_ERR_EMAIL = "SIGN_UP_ERR_EMAIL";
    public static final String SIGN_UP_ERR_USERNAME = "SIGN_UP_ERR_USERNAME";
    public static final String SIGN_UP_ERR_PASSWORD = "SIGN_UP_ERR_PASSWORD";
    public static final String SIGN_UP_ERR_RE_PASSWORD = "SIGN_UP_ERR_RE_PASSWORD";
    
    public static final String SIGN_UP_ERR_FULL_NAME_EMPTY = "SIGN_UP_ERR_FULL_NAME";
    public static final String SIGN_UP_ERR_EMAIL_EMPTY = "SIGN_UP_ERR_EMAIL";
    public static final String SIGN_UP_ERR_USERNAME_EMPTY = "SIGN_UP_ERR_USERNAME";
    public static final String SIGN_UP_ERR_PASSWORD_EMPTY = "SIGN_UP_ERR_PASSWORD";
    public static final String SIGN_UP_ERR_RE_PASSWORD_EMPTY = "SIGN_UP_ERR_RE_PASSWORD";
    /*
     *   SignUp view
     */
}
