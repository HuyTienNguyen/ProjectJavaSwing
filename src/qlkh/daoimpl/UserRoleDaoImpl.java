/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.IUserRoleDAO;
import qlkh.entities.UserRole;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class UserRoleDaoImpl implements IUserRoleDAO {

    private static Connection conn;
    private static final String SQL_GET_ALL = "SELECT * FROM UserRole";

    @Override
    public List<UserRole> getAllUserRole() {
        List<UserRole> listUserRole = new ArrayList<>();

        try (Connection conn = DatabaseHelper.getInstance().getConnectionSqlserver();
             PreparedStatement pst = conn.prepareCall(SQL_GET_ALL);
             ResultSet rs = pst.executeQuery(); ) 
        {
            while(rs.next()){
                UserRole userRole = new UserRole(rs.getInt(1), rs.getString(2));
                listUserRole.add(userRole);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listUserRole;

    }

    @Override
    public void insert(UserRole e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserRole e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserRole getUserRoleByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
