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
import qlkh.dao.IUnitDAO;
import qlkh.entities.Unit;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class UnitDaoImpl implements IUnitDAO {

    private static Connection conn;
    private static final String SQL_GET_ALL = "SELECT * from Unit ORDER BY  status DESC,name ";
    private static final String SQL_INSERT_BY_PROCEDURE = "{call sp_add_new_unit(?,?)}";
    private static final String SQL_UPDATE_BY_PROCEDURE = "{call sp_update_unit(?,?,?)}";
    private static final String SQL_DELETE_BY_PROCEDURE = "{call sp_delete_unit(?,?)}";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Unit WHERE ID = ?";

    @Override
    public List<Unit> getAllUnits() {
        //tạo list Unit
        List<Unit> listUnit = new ArrayList<>();
        //khởi tạo mảng param rỗng để chạy lệnh sql server all from unit
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);
            while (rs.next()) {
                Unit unit = new Unit(rs.getInt(1), rs.getString(2),rs.getInt(3));
                listUnit.add(unit);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUnit;
    }

    @Override
    public Unit getUnitByID(Integer key) {
        //tao doi tuong Unit
        Unit unit = null;
        // Khởi tạo mảng param kiểu Integer để chạy lệnh sql select from unit by key Integer
        Integer[] param = new Integer[]{key};
        try {
            //goi phuong thuc data tra ve theo kieu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);
            while (rs.next()) {
                unit = new Unit(rs.getInt(1), rs.getString(2),rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return unit;
    }

    @Override
    public int insert(Unit element) {
        //khoi tao bien dem so ban ghi duoc ghi vao csdl
        Integer countInsert = 0;
        try {
            countInsert = DatabaseHelper.insertDataByCallableStatement(SQL_INSERT_BY_PROCEDURE, element.getParam(Constants.ACTION_INSERT_BY_PROC));
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(Unit element) {
        //khoi tao bien dem so ban ghi dc update vao csdl
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateDataByCallableStatement(SQL_UPDATE_BY_PROCEDURE, element.getParam(Constants.ACTION_UPDATE_BY_PROC));
        } catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int delete(Unit element) {
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
