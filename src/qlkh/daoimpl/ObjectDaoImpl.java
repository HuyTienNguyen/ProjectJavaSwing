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
import qlkh.dao.IObjectDAO;
import qlkh.entities.Objects;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;


/**
 *
 * @author GIANG
 */
public class ObjectDaoImpl implements IObjectDAO {
    private static Connection conn;
    private static final String SQL_GET_ALL = "SELECT * FROM Objects";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Objects WHERE ID = ?";
    private static final String SQL_INSERT = "INSERT INTO Objects(name,idUnit,idSuplier,idCate) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  Objects SET NAME =?, idUnit=?,idSuplier=?,idCate=? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM  Objects  WHERE ID =?";
    @Override
    public List<Objects> getAllObjects() {
        List<Objects> listObjects = new ArrayList<>();
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);
            while(rs.next()){
                Objects ob = new Objects(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
                listObjects.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listObjects;
    }

    @Override
    public Objects getObjectById(String key) {
        Objects objects = null;
        String[] param = new String[]{key};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);
            objects = new Objects(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
        } catch (SQLException ex) {
            Logger.getLogger(ObjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return objects;
    }

    @Override
    public int insert(Objects element) {
        Integer countInsert = 0;
        try {
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (SQLException ex) {
            Logger.getLogger(ObjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(Objects element) {
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(ObjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int delete(String key) {
        Integer countDelete = 0;
        String[] param = new String[]{key};
        try {
            countDelete = DatabaseHelper.deleteData(SQL_DELETE, key);
        } catch (SQLException ex) {
            Logger.getLogger(ObjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
