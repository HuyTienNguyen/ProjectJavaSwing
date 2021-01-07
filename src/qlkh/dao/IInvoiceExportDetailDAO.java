/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.InvoiceExportDetail;

/**
 *
 * @author GIANG
 */
public interface IInvoiceExportDetailDAO extends IInventoryDAO<InvoiceExportDetail , String> {
    public  List<InvoiceExportDetail> getAllInvoiceExportDetail();
    public InvoiceExportDetail getInvoiceExportDetailByID(String key);

  
}
