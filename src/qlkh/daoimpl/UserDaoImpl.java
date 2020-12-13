/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.IUserDAO;

import qlkh.entities.UserRole;
import qlkh.entities.Users;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class UserDaoImpl implements IUserDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM Users";
    private static final String SQL_INSERT = "INSERT INTO Users(Name,Username,password,idRole,email) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  Users SET NAME =?, username =?, password =?,idRole=? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM  Users  WHERE Name =?";

    private static final String SQL_SELECT_BY_NAME_OR_EMAIL = "SELECT * FROM Users WHERE Name= ? OR EMAIL =?";
    private static final String SQL_SELECT_BY_MAIL_AND_CODE = "SELECT * FROM Users WHERE (Name=?  OR EMAIL =?) AND verifyCode =?";

    @Override
    public List<Users> getAllUsers() {
        // Khởi tạo list UserRole
        List<Users> listUsers = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from users
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                Users user = new Users(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("UserName"),
                        rs.getInt("idRole"),
                        rs.getString("email"));
                listUsers.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUsers;
    }

    @Override
    public Users getUserByNameOrEmail(String key) {
        //Khởi tạo đối tượng userRole
        Users user = null;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from user by name or email
            String[] param = new String[]{key, key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_NAME_OR_EMAIL, param);
            while (rs.next()) {
                user = new Users(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getInt("idRole"),
                        rs.getString("email"),
                        rs.getInt("verifyCode"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public boolean login(Users element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Users element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countInsert = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_INSERT và tham số user.getParam
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public int update(Users element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countUpdate = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_Update và tham số user.getParam
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

    @Override
    public int delete(String key) {
        //Khởi tạo biến đếm số bản ghi bi xoa khoi csdl
        Integer countDelete = 0;
        try {
            // Khởi tạo mảng @param kiểu Integer để chạy lệnh sql Delete from user by key String
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            countDelete = DatabaseHelper.deleteData(SQL_DELETE, param);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countDelete;
    }

    @Override
    public Users getUserByVerifyCode(Users element) {
        //Khởi tạo đối tượng userRole
        Users user = null;
        try {

            // @param lấy từ entities.Users
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_NAME_OR_EMAIL, element.getParam(Constants.ACTION_GET_USER_BY_CODE));
            while (rs.next()) {
                user = new Users(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getInt("idRole"),
                        rs.getString("email"),
                        rs.getInt("verifyCode"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

}
