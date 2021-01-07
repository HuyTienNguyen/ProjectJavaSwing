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
import qlkh.dao.IInvoiceExportDAO;
import qlkh.entities.InvoiceExport;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class InvoiceExportDaoImpl implements IInvoiceExportDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM InvoiceExport";
    private static final String SQL_INSERT = "INSERT INTO InvoiceExport(Id,DateOutput,IdCustomer) VALUES(?,?,?)";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM InvoiceExport WHERE Id = ? ";

    @Override
    public List<InvoiceExport> getAllInvoiceExport() {
        // Khởi tạo list Outputs
        List<InvoiceExport> listOuputs = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                InvoiceExport output = new InvoiceExport(
                        rs.getString("Id"),
                        rs.getTimestamp("DateOutput"),
                        rs.getInt("idCustomer"));
                listOuputs.add(output);
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
        return listOuputs;
    }

    @Override
    public InvoiceExport getInvoiceExportByID(String key) {
        // Khởi tạo đối tượng output
        InvoiceExport invoiceExport = null;
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from Output
        String[] param = new String[]{key};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_ID, param);) {
            while (rs.next()) {
                invoiceExport = new InvoiceExport(
                        rs.getString("Id"),
                        rs.getTimestamp("DateOutput"),
                        rs.getInt("IdCustomer"));

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
        return invoiceExport;
    }

    @Override
    public int insert(InvoiceExport element) {
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
    public int update(InvoiceExport element) {
        return 0;
    }

    
    public int delete(String key) {
        return 0;
    }

    @Override
    public int delete(InvoiceExport element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
