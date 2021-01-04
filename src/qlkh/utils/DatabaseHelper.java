/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANG
 */
public class DatabaseHelper {

    private static DatabaseHelper instance;
    private static Connection connectionSqlserver;
    private static final String DRIVER_SQL_SERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String HOST_SQLSERVER = "localhost";
    private static final String PORT_SQLSERVER = "1433";
    private static final String DATABASE_NAME_SQLSERVER = "QuanLyKhoHang";

    private static final String URL_SQL_SERVER = "jdbc:sqlserver://" + HOST_SQLSERVER + ":" + PORT_SQLSERVER + ";databaseName=" + DATABASE_NAME_SQLSERVER;
    private static final String USER_SQLSERVER = "sa";
    private static final String PASSWORD_SQLSERVER = "1";

    /**
     * Lớp hiện tại triển khai Singleton pattern Hàm khởi tạo không thể tạo ra
     * thực thể từ bên ngoài
     *
     *
     */
    private DatabaseHelper() {
        try {
            Class.forName(DRIVER_SQL_SERVER);
            this.connectionSqlserver = DriverManager.getConnection(URL_SQL_SERVER, USER_SQLSERVER, PASSWORD_SQLSERVER);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    /**
     * Hàm lấy về kết nối Connection với Sqlserver
     *
     *
     */
    public Connection getConnectionSqlserver() {
        System.out.println("ket noi thanh cong");
        return this.connectionSqlserver;

    }

    /**
     * Hàm lấy về thực thể của DatabaseHelper mà không cần khởi tạo constructor
     *
     */
    public static DatabaseHelper getInstance() {
        try {
            if (instance == null) {
                instance = new DatabaseHelper();
            } else if (instance.getConnectionSqlserver().isClosed()) {
                instance = new DatabaseHelper();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;

    }

    /**
     * Hàm đóng kết nối Cơ sở dữ liệu
     *
     * @throws java.sql.SQLException
     */
    public void closeDatabaseConnection() throws SQLException {
        if (connectionSqlserver.isClosed() == false || connectionSqlserver != null) {
            connectionSqlserver.close();
            System.out.println("dong ket noi thanh cong");
        }
    }

    public boolean checkConnection() throws SQLException {
        return connectionSqlserver.isClosed();
    }

    /**
     * Hàm lấy về câu lệnh preparedStatement
     *
     * @param isInsert true = insert, false = update
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào
     */
    private static <E> PreparedStatement getPrepareStatement(boolean isInsert, String sql, E... args) throws SQLException {
        PreparedStatement pstm;
        if (connectionSqlserver == null || connectionSqlserver.isClosed() == true) {
            connectionSqlserver = getInstance().getConnectionSqlserver();
        }
        if (isInsert == true) {
            // 1. Tạo PreparedStatement với tùy chọn lấy về danh sách ID của  dòng trong câu lệnh insert
            pstm = connectionSqlserver.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } else {
            // 2. Tạo PreparedStatement với tùy chọn ResultSet cho phép cuộn và cập nhật dữ liệu
            pstm = connectionSqlserver.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        // kieu object
        // Object [] param = new Object[]{String,integer}
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                pstm.setInt(i + 1, (Integer) args[i]);
            } else if (args[i] instanceof Float) {
                pstm.setFloat(i + 1, (Float) args[i]);
            } else if (args[i] instanceof Double) {
                pstm.setDouble(i + 1, (Double) args[i]);
            } else if (args[i] instanceof Long) {
                pstm.setLong(i + 1, (Long) args[i]);
            } else if (args[i] instanceof String) {
                pstm.setString(i + 1, (String) args[i]);
            } else if (args[i] instanceof java.sql.Timestamp) {
                pstm.setTimestamp(i + 1, Utils.getTimestampNow());
            }
        }
        return pstm;
    }

    /**
     * Hàm lấy về câu lệnh preparedStatement
     *
     * @param isInsert true = insert, false = update
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào
     */
    private static <E> CallableStatement getCallableStatement(String sql, E... args) throws SQLException {
        CallableStatement cst;
        if (connectionSqlserver == null || connectionSqlserver.isClosed() == true) {
            connectionSqlserver = getInstance().getConnectionSqlserver();
        }

        // 1. Tạo PreparedStatement với tùy chọn lấy về danh sách ID của  dòng trong câu lệnh insert
        cst = connectionSqlserver.prepareCall(sql);

        int size = args.length;
        // Đăng ký tham số đầu ra cho thủ tục
        cst.registerOutParameter(1, Types.INTEGER);
        int numberOne = 1;

        // kieu object
        // Object [] param = new Object[]{String,integer}
        for (int i = numberOne; i < size; i++) {
            if (args[i] instanceof Integer) {
                cst.setInt(i + 1, (Integer) args[i]);
            } else if (args[i] instanceof Float) {
                cst.setFloat(i + 1, (Float) args[i]);
            } else if (args[i] instanceof Double) {
                cst.setDouble(i + 1, (Double) args[i]);
            } else if (args[i] instanceof Long) {
                cst.setLong(i + 1, (Long) args[i]);
            } else if (args[i] instanceof String) {
                cst.setString(i + 1, (String) args[i]);
            } else if (args[i] instanceof java.sql.Timestamp) {
                cst.setTimestamp(i + 1, Utils.getTimestampNow());
            }
        }
        return cst;
    }

    /**
     * Hàm lấy về dữ liệu: SELECT
     *
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào E1 generic K Ttype V value return
     * PreparedStatement
     */
    public static <E> ResultSet selectData(String sql, E... args) throws SQLException {
        PreparedStatement pstm = getPrepareStatement(false, sql, args);
        return pstm.executeQuery();
    }

    /**
     * Hàm cập nhật dữ liệu: INSERT | UPFATE | DELETE
     *
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào return PreparedStatement
     */
    public static <E> int updateData(String sql, E... args) throws SQLException {
        PreparedStatement pstm = getPrepareStatement(false, sql, args);
        return pstm.executeUpdate();
    }

    /**
     * Hàm cập nhật dữ liệu: INSERT
     *
     * @param <E> paramameter generic
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào
     * @return
     * @throws java.sql.SQLException return PreparedStatement
     */
    public static <E> int insertData(String sql, E... args) throws SQLException {
        PreparedStatement pstm = getPrepareStatement(true, sql, args);
        return pstm.executeUpdate();

    }

    /**
     * Hàm cập nhật dữ liệu: DELETE
     *
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào return PreparedStatement
     */
    public static <E> int deleteData(String sql, E... args) throws SQLException {
        PreparedStatement pstm = getPrepareStatement(false, sql, args);
        return pstm.executeUpdate();

    }

    /**
     * Hàm cập nhật dữ liệu: INSERT
     *
     * @param <E> paramameter generic
     * @param sql cú pháp SQL kèm tham số
     * @param args mảng tham số truyền vào
     * @return CallableStatement
     * @throws java.sql.SQLException
     */
    public static <E> int insertDataByCallableStatement(String sql, E... args) throws SQLException {
        CallableStatement cst = getCallableStatement(sql, args);
        cst.executeUpdate();
        return cst.getInt(1);
    }

    public static <E> int updateDataByCallableStatement(String sql, E... args) throws SQLException {
        CallableStatement cst = getCallableStatement(sql, args);
        cst.executeUpdate();
        return cst.getInt(1);
    }

    public static <E> int deleteDataByCallableStatement(String sql, E... args) throws SQLException {
        CallableStatement cst = getCallableStatement(sql, args);
        cst.executeUpdate();
        return cst.getInt(1);
    }
    public static <E> boolean checkUniqueData(String sql, E... args) throws SQLException {
        boolean check = false;
        PreparedStatement pstm = getPrepareStatement(false, sql, args);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            check = true;
        }
        return check;
    }

    public static <E> String getDataTypeFieldName(String sql, E... args) throws Exception {
        PreparedStatement pstm = getPrepareStatement(false, sql, args);
        ResultSet rs = pstm.executeQuery();
        ResultSetMetaData dataTypeFieldName = rs.getMetaData();
        String dataType = JDBCType.valueOf(dataTypeFieldName.getColumnType(1)).toString();
        return dataType;
    }
}
