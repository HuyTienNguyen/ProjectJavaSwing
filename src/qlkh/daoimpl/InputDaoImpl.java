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
import qlkh.dao.IInputDAO;
import qlkh.entities.Input;
import qlkh.entities.Output;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;


/**
 *
 * @author GIANG
 */
public class InputDaoImpl implements IInputDAO {
    private static final String SQL_GET_ALL = "SELECT * FROM Input";
    private static final String SQL_INSERT = "INSERT INTO Input(Id,DateInput) VALUES(?,?)";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Input WHERE Id = ? ";
    @Override
    public List<Input> getAllInputs() {
        // Khởi tạo list Outputs
        List<Input> listInput = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                Input input = new Input(
                        rs.getString("Id"),
                        rs.getTimestamp("DateInput"));
                listInput.add(input);
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
        return listInput;
    }

    @Override
    public Input getInputByID(String key) {
        // Khởi tạo đối tượng output
        Input input = null;
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{key};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);) {
            while (rs.next()) {
                input = new Input(
                        rs.getString("Id"),
                        rs.getTimestamp("DateInput"));

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
        return input;
    }

    @Override
    public int insert(Input element) {
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
    public int update(Input element) {
        return 0;
    }

    @Override
    public int delete(Input element) {
        return 0;
    }

   
  
    
}
