/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.controller;

import java.util.List;
import qlkh.daoimpl.InvoiceExportDaoImpl;
import qlkh.daoimpl.InvoiceImportDetailDaoImpl;
import qlkh.daoimpl.ProductDaoImpl;
import qlkh.entities.Products;
import qlkh.test.HuyTestFrameInvoiceExportDetail;

/**
 *
 * @author user
 */
public class InvoiceExportDetailController {
    HuyTestFrameInvoiceExportDetail view;
    ProductDaoImpl proDao;
    InvoiceImportDetailDaoImpl invoiceImDetailDao;
    InvoiceExportDaoImpl invoiceExDao;
    public InvoiceExportDetailController() {
        view = new HuyTestFrameInvoiceExportDetail();
        proDao = new ProductDaoImpl();
        invoiceImDetailDao = new InvoiceImportDetailDaoImpl();
        invoiceExDao = new InvoiceExportDaoImpl();
    }
    
    
    public void showView() {
        if (view == null) {
            view = new HuyTestFrameInvoiceExportDetail();
        }
        List<Products> products = proDao.getAllProducts();
    }
}
