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
    public static void main(String[] args) throws SQLException {
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
      //Query to retrieve records
      String query = "Select * from UserRole";
      //Executing the query
      ResultSet rs = stmt.executeQuery(query);
      //Getting the ResultSetMetadata object
      ResultSetMetaData mertadata = rs.getMetaData();
      //Returns the specified column's java.sql.Type name
      //Retrieving the data type of a column
      int ID_Type = mertadata.getColumnType(1);
      int FirstName_Type = mertadata.getColumnType(2);
      System.out.println("Data type of the column ID: "+JDBCType.valueOf(ID_Type));
      System.out.println("Data type of the column First_Name: "+JDBCType.valueOf(FirstName_Type));
      System.out.println("adsf");
    }

}
