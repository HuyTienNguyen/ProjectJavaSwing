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
import qlkh.dao.IInvoiceImportDetailDAO;
import qlkh.entities.InvoiceImportDetail;
import qlkh.utils.Constants;
import qlkh.utils.DatabaseHelper;


/**
 *
 * @author GIANG
 */
public class InvoiceImportDetailDaoImpl implements IInvoiceImportDetailDAO {
    private static final String SQL_GET_ALL = "SELECT * FROM InvoiceImportDetail";
    private static final String SQL_INSERT = "INSERT INTO InvoiceImportDetail(Id,IdProduct,IdInvoiceImport,number,inputPrice,outputPrice,Status) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE  InvoiceImportDetail SET IdProduct =?, IdInvoiceImport =?, number =?,inputPrice=?,OutputPrice=?,Status=? WHERE Id =?";
    private static final String SQL_DELETE = "DELETE FROM  InvoiceImportDetail  WHERE Id =?";
    private static final String SQL_INSERT_BY_PROC ="{call sp_add_invoice_import_Detail(?,?,?,?,?,?,?)}";
    private static final String SQL_SELECT_BY_Id = "SELECT * FROM InvoiceImportDetail WHERE Id= ? ";
    @Override
    public List<InvoiceImportDetail> getAllDetails() {
        List<InvoiceImportDetail> listInvoiceImportDetail = new ArrayList<>();
        String[] param = new String[]{};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_GET_ALL, param);
            while(rs.next()){
                InvoiceImportDetail inputinfo = new InvoiceImportDetail(rs.getString("Id"),rs.getString("IdProduct"),rs.getString("IdInvoiceImport"),rs.getInt("number"),rs.getFloat("InputPrice"),rs.getFloat("OutputPrice"),rs.getString("status"));
                listInvoiceImportDetail.add(inputinfo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceImportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInvoiceImportDetail;
    }

    @Override
    public InvoiceImportDetail getInvoiceImportDetailByID(String key) {
        InvoiceImportDetail invoiceImportDetail = null;
        String[] param = new String[]{key};
        try {
            ResultSet rs = DatabaseHelper.selectData(SQL_SELECT_BY_Id, param);
            if(rs.next()){
                invoiceImportDetail = new InvoiceImportDetail(rs.getString("Id"),rs.getString("IdProduct"),rs.getString("IdInvoiceImport"),rs.getInt("number"),rs.getFloat("InputPrice"),rs.getFloat("OutputPrice"),rs.getString("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceImportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return invoiceImportDetail;
    }

    @Override
    public int insert(InvoiceImportDetail element) {
        Integer countInsert = -1;
        try {
            countInsert = DatabaseHelper.insertDataByCallableStatement(SQL_INSERT_BY_PROC, element.getParam(Constants.ACTION_INSERT_BY_PROC));
           
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceImportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public int update(InvoiceImportDetail element) {
        Integer countUpdate = 0;
        try {
            countUpdate = DatabaseHelper.updateData(SQL_UPDATE, element.getParam(Constants.ACTION_UPDATE));
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceImportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DatabaseHelper.getInstance().closeDatabaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceExportDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return countUpdate;
    }

    @Override
    public int delete(InvoiceImportDetail element) {
        return 0;
         }

   
 
 
    
}
