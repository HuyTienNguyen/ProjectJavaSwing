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
import qlkh.dao.IUserRoleDAO;
import qlkh.entities.UserRole;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class UserRoleDaoImpl implements IUserRoleDAO {

 
    private static final String SQL_GET_ALL = "SELECT * FROM UserRole";
    private static final String SQL_INSERT = "INSERT INTO UserRole(name) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE  UserRole SET NAME =? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM  UserRole  WHERE ID =?";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM UserRole WHERE ID = ?";

    @Override
    public List<UserRole> getAllUserRole() {
        // Khởi tạo list UserRole
        List<UserRole> listUserRole = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from userRole
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                UserRole userRole = new UserRole(rs.getInt(1), rs.getString(2));
                listUserRole.add(userRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUserRole;

    }

    @Override
    public int insert(UserRole element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countInsert = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_INSERT và tham số userRole.getPâram
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public UserRole getUserRoleByID(Integer key) {
        //Khởi tạo đối tượng userRole
        UserRole userRole = null;
        try {
            // Khởi tạo mảng param kiểu Integer để chạy lệnh sql select from userRole by key Integer
            Integer[] param = new Integer[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);
            while (rs.next()) {
                userRole = new UserRole(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userRole;
    }

    @Override
    public int update(UserRole element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countUpdate = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_Update và tham số userRole.getPâram
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

   
    public int delete(Integer key) {
        //Khởi tạo biến đếm số bản ghi bi xoa khoi csdl
        Integer countDelete = 0;
        try {
            // Khởi tạo mảng param kiểu Integer để chạy lệnh sql select from userRole by key Integer
            Integer[] param = new Integer[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            countDelete = DatabaseHelper.deleteData(SQL_DELETE, param);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countDelete;
    }

    @Override
    public int delete(UserRole element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
