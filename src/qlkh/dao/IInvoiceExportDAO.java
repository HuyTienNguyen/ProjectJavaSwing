/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.dao;
import java.util.List;
import qlkh.entities.InvoiceExport;

/**
 *
 * @author GIANG
 */
public interface IInvoiceExportDAO extends IInventoryDAO<InvoiceExport , String> {
    public  List<InvoiceExport> getAllInvoiceExport();
    public InvoiceExport getInvoiceExportByID(String key);

  
}
