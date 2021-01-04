/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author user
 */
public class testLocale {

    /**
     * @param args the command line arguments
     */
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhoHang";
    private static final String USER = "sa";
    private static final String PASS = "1";
    public static void main(String[] args) throws SQLException, Exception {
//   private static final String DRIVER_SQL_SERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testLocale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testLocale.class.getName()).log(Level.SEVERE, null, ex);
        }
      //Creating the Statement
      Statement stmt = con.createStatement();
      String tableSqlName = "table", fieldSqlName = "field", tableName = "UserRole", fieldName = "name";
      int fieldId = 2;
      String sqlCheckDataType = Constants.QUERY_CHECK_DATA_TYPE_FIELD_NAME.replaceAll(tableSqlName, tableName);
      //SELECT field FROM table
      sqlCheckDataType = sqlCheckDataType.replaceAll(fieldSqlName, fieldName);
      
      String[] param = new String[]{};
      String dataTypeFieldName = DatabaseHelper.getDataTypeFieldName(sqlCheckDataType, param);
      String value = "manager";
      Object value1 = null;
        System.out.println(dataTypeFieldName);
        if(dataTypeFieldName.equals("INTEGER")){
            value1 = Integer.parseInt(value);
        }
        else if(dataTypeFieldName.equals("FLOAT")){
            value1 = Float.parseFloat(value);
        }
        else if(dataTypeFieldName.equals("BOOLEAN")){
            value1 = Boolean.parseBoolean(value);
        }
        else if(dataTypeFieldName.equals("NVARCHAR")){
            value1 = value;
        }
       
        Object getparam[] = new Object[]{
            value1,
            fieldId
        };
        String sql = Constants.QUERY_CHECK_UNIQUE_CONSTANTS_WHEN_UPDATE.replaceAll(tableSqlName, tableName);
        //SELECT * FROM table where field =? and id not like ?
        sql = sql.replaceAll(fieldSqlName, fieldName);
        if(DatabaseHelper.checkUniqueData(sql, getparam)){
            System.out.println("oke");
        }
        else{
            System.out.println("false");
        }
    }

}
