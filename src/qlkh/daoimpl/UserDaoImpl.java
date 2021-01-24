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
    private static final String SQL_INSERT = "INSERT INTO Users(Name,Username,password,email) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  Users SET NAME =?, username =?, password =? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM  Users  WHERE Name =?";
    private static final String SQL_UPDATE_VERIFY_CODE = "UPDATE Users SET verifyCode = ? WHERE EMAIL = ?";

    private static final String SQL_SELECT_BY_USERNAME_AND_PASS = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
    private static final String SQL_SELECT_BY_NAME_OR_EMAIL = "SELECT * FROM Users WHERE Name= ? OR EMAIL =?";
        private static final String SQL_SELECT_BY_ID = "SELECT * FROM Users WHERE Id =?";

    private static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM Users WHERE EMAIL =?";
    private static final String SQL_SELECT_BY_MAIL_AND_CODE = "SELECT * FROM Users WHERE EMAIL =? AND verifyCode =?";
    private static final String SQL_SELECT_USERNAME_AND_EMAIL = "SELECT * From users where username = ? and email = ?";
    private static final String SQL_UPDATE_PASSWORD_BY_EMAIL = "Update Users Set Password = ? Where Email = ?";
    private static final String SQL_GET_ID_BY_USER_PASS = "select id from users where username = ? and password = ?";
    @Override
    public List<Users> getUsers() {
        // Khởi tạo list UserRole
        List<Users> listUsers = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from users
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("Id"));
                user.setName(rs.getString("Name"));
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("email"));
                
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
        //Khởi tạo đối tượng User
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
    public Users getUserById(int id) {
        //Khởi tạo đối tượng User
        Users user = null;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from user by name or email
            Integer[] param = new Integer[]{ id};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);
            while (rs.next()) {
                user = new Users(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
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
        return user;}
    @Override
    public boolean login(Users element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Users element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        System.out.println("hihi");
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


    public boolean checkUser(Users userLogin) {
        boolean check = false;
        if (userLogin != null) {
           
            try {
                ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_USERNAME_AND_PASS, userLogin.getParam(Constants.ACTION_GET_USER_BY_USERNAME_PASS));
                if(rs.next()){
                    check =  true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    @Override
    public int delete(Users element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean checkExistsUserByEmail(String key) {
        boolean check = false;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from user by name or email
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_EMAIL, param);
            if(rs.next()){
                check = true;
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
        return check;
    }
    public int UpdateVerifyCode(String key,String Email) {
        int countRecord = 0;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from user by name or email
            String[] param = new String[]{key,Email};
            // GỌi phương thức selectData trả về theo kiểu result set
            countRecord = DatabaseHelper.updateData(SQL_UPDATE_VERIFY_CODE, param);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countRecord;
    }
    public int getRecordThroughVerifyCode(String key,String Email) {
        int countRecord = 0;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from user by name or email
            String[] param = new String[]{Email,key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_MAIL_AND_CODE, param);
            if(rs.next()){
                countRecord = 1;
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
        return countRecord;
    }

    public boolean checkUsernameAndEmail(Users element) throws SQLException{
        boolean check = false;
        ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_USERNAME_AND_EMAIL,element.getParam(Constants.ACTION_SELECT_USERNAME_AND_EMAIL));
        if(rs.next()){
            check = true;
        }
        return check;
    }
    
    public int updatePasswordByEmail(String password, String Email) throws SQLException{
        int countUpdate = 0;
        String[] param = new String[]{password,Email};
        countUpdate = DatabaseHelper.updateData(SQL_UPDATE_PASSWORD_BY_EMAIL, param);
        return countUpdate;
    }
    
    public String getIdUser(Users element ){
        String idUser = "";
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ID_BY_USER_PASS, element.getParam(Constants.ACTION_GET_ID_USER));
            if(rs.next()){
                idUser = String.valueOf(rs.getInt("id"));
            }
            else{
                idUser = "null";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUser;
    }

}