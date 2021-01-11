/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.InvoiceImportDetail;

/**
 *
 * @author GIANG
 */
public interface IInvoiceImportDetailDAO extends IInventoryDAO<InvoiceImportDetail , String> {
    public  List<InvoiceImportDetail> getAllDetails();
    public InvoiceImportDetail getInvoiceImportDetailByID(String key);

  
}
