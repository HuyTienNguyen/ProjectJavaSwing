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
import qlkh.dao.IInvoiceImportDAO;
import qlkh.entities.InvoiceImport;
import qlkh.entities.InvoiceExport;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;


/**
 *
 * @author GIANG
 */
public class InvoiceImportDaoImpl implements IInvoiceImportDAO {
    private static final String SQL_GET_ALL = "SELECT * FROM InvoiceImport";
    private static final String SQL_INSERT = "INSERT INTO InvoiceImport(Id,DateInput) VALUES(?,?)";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM InvoiceImport WHERE Id = ? ";
    @Override
    public List<InvoiceImport> getAllInvoiceImport() {
        // Khởi tạo list Outputs
        List<InvoiceImport> listInvoiceImport = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                InvoiceImport input = new InvoiceImport(
                        rs.getString("Id"),
                        rs.getTimestamp("DateInput")
                      );
                listInvoiceImport.add(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInvoiceImport;
    }

    @Override
    public InvoiceImport getInvoiceImportByID(String key) {
        // Khởi tạo đối tượng output
        InvoiceImport invoiceInport = null;
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{key};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);) {
            while (rs.next()) {
                invoiceInport = new InvoiceImport(
                        rs.getString("Id"),
                        rs.getTimestamp("DateInput") );

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return invoiceInport;
    }

    @Override
    public int insert(InvoiceImport element) {
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
                Logger.getLogger(InvoiceExportDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public int update(InvoiceImport element) {
        return 0;
    }

    @Override
    public int delete(InvoiceImport element) {
        return 0;
    }

   
  
    
}
