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
    public static final int ACTION_SELECT_BY_PROC = 7;

   
    // Hằng số thông báo thành công
    public static final String MSG_ADD_SUCCESS = "MSG_ADD_SUCCESS";
    public static final String MSG_ADD_ERROR = "MSG_ADD_ERROR";
    public static final String MSG_EDIT_SUCCESS = "MSG_EDIT_SUCCESS";
    public static final String MSG_EDIT_ERROR = "MSG_EDIT_ERROR";

    public static final String MSG_UPDATE_SUCCESS = "MSG_UPDATE_SUCCESS";
    public static final String MSG_UPDATE_ERROR = "MSG_UPDATE_ERROR";
    public static final String MSG_DELETE_SUCCESS = "MSG_DELETE_SUCCESS";
    public static final String MSG_DELETE_ERROR = "MSG_DELETE_ERROR";
    //Hằng số title and message dialog
    public static final String MSG_DIALOG_DELETE = "MSG_DIALOG_DELETE";
    public static final String MSG_DIALOG_TITLE = "MSG_DIALOG_TITLE";
    public static final String MSG_DIALOG_SHOW = "MSG_DIALOG_SHOW";
    public static final String MSG_DIALOG_TITLE_SHOW = "MSG_DIALOG_TITLE_SHOW";
    // Hằng số show hide status
    public static final String STATUS_HIDE = "HIDE";
    public static final String STATUS_SHOW = "SHOW";

    // Hằng số cho Class UserDaoImpl
    public static final int ACTION_GET_USER_BY_CODE = 8;
    public static final int ACTION_GET_USER_BY_USERNAME_PASS = 9;
    public static final int ACTION_GET_USER_BY_EMAIL = 10;
    public static final int ACTION_SELECT_USERNAME_AND_EMAIL = 11;
    public static final int ACTION_GET_ID_USER = 12;
    // SImple format date
    public static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
    public static final String DATE_FORMAT_WITH_HOUR = "dd-MM-yyyy";

    //
    public static final String PLEASE_CHOOSE_ONE = "PLEASE_CHOOSE_ONE";
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
     *   Suplier Table
     */
    // Header Suplier Table
    public static final String[] HEADER_SUPLIER_TABLE = {"Id", "Name", "Phone", "Address", "Email", "Info", "ContractDate", "Character", "Status"};
    public static final String MSG_SUPLIER_NAME_CANT_BE_EMPTY = "MSG_UNIT_NAME_CANT_BE_EMPTY";

    /*
     *   END Suplier Table
     */
    // Header Products Table
    public static final String[] HEADER_PRODUCT_TABLE = {"Id", "Name", "Suplier", "Category", "Unit", "Price", "Tax"};
    public static final String MSG_PRODUCT_NAME_CANT_BE_EMPTY = "MSG_UNIT_NAME_CANT_BE_EMPTY";

// Header Report Table1
    public static final String[] HEADER_REPORT_TABLE1 = {"Id", "Name", "Suplier", "Category", "Unit"};

    public static final String[] HEADER_REPORT_TABLE2 = {"Id", "Name", "Suplier", "Category", "Unit"};
    public static final String[] HEADER_REPORT_TABLE3 = {"Id", "Name", "Suplier", "Category", "Unit"};


    /*
     *   END Suplier Table
     /*
     *   Category Table
     */
    // Header Suplier Table
    public static final String[] HEADER_CATEGORY_TABLE = {"Id", "Name", "Character", "Status"};
    public static final String MSG_CATEGORY_NAME_CANT_BE_EMPTY = "MSG_UNIT_NAME_CANT_BE_EMPTY";

    /*
     *   END Category Table
     */
    /*
     *   Customers Table
     */
    // Header Customers Table
    public static final String[] HEADER_CUSTOMERS_TABLE = {"Id", "Name", "Address", "Phone", "Email", "MoreInfo", "ContractDate"};
    public static final String MSG_CUSTOMERS_NAME_CANT_BE_EMPTY = "MSG_UNIT_NAME_CANT_BE_EMPTY";

    /*
     *   END Customers Table
     */
    // Header InvoiceImportDetail Table
    public static final String[] HEADER_IMPORT_DETAIL_TABLE = {"Id", "Product Name", "Number", "Input Price", "OutputPrice", "Date"};

    /*
     *   END Suplier Table
     /*
    
     /*
     *   Export Detail
     /*/
    public static final String[] HEADER_EXPORT_DETAIL_TABLE = {"Id", "Id InvoiceExport", "Name Customer", "Product Name", "Counts", "Money", "Name User", "Date Output"};

    /*
     *   Export Detail
     /*
    
    
    
     */
    /*
     *   Customers Table
     */
    // Header Customers Table
    public static final String[] HEADER_USER_TABLE = {"Id", "Name", "User Name", "Email"};

    /*
     *   END Customers Table
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

    public static final String QUERY_CHECK_UNIQUE_CONSTANTS = "SELECT * FROM table where field =?";
    public static final String QUERY_CHECK_UNIQUE_CONSTANTS_WHEN_UPDATE = "SELECT * FROM table where field = ? and id not like ?";
    public static final String QUERY_CHECK_DATA_TYPE_FIELD_NAME = "SELECT field FROM table";
    public static final String QUERY_CHECK_EXISTS_ID_FOREIGN_KEY = "SELECT * FROM table where field = ?";


    /*
     * invoiceexportdetail
     */
    public static final String MSG_NO_QUALITY = "MSG_NO_QUALITY";
    public static final String MSG_ERROR_LOGIC = "MSG_ERROR_LOGIC";

    /*
     *end invoiceexportdetail
     */
}
