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
import qlkh.dao.ICustomerDAO;
import qlkh.entities.Customers;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class CustomerDaoImpl implements ICustomerDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM Customer";
    private static final String SQL_INSERT = "INSERT INTO Customer(Name,address,phone,email,MoreInfo,ContractDate) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  Customer SET NAME =?, address =?, phone =?,email=?,MoreInfo=?,ContractDate=? WHERE ID =?";
    private static final String SQL_DELETE = "DELETE FROM  Customer  WHERE ID =?";

    private static final String SQL_SELECT_BY_NAME = "SELECT * FROM Customer WHERE Name= ? ";

    @Override
    public List<Customers> getAllCustomers() {
        // Khởi tạo list UserRole
        List<Customers> listCustomers = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Customers
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                Customers customer = new Customers(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("MoreInfo"),
                        rs.getTimestamp("ContractDate"));
                listCustomers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listCustomers;
    }

    @Override
    public Customers getCustomersByName(String key) {
        //Khởi tạo đối tượng userRole
       Customers customer = null;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from Customers by name 
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_NAME, param);
            while (rs.next()) {
                  customer = new Customers(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("MoreInfo"),
                        rs.getTimestamp("ContractDate"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) { 
               Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
           } 
        }
        return customer;
    }

    @Override
    public int insert(Customers element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countInsert = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_INSERT và tham số customer.getParam
            countInsert = DatabaseHelper.insertData(SQL_INSERT, element.getParam(Constants.ACTION_INSERT));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return countInsert;
    }

    @Override
    public int update(Customers element) {
        //Khởi tạo biến đếm số bản ghi được ghi vào csdl
        Integer countUpdate = 0;
        try {
            // Thục hiện phương thức insert data với câu query SQL_Update và tham số customer.getParam
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return countUpdate;
    }

    @Override
    public int delete(Integer key) {
        //Khởi tạo biến đếm số bản ghi bi xoa khoi csdl
        Integer countDelete = 0;
        try {
            // Khởi tạo mảng @param kiểu Integer để chạy lệnh sql Delete from Customers by key Integer
            Integer[] param = new Integer[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            countDelete = DatabaseHelper.deleteData(SQL_DELETE, param);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return countDelete;
    }

}
