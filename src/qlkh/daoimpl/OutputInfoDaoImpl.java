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
import qlkh.dao.IOutputInfoDAO;
import qlkh.entities.Customers;
import qlkh.entities.OutputInfo;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class OutputInfoDaoImpl implements IOutputInfoDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM OutputInfo";
    private static final String SQL_INSERT = "INSERT INTO OutputInfo(Id,IdObjects,IdInputInfo,IdOutput,IdCustomer,Counts,Status) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  OutputInfo SET IdObjects =?, IdInputInfo =?, IdOutput =?,IdCustomer=?,Counts=?,Status=? WHERE Id =?";
    private static final String SQL_DELETE = "DELETE FROM  OutputInfo  WHERE Id =?";

    private static final String SQL_SELECT_BY_Id = "SELECT * FROM OutputInfo WHERE Id= ? ";

    @Override
    public List<OutputInfo> getAllOutputInfos() {
        // Khởi tạo list OutputInfo
        List<OutputInfo> listOutputInfos = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from OutputInfo
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                OutputInfo outputInfo = new OutputInfo(
                        rs.getString("Id"),
                        rs.getString("IdObjects"),
                        rs.getString("IdInputInfo"),
                        rs.getString("IdOutput"),
                        rs.getInt("IdCustomer"),
                        rs.getInt("Counts"),
                        rs.getString("Status"));
                listOutputInfos.add(outputInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOutputInfos;
    }

    @Override
    public OutputInfo getOutputInfoByID(String key) {
        //Khởi tạo đối tượng OutputInfo
        OutputInfo outputInfo = null;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from OutputInfo by Id 
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_Id, param);
            while (rs.next()) {
                outputInfo = new OutputInfo(
                        rs.getString("Id"),
                        rs.getString("IdObjects"),
                        rs.getString("IdInputInfo"),
                        rs.getString("IdOutput"),
                        rs.getInt("IdCustomer"),
                        rs.getInt("Counts"),
                        rs.getString("Status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return outputInfo;
    }

    @Override
    public int insert(OutputInfo element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countInsert = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_INSERT và tham số OutputInfo.getParam
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public int update(OutputInfo element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countUpdate = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_Update và tham số OutputInfo.getParam
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

    @Override
    public int delete(String key) {
        //Khởi tạo biến đếm số bản ghi bi xoa khoi csdl
        Integer countDelete = 0;
        try {
            // Khởi tạo mảng @param kiểu String để chạy lệnh sql Delete from OutputInfo by key String
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            countDelete = DatabaseHelper.deleteData(SQL_DELETE, param);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countDelete;
    }

}
