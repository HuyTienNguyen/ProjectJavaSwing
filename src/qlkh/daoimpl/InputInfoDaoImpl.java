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
import qlkh.dao.IInputInfoDAO;
import qlkh.entities.InputInfo;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;


/**
 *
 * @author GIANG
 */
public class InputInfoDaoImpl implements IInputInfoDAO {
    private static final String SQL_GET_ALL = "SELECT * FROM InputInfo";
    private static final String SQL_INSERT = "INSERT INTO InputInfo(Id,IdObjects,IdInput,counts,inputPrice,outputPrice,Status) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  InputInfo SET IdObjects =?, IdInput =?, counts =?,inputPrice=?,OutputPrice=?,Status=? WHERE Id =?";
    private static final String SQL_DELETE = "DELETE FROM  InputInfo  WHERE Id =?";

    private static final String SQL_SELECT_BY_Id = "SELECT * FROM InputInfo WHERE Id= ? ";
    @Override
    public List<InputInfo> getAllInputInfos() {
        List<InputInfo> listInputInfo = new ArrayList<>();
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);
            while(rs.next()){
                InputInfo inputinfo = new InputInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getFloat(6),rs.getString(7));
                listInputInfo.add(inputinfo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInputInfo;
    }

    @Override
    public InputInfo getInputInfoByID(String key) {
        InputInfo inputinfo = null;
        String[] param = new String[]{key};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_Id, param);
            if(rs.next()){
                inputinfo = new InputInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getFloat(6),rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(OutputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inputinfo;
    }

    @Override
    public int insert(InputInfo element) {
        Integer countInsert = 0;
        try {
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (SQLException ex) {
            Logger.getLogger(InputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(InputInfo element) {
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(InputInfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int delete(InputInfo element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
 
 
    
}
