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
import qlkh.dao.IOutputDAO;
import qlkh.entities.Output;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class OutputDaoImpl implements IOutputDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM Output";
    private static final String SQL_INSERT = "INSERT INTO Output(Id,DateOutput) VALUES(?,?)";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Output WHERE Id = ? ";

    @Override
    public List<Output> getAllOutputs() {
        // Khởi tạo list Outputs
        List<Output> listOuputs = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                Output output = new Output(
                        rs.getString("Id"),
                        rs.getTimestamp("DateOutput"));
                listOuputs.add(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOuputs;
    }

    @Override
    public Output getOutputByID(String key) {
        // Khởi tạo đối tượng output
        Output output = null;
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{key};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);) {
            while (rs.next()) {
                output = new Output(
                        rs.getString("Id"),
                        rs.getTimestamp("DateOutput"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    @Override
    public int insert(Output element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countInsert = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_INSERT và tham số output.getParam
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public int update(Output element) {
        return 0;
    }

    @Override
    public int delete(String key) {
        return 0;
    }

}
