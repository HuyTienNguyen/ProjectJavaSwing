/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlkh.dao.ICategoryDAO;
import qlkh.entities.Category;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author user
 */
public class CategoryDaoImpl implements ICategoryDAO{
    private static Connection conn;
    private static final String SQL_SELECT_ALL = "SELECT * FROM Category  ORDER BY  status DESC,name ";
    private static final String SQL_GET_BY_ID = "SELECT * FROM Category Where id = ?";
    private static final String SQL_INSERT = "INSERT INTO Category(name,characters) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE Category Set name = ?, characters = ? where id = ?";
    private static final String SQL_DELETE = "DELETE FROM Category where id = ?";
        private static final String SQL_DELETE_BY_PROCEDURE = "{call sp_delete_category(?,?)}";

    @Override
    public List<Category> getAllCategoies() {
        List<Category> listCate = new ArrayList<>();
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_ALL, param);
            while(rs.next()){
                Category category = new Category(rs.getInt("id"),rs.getString("name"),rs.getString("characters"),rs.getInt("status"));
                listCate.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCate;
    }

    @Override
    public Category getCateById(Integer key) {
        Category category = null;
        Integer[] param = new Integer[]{key};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_BY_ID, param);
            while(rs.next()){
                category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return category;
    }

    @Override
    public int insert(Category element) {
        Integer countInsert = 0;
        try {
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(Category element) {
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

    @Override
    public int delete(Category element) {
        Integer countDelete = 0;
        try {
            // Khởi tạo mảng param kiểu Integer để chạy lệnh sql select from userRole by key Integer
           
            countDelete = DatabaseHelper.deleteDataByCallableStatement(SQL_DELETE_BY_PROCEDURE, element.getParam(Constants.ACTION_DELETE_BY_PROC));
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countDelete;
    }
    
}
