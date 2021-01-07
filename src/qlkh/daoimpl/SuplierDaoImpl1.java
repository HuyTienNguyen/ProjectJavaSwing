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
import qlkh.dao.ISuplierDAO;
import qlkh.entities.Supliers;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class SuplierDaoImpl1 implements ISuplierDAO {

    private static Connection conn;
    private static final String SQL_GET_ALL = "SELECT * FROM Suplier ORDER BY  status DESC,name";
    private static final String SQL_INSERT = "INSERT INTO Suplier(name,address,phone,email,moreinfo,contractDate,characters) values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Suplier SET name = ? , address = ?, phone = ?, email = ?, moreinfo = ?, contractDate = ?, characters = ? where id = ?";
    private static final String SQL_DELETE = "DELETE FROM Suplier where id = ?";
    private static final String SQL_GET_BY_ID = "SELECT * FROM Suplier WHERE id = ?";
    private static final String SQL_DELETE_BY_PROCEDURE = "{call sp_delete_suplier(?,?)}";

    @Override
    public List<Supliers> getAllSupliers() {
        //tạo danh sách lưu tất cả suplier
        List<Supliers> listSuplier = new ArrayList<>();
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);
            while (rs.next()) {
                Supliers supliers = new Supliers(
                                                 rs.getInt("id"),
                                                 rs.getString("name"),
                                                 rs.getString("address"),
                                                 rs.getString("phone"),
                                                 rs.getString("email"),
                                                 rs.getString("moreInfo"),
                                                 rs.getTimestamp("ContractDate"),
                                                 rs.getInt("status"),
                                                 rs.getString("characters"));
                listSuplier.add(supliers);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDaoImpl1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listSuplier;
    }

    @Override
    public Supliers getSuplierById(Integer key) {
        Supliers supliers = null;
        Integer[] param = new Integer[]{key};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_BY_ID, param);
            rs.next();
            supliers = new Supliers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getTimestamp(7), rs.getString(8));
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDaoImpl1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserRoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return supliers;
    }

    @Override
    public int insert(Supliers element) {
        Integer countInsert = 0;
        try {
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDaoImpl1.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(Supliers element) {
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDaoImpl1.class.getName()).log(Level.SEVERE, null, ex);
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
    public int delete(Supliers element) {
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
