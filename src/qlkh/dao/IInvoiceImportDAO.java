/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.InvoiceImport;

/**
 *
 * @author GIANG
 */
public interface IInvoiceImportDAO extends IInventoryDAO<InvoiceImport , String> {
    public  List<InvoiceImport> getAllInvoiceImport();
    public InvoiceImport getInvoiceImportByID(String key);

  
}
