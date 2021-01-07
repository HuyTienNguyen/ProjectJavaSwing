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
import qlkh.dao.IInvoiceExportDetailDAO;
import qlkh.entities.Customers;
import qlkh.entities.InvoiceExportDetail;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;

/**
 *
 * @author GIANG
 */
public class InvoiceExportDetailDaoImpl implements IInvoiceExportDetailDAO {

    private static final String SQL_GET_ALL = "SELECT * FROM InvoiceExportDetail";
    private static final String SQL_INSERT = "INSERT INTO InvoiceExportDetail(Id,IdProduct,IdInvoiceImportDetail,IdInvoiceExport,Counts,Status) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  InvoiceExportDetail SET IdProduct =?, IdInvoiceImportDetail =?, IdInvoiceExport =?,Counts=?,Status=? WHERE Id =?";
    private static final String SQL_DELETE = "DELETE FROM  InvoiceExportDetail  WHERE Id =?";

    private static final String SQL_SELECT_BY_Id = "SELECT * FROM InvoiceExportDetail WHERE Id= ? ";

    @Override
    public List<InvoiceExportDetail> getAllInvoiceExportDetail() {
        // Khởi tạo list OutputInfo
        List<InvoiceExportDetail> listInvoiceExportDetail = new ArrayList<>();
        // Khởi tạo mảng param rỗng để chạy lệnh sql select all from OutputInfo
        String[] param = new String[]{};
        try (ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);) {
            while (rs.next()) {
                InvoiceExportDetail invoiceexportDetail = new InvoiceExportDetail(
                        rs.getString("Id"),
                        rs.getString("IdProduct"),
                        rs.getString("IdInvoiceImportDetail"),
                        rs.getString("IdInvoiceExport"),
                        rs.getInt("Counts"),
                        rs.getString("Status"));
                listInvoiceExportDetail.add(invoiceexportDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInvoiceExportDetail;
    }

    @Override
    public InvoiceExportDetail getInvoiceExportDetailByID(String key) {
        //Khởi tạo đối tượng OutputInfo
        InvoiceExportDetail listInvoiceExportDetail = null;
        try {
            // Khởi tạo mảng param kiểu String để chạy lệnh sql select from OutputInfo by Id 
            String[] param = new String[]{key};
            // GỌi phương thức selectData trả về theo kiểu result set
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_Id, param);
            while (rs.next()) {
                listInvoiceExportDetail = new InvoiceExportDetail(
                        rs.getString("Id"),
                        rs.getString("IdProduct"),
                        rs.getString("IdInvoiceImportDetail"),
                        rs.getString("IdInvoiceExport"),
                        rs.getInt("Counts"),
                        rs.getString("Status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInvoiceExportDetail;
    }

    @Override
    public int insert(InvoiceExportDetail element) {
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
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countInsert;
    }

    @Override
    public int update(InvoiceExportDetail element) {
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
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

   
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
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countDelete;
    }

    @Override
    public int delete(InvoiceExportDetail element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
