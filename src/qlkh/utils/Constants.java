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
}
